package com.demo.recyclerviewadapter.holder;

import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.demo.recyclerviewadapter.R;
import com.demo.recyclerviewadapter.adpter.BaseViewHolder;
import com.demo.recyclerviewadapter.model.ItemData;


/**
 * Created by hzsunyj on 16/12/30.
 */
public class LogoutViewHolder extends BaseViewHolder<ItemData> {


    private TextView logout;

    /**
     * @param parent
     * @param view
     */
    public LogoutViewHolder(ViewGroup parent, View view) {
        super(parent, view);
    }

    @Override
    public void findViews() {
        logout = (TextView) itemView.findViewById(R.id.logout_btn);
    }

    @Override
    public void onBindViewHolder(ItemData data) {

    }

    @Override
    public boolean enable() {
        return false;
    }
}
