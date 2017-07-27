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

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.lang.reflect.WildcardType;
import java.util.ArrayList;
import java.util.Map;
import java.util.SortedMap;

import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.ArraysKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.IntRange;

/**
 * Created by hoanghiep on 7/25/17.
 */

public class APTFilter {
    @NotNull
    private static final Pair[] APT_BUILT_YEAR_VALUES;
    @NotNull
    private static final Map APT_DEAL_TYPE_VALUES;
    @NotNull
    private static final Pair[] APT_POPULATION_VALUES;
    @NotNull
    private static final SortedMap APT_RENT_DEPOSIT_PRICE_VALUES;
    @NotNull
    private static final SortedMap APT_RENT_DEPOSIT_PRICE_VIEW_VALUES;
    @NotNull
    private static final SortedMap APT_RENT_MONTHLY_FEE_VALUES;
    @NotNull
    private static final SortedMap APT_SALE_PRICE_VALUES;
    @NotNull
    private static final SortedMap APT_SALE_PRICE_VIEW_VALUES;
    @NotNull
    private static final APTFilter.APTFilterSizeRange[] APT_SIZE_VALUES;
    @NotNull
    private static String UNIT_PRICE_MAN = "만";
    @NotNull
    private static String UNIT_PRICE_UK = "억";
    @NotNull
    private static String UNIT_SIZE_METER = "m²";
    @NotNull
    private static String UNIT_SIZE_PYONG = "평";
    private int builtYear;
    @NotNull
    private APTFilter.DealType dealType;
    private int monthlyFeeLeft;
    private int monthlyFeeRight;
    private int population;
    private int rentDepositLeft;
    private int rentDepositRight;
    private int salePriceLeft;
    private int salePriceRight;
    private String selectedSizeIndex;
    @Nullable
    private String selectedSizeItems;

    public static Pair[] getAptBuiltYearValues() {
        return APT_BUILT_YEAR_VALUES;
    }

    public static Map getAptDealTypeValues() {
        return APT_DEAL_TYPE_VALUES;
    }

    public static Pair[] getAptPopulationValues() {
        return APT_POPULATION_VALUES;
    }

    public static SortedMap getAptRentDepositPriceValues() {
        return APT_RENT_DEPOSIT_PRICE_VALUES;
    }

    public static SortedMap getAptRentDepositPriceViewValues() {
        return APT_RENT_DEPOSIT_PRICE_VIEW_VALUES;
    }

    public static SortedMap getAptRentMonthlyFeeValues() {
        return APT_RENT_MONTHLY_FEE_VALUES;
    }

    public static SortedMap getAptSalePriceValues() {
        return APT_SALE_PRICE_VALUES;
    }

    public static SortedMap getAptSalePriceViewValues() {
        return APT_SALE_PRICE_VIEW_VALUES;
    }

    public static APTFilterSizeRange[] getAptSizeValues() {
        return APT_SIZE_VALUES;
    }

    public static String getUnitPriceMan() {
        return UNIT_PRICE_MAN;
    }

    public static String getUnitPriceUk() {
        return UNIT_PRICE_UK;
    }

    public static String getUnitSizeMeter() {
        return UNIT_SIZE_METER;
    }

    public static String getUnitSizePyong() {
        return UNIT_SIZE_PYONG;
    }

    @NotNull
    public final APTFilter.DealType getDealType() {
        return this.dealType;
    }

    @NotNull
    public final String getDealTypeString() {
        String var1 = (String)getAptDealTypeValues().get(this.dealType);
        if(var1 == null) {
            var1 = "";
        }

        return var1;
    }

