package com.example.demobds.view.adapters;

import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;

import com.example.demobds.view.fragments.MainTabHome1Fragment;
import com.example.demobds.view.fragments.MainTabHome2Fragment;

/**
 * Created by hoanghiep on 7/21/17.
 */

public class MainPagerAdapter extends FragmentPagerAdapter implements ViewPager.OnPageChangeListener {
    private int currentPosition;
    private Fragment[] fragments = {new MainTabHome1Fragment(), new MainTabHome2Fragment()};

    public MainPagerAdapter(FragmentManager fm) {
        super(fm);
        this.currentPosition = -1;
    }

    @Override
    public Fragment getItem(int position) {
        Fragment localFragment = this.fragments[position];
        return localFragment;
    }

    @Override
    public int getCount() {
        return fragments.length;
    }

    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

    }

    @Override
    public void onPageSelected(int position) {

    }

    @Override
    public void onPageScrollStateChanged(int state) {

    }
}
