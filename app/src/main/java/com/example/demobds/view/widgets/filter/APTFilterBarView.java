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

package com.example.demobds.view.widgets.filter;

import android.content.Context;
import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Build;
import android.support.annotation.Nullable;
import android.support.v4.widget.PopupWindowCompat;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.TextView;

import com.example.demobds.R;

import java.util.Iterator;

import kotlin.TypeCastException;
import kotlin.jvm.internal.Intrinsics;

/**
 * Created by hoanghiep on 7/25/17.
 */

public class APTFilterBarView extends LinearLayout {
    private PopupWindow currentShowingPopup;

    public APTFilterBarView(Context context) {
        super(context);
        setViewModel(null);
    }

    public APTFilterBarView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        setViewModel(null);
    }

    public APTFilterBarView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        setViewModel(null);
    }

    public final void setViewModel(@Nullable APTFilterBarViewModel viewModel) {

        APTFilterBarViewModel barViewModel = new APTFilterBarViewModel();
        int countMenu = barViewModel.getMenuTitles().length;
        for (int i = 0; i < countMenu; i++) {
            View var7 = this.createMenuButton(this.getContext(), barViewModel.getMenuTitles()[i], barViewModel.getMenuTitles()[i]);
            this.addView(var7, (LayoutParams)(new android.widget.LinearLayout.LayoutParams(0, -1, 1.0F)));
        }
    }

    private final View createMenuButton(Context context, String tag, String title) {
        View view = LayoutInflater.from(context).inflate(R.layout.apt_filterbar_menu_button, this, false);
        TextView titleView = (TextView) view.findViewById(R.id.text);
        titleView.setText(title);
        view.setTag(tag);
        view.setOnClickListener((new OnClickListener() {
            public final void onClick(View view) {
                APTFilterBarView listener = APTFilterBarView.this;
                listener.onClickCommonGTMListener(view);
            }
        }));
        Intrinsics.checkExpressionValueIsNotNull(view, "button");
        return view;
    }

    private final void onClickCommonGTMListener(View view) {
        Object tag = view.getTag();
        if(tag == null) {
            throw new TypeCastException("null cannot be cast to non-null type kotlin.String");
        } else {
            String tagString = (String)tag;

            switch(tagString.hashCode()) {
                case 1409193:
                    if(tagString.equals("가격")) {
                        this.onClickPriceMenu(view);
                    }
                    break;
                case 1530893:
                    if(tagString.equals("면적")) {
                        this.onClickSizeMenu(view);
                    }
                    break;
                case 1361802420:
                    if(tagString.equals("거래방법")) {
                        this.onClickDealTypeMenu(view);
                    }
                    break;
                case 1415785492:
                    if(tagString.equals("단지특징")) {
                        this.onClickProperyMenu(view);
                    }
            }

        }
    }

    public final boolean closeCurrentShowingMenu() {
        boolean isShowMenu;
        if(this.isMenuShowing()) {
            PopupWindow currentShowingPopup = this.currentShowingPopup;
            if(currentShowingPopup != null) {
                currentShowingPopup.dismiss();
            }
            this.currentShowingPopup = null;
            isShowMenu = true;
        } else {
            isShowMenu = false;
        }

        return isShowMenu;
    }

    public final boolean isMenuShowing() {
        PopupWindow currentShowingPopup = this.currentShowingPopup;
        boolean isMenuShow;
        isMenuShow = currentShowingPopup != null && currentShowingPopup.isShowing();
        return isMenuShow;
    }

    private void onClickDealTypeMenu(View view) {
        if(this.currentShowingPopup != null && ((ImageView)view.findViewById(R.id.arrow)).isSelected()) {
            this.closeCurrentShowingMenu();
        } else {
            /*this.changingMenuButtonArrow(view);
            APTFilterDealTypeMenuView var2 = new APTFilterDealTypeMenuView(this.getContext());
            var2.setConfirmClickListener(this.confirmClickListener);
            var2.setCancelClickListener(this.cancelClickListener);*/
            //this.showMenu((View)var2);
        }

    }

    private final void onClickPriceMenu(View var1) {
        /*if(this.currentShowingPopup != null && ((ImageView)var1.findViewById(id.arrow)).isSelected()) {
            this.closeCurrentShowingMenu();
        } else {
            this.changingMenuButtonArrow(var1);
            APTFilterBarViewModel var3 = this.viewModel;
            APTFilter.DealType var4;
            if(var3 != null) {
                var4 = var3.dealType();
            } else {
                var4 = null;
            }

            APTFilterBaseMenuView var2 = (APTFilterBaseMenuView)null;
            APTFilterBaseMenuView var5;
            if(var4 == null) {
                var5 = var2;
            } else {
                switch(APTFilterBarView$WhenMappings.$EnumSwitchMapping$0[var4.ordinal()]) {
                    case 1:
                        var5 = (APTFilterBaseMenuView)(new APTFilterSalePriceMenuView(this.getContext()));
                        break;
                    case 2:
                        var5 = (APTFilterBaseMenuView)(new APTFilterRentPriceMenuView(this.getContext()));
                        break;
                    default:
                        var5 = var2;
                }
            }

            if(var5 != null) {
                var5.setConfirmClickListener(this.confirmClickListener);
                var5.setCancelClickListener(this.cancelClickListener);
                this.showMenu((View)var5);
            }
        }*/

    }

    private final void onClickProperyMenu(View var1) {
        /*boolean var4 = true;
        byte var2 = 0;
        if(this.currentShowingPopup != null && ((ImageView)var1.findViewById(id.arrow)).isSelected()) {
            this.closeCurrentShowingMenu();
        } else {
            this.changingMenuButtonArrow(var1);
            APTFilterPropertyMenuView var6 = new APTFilterPropertyMenuView(this.getContext());
            APTSelectBarView var5 = (APTSelectBarView)var6.getContentView().findViewById(id.selectbar_built_date);
            boolean var3;
            if(this.isAPTItemList) {
                var3 = false;
            } else {
                var3 = true;
            }

            var5.setEnabled(var3);
            var5 = (APTSelectBarView)var6.getContentView().findViewById(id.selectbar_population);
            var3 = var4;
            if(this.isAPTItemList) {
                var3 = false;
            }

            var5.setEnabled(var3);
            Button var7 = (Button)var6.getContentView().findViewById(id.cancel);
            if(this.isAPTItemList) {
                var2 = 8;
            }

            var7.setVisibility(var2);
            var6.setConfirmClickListener(this.confirmClickListener);
            var6.setCancelClickListener(this.cancelClickListener);
            this.showMenu((View)var6);
        }*/

    }

    private final void onClickSizeMenu(View var1) {
        /*if(this.currentShowingPopup != null && ((ImageView)var1.findViewById(id.arrow)).isSelected()) {
            this.closeCurrentShowingMenu();
        } else {
            this.changingMenuButtonArrow(var1);
            Object var2;
            if(this.isAPTItemList) {
                var2 = new APTFilterSizeMenuView2(this.getContext(), this.isUnitMeter);
            } else {
                var2 = new APTFilterSizeMenuView(this.getContext(), this.isUnitMeter);
            }

            if(var2 instanceof APTFilterBaseMenuView) {
                ((APTFilterBaseMenuView)var2).setConfirmClickListener(this.confirmClickListener);
                ((APTFilterBaseMenuView)var2).setCancelClickListener(this.cancelClickListener);
                ((APTFilterBaseMenuView)var2).setAPTItemList(this.isAPTItemList);
                ((APTFilterBaseMenuView)var2).setAptId(this.aptId);
                this.showMenu((View)var2);
            }
        }*/

    }

    private final void showMenu(View var1) {
        /*View var5;
        if(this.currentShowingPopup != null) {
            PopupWindow var2 = this.currentShowingPopup;
            if(var2 != null) {
                var5 = var2.getContentView();
            } else {
                var5 = null;
            }

            if(!(var5 instanceof LinearLayout)) {
                var5 = null;
            }

            LinearLayout var7 = (LinearLayout)var5;
            View var3;
            if(var7 != null) {
                var3 = var7.findViewWithTag("menu_view");
                if(var3 != null && Intrinsics.areEqual(var1, var3)) {
                    this.closeCurrentShowingMenu();
                    return;
                }
            }

            if(var7 != null) {
                var7.removeAllViews();
            }

            var1.setTag("menu_view");
            var3 = new View(this.getContext());
            var3.setLayoutParams((LayoutParams)(new android.widget.LinearLayout.LayoutParams(-1, -1)));
            Sdk15PropertiesKt.setBackgroundColor(var3, Color.parseColor("#99000000"));
            var3.setOnClickListener((OnClickListener)(new OnClickListener() {
                public final void onClick(View var1) {
                    APTFilterBarView.this.closeCurrentShowingMenu();
                }
            }));
            if(var7 != null) {
                var7.addView(var1, -1, -2);
            }

            if(var7 != null) {
                var7.addView(var3, -1, -2);
            }
        } else {
            LinearLayout var6 = new LinearLayout(this.getContext());
            var6.setOrientation(1);
            var1.setTag("menu_view");
            var5 = new View(this.getContext());
            var5.setLayoutParams((LayoutParams)(new android.widget.LinearLayout.LayoutParams(-1, -1)));
            Sdk15PropertiesKt.setBackgroundColor(var5, Color.parseColor("#99000000"));
            var5.setOnClickListener((OnClickListener)(new OnClickListener() {
                public final void onClick(View var1) {
                    APTFilterBarView.this.closeCurrentShowingMenu();
                }
            }));
            var6.addView(var1, -1, -2);
            var6.addView(var5, -1, -2);
            PopupWindow var4 = new PopupWindow((View)var6, -1, -2);
            var4.setOnDismissListener((PopupWindow.OnDismissListener)(new PopupWindow.OnDismissListener() {
                public final void onDismiss() {
                    Iterator var1 = APTFilterBarView.this.menuButtons.iterator();

                    while(var1.hasNext()) {
                        ((ImageView)((View)var1.next()).findViewById(id.arrow)).setSelected(false);
                    }

                }
            }));
            PopupWindowCompat.showAsDropDown(var4, (View)this, 0, 0, 80);
            if(Build.VERSION.SDK_INT >= 24) {
                var4.update(-1, -2);
            }

            this.currentShowingPopup = var4;
        }*/

    }
}
