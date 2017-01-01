package com.demo.recyclerviewadapter.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;

import com.demo.recyclerviewadapter.R;
import com.demo.recyclerviewadapter.adpter.BaseAdapter;
import com.demo.recyclerviewadapter.adpter.onItemClickListener;
import com.demo.recyclerviewadapter.holder.SettingDelegate;
import com.demo.recyclerviewadapter.model.ItemData;
import com.demo.recyclerviewadapter.uitl.ToolbarHelper;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private RecyclerView settingInfo;

    private List<ItemData> datas;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findViews();
        initTitle();
        initData();
        initRecyclerView();
    }

    /**
     * find views
     */
    private void findViews() {
        settingInfo = (RecyclerView) findViewById(R.id.setting_info);
    }

    /**
     * init title bar
     */
    private void initTitle() {
        Toolbar myToolbar = (Toolbar) findViewById(R.id.my_toolbar);
        myToolbar.setNavigationIcon(android.support.v7.appcompat.R.drawable.abc_ic_ab_back_material);
        myToolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setResult(RESULT_CANCELED);
                finish();
            }
        });
        ToolbarHelper.layoutTitleCenter(this, myToolbar, getString(R.string.title));
    }

    private void initData() {
        datas = new ArrayList<>(20);
        datas.add(new ItemData(0, SettingDelegate.SELF_INFO));
        datas.add(new ItemData(0, SettingDelegate.SEPARATE_TYPE));
        for (int i = 0; i < 3; ++i) {
            datas.add(new ItemData(0, SettingDelegate.ARROW_TYPE, "我是箭头"));
            datas.add(new ItemData(0, SettingDelegate.CHECK_TYPE, "选中我"));
            datas.add(new ItemData(0, SettingDelegate.TOGGLE_TYPE, "开启"));
            datas.add(new ItemData(0, SettingDelegate.SEPARATE_TYPE));
        }
        datas.add(new ItemData(0, SettingDelegate.LOGOUT_TYPE));
    }

    /**
     * init
     */
    private void initRecyclerView() {
        settingInfo.setHasFixedSize(true);
        DividerItemDecoration decor = new DividerItemDecoration(this, DividerItemDecoration.VERTICAL);
        settingInfo.addItemDecoration(decor);
        settingInfo.setLayoutManager(new LinearLayoutManager(this));
        settingInfo.setAdapter(new BaseAdapter(datas, new SettingDelegate(), new onItemClickListener() {
            @Override
            public void onClick(View v, Object data) {
                ArrowActivity.start(MainActivity.this);
            }

            @Override
            public boolean onLongClick(View v, Object data) {
                return false;
            }
        }));
    }
}