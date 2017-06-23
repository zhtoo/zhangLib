package com.hs.recyclerviewdemo.adapter;

import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.hs.recyclerviewdemo.R;
import com.hs.recyclerviewdemo.bean.DemoItem;
import com.hs.recyclerviewdemo.ui.DetailActivity;
import com.hs.recyclerviewdemo.ui.SelectActivity;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;


public class ItemsAdapter extends BaseAbstractRecycleCursorAdapter<RecyclerView.ViewHolder> {
    private final LayoutInflater mLayoutInflater;

    public ItemsAdapter(Context context) {
        super(context, null);
        mLayoutInflater = LayoutInflater.from(context);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, Cursor cursor) {
        DemoItem item = DemoItem.fromCursor(cursor);
        ((NormalTextViewHolder) holder).mTextView.setText(item.title);
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new NormalTextViewHolder(mLayoutInflater.inflate(R.layout.item_text, parent, false), this);
    }

    public static class NormalTextViewHolder extends RecyclerView.ViewHolder {
        @Bind(R.id.text_view)
        TextView mTextView;
        ItemsAdapter mAdapter;

        NormalTextViewHolder(View view, ItemsAdapter adapter) {
            super(view);
            mAdapter = adapter;
            ButterKnife.bind(this, view);
        }

        @OnClick(R.id.cv_item)
        void onItemClick() {
            Log.d("NormalTextViewHolder", "onClick--> position = " + getPosition());
            DemoItem item = DemoItem.fromCursor((Cursor) mAdapter.getItem(getPosition()));
            if (getPosition() < 11) {
                Intent intent = new Intent(mAdapter.mContext, DetailActivity.class);
                intent.putExtra("position", getPosition());
                intent.putExtra("title", item.title);
                mAdapter.mContext.startActivity(intent);
            } else {
                Intent intent = new Intent(mAdapter.mContext, SelectActivity.class);
                intent.putExtra("position", getPosition());
                intent.putExtra("title", item.title);
                mAdapter.mContext.startActivity(intent);
            }
        }
    }
}
