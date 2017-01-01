package com.demo.recyclerviewadapter.adpter;

import android.view.View;

/**
 * Created by hzsunyj on 16/12/30.
 */
public interface onItemClickListener<T> {
    void onClick(View v, T data);

    boolean onLongClick(View v, T data);
}
