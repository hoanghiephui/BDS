/*
 * Copyright (c) 2017 Hoang Hiep.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *
 */

package com.example.demobds.view.activity;

import android.Manifest;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.Toast;

import com.jemshit.elitemvp.RxBus;

import java.util.List;
import java.util.concurrent.TimeUnit;

import butterknife.ButterKnife;
import butterknife.Unbinder;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;
import pub.devrel.easypermissions.AfterPermissionGranted;
import pub.devrel.easypermissions.AppSettingsDialog;
import pub.devrel.easypermissions.EasyPermissions;

/**
 * Created by hoanghiep on 7/18/17.
 */

public abstract class BaseActivity extends AppCompatActivity implements EasyPermissions.PermissionCallbacks {
    private static final String TAG = BaseActivity.class.getSimpleName();
    public static String[] PERMISSIONS_ALL = {Manifest.permission.READ_EXTERNAL_STORAGE,
            Manifest.permission.WRITE_EXTERNAL_STORAGE, Manifest.permission.ACCESS_FINE_LOCATION,
            Manifest.permission.ACCESS_COARSE_LOCATION, Manifest.permission.READ_PHONE_STATE, Manifest.permission.RECEIVE_SMS,
            Manifest.permission.CAMERA
    };
    public static final int REQUEST_ALL = 123;
    private Unbinder mUnbinder;
    private CompositeDisposable disposable;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getLayoutID() != 0) {
            setContentView(getLayoutID());
        }

        ButterKnife.setDebug(true);
        mUnbinder = ButterKnife.bind(this);
        initPresenter();
        attachView();
        disposable = new CompositeDisposable();
        onSubscribeEventRx();
        initOnCreate(savedInstanceState);
    }

    @Override
    protected void onResume() {
        super.onResume();
        requestPermissions();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (mUnbinder != null) {
            mUnbinder.unbind();
        }

        if (disposable != null && !disposable.isDisposed()) {
            disposable.dispose();
            disposable.clear();
        }

        onDestroyPresenter();
    }

    protected abstract int getLayoutID();

    /**
     * Initialize Presenter
     */
    protected void initPresenter() {
    }

    /**
     * Attach View to it
     */
    protected void attachView() {
    }


    protected abstract void initOnCreate(Bundle savedInstanceState);

    /**
     * Subsrcibe event rx
     *
     * @param object
     */
    protected void onSubscribeEvent(Object object) {
    }

    /**
     * Destroy (Detach View from) Presenter. Also unsubscribes from Subscriptions
     */
    protected void onDestroyPresenter() {
    }

    private synchronized void onSubscribeEventRx() {
        disposable.add(RxBus.getInstance()
                .receive()
                .subscribeOn(Schedulers.io())
                .delay(300, TimeUnit.MILLISECONDS)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<Object>() {
                    @Override
                    public void accept(Object object) throws Exception {
                        onSubscribeEvent(object);
                    }
                }));
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);

        // EasyPermissions handles the request result.
        EasyPermissions.onRequestPermissionsResult(requestCode, permissions, grantResults, this);
    }

    //callback permission
    @Override
    public void onPermissionsGranted(int requestCode, List<String> perms) {
        Log.d(TAG, "onPermissionsGranted: " + requestCode);
        for (String perm : perms) {
            Log.d(TAG, "onPermissionsGranted: perm " + perm);
        }
    }

    @Override
    public void onPermissionsDenied(int requestCode, List<String> perms) {
        for (String perm : perms) {
            Log.d(TAG, "onPermissionsDenied: " + perm);
        }
        if (EasyPermissions.somePermissionPermanentlyDenied(this, perms)) {
            new AppSettingsDialog.Builder(this).build().show();
        }
    }
    //end callback permission

    @AfterPermissionGranted(REQUEST_ALL)
    public void requestPermissions() {
        if (EasyPermissions.hasPermissions(this, PERMISSIONS_ALL)) {
            // Have permission, do the thing!
            Toast.makeText(this, "TODO: Camera things", Toast.LENGTH_LONG).show();
        } else {
            // Ask for one permission
            EasyPermissions.requestPermissions(this, "check",
                    REQUEST_ALL, PERMISSIONS_ALL);
        }
    }
}
