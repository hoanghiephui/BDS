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
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.FrameLayout;

import com.example.demobds.R;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import kotlin.jvm.internal.Intrinsics;

/**
 * Created by hoanghiep on 7/26/17.
 */

public abstract class APTFilterBaseMenuView extends FrameLayout {
    private int aptId;
    @Nullable
    private OnClickListener cancelClickListener;
    @Nullable
    private OnClickListener confirmClickListener;
    @NotNull
    private final View contentView;
    private boolean isAPTItemList;
    @Nullable
    //private APTFilterBaseMenuModel model;
    private int resId = this.createViewByResId();

    public abstract int createViewByResId();

    @Nullable
    public final OnClickListener getCancelClickListener() {
        return this.cancelClickListener;
    }

    @Nullable
    public final OnClickListener getConfirmClickListener() {
        return this.confirmClickListener;
    }

    public void onCancelClick(@Nullable View view) {
    }

    public abstract void onConfirmClick(@Nullable View view);

    @NotNull
    public final View getContentView() {
        return this.contentView;
    }

    public APTFilterBaseMenuView(@NonNull Context context) {
        super(context);
        View view = LayoutInflater.from(context).inflate(this.resId, (ViewGroup)null);
        this.contentView = view;
        this.addView(this.contentView);
        ((Button)this.contentView.findViewById(R.id.confirm)).setOnClickListener((OnClickListener)(new OnClickListener() {
            public final void onClick(View var1) {
                OnClickListener var2 = APTFilterBaseMenuView.this.getConfirmClickListener();
                if(var2 != null) {
                    var2.onClick(var1);
                }

                APTFilterBaseMenuView.this.onConfirmClick(var1);
            }
        }));
        ((Button)this.contentView.findViewById(R.id.cancel)).setOnClickListener((OnClickListener)(new OnClickListener() {
            public final void onClick(View var1) {
                OnClickListener var2 = APTFilterBaseMenuView.this.getCancelClickListener();
                if(var2 != null) {
                    var2.onClick(var1);
                }

                APTFilterBaseMenuView.this.onCancelClick(var1);
            }
        }));
    }

    @Nullable
    public final APTFilterBaseMenuModel createModel(int layout) {
        APTFilterBaseMenuModel baseMenuModel;
        switch(layout) {
            case R.layout.apt_filterbar_dealtype_view:
                baseMenuModel = new APTFilterDealTypeMenuModel();
                break;
            case R.layout.apt_filterbar_menu_button:
            default:
                baseMenuModel = null;
                break;
            case R.layout.apt_filterbar_property_view:
                baseMenuModel = (APTFilterBaseMenuModel)(new APTFilterPropertyMenuModel());
                break;
            case R.layout.apt_filterbar_rent_price_view:
            case R.layout.apt_filterbar_sale_price_view:
                baseMenuModel = (APTFilterBaseMenuModel)(new APTFilterPriceMenuModel());
                break;
            case R.layout.apt_filterbar_size_view:
                if(this.isAPTItemList) {
                    baseMenuModel = (APTFilterBaseMenuModel)(new APTFilterSizeMenuModel2());
                } else {
                    baseMenuModel = (APTFilterBaseMenuModel)(new APTFilterSizeMenuModel());
                }
        }

        return baseMenuModel;
    }

}