    static {
        APT_DEAL_TYPE_VALUES = MapsKt.mapOf(new Pair[]{TuplesKt.to(APTFilter.DealType.ALL, "전체 유형"), TuplesKt.to(APTFilter.DealType.SALES, "매매"), TuplesKt.to(APTFilter.DealType.RENT, "전월세")});
        APT_SALE_PRICE_VALUES = MapsKt.sortedMapOf(new Pair[]{TuplesKt.to(Integer.valueOf(0), "0"), TuplesKt.to(Integer.valueOf(1), "0.5"), TuplesKt.to(Integer.valueOf(2), "1"), TuplesKt.to(Integer.valueOf(3), "1.5"), TuplesKt.to(Integer.valueOf(4), "2"), TuplesKt.to(Integer.valueOf(5), "2.5"), TuplesKt.to(Integer.valueOf(6), "3"), TuplesKt.to(Integer.valueOf(7), "4"), TuplesKt.to(Integer.valueOf(8), "5"), TuplesKt.to(Integer.valueOf(9), "6"), TuplesKt.to(Integer.valueOf(10), "7"), TuplesKt.to(Integer.valueOf(11), "10"), TuplesKt.to(Integer.valueOf(12), "13"), TuplesKt.to(Integer.valueOf(13), "15"), TuplesKt.to(Integer.valueOf(14), "제한 없음")});
        APT_SALE_PRICE_VIEW_VALUES = MapsKt.sortedMapOf(new Pair[]{TuplesKt.to(Integer.valueOf(0), "0"), TuplesKt.to(Integer.valueOf(1), "5,000"), TuplesKt.to(Integer.valueOf(2), "1억"), TuplesKt.to(Integer.valueOf(3), "1억5,000"), TuplesKt.to(Integer.valueOf(4), "2억"), TuplesKt.to(Integer.valueOf(5), "2억5,000"), TuplesKt.to(Integer.valueOf(6), "3억"), TuplesKt.to(Integer.valueOf(7), "4억"), TuplesKt.to(Integer.valueOf(8), "5억"), TuplesKt.to(Integer.valueOf(9), "6억"), TuplesKt.to(Integer.valueOf(10), "7억"), TuplesKt.to(Integer.valueOf(11), "10억"), TuplesKt.to(Integer.valueOf(12), "13억"), TuplesKt.to(Integer.valueOf(13), "15억"), TuplesKt.to(Integer.valueOf(14), "제한 없음")});
        APT_RENT_DEPOSIT_PRICE_VALUES = MapsKt.sortedMapOf(new Pair[]{TuplesKt.to(Integer.valueOf(0), "0"), TuplesKt.to(Integer.valueOf(1), "0.1"), TuplesKt.to(Integer.valueOf(2), "0.5"), TuplesKt.to(Integer.valueOf(3), "1"), TuplesKt.to(Integer.valueOf(4), "1.5"), TuplesKt.to(Integer.valueOf(5), "2"), TuplesKt.to(Integer.valueOf(6), "2.5"), TuplesKt.to(Integer.valueOf(7), "3"), TuplesKt.to(Integer.valueOf(8), "3.5"), TuplesKt.to(Integer.valueOf(9), "4"), TuplesKt.to(Integer.valueOf(10), "4.5"), TuplesKt.to(Integer.valueOf(11), "5"), TuplesKt.to(Integer.valueOf(12), "7"), TuplesKt.to(Integer.valueOf(13), "10"), TuplesKt.to(Integer.valueOf(14), "제한 없음")});
        APT_RENT_DEPOSIT_PRICE_VIEW_VALUES = MapsKt.sortedMapOf(new Pair[]{TuplesKt.to(Integer.valueOf(0), "0"), TuplesKt.to(Integer.valueOf(1), "1,000"), TuplesKt.to(Integer.valueOf(2), "5,000"), TuplesKt.to(Integer.valueOf(3), "1억"), TuplesKt.to(Integer.valueOf(4), "1억5,000"), TuplesKt.to(Integer.valueOf(5), "2억"), TuplesKt.to(Integer.valueOf(6), "2억5,000"), TuplesKt.to(Integer.valueOf(7), "3억"), TuplesKt.to(Integer.valueOf(8), "3억5,000"), TuplesKt.to(Integer.valueOf(9), "4억"), TuplesKt.to(Integer.valueOf(10), "4억5,000"), TuplesKt.to(Integer.valueOf(11), "5억"), TuplesKt.to(Integer.valueOf(12), "7억"), TuplesKt.to(Integer.valueOf(13), "10억"), TuplesKt.to(Integer.valueOf(14), "제한 없음")});
        APT_RENT_MONTHLY_FEE_VALUES = MapsKt.sortedMapOf(new Pair[]{TuplesKt.to(Integer.valueOf(0), "0"), TuplesKt.to(Integer.valueOf(1), "10"), TuplesKt.to(Integer.valueOf(2), "20"), TuplesKt.to(Integer.valueOf(3), "30"), TuplesKt.to(Integer.valueOf(4), "40"), TuplesKt.to(Integer.valueOf(5), "50"), TuplesKt.to(Integer.valueOf(6), "60"), TuplesKt.to(Integer.valueOf(7), "70"), TuplesKt.to(Integer.valueOf(8), "80"), TuplesKt.to(Integer.valueOf(9), "90"), TuplesKt.to(Integer.valueOf(10), "100"), TuplesKt.to(Integer.valueOf(11), "120"), TuplesKt.to(Integer.valueOf(12), "160"), TuplesKt.to(Integer.valueOf(13), "200"), TuplesKt.to(Integer.valueOf(14), "제한 없음")});
        APT_SIZE_VALUES = new APTFilter.APTFilterSizeRange[]{new APTFilter.APTFilterSizeRange(new APTFilter.APTFilterSizeData(0), new APTFilter.APTFilterSizeData(66)), new APTFilter.APTFilterSizeRange(new APTFilter.APTFilterSizeData(66), new APTFilter.APTFilterSizeData(99)), new APTFilter.APTFilterSizeRange(new APTFilter.APTFilterSizeData(99), new APTFilter.APTFilterSizeData(132)), new APTFilter.APTFilterSizeRange(new APTFilter.APTFilterSizeData(132), new APTFilter.APTFilterSizeData(165)), new APTFilter.APTFilterSizeRange(new APTFilter.APTFilterSizeData(165), new APTFilter.APTFilterSizeData(Integer.MAX_VALUE))};
        APT_BUILT_YEAR_VALUES = new Pair[]{new Pair("전체", Integer.valueOf(0)), new Pair("30년 이내", Integer.valueOf(30)), new Pair("20년 이내", Integer.valueOf(20)), new Pair("10년 이내", Integer.valueOf(10)), new Pair("5년 이내", Integer.valueOf(5))};
        APT_POPULATION_VALUES = new Pair[]{new Pair("100세대 이상", Integer.valueOf(100)), new Pair("500세대 이상", Integer.valueOf(500)), new Pair("1,000세대 이상", Integer.valueOf(1000))};
        UNIT_PRICE_UK = "억";
        UNIT_PRICE_MAN = "만";
        UNIT_SIZE_PYONG = "평";
        UNIT_SIZE_METER = "m²";
    }

