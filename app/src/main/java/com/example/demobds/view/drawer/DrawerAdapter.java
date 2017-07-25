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

package com.example.demobds.view.drawer;

import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.CountDownTimer;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.content.ContextCompat;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.widget.Toolbar;
import android.text.SpannableString;
import android.text.style.ForegroundColorSpan;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.demobds.R;
import com.example.demobds.models.User;
import com.example.demobds.view.activity.BaseActivity;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;

/**
 * Created by hoanghiep on 7/22/17.
 */

public class DrawerAdapter implements NavigationView.OnNavigationItemSelectedListener, DrawerLayout.DrawerListener {
    private CountDownTimer countDownTimer;
    private ImageView imgFooter;
    private TextView versionTextView;
    private User user;
    private Unbinder unbinder;

    private DrawerAdapter.DrawerHeaderHolder headerHolder;
    private DrawerCallback drawerCallback;
    private int imageClickTimes = 0;
    private int registerRoomCount = 0;

    public DrawerAdapter(DrawerCallback drawerCallback) {
        this.drawerCallback = drawerCallback;
        this.imgFooter = drawerCallback.getImageViewFooter();
        this.versionTextView = drawerCallback.getVersionTextView();
        this.user = drawerCallback.getUser();
        this.initDrawer();
    }

    @Override
    public void onDrawerSlide(View drawerView, float slideOffset) {
        this.drawerCallback.onDrawerSlide(drawerView, slideOffset);
        if (slideOffset > 0.0f) {
            this.drawerCallback.onDrawerOpened(true);
        } else if (slideOffset == 0.0f) {
            this.drawerCallback.onDrawerOpened(false);
        }
    }

    @Override
    public void onDrawerOpened(View drawerView) {
        DrawerAdapter.this.checkLogedState();
        DrawerAdapter.this.checkNotiState();
    }

    @Override
    public void onDrawerClosed(View drawerView) {}

    @Override
    public void onDrawerStateChanged(int newState) {}

    public interface DrawerCallback {
        BaseActivity getActivity();
        User getUser();
        DrawerLayout getDrawerLayout();
        Toolbar getToolbar();
        NavigationView getNavigationView();
        ImageView getImageViewFooter();
        TextView getVersionTextView();
        void onDrawerOpened(boolean isOpen);
        void onDrawerSlide(View drawerView, float slideOffset);
    }

