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

package com.example.demobds.view.widgets;

import android.content.Context;
import android.util.AttributeSet;

import com.edmodo.rangebar.RangeBar;

/**
 * Created by hoanghiep on 7/26/17.
 */

public class CustomRangeBar extends RangeBar implements RangeBar.OnRangeBarChangeListener {
    boolean isFromUser;
    ZBOnRangeBarChangeListener listener;
    int tickCount;

    public CustomRangeBar(Context context) {
        this(context, (AttributeSet)null);
    }

    public CustomRangeBar(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public CustomRangeBar(Context context, AttributeSet attributeSet, int var3) {
        super(context, attributeSet, var3);
        this.tickCount = 0;
        this.isFromUser = true;
        this.listener = null;
        this.setOnRangeBarChangeListener(this);
    }

    public void onIndexChangeListener(RangeBar rangeBar, int var2, int var3) {
        int var4 = var2;
        if(var2 < 0) {
            rangeBar.setThumbIndices(0, rangeBar.getRightIndex());
            var4 = 0;
        }

        var2 = var3;
        if(this.tickCount > 0) {
            var2 = var3;
            if(var3 > this.tickCount - 1) {
                rangeBar.setThumbIndices(rangeBar.getLeftIndex(), this.tickCount - 1);
                var2 = this.tickCount - 1;
            }
        }

        if(this.listener != null) {
            this.listener.onIndexChangeListener(rangeBar, var4, var2, this.isFromUser);
        }

        this.isFromUser = true;
    }

    public void setListener(ZBOnRangeBarChangeListener var1) {
        this.listener = var1;
    }

    public void setThumbIndices(int var1, int var2) {
        this.isFromUser = false;
        super.setThumbIndices(var1, var2);
    }

    public void setTickCount(int var1) {
        super.setTickCount(var1);
        this.tickCount = var1;
    }

    public interface ZBOnRangeBarChangeListener {
        void onIndexChangeListener(RangeBar var1, int var2, int var3, boolean var4);
    }
}
