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
public class ArrowViewHolder extends BaseViewHolder<ItemData> {

    private TextView name;

    /**
     * @param parent
     * @param view
     */
    public ArrowViewHolder(ViewGroup parent, View view) {
        super(parent, view);
    }


    @Override
    public void findViews() {
        name = (TextView) itemView.findViewById(R.id.display_setting_name);
    }

    @Override
    public void onBindViewHolder(ItemData data) {
        name.setText(data.itemDesc);
    }
}
