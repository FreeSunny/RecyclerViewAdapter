package com.demo.recyclerviewadapter.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;

import com.demo.recyclerviewadapter.R;
import com.demo.recyclerviewadapter.adpter.BaseDelegate;
import com.demo.recyclerviewadapter.adpter.BaseViewHolder;
import com.demo.recyclerviewadapter.adpter.LoadMoreAdapter;
import com.demo.recyclerviewadapter.holder.TextViewHolder;

import java.util.ArrayList;
import java.util.List;

public class ArrowActivity extends AppCompatActivity {

    public static void start(Context context) {
        Intent intent = new Intent(context, ArrowActivity.class);
        context.startActivity(intent);
    }

    private RecyclerView loadMore;

    private List<String> datas;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_arrow);
        findViews();
        init();
    }

    private void findViews() {
        loadMore = (RecyclerView) findViewById(R.id.load_more);
    }

    private void init() {
        final LinearLayoutManager layout = new LinearLayoutManager(this);
        loadMore.setLayoutManager(layout);
        datas = new ArrayList<>();
        setData();
        final LoadMoreAdapter adapter = new LoadMoreAdapter(datas, new BaseDelegate() {
            @Override
            public BaseViewHolder onCreateViewHolder(ViewGroup parent, View view, int viewType) {
                return new TextViewHolder(parent, view);
            }

            @Override
            public int getItemViewType(Object data) {
                return 0;
            }

            @Override
            public int getLayoutId(int viewType) {
                return R.layout.view_holder_item_text;
            }
        });
        loadMore.setAdapter(adapter);
        loadMore.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrollStateChanged(RecyclerView recyclerView, int newState) {
                super.onScrollStateChanged(recyclerView, newState);
            }

            @Override
            public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
                super.onScrolled(recyclerView, dx, dy);
                int lastVisibleItemPosition = layout.findLastVisibleItemPosition();
                if (lastVisibleItemPosition + 1 == adapter.getItemCount()) {
                    adapter.notifyItemRemoved(lastVisibleItemPosition);
                    setData();
                }
            }
        });
    }

    private void setData() {
        for (int i = 0; i < 20; ++i) {
            datas.add("item = " + i);
        }
    }
}
