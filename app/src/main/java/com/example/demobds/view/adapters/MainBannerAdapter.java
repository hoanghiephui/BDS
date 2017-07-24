package com.example.demobds.view.adapters;

import android.content.Context;
import android.view.ViewGroup;

import com.example.demobds.models.MainSnsModel;
import com.example.demobds.view.adapters.base.BaseAdapter;
import com.example.demobds.view.viewholder.MainBannerViewHolder;

/**
 * Created by hoanghiep on 7/22/17.
 */

public class MainBannerAdapter extends BaseAdapter<MainSnsModel, MainBannerViewHolder> {
    public MainBannerAdapter(Context paramContext) {
        super(paramContext);
    }

    @Override
    protected void onBindItemView(MainBannerViewHolder viewHolder, int position) {
        //viewHolder.onBindViews(getItem(position));
    }

    @Override
    protected MainBannerViewHolder onCreateItemView(ViewGroup paramViewGroup, int viewType) {
        return null; //new MainBannerViewHolder(inflater.inflate(R.layout.item_banner, paramViewGroup, false));
    }
}