    public APTFilter() {
        this.dealType = APTFilter.DealType.SALES;
        this.salePriceRight = getAptSalePriceValues().size() - 1;
        this.rentDepositRight = getAptRentDepositPriceValues().size() - 1;
        this.selectedSizeItems = "";
    }

    public APTFilter(@NotNull APTFilter.DealType var1) {
        Intrinsics.checkParameterIsNotNull(var1, "dealType");
        this.dealType = APTFilter.DealType.SALES;
        this.salePriceRight = getAptSalePriceValues().size() - 1;
        this.rentDepositRight = getAptRentDepositPriceValues().size() - 1;
        this.selectedSizeItems = "";
        this.dealType = var1;
    }

    public final int getRentDepositLeft() {
        int var1;
        if(this.rentDepositLeft == getAptRentDepositPriceValues().size() - 1 && this.getRentDepositRight() == getAptRentDepositPriceValues().size() - 1) {
            var1 = 0;
        } else {
            var1 = Math.min(this.rentDepositLeft, getAptRentDepositPriceValues().size() - 1);
        }

        return var1;
    }

    public final int getRentDepositRight() {
        return Math.min(this.rentDepositRight, getAptRentDepositPriceValues().size() - 1);
    }

    public final int getSalePriceLeft() {
        int var1;
        if(this.salePriceLeft == getAptSalePriceValues().size() - 1 && this.getSalePriceRight() == getAptSalePriceValues().size() - 1) {
            var1 = 0;
        } else {
            var1 = Math.min(this.salePriceLeft, getAptSalePriceValues().size() - 1);
        }

        return var1;
    }

    public final int getSalePriceRight() {
        return Math.min(this.salePriceRight, getAptSalePriceValues().size() - 1);
    }

