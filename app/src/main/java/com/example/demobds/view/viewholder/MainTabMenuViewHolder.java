package com.example.demobds.view.viewholder;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.LinearLayout;

import com.example.demobds.R;
import com.example.demobds.ultis.IntentUltis;
import com.example.demobds.view.activity.BaseActivity;
import com.example.demobds.view.viewholder.base.BaseViewHolder;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by hoanghiep on 7/22/17.
 */

public class MainTabMenuViewHolder extends BaseViewHolder<BaseActivity> {
    @BindView(R.id.btn_main_tab1_search_map)
    LinearLayout mainTabSeachMap;
    private BaseActivity baseActivity;

    public MainTabMenuViewHolder(View itemView) {
        super(itemView);
        ButterKnife.bind(this, itemView);
    }

    @Override
    public void onBindViews(BaseActivity data) {
        this.baseActivity = data;
    }


    @OnClick(R.id.btn_main_tab1_search_map)
    public void onClickSearchMap() {
        IntentUltis.openSearchMap(baseActivity);
    }

    @OnClick(R.id.btn_main_tab1_search_officetel)
    public void onClickSearchOffice() {

    }

    @OnClick(R.id.btn_main_tab1_search_subway)
    public void onClickSearchSubWay() {

    }
}
