package com.example.demobds.view.fragments;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.example.demobds.R;
import com.example.demobds.view.activity.BaseActivity;
import com.example.demobds.view.adapters.ApartmentHousingAdapter;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * Created by hoanghiep on 7/21/17.
 */

public class MainTabHome1Fragment extends BaseFragment {
    @BindView(R.id.container)
    RecyclerView recyclerView;

    @Override
    protected void injectDependences() {

    }

    @Override
    protected void attachView() {

    }

    @Override
    protected int getFragmentLayout() {
        return R.layout.fragment_main_tab_home1;
    }

    @Override
    protected void bindEventHandlers(View view, Bundle savedInstanceState) {
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        ApartmentHousingAdapter apartmentHousingAdapter = new ApartmentHousingAdapter((BaseActivity)getActivity());
        recyclerView.setAdapter(apartmentHousingAdapter);
    }

    @Override
    protected void onSubscribeEvent(Object object) {

    }
}
