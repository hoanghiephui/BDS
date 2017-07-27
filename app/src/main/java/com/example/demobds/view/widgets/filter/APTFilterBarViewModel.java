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

    public final String[] getMenuTitles() {
        APTFilter aptFilter = APTFilterDAO.find();
        String var5 = aptFilter.getDealTypeString();
        APTFilter.DealType dealType = aptFilter.getDealType();
        int var1;
        int var2;
        String titleMenu;
        switch (APTFilter.DealType.values()[dealType.ordinal()]) {
            case RENT:
                var1 = aptFilter.getSalePriceLeft();
                var2 = aptFilter.getSalePriceRight();
                if(var1 == 0 && var2 == ((Map)APTFilter.getAptSalePriceValues()).size() - 1) {
                    titleMenu = "전체가격";
                } else if(var1 == 0 && var2 != ((Map)APTFilter.getAptSalePriceValues()).size() - 1) {
                    titleMenu = (String)APTFilter.getAptSalePriceValues().get(var2);
                    titleMenu = titleMenu + APTFilter.getUnitPriceUk() + " 까지";
                } else if(var1 == var2) {
                    titleMenu = (String)APTFilter.getAptSalePriceValues().get(var2);
                    titleMenu = titleMenu + APTFilter.getUnitPriceUk();
                } else {
                    titleMenu = (String)APTFilter.getAptSalePriceValues().get(var1);
                    titleMenu = titleMenu + APTFilter.getUnitPriceUk() + " 부터";
                }
                break;
            case SALES:
                var1 = aptFilter.getRentDepositLeft();
                var2 = aptFilter.getRentDepositRight();
                if(var1 == 0 && var2 == ((Map)APTFilter.getAptRentDepositPriceValues()).size() - 1) {
                    titleMenu = "전체가격";
                } else if(var1 == 0 && var2 != ((Map)APTFilter.getAptRentDepositPriceValues()).size() - 1) {
                    titleMenu = (String)APTFilter.getAptRentDepositPriceValues().get(var2);
                    titleMenu = titleMenu + APTFilter.getUnitPriceUk() + " 까지";
                } else if(var1 == var2) {
                    titleMenu = (String)APTFilter.getAptRentDepositPriceValues().get(var2);
                    titleMenu = titleMenu + APTFilter.getUnitPriceUk();
                } else {
                    titleMenu = (String)APTFilter.getAptRentDepositPriceValues().get(var1);
                    titleMenu = titleMenu + APTFilter.getUnitPriceUk() + " 부터";
                }
                break;
            default:
                titleMenu = "";
                break;
        }

        String var7;
        if(aptFilter.getSelectedSizeIndex().size() == ((Object[])APTFilter.getAptSizeValues()).length) {
            var7 = "전체면적";
        } else {
            var7 = aptFilter.getSelectedSizeIndex().size() + "개 면적대";
        }

        return new String[]{var5, titleMenu, var7, "단지특징"};
    }
}