    private void initDrawer() {
        BaseActivity baseActivity = this.drawerCallback.getActivity();
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                drawerCallback.getActivity(), drawerCallback.getDrawerLayout(), drawerCallback.getToolbar(), R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawerCallback.getDrawerLayout().addDrawerListener(toggle);
        toggle.syncState();
        this.drawerCallback.getNavigationView().setNavigationItemSelectedListener(this);
        drawerCallback.getDrawerLayout().addDrawerListener(this);
        View view = drawerCallback.getNavigationView().getHeaderView(0);
        //unbinder = ButterKnife.bind(this, view);

        this.headerHolder = new DrawerHeaderHolder(view);
        this.addRewardText(R.id.btn_drawer_danji_inquiry);
        this.addRewardText(R.id.btn_drawer_item_sorry);
        try {
            PackageInfo packageInfo = baseActivity.getPackageManager().getPackageInfo(baseActivity.getPackageName(), 0);
            TextView var3 = this.versionTextView;
            StringBuilder var5 = new StringBuilder();
            var3.setText(var5.append("앱버전 : ").append(packageInfo.versionName).toString());
        } catch (PackageManager.NameNotFoundException var4) {
            var4.printStackTrace();
        }

        this.checkLogedState();
        this.checkNotiState();
        this.drawerCallback.getImageViewFooter().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(DrawerAdapter.this.countDownTimer == null) {
                    DrawerAdapter.this.countDownTimer = DrawerAdapter.this.getCountDownTimer();
                    DrawerAdapter.this.countDownTimer.start();
                }
                closeDrawer();
            }
        });
    }

    private void checkNotiState() {

    }

    private void checkLogedState() {
        if (headerHolder != null) {
            headerHolder.unsignedSignUpLayout.setVisibility(View.VISIBLE);
        }
        resetMenu(drawerCallback.getActivity());
    }

    @OnClick({R.id.btn_setting, R.id.btn_noticenter})
    void onClickHeader(View view) {
        switch (view.getId()) {
            case R.id.btn_setting:
                break;
            case R.id.btn_noticenter:
                break;
            default:
                break;
        }
        this.closeDrawer();
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.btn_drawer_item_recent:
                break;
            case R.id.btn_drawer_item_zzim:
                break;
            case R.id.btn_drawer_favorite_agent:
                break;
            case R.id.btn_drawer_item_sorry:
                break;
            case R.id.btn_drawer_item_search:
                break;
            case R.id.btn_drawer_item_addroom:
                break;
            case R.id.btn_drawer_danji_recent:
                break;
            case R.id.btn_drawer_danji_zzim:
                break;
            case R.id.btn_drawer_danji_inquiry:
                break;
            case R.id.btn_drawer_danji_item_recent:
                break;
            case R.id.btn_drawer_danji_item_search:
                break;
            case R.id.btn_drawer_danji_register:
                break;
            case R.id.btn_drawer_etc_support:
                break;
            case R.id.btn_drawer_etc_event:
                break;
            default:
                break;
        }
        this.closeDrawer();
        return true;
    }

    public boolean closeDrawer() {
        boolean isOpen;
        if (this.isOpened()) {
            this.drawerCallback.getDrawerLayout().closeDrawer(GravityCompat.START);
            isOpen = true;
        } else {
            isOpen = false;
        }

        return isOpen;
    }

    public boolean isOpened() {
        return this.drawerCallback.getDrawerLayout().isDrawerOpen(GravityCompat.START);
    }

    public void notifyDataSetChanged() {
        this.resetMenu(this.drawerCallback.getActivity());
    }

    public void resetMenu(BaseActivity var1) {
        Menu menu = this.drawerCallback.getNavigationView().getMenu();
        if(menu != null) {
            MenuItem menuItem;
            if(this.user != null && this.user.user_type == 3) {
                menuItem = menu.findItem(R.id.btn_drawer_item_addroom);
                menuItem.setTitle("중개사 사이트로 이동");
                menuItem.setIcon(var1.getResources().getDrawable(R.drawable.ic_title_agent_24x24_nor_black));
            } else {
                menuItem = menu.findItem(R.id.btn_drawer_item_addroom);
                menuItem.setTitle("중개사무소에 방 내놓기·관리");
                menuItem.setIcon(var1.getResources().getDrawable(R.drawable.ic_title_sale_oneroom_24x24_nor_black));
            }
        }

    }

    private CountDownTimer getCountDownTimer() {
        return new CountDownTimer(100000L, 500L) {
            public void onFinish() {
                DrawerAdapter.this.imageClickTimes = 0;
                DrawerAdapter.this.countDownTimer = null;
            }

            public void onTick(long var1) {
                if(DrawerAdapter.this.imageClickTimes >= 10) {
                    DrawerAdapter.this.showInfoAlert();
                    this.onFinish();
                    this.cancel();
                }

            }
        };
    }

    private void showInfoAlert() {
        /*(new Builder(this.activity)).setMessage(this.appInfoMessage()).setPositiveButton(17039370, new android.content.DialogInterface.OnClickListener() {
            public void onClick(DialogInterface var1, int var2) {
                ((ClipboardManager)DrawerAdapter.this.activity.getSystemService("clipboard")).setPrimaryClip(ClipData.newPlainText("app info", DrawerAdapter.this.appInfoMessage()));
                Toast.makeText(DrawerAdapter.this.activity, "클립보드에 복사되었습니다", 0).show();
            }
        }).setCancelable(false).create().show();*/
    }

    private void addRewardText(int id) {
        MenuItem var2 = this.drawerCallback.getNavigationView().getMenu().findItem(id);
        CharSequence var4 = var2.getTitle();
        String var3 = this.drawerCallback.getActivity().getString(R.string.menu_request_reward);
        var3 = var4 + "\n" + var3;
        SpannableString var5 = new SpannableString(var3);
        var5.setSpan(new ForegroundColorSpan(ContextCompat.getColor(this.drawerCallback.getActivity(), R.color.grey2)), var2.getTitle().length(), var3.length(), 33);
        var2.setTitle(var5);
    }


    public class DrawerHeaderHolder {
        @BindView(R.id.ic_new)
        ImageView newIcon;
        @BindView(R.id.drawer_main_header_signed)
        View signedLayout;
        @BindView(R.id.drawer_main_header_tv_email)
        TextView tvEmail;
        @BindView(R.id.drawer_main_header_tv_name)
        TextView tvName;
        @BindView(R.id.drawer_main_header_unsigned)
        View unsignedLayout;
        @BindView(R.id.drawer_main_header_unsigned_signup)
        View unsignedSignUpLayout;

        public DrawerHeaderHolder(View view) {
            unbinder = ButterKnife.bind(this, view);
        }

        @OnClick({R.id.btn_agent_signup})
        public void onClickAgentSignUp() {
            DrawerAdapter.this.closeDrawer();
        }

        @OnClick({R.id.btn_login})
        void onClickLogin() {
            DrawerAdapter.this.closeDrawer();
        }

        @OnClick({R.id.btn_normal_signup})
        public void onClickNormalSignUp() {
            DrawerAdapter.this.closeDrawer();
        }
    }

    public void onDestroyDrawer() {
        if (unbinder != null) {
            unbinder.unbind();
        }
    }
}
