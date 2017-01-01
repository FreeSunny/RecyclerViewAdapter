package com.demo.recyclerviewadapter.holder;

import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.ToggleButton;

import com.demo.recyclerviewadapter.R;
import com.demo.recyclerviewadapter.adpter.BaseViewHolder;
import com.demo.recyclerviewadapter.model.ItemData;

/**
 * Created by hzsunyj on 16/12/30.
 */
public class ToggleViewHolder extends BaseViewHolder<ItemData> {

    private TextView name;

    private ToggleButton toggleButton;

    /**
     * @param parent
     * @param view
     */
    public ToggleViewHolder(ViewGroup parent, View view) {
        super(parent, view);
    }

    @Override
    public void findViews() {
        name = (TextView) itemView.findViewById(R.id.display_item_name);
        toggleButton = (ToggleButton) itemView.findViewById(R.id.toggle_btn);
    }

    @Override
    public void onBindViewHolder(ItemData data) {
        name.setText(data.itemDesc);
    }

    @Override
    public boolean enable() {
        return false;
    }
}
