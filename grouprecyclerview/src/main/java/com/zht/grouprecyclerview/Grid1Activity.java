package com.zht.grouprecyclerview;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.widget.TextView;
import android.widget.Toast;

import com.zht.grouprecyclerview.View.BaseViewHolder;
import com.zht.grouprecyclerview.View.GroupedGridLayoutManager;
import com.zht.grouprecyclerview.View.GroupedRecyclerViewAdapter;


/**
 * 子项为Grid布局的分组列表。给RecyclerView的LayoutManager
 * 设置为{@link GroupedGridLayoutManager}即可。
 */
public class Grid1Activity extends AppCompatActivity {

    private TextView tvTitle;
    private RecyclerView rvList;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_group_list);

        tvTitle = (TextView) findViewById(R.id.tv_title);
        rvList = (RecyclerView) findViewById(R.id.rv_list);

        tvTitle.setText(R.string.grid_children_1);

        GroupedListAdapter adapter = new GroupedListAdapter(this, GroupModel.getGroups(10, 10));


        adapter.setOnHeaderClickListener(new GroupedRecyclerViewAdapter.OnHeaderClickListener() {
            @Override
            public void onHeaderClick(GroupedRecyclerViewAdapter adapter, BaseViewHolder holder, int groupPosition) {
                Toast.makeText(Grid1Activity.this, "组头：groupPosition = " + groupPosition,
                        Toast.LENGTH_LONG).show();
            }
        });
        adapter.setOnFooterClickListener(new GroupedRecyclerViewAdapter.OnFooterClickListener() {
            @Override
            public void onFooterClick(GroupedRecyclerViewAdapter adapter, BaseViewHolder holder, int groupPosition) {
                Toast.makeText(Grid1Activity.this, "组尾：groupPosition = " + groupPosition,
                        Toast.LENGTH_LONG).show();
            }
        });
        adapter.setOnChildClickListener(new GroupedRecyclerViewAdapter.OnChildClickListener() {
            @Override
            public void onChildClick(GroupedRecyclerViewAdapter adapter, BaseViewHolder holder,
                                     int groupPosition, int childPosition) {
                Toast.makeText(Grid1Activity.this, "子项：groupPosition = " + groupPosition
                                + ", childPosition = " + childPosition,
                        Toast.LENGTH_LONG).show();
            }
        });
        rvList.setAdapter(adapter);


        //直接使用GroupedGridLayoutManager实现子项的Grid效果
        GroupedGridLayoutManager gridLayoutManager = new GroupedGridLayoutManager(this, 4, adapter);
        rvList.setLayoutManager(gridLayoutManager);

    }

    public static void openActivity(Context context) {
        Intent intent = new Intent(context, Grid1Activity.class);
        context.startActivity(intent);
    }
}