    public static final class APTFilterSizeRange {
        @NotNull
        private final APTFilter.APTFilterSizeData end;
        @NotNull
        private final IntRange range;
        @NotNull
        private final APTFilter.APTFilterSizeData start;

        public APTFilterSizeRange(@NotNull APTFilter.APTFilterSizeData var1, @NotNull APTFilter.APTFilterSizeData var2) {
            Intrinsics.checkParameterIsNotNull(var1, "start");
            Intrinsics.checkParameterIsNotNull(var2, "end");
            this.start = var1;
            this.end = var2;
            this.range = new IntRange(this.start.getMeter(), this.end.getMeter());
        }

        // $FF: synthetic method
        // $FF: bridge method
        @NotNull
        public static APTFilter.APTFilterSizeRange copy$default(APTFilter.APTFilterSizeRange var0, APTFilter.APTFilterSizeData var1, APTFilter.APTFilterSizeData var2, int var3, Object var4) {
            if ((var3 & 1) != 0) {
                var1 = var0.start;
            }

            if ((var3 & 2) != 0) {
                var2 = var0.end;
            }

            return var0.copy(var1, var2);
        }

        @NotNull
        public final APTFilter.APTFilterSizeData component1() {
            return this.start;
        }

        @NotNull
        public final APTFilter.APTFilterSizeData component2() {
            return this.end;
        }

        @NotNull
        public final APTFilter.APTFilterSizeRange copy(@NotNull APTFilter.APTFilterSizeData var1, @NotNull APTFilter.APTFilterSizeData var2) {
            Intrinsics.checkParameterIsNotNull(var1, "start");
            Intrinsics.checkParameterIsNotNull(var2, "end");
            return new APTFilter.APTFilterSizeRange(var1, var2);
        }

        public boolean equals(@Nullable Object var1) {
            boolean var2;
            if (var1 instanceof APTFilter.APTFilterSizeRange && ((APTFilter.APTFilterSizeRange) var1).start.getMeter() == this.start.getMeter() && ((APTFilter.APTFilterSizeRange) var1).end.getMeter() == this.end.getMeter()) {
                var2 = true;
            } else {
                var2 = false;
            }

            return var2;
        }

        @NotNull
        public final APTFilter.APTFilterSizeData getEnd() {
            return this.end;
        }

        @NotNull
        public final IntRange getRange() {
            return this.range;
        }

        @NotNull
        public final APTFilter.APTFilterSizeData getStart() {
            return this.start;
        }

        public int hashCode() {
            int var2 = 0;
            APTFilter.APTFilterSizeData var3 = this.start;
            int var1;
            if (var3 != null) {
                var1 = var3.hashCode();
            } else {
                var1 = 0;
            }

            var3 = this.end;
            if (var3 != null) {
                var2 = var3.hashCode();
            }

            return var1 * 31 + var2;
        }

        public String toString() {
            return "APTFilterSizeRange(start=" + this.start + ", end=" + this.end + ")";
        }
    }

    public static final class APTFilterSizeData {
        private final int meter;

        public APTFilterSizeData(int var1) {
            this.meter = var1;
        }

        // $FF: synthetic method
        // $FF: bridge method
        @NotNull
        public static APTFilter.APTFilterSizeData copy$default(APTFilter.APTFilterSizeData var0, int var1, int var2, Object var3) {
            if ((var2 & 1) != 0) {
                var1 = var0.meter;
            }

            return var0.copy(var1);
        }

        public final int component1() {
            return this.meter;
        }

        @NotNull
        public final APTFilter.APTFilterSizeData copy(int var1) {
            return new APTFilter.APTFilterSizeData(var1);
        }

        public boolean equals(Object var1) {
            boolean var4 = false;
            boolean var3;
            if (this != var1) {
                var3 = var4;
                if (!(var1 instanceof APTFilter.APTFilterSizeData)) {
                    return var3;
                }

                APTFilter.APTFilterSizeData var5 = (APTFilter.APTFilterSizeData) var1;
                boolean var2;
                if (this.meter == var5.meter) {
                    var2 = true;
                } else {
                    var2 = false;
                }

                var3 = var4;
                if (!var2) {
                    return var3;
                }
            }

            var3 = true;
            return var3;
        }

        public final int getMeter() {
            return this.meter;
        }

