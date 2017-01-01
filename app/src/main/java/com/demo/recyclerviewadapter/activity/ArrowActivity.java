package com.demo.recyclerviewadapter.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.demo.recyclerviewadapter.R;

public class ArrowActivity extends AppCompatActivity {

    public static void start(Context context){
        Intent intent = new Intent(context, ArrowActivity.class);
        context.startActivity(intent);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_arrow);
    }
}
