package com.example.demobds.view.viewholder.base;

import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.example.demobds.view.adapters.listener.OnViewItemClickListener;

import butterknife.ButterKnife;

/**
 * Created by hoanghiep on 7/22/17.
 */

public abstract class BaseViewHolder<T> extends RecyclerView.ViewHolder implements ViewHolderUtils<T> {
    private View mRootView;
    protected OnViewItemClickListener onViewItemClickListener = null;
    private int position;

    public BaseViewHolder(View itemView) {
        super(itemView);
        ButterKnife.bind(this, itemView);
    }

    public int getPositions() {
        return this.position;
    }

    public View getRootView() {
        return this.mRootView;
    }

    public abstract void onBindViews(T data);

    public void setOnViewItemClickListener(OnViewItemClickListener paramOnViewItemClickListener) {
        this.onViewItemClickListener = paramOnViewItemClickListener;
    }

    public void setPosition(int position) {
        this.position = position;
    }

    public void setRootView(View paramView) {
        this.mRootView = paramView;
    }
}
