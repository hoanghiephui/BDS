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
import android.graphics.Typeface;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.demobds.R;

import kotlin.jvm.internal.Intrinsics;

/**
 * Created by hoanghiep on 7/25/17.
 */

public class APTFilterBarView extends LinearLayout {
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
        View var7 = this.createMenuButton(this.getContext(), "a", "a");
        this.addView(var7, (LayoutParams)(new android.widget.LinearLayout.LayoutParams(0, -1, 1.0F)));


    }

    private final View createMenuButton(Context context, String tag, String title) {
        View view = LayoutInflater.from(context).inflate(R.layout.apt_filterbar_menu_button, this, false);
        TextView titleView = (TextView) view.findViewById(R.id.text);
        titleView.setText(title);
        view.setTag(tag);
        view.setOnClickListener((new OnClickListener() {
            public final void onClick(View var1) {
                APTFilterBarView listener = APTFilterBarView.this;
                Intrinsics.checkExpressionValueIsNotNull(var1, "it");
                //listener.onClickCommonGTMListener(var1);
            }
        }));
        Intrinsics.checkExpressionValueIsNotNull(view, "button");
        return view;
    }
}
