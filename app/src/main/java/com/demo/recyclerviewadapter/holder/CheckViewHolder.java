package com.demo.recyclerviewadapter.holder;

import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.TextView;

import com.demo.recyclerviewadapter.R;
import com.demo.recyclerviewadapter.adpter.BaseViewHolder;
import com.demo.recyclerviewadapter.model.ItemData;


/**
 * Created by hzsunyj on 16/12/30.
 */
public class CheckViewHolder extends BaseViewHolder<ItemData> {

    private TextView name;

    private CheckBox check;

    /**
     * @param parent
     * @param view
     */
    public CheckViewHolder(ViewGroup parent, View view) {
        super(parent, view);
    }

    @Override
    public void findViews() {
        name = (TextView) itemView.findViewById(R.id.display_item_name);
        check = (CheckBox) itemView.findViewById(R.id.check_view);
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
