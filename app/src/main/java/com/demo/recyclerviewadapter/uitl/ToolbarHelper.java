package com.demo.recyclerviewadapter.uitl;

import android.content.Context;
import android.support.v7.widget.Toolbar;
import android.util.TypedValue;
import android.view.Gravity;
import android.view.ViewGroup;
import android.widget.TextView;

import com.demo.recyclerviewadapter.R;


/**
 * Created by hzsunyj on 16/12/28.
 */
public class ToolbarHelper {

    /**
     * Layout title in toolbar horizontal center
     *
     * @param toolbar
     * @param titleRes
     */
    public static void layoutTitleCenter(Context context, Toolbar toolbar, int titleRes) {
        layoutTitleCenter(context, toolbar, context.getString(titleRes));
    }

    /**
     * Layout title in toolbar horizontal center, common setting style
     *
     * @param toolbar
     * @param title
     */
    public static void layoutTitleCenter(Context context, Toolbar toolbar, String title) {
        Toolbar.LayoutParams params = new Toolbar.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup
                .LayoutParams.WRAP_CONTENT);
        params.gravity = Gravity.CENTER_HORIZONTAL;
        TextView titleView = new TextView(context);
        titleView.setText(title);
        titleView.setTextColor(context.getResources().getColor(R.color.black));
        titleView.setTextSize(TypedValue.COMPLEX_UNIT_SP, 16);
        toolbar.addView(titleView, params);
    }


}
