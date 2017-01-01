package com.demo.recyclerviewadapter.holder;

import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.demo.recyclerviewadapter.R;
import com.demo.recyclerviewadapter.adpter.BaseViewHolder;
import com.demo.recyclerviewadapter.model.ItemData;


/**
 * Created by hzsunyj on 16/12/30.
 */
public class SelfInfoViewHolder extends BaseViewHolder<ItemData> {

    private ImageView headView;

    private TextView nameGender;

    private TextView birthday;

    /**
     * @param parent
     * @param view
     */
    public SelfInfoViewHolder(ViewGroup parent, View view) {
        super(parent, view);
    }

    @Override
    public void findViews() {
        headView = (ImageView) itemView.findViewById(R.id.self_info_head_view);
        nameGender = (TextView) itemView.findViewById(R.id.self_name_gender);
        birthday = (TextView) itemView.findViewById(R.id.birthday);
    }

    @Override
    public void onBindViewHolder(ItemData data) {

    }

    @Override
    public boolean enable() {
        return false;
    }
}
