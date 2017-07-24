package com.example.demobds.view.viewholder.base;

import android.support.v7.widget.RecyclerView;

/**
 * Created by hoanghiep on 7/22/17.
 */

public class ViewWrapper<V extends BaseViewHolder>
        extends RecyclerView.ViewHolder {
    private V mRootView;

    public ViewWrapper(V paramV) {
        super(paramV.itemView);
        this.mRootView = paramV;
    }

    public V getView() {
        this.mRootView.setPosition(getAdapterPosition());
        return this.mRootView;
    }
}
