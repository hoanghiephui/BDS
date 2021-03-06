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
import android.animation.ValueAnimator;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.NavigationView;
import android.support.design.widget.TabLayout;
import android.support.v4.view.GravityCompat;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.airbnb.lottie.LottieAnimationView;
import com.example.demobds.R;
import com.example.demobds.models.User;
import com.example.demobds.view.adapters.MainPagerAdapter;
import com.example.demobds.view.drawer.DrawerAdapter;

import java.util.List;

import butterknife.BindView;
import butterknife.OnClick;
import pub.devrel.easypermissions.AfterPermissionGranted;
import pub.devrel.easypermissions.AppSettingsDialog;
import pub.devrel.easypermissions.EasyPermissions;

public class MainActivity extends BaseActivity
        implements ViewPager.OnPageChangeListener {
    private static final String TAG = MainActivity.class.getSimpleName();

    @BindView(R.id.animationView)
    LottieAnimationView lottieAnimationView;
    @BindView(R.id.tabLayout)
    TabLayout tabLayout;
    @BindView(R.id.viewPager)
    ViewPager viewPager;


    @Override
    protected int getLayoutID() {
        return R.layout.activity_main;
    }

    @Override
    protected void initPresenter() {
        super.initPresenter();
    }

    @Override
    protected void attachView() {
        super.attachView();
    }

    @Override
    protected void initOnCreate(Bundle savedInstanceState) {
        setSupportActionBar(toolbar);

        MainPagerAdapter mainPagerAdapter = new MainPagerAdapter(getSupportFragmentManager());
        viewPager.setAdapter(mainPagerAdapter);
        tabLayout.addOnTabSelectedListener(new TabLayout.ViewPagerOnTabSelectedListener(viewPager));
        viewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));
        viewPager.addOnPageChangeListener(this);
    }

    @Override
    protected void onSubscribeEvent(Object object) {
        super.onSubscribeEvent(object);
    }

    @Override
    protected void onDestroyPresenter() {
        super.onDestroyPresenter();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.action_settings:
                return true;
            case android.R.id.home:
                if (drawer != null) {
                    drawer.openDrawer(GravityCompat.START);  // OPEN DRAWER
                }
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }

    }

    /////action click
    @OnClick({R.id.btn_tab1, R.id.btn_tab2})
    void onActionClick(View view) {
        switch (view.getId()) {
            case R.id.btn_tab1:
                viewPager.setCurrentItem(0, true);
                break;
            case R.id.btn_tab2:
                viewPager.setCurrentItem(1, true);
                break;
        }
    }

    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

    }

    @Override
    public void onPageSelected(int position) {
        onChangeAnimationHeader(position);
    }

    private void onChangeAnimationHeader(int position) {
        lottieAnimationView.setLayerType(2, null);
        ValueAnimator valueAnimator;
        switch (position) {
            case 0:
                valueAnimator = ValueAnimator.ofFloat(0.5f, 1.0f);
                valueAnimator.setDuration(500);
                lottieAnimationView.setLayerType(1, null);
                valueAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
                    @Override
                    public void onAnimationUpdate(ValueAnimator valueAnimator) {
                        lottieAnimationView.setProgress((float) valueAnimator.getAnimatedValue());
                    }
                });
                valueAnimator.start();
                break;
            default:
                valueAnimator = ValueAnimator.ofFloat(0.0f, 0.5f);
                valueAnimator.setDuration(500);
                valueAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
                    @Override
                    public void onAnimationUpdate(ValueAnimator valueAnimator) {
                        lottieAnimationView.setProgress((float) valueAnimator.getAnimatedValue());
                    }
                });
                valueAnimator.start();
                break;
        }
    }

    @Override
    public void onPageScrollStateChanged(int state) {

    }

}
