package com.hs.mylib;

import android.os.Handler;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.hs.ptr.DividerItemDecoration;
import com.hs.ptr.adapter.RecyclerAdapter;
import com.king.view.superswiperefreshlayout.SuperSwipeRefreshLayout;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by zhanghaitao on 2017/5/17.
 */

public class TestActivity extends RefreshableActivity {



    private SuperSwipeRefreshLayout ssrl;
    private RecyclerView recyclerView;
    private RecyclerAdapter adapter;
    private List<String> listData;
    private int[] colors = new int[]{
            0x7fff0000, 0x700ff000, 0x7f0000ff
    };
    @Override
    public void initUI() {
        setContentView(R.layout.activity_main);
        ssrl = findView(R.id.ssrl);
        ssrl.setColorSchemeColors(colors);
        setLayout(ssrl);
        recyclerView = findView(R.id.recyclerView);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.addItemDecoration(new DividerItemDecoration(this, DividerItemDecoration.VERTICAL));
    }



    @Override
    public void pullRefresh() {
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                TestActivity.this.runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        listData.clear();
                        for (int i = 0; i < 20; i++) {
                            listData.add("Item" + i);
                        }

                        refreshView();
                    }
                });
            }
        }, 1500);

    }



    @Override
    public void loadMore() {

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                TestActivity.this.runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        listData.add("Item" + listData.size());
                        refreshView();
                    }
                });
            }
        }, 1500);
    }

    private void refreshView(){
        adapter.notifyDataSetChanged();
        ssrl.setRefreshing(false);
    }

    @Override
    public void initListData() {
        listData = new ArrayList<>();

        for (int i = 0; i < 20; i++) {
            listData.add("Item" + i);
        }

        adapter = new RecyclerAdapter(context,listData);

        recyclerView.setLayoutManager(new LinearLayoutManager(context,LinearLayoutManager.VERTICAL,false));
        recyclerView.setAdapter(adapter);


    }
}
