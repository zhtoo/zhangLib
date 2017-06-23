package com.hs.mylib;

import com.king.base.BaseActivity;
import com.king.base.model.EventMessage;
import com.king.view.superswiperefreshlayout.SuperSwipeRefreshLayout;

/**
 * Created by zhanghaitao on 2017/5/17.
 */

public abstract class RefreshableActivity extends BaseActivity {

    public void setLayout(SuperSwipeRefreshLayout ssrl) {
        this.ssrl = ssrl;
    }

    private SuperSwipeRefreshLayout ssrl;


    @Override
    public void addListeners() {

        ssrl.setOnRefreshListener(new SuperSwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh(SuperSwipeRefreshLayout.Direction direction) {
                if(direction == SuperSwipeRefreshLayout.Direction.TOP){
                    pullRefresh();
                }else if(direction == SuperSwipeRefreshLayout.Direction.BOTTOM){
                    loadMore();
                }
            }
        });

    }

    public abstract void    pullRefresh();
    public abstract void    loadMore();
    public abstract void    initListData();


    @Override
    public void initData() {
        initListData();
    }

    @Override
    public void onEventMessage(EventMessage em) {

    }
}