        public final int getPyong() {
            int var1 = Integer.MAX_VALUE;
            if (this.meter != Integer.MAX_VALUE) {
                var1 = (int) Math.round((double) this.meter / 3.3D);
            }

            return var1;
        }

        public int hashCode() {
            return this.meter;
        }

        public String toString() {
            return "APTFilterSizeData(meter=" + this.meter + ")";
        }
    }

    public enum DealType {

        ALL("ALL", 2),
        RENT("RENT", 1),
        SALES("SALES", 0);
        private String type;
        private int value;

        DealType(String type, int value) {
            this.type = type;
            this.value = value;
        }

        public String getType() {
            return type;
        }

        public int getValue() {
            return value;
        }
    }

    @NotNull
    public final ArrayList getSelectedSizeIndex() {
        int var1;
        ArrayList var3;
        if(this.selectedSizeIndex == null) {
            ArrayList var4 = new ArrayList();
            Object[] var5 = getAptSizeValues();
            int var2 = 0;
            var1 = 0;

            while(true) {
                var3 = var4;
                if(var1 >= var5.length) {
                    break;
                }

                APTFilter.APTFilterSizeRange var10 = (APTFilter.APTFilterSizeRange)var5[var1];
                var4.add(Integer.valueOf(var2));
                ++var1;
                ++var2;
            }
        } else {
            Gson var14 = new Gson();
            String var6 = this.selectedSizeIndex;
            if(var6 == null) {
                Intrinsics.throwNpe();
            }

            Type var13 = (new TypeToken() {
            }).getType();
            Intrinsics.checkExpressionValueIsNotNull(var13, "object : TypeToken<T>() {} .type");
            Type var11 = var13;
            if(var13 instanceof ParameterizedType) {
                Object[] var12 = (Object[])((ParameterizedType)var13).getActualTypeArguments();
                var1 = 0;

                boolean var8;
                while(true) {
                    if(var1 >= var12.length) {
                        var8 = false;
                        break;
                    }

                    Type var7 = (Type)var12[var1];
                    boolean var9;
                    if(var7 instanceof WildcardType && ArraysKt.contains((Object[])((WildcardType)var7).getUpperBounds(), Object.class)) {
                        var9 = true;
                    } else {
                        var9 = false;
                    }

                    if(var9) {
                        var8 = true;
                        break;
                    }

                    ++var1;
                }

                var11 = var13;
                if(var8) {
                    var12 = (Object[])((ParameterizedType)var13).getActualTypeArguments();
                    var1 = 0;

                    while(true) {
                        if(var1 >= var12.length) {
                            var8 = true;
                            break;
                        }

                        if(!((Type)var12[var1] instanceof WildcardType)) {
                            var8 = false;
                            break;
                        }

                        ++var1;
                    }

                    if(!var8) {
                        //throw (Throwable)(new IllegalArgumentException("Either none or all type parameters can be wildcard in " + var13));
                    }

                    var11 = ((ParameterizedType)var13).getRawType();
                    Intrinsics.checkExpressionValueIsNotNull(var11, "type.rawType");
                }
            }

            Object var15 = var14.fromJson(var6, var11);
            Intrinsics.checkExpressionValueIsNotNull(var15, "fromJson(json, typeToken<T>())");
            var3 = (ArrayList)var15;
        }

        return var3;
    }

    @NotNull
    public final String getSelectedSizeIndexString() {
        String var5;
        if(this.selectedSizeIndex == null) {
            Gson var3 = new Gson();
            int var2 = ((Object[])getAptSizeValues()).length;
            Integer[] var4 = new Integer[var2];
            int var1 = 0;
            --var2;
            if(var2 <= 0) {
                while(true) {
                    var4[var1] = Integer.valueOf(var1);
                    if(var1 == var2) {
                        break;
                    }

                    ++var1;
                }
            }

            var5 = var3.toJson(var4);
            Intrinsics.checkExpressionValueIsNotNull(var5, "Gson().toJson(Array(APT_…S.count(), { i -> (i) }))");
        } else {
            String var6 = this.selectedSizeIndex;
            var5 = var6;
            if(var6 == null) {
                Intrinsics.throwNpe();
                var5 = var6;
            }
        }

        return var5;
    }
}
