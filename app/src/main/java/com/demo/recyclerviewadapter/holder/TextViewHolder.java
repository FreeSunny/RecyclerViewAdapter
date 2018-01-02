package com.demo.recyclerviewadapter.holder;

import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.demo.recyclerviewadapter.adpter.BaseViewHolder;

import static com.demo.recyclerviewadapter.R.id;

/**
 * Created by hzsunyj on 2018/1/2.
 */

public class TextViewHolder extends BaseViewHolder<String> {


    private TextView textView;

    /**
     * @param parent current no use, may be future use
     * @param view
     */
    public TextViewHolder(ViewGroup parent, View view) {
        super(parent, view);
    }

    @Override
    public void findViews() {
        textView = (TextView) itemView.findViewById(id.content);
    }

    @Override
    public void onBindViewHolder(String data) {
        textView.setText(data);
    }
}
