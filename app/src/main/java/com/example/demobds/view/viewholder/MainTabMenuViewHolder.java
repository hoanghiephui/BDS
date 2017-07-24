package com.example.demobds.view.viewholder;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.LinearLayout;

import com.example.demobds.R;
import com.example.demobds.view.viewholder.base.BaseViewHolder;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by hoanghiep on 7/22/17.
 */

public class MainTabMenuViewHolder extends RecyclerView.ViewHolder {
    @BindView(R.id.btn_main_tab1_search_map)
    LinearLayout mainTabSeachMap;

    public MainTabMenuViewHolder(View itemView) {
        super(itemView);
        ButterKnife.bind(this, itemView);
    }


    @OnClick(R.id.btn_main_tab1_search_map)
    public void onClickSearchMap() {

    }

    @OnClick(R.id.btn_main_tab1_search_officetel)
    public void onClickSearchOffice() {

    }

    @OnClick(R.id.btn_main_tab1_search_subway)
    public void onClickSearchSubWay() {

    }
}
