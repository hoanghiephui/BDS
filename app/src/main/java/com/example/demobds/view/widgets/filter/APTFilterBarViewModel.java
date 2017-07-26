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

import com.example.demobds.realm.dao.APTFilterDAO;

import java.util.Map;

import kotlin.jvm.internal.Intrinsics;

/**
 * Created by hoanghiep on 7/25/17.
 */

public final class APTFilterBarViewModel {
    private final String[] menuTypes = new String[]{"거래방법", "가격", "면적", "단지특징"};

    private final String[] getMenuTitles() {
        APTFilter var4 = APTFilterDAO.find();
        String var5 = var4.getDealTypeString();
        APTFilter.DealType var3 = var4.getDealType();
        int var1;
        int var2;
        String var6;
        switch(APTFilterBarViewModel$WhenMappings.$EnumSwitchMapping$0[var3.ordinal()]) {
            case 1:
                var1 = var4.getSalePriceLeft();
                var2 = var4.getSalePriceRight();
                if(var1 == 0 && var2 == ((Map)APTFilter.getAptSalePriceValues()).size() - 1) {
                    var6 = "전체가격";
                } else if(var1 == 0 && var2 != ((Map)APTFilter.getAptSalePriceValues()).size() - 1) {
                    var6 = (String)APTFilter.getAptSalePriceValues().get(Integer.valueOf(var2));
                    var6 = var6 + APTFilter.getUnitPriceUk() + " 까지";
                } else if(var1 == var2) {
                    var6 = (String)APTFilter.getAptSalePriceValues().get(Integer.valueOf(var2));
                    var6 = var6 + APTFilter.getUnitPriceUk();
                } else {
                    var6 = (String)APTFilter.getAptSalePriceValues().get(Integer.valueOf(var1));
                    var6 = var6 + APTFilter.getUnitPriceUk() + " 부터";
                }
                break;
            case 2:
                var1 = var4.getRentDepositLeft();
                var2 = var4.getRentDepositRight();
                if(var1 == 0 && var2 == ((Map)APTFilter.getAptRentDepositPriceValues()).size() - 1) {
                    var6 = "전체가격";
                } else if(var1 == 0 && var2 != ((Map)APTFilter.getAptRentDepositPriceValues()).size() - 1) {
                    var6 = (String)APTFilter.getAptRentDepositPriceValues().get(Integer.valueOf(var2));
                    var6 = var6 + APTFilter.getUnitPriceUk() + " 까지";
                } else if(var1 == var2) {
                    var6 = (String)APTFilter.getAptRentDepositPriceValues().get(Integer.valueOf(var2));
                    var6 = var6 + APTFilter.getUnitPriceUk();
                } else {
                    var6 = (String)APTFilter.getAptRentDepositPriceValues().get(Integer.valueOf(var1));
                    var6 = var6 + APTFilter.getUnitPriceUk() + " 부터";
                }
                break;
            default:
                var6 = "";
        }

        String var7;
        if(var4.getSelectedSizeIndex().size() == ((Object[])APTFilter.getAptSizeValues()).length) {
            var7 = "전체면적";
        } else {
            var7 = var4.getSelectedSizeIndex().size() + "개 면적대";
        }

        return new String[]{var5, var6, var7, "단지특징"};
    }
}
