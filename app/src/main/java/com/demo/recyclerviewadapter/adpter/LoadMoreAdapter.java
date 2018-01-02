package com.demo.recyclerviewadapter.adpter;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.demo.recyclerviewadapter.R;
import com.demo.recyclerviewadapter.holder.MoreViewHolder;

import java.util.List;

/**
 * Created by hzsunyj on 2018/1/2.
 */

public class LoadMoreAdapter extends BaseAdapter {

    public LoadMoreAdapter(List dataList, BaseDelegate delegate) {
        super(dataList, delegate);
    }

    public LoadMoreAdapter(List dataList, BaseDelegate delegate, OnItemClickListener listener) {
        super(dataList, delegate, listener);
    }

    @Override
    public int getItemCount() {
        int itemCount = super.getItemCount();
        return itemCount != 0 ? itemCount + 1 : 0;
    }

    @Override
    public int getItemViewType(int position) {
        if (position + 1 == getItemCount()) {
            return BaseDelegate.LOAD_MORE_;
        } else {
            return super.getItemViewType(position);
        }
    }

    @Override
    public void onBindViewHolder(BaseViewHolder holder, int position) {
        if (position + 1 == getItemCount()) {

        } else {
            super.onBindViewHolder(holder, position);
        }
    }

    @Override
    public BaseViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        if (viewType == BaseDelegate.LOAD_MORE_) {
            return new MoreViewHolder(parent, LayoutInflater.from(parent.getContext()).inflate(R.layout
                    .view_holder_item_more, parent, false));
        }
        return super.onCreateViewHolder(parent, viewType);
    }
}
