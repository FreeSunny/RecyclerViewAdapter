package com.demo.recyclerviewadapter.adpter;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;

import java.util.Collections;
import java.util.List;

/**
 * Created by hzsunyj on 16/12/30.
 */
public class BaseAdapter<T> extends RecyclerView.Adapter<BaseViewHolder> {

    /**
     * data source
     */
    public List<T> dataList;

    /**
     * onClick onLongClick callback
     */
    public OnItemClickListener listener;

    /**
     * constructor view holder delegate
     */
    public BaseDelegate delegate;

    /**
     * constructor
     *
     * @param dataList
     * @param delegate
     */
    public BaseAdapter(List<T> dataList, BaseDelegate delegate) {
        this(dataList, delegate, null);
    }

    /**
     * constructor
     *
     * @param dataList
     * @param delegate
     * @param listener
     */
    public BaseAdapter(List<T> dataList, BaseDelegate delegate, OnItemClickListener listener) {
        checkData(dataList);
        this.delegate = delegate;
        this.listener = listener;
    }

    /**
     * just is empty
     *
     * @param dataList
     */
    private void checkData(List<T> dataList) {
        if (dataList == null) {
            dataList = Collections.emptyList();
        }
        this.dataList = dataList;
    }

    /**
     * set onclick & onLongClick callback
     *
     * @param listener
     */
    public void setOnItemClickListener(OnItemClickListener listener) {
        this.listener = listener;
    }

    /**
     * create view holder
     *
     * @param parent
     * @param viewType
     * @return
     */
    @Override
    public BaseViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        BaseViewHolder baseViewHolder = delegate.onCreateViewHolder(parent, viewType);
        baseViewHolder.findViews();
        return baseViewHolder;
    }

    /**
     * bind view holder
     *
     * @param holder
     * @param position
     */
    @Override
    public void onBindViewHolder(BaseViewHolder holder, final int position) {
        holder.onBindViewHolder(dataList.get(position));
        if (listener != null && holder.enable()) {
            holder.itemView.setOnClickListener(onClickListenerMediator);
            holder.itemView.setOnLongClickListener(onLongClickListenerMediator);
        }
    }

    View.OnClickListener onClickListenerMediator = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            int position = getViewHolderAdapterPosition(v);
            listener.onClick(v, position, position >= 0 ? dataList.get(position) : null);
        }
    };

    View.OnLongClickListener onLongClickListenerMediator = new View.OnLongClickListener() {
        @Override
        public boolean onLongClick(View v) {
            int position = getViewHolderAdapterPosition(v);
            return listener.onLongClick(v, position, position >= 0 ? dataList.get(position) : null);
        }
    };

    private int getViewHolderAdapterPosition(View v) {
        if (v == null) {
            return -1;
        }
        ViewParent parent = v.getParent();
        if (parent instanceof RecyclerView) {
            ((RecyclerView) parent).getChildAdapterPosition(v);
        }
        return -1;
    }

    /**
     * get item count
     *
     * @return
     */
    @Override
    public int getItemCount() {
        return dataList.size();
    }

    /**
     * get item view type
     *
     * @param position
     * @return
     */
    @Override
    public int getItemViewType(int position) {
        return delegate.getItemViewType(dataList.get(position));
    }
}
