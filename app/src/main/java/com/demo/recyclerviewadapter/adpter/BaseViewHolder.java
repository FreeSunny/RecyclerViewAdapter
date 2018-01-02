package com.demo.recyclerviewadapter.adpter;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by hzsunyj on 16/12/30.
 */
public abstract class BaseViewHolder<T> extends RecyclerView.ViewHolder {

//    public BaseViewHolder(ViewGroup parent) {
    //        this(parent, 0);
    //    }
    //
    //    public BaseViewHolder(ViewGroup parent, int layoutId) {
    //        this(parent, LayoutInflater.from(parent.getContext()).inflate(layoutId, parent, false));
    //    }

    /**
     * @param parent current no use, may be future use
     * @param view
     */
    public BaseViewHolder(ViewGroup parent, View view) {
        super(view);
    }

    /**
     * find all views
     */
    public abstract void findViews();

    /**
     * bind view holder
     *
     * @param data
     */
    public abstract void onBindViewHolder(T data);

    /**
     * holder click enable
     *
     * @return
     */
    public boolean enable() {
        return true;
    }

}
