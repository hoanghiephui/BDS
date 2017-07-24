package com.example.demobds.view.adapters.base;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.example.demobds.view.adapters.listener.OnViewItemClickListener;
import com.example.demobds.view.viewholder.base.BaseViewHolder;
import com.example.demobds.view.viewholder.base.ViewWrapper;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by hoanghiep on 7/22/17.
 */

public abstract class BaseAdapter<D, V extends BaseViewHolder>
        extends RecyclerView.Adapter<ViewWrapper<V>> {
    protected final String TAG = getClass().getSimpleName();
    private Context context;
    private List<D> itemList = new ArrayList<>();
    protected OnViewItemClickListener onViewItemClickListener = null;
    protected LayoutInflater inflater;

    public BaseAdapter(Context paramContext) {
        if (paramContext == null) {
            throw new IllegalStateException("context == null");
        }
        this.context = paramContext;
        this.inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    public void add(D data) {
        if (data == null) {
            return;
        }
        itemList.add(data);
        notifyDataSetChanged();
    }

    public void addAll(List<D> listData) {
        if (listData == null) {
            return;
        }
        this.itemList.addAll(listData);
        notifyDataSetChanged();
    }

    public void change(D data, int position) {
        this.itemList.set(position, data);
        notifyDataSetChanged();
    }

    public void firstAdd(D data) {
        if (data == null) {
            return;
        }
        this.itemList.add(0, data);
        notifyDataSetChanged();
    }

    public Context getContext() {
        return this.context;
    }

    public D getItem(int position) {
        return itemList.get(position);
    }

    public int getItemCount() {
        return itemList.size();
    }

    public long getItemId(int position) {
        return getItem(position).hashCode();
    }

    public boolean isEmptyList() {
        return this.itemList.isEmpty();
    }

    protected abstract void onBindItemView(V viewHolder, int position);

    public void onBindViewHolder(ViewWrapper<V> paramViewWrapper, int position) {
        onBindItemView(paramViewWrapper.getView(), position);
    }

    protected abstract V onCreateItemView(ViewGroup paramViewGroup, int viewType);

    public ViewWrapper<V> onCreateViewHolder(ViewGroup paramViewGroup, int viewType) {
        return new ViewWrapper<>(onCreateItemView(paramViewGroup, viewType));
    }

    public void refresh(List<D> paramList) {
        this.itemList.clear();
        if (paramList != null) {
            this.itemList.addAll(paramList);
        }
        notifyDataSetChanged();
    }

    public void remove(int postion) {
        this.itemList.remove(postion);
        notifyDataSetChanged();
    }

    public void remove(D data) {
        this.itemList.remove(data);
        notifyDataSetChanged();
    }

    public void removeAll() {
        this.itemList.clear();
        notifyDataSetChanged();
    }

    public void setOnViewItemClickListener(OnViewItemClickListener paramOnViewItemClickListener) {
        this.onViewItemClickListener = paramOnViewItemClickListener;
    }
}
