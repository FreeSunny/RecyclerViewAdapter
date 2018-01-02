package com.demo.recyclerviewadapter.holder;

import android.view.View;
import android.view.ViewGroup;

import com.demo.recyclerviewadapter.R;
import com.demo.recyclerviewadapter.adpter.BaseDelegate;
import com.demo.recyclerviewadapter.adpter.BaseViewHolder;
import com.demo.recyclerviewadapter.model.ItemData;


/**
 * Created by hzsunyj on 16/12/30.
 */
public class SettingDelegate extends BaseDelegate<ItemData> {

    public static final int SEPARATE_TYPE = 0;

    public static final int SELF_INFO = 1;

    public static final int ARROW_TYPE = 2;

    public static final int CHECK_TYPE = 3;

    public static final int TOGGLE_TYPE = 4;

    public static final int LOGOUT_TYPE = 5;

    @Override
    public BaseViewHolder onCreateViewHolder(ViewGroup parent, View view, int viewType) {
        switch (viewType) {
            case SEPARATE_TYPE:
                return new SeparateViewHolder(parent, view);
            case SELF_INFO:
                return new SelfInfoViewHolder(parent, view);
            case ARROW_TYPE:
                return new ArrowViewHolder(parent, view);
            case CHECK_TYPE:
                return new CheckViewHolder(parent, view);
            case TOGGLE_TYPE:
                return new ToggleViewHolder(parent, view);
            case LOGOUT_TYPE:
                return new LogoutViewHolder(parent, view);
        }
        return null;
    }

    @Override
    public int getItemViewType(ItemData data) {
        return data.holderType;
    }

    @Override
    public int getLayoutId(int viewType) {
        switch (viewType) {
            case SEPARATE_TYPE:
                return R.layout.view_holder_setting_separate;
            case SELF_INFO:
                return R.layout.view_holder_setting_self_info;
            case ARROW_TYPE:
                return R.layout.view_holder_setting_arrow;
            case CHECK_TYPE:
                return R.layout.view_holder_setting_check;
            case TOGGLE_TYPE:
                return R.layout.view_holder_setting_toggle;
            case LOGOUT_TYPE:
                return R.layout.view_holder_setting_logout;
        }
        return 0;
    }
}
