package com.example.demobds.view.adapters;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.demobds.R;
import com.example.demobds.models.BannerModel;
import com.example.demobds.view.activity.BaseActivity;
import com.example.demobds.view.viewholder.MainApartmentHousingNewsViewHolder;
import com.example.demobds.view.viewholder.MainApartmentHousingReadViewHolder;
import com.example.demobds.view.viewholder.MainApartmentHousingSnsViewHolder;
import com.example.demobds.view.viewholder.MainBannerViewHolder;
import com.example.demobds.view.viewholder.MainTabMenuViewHolder;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by hoanghiep on 7/22/17.
 */

public class ApartmentHousingAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private int[] layouts = {R.layout.item_main_tab_menu, R.layout.item_main_top_banner, R.layout.main_tab1_items_read, R.layout.item_main_tab1_zzim,
            R.layout.main_tab1_items_favorite, R.layout.main_tab_news, R.layout.item_main_tab_sns, R.layout.item_main_top_banner};

    private String[] images = {"http://static.panoramio.com/photos/large/132796978.jpg",
            "http://static.panoramio.com/photos/large/132796977.jpg",
            "http://static.panoramio.com/photos/large/133036192.jpg",
            "http://static.panoramio.com/photos/large/132796982.jpg",
            "http://static.panoramio.com/photos/large/132796981.jpg"
    };
    private List<BannerModel> list = new ArrayList<>();
    private BaseActivity baseActivity;

    public ApartmentHousingAdapter(BaseActivity baseActivity) {
        this.baseActivity = baseActivity;
        for (String image : images) {
            BannerModel bannerModel = new BannerModel();
            bannerModel.setImageUrl(image);
            list.add(bannerModel);
        }
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(viewType, parent, false);
        switch (viewType) {
            case R.layout.item_main_tab_menu:
                return new MainTabMenuViewHolder(view);
            case R.layout.item_main_top_banner:
                return new MainBannerViewHolder(view);
            case R.layout.main_tab1_items_read:
                return new MainApartmentHousingReadViewHolder(view);
            case R.layout.item_main_tab1_zzim:
                return new MainApartmentHousingReadViewHolder(view);
            case R.layout.main_tab1_items_favorite:
                return new MainApartmentHousingReadViewHolder(view);
            case R.layout.main_tab_news:
                return new MainApartmentHousingNewsViewHolder(view);
            case R.layout.item_main_tab_sns:
                return new MainApartmentHousingSnsViewHolder(view);
            default:
                return new MainBannerViewHolder(view);
        }
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        if (position == 0) {
            ((MainTabMenuViewHolder) holder).onBindViews(baseActivity);
        } else if (position == 1) {
            ((MainBannerViewHolder) holder).onBindViews(list);
        } else if (position == 7) {
            ((MainBannerViewHolder) holder).onBindViews(list);
        }
    }

    @Override
    public int getItemCount() {
        return layouts.length;
    }

    @Override
    public int getItemViewType(int position) {
        return this.layouts[position];
    }

    @Override
    public void onDetachedFromRecyclerView(RecyclerView recyclerView) {
        super.onDetachedFromRecyclerView(recyclerView);
    }
}
