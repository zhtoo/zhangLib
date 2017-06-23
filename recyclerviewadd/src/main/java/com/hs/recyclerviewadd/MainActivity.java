package com.hs.recyclerviewadd;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.hs.recyclerviewadd.adapter.HeaderBottomAdapter;

/**
 * 给RecyclerView添加头布局和脚布局
 * RecyclerView通过getItemViewType来实现复杂布局
 */
public class MainActivity extends AppCompatActivity {

    private RecyclerView mRecyclerView;
    private LinearLayoutManager layoutManager;
    private HeaderBottomAdapter adapter;
    private GridLayoutManager gridLayoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mRecyclerView = (RecyclerView) findViewById(R.id.rv_list);
        //List布局
        layoutManager = new LinearLayoutManager(this);
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        mRecyclerView.setLayoutManager(layoutManager);
        mRecyclerView.setAdapter(adapter = new HeaderBottomAdapter(this));


        //Grid布局
        /*gridLayoutManager = new GridLayoutManager(MainActivity.this, 2);
        mRecyclerView.setLayoutManager(gridLayoutManager);//这里用线性宫格显示 类似于grid view
        mRecyclerView.setAdapter(adapter = new HeaderBottomAdapter(this));

        gridLayoutManager.setSpanSizeLookup(new GridLayoutManager.SpanSizeLookup() {
            @Override
            public int getSpanSize(int position) {
                return (adapter.isHeaderView(position) || adapter.isBottomView(position)) ? gridLayoutManager.getSpanCount() : 1;
            }
        });*/




    }
}
