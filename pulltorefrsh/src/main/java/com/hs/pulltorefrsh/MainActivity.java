package com.hs.pulltorefrsh;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.ListView;
import android.widget.Toast;

import in.srain.cube.views.ptr.PtrDefaultHandler;
import in.srain.cube.views.ptr.PtrFrameLayout;
import in.srain.cube.views.ptr.PtrHandler;
import in.srain.cube.views.ptr.header.StoreHouseHeader;
import in.srain.cube.views.ptr.util.PtrLocalDisplay;


import static in.srain.cube.views.ptr.util.PtrLocalDisplay.dp2px;

public class MainActivity extends AppCompatActivity {

    private ListView mListView;
    private MyAdapter adapter;
    private PtrFrameLayout mPtrFrameLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
       /* //1.find the listview
        mListView = (ListView) findViewById(R.id.load_more_listview);
        // 为listview的创建一个headerview,注意，如果不加会影响到加载的footview的显示！
        View headerMarginView = new View(this);
        headerMarginView.setLayoutParams(new AbsListView.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, dp2px(20)));
        mListView.addHeaderView(headerMarginView);
        //2.绑定模拟的数据
        adapter = new MyAdapter(this, datas);
        mListView.setAdapter(adapter);
        //3.设置下拉刷新组件和事件监听
        mPtrFrameLayout = (PtrFrameLayout) findViewById(R.id.load_more_list_view_ptr_frame);
        mPtrFrameLayout.setLoadingMinTime(1000);
        mPtrFrameLayout.setResistance(2.0f);
//        final MaterialHeader header = new MaterialHeader(this);
//        int[] colors = getResources().getIntArray(R.array.google_colors);
//        header.setColorSchemeColors(colors);
//        header.setLayoutParams(new PtrFrameLayout.LayoutParams(-1, -2));
//        header.setPadding(0, PtrLocalDisplay.dp2px(20), 0, PtrLocalDisplay.dp2px(20));

        StoreHouseHeader header = new StoreHouseHeader(this);
        header.setPadding(0, PtrLocalDisplay.dp2px(20), 0, PtrLocalDisplay.dp2px(20));
        header.initWithStringArray(R.array.akta);

        mPtrFrameLayout.setLoadingMinTime(1000);
        mPtrFrameLayout.setDurationToCloseHeader(2000);
        mPtrFrameLayout.setHeaderView(header);
        mPtrFrameLayout.addPtrUIHandler(header);
        //设置延时自动刷新数据
        mPtrFrameLayout.postDelayed(new Runnable() {
            @Override
            public void run() {
                mPtrFrameLayout.autoRefresh(false);
            }
        }, 200);
        mPtrFrameLayout.setPtrHandler(new PtrHandler() {
            @Override
            public boolean checkCanDoRefresh(PtrFrameLayout frame, View content, View header) {
                // here check list view, not content.
                return PtrDefaultHandler.checkContentCanBePulledDown(frame, mListView, header);
            }

            @Override
            public void onRefreshBegin(PtrFrameLayout frame) {
                //实现下拉刷新的功能
                Log.i("test", "-----onRefreshBegin-----");
                mPtrFrameLayout.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        initData();
                        mPtrFrameLayout.refreshComplete();
                        Toast.makeText(MainActivity.this, "刷新成功", Toast.LENGTH_SHORT).show();
                        //第一个参数是：数据是否为空；第二个参数是：是否还有更多数据
                        mLoadMoreListViewContainer.loadMoreFinish(false, true);
                    }
                }, 2000);
            }
        });

        //4.加载更多的组件
        mLoadMoreListViewContainer = (LoadMoreListViewContainer) findViewById(R.id.load_more_list_view_container);
        mLoadMoreListViewContainer.setAutoLoadMore(false);//设置是否自动加载更多
        mLoadMoreListViewContainer.useDefaultHeader();
        //5.添加加载更多的事件监听
        mLoadMoreListViewContainer.setLoadMoreHandler(new LoadMoreHandler() {
            @Override
            public void onLoadMore(LoadMoreContainer loadMoreContainer) {
                //模拟加载更多的业务处理
                mLoadMoreListViewContainer.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        loadMore();
                        mLoadMoreListViewContainer.loadMoreFinish(false, true);
                    }
                }, 1000);
            }
        });*/

    }

    private void initData() {
        /*datas.clear();
        for (int i = 0; i < 20; i++) {
            datas.add("测试数据" + i);
        }
        adapter.refresh();*/
    }

    private void loadMore() {
        /*for (int i = 0; i < 20; i++) {
            datas.add("新增数据" + i);
        }
        adapter.refresh();*/
    }

    private class MyAdapter {
        public MyAdapter(MainActivity mainActivity, Object p1) {
        }
    }
}
