package com.example.demobds.view.viewholder;

import android.view.View;

import com.example.demobds.R;
import com.example.demobds.models.BannerModel;
import com.example.demobds.view.viewholder.base.BaseViewHolder;
import com.freegeek.android.materialbanner.MaterialBanner;
import com.freegeek.android.materialbanner.holder.ViewHolderCreator;

import java.util.List;

import butterknife.BindView;

/**
 * Created by hoanghiep on 7/22/17.
 */

public class MainBannerViewHolder extends BaseViewHolder<List<BannerModel>> {
    @BindView(R.id.material_banner)
    MaterialBanner bannerSlider;

    public MainBannerViewHolder(View paramView) {
        super(paramView);
    }

    @Override
    public void onBindViews(List<BannerModel> data) {
        bannerSlider.setPages(
                new ViewHolderCreator<ImageHolderView>() {
                    @Override
                    public ImageHolderView createHolder() {
                        return new ImageHolderView();
                    }
                }, data);
        bannerSlider.setIndicatorInside(true);
        bannerSlider.startTurning(3000);
    }
}
