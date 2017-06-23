package com.hs.recyclerviewdemo.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.hs.recyclerviewdemo.R;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;


public abstract class SettingSingleSelectAdapter<T> extends BaseSingleSelectStatusAdapter<T> {

    public SettingSingleSelectAdapter(Context context) {
        super(context);
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new SettingSingleSelectViewHolder(mLayoutInflater.inflate(R.layout.item_setting_select, parent, false), this);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        if (holder instanceof SettingSingleSelectViewHolder) {
            ((SettingSingleSelectViewHolder) holder).bindViewData(getItemTitle(position), position);
        }
    }

    public abstract String getItemTitle(int position);

    static class SettingSingleSelectViewHolder extends RecyclerView.ViewHolder {
        @Bind(R.id.tv_name)
        TextView mTvName;
        @Bind(R.id.iv_check)
        ImageView mIvCheck;

        SettingSingleSelectAdapter mAdapter;

        SettingSingleSelectViewHolder(View view, SettingSingleSelectAdapter adapter) {
            super(view);
            ButterKnife.bind(this, view);
            mAdapter = adapter;
        }

        public void bindViewData(String name, int position) {
            mIvCheck.setVisibility((position == mAdapter.mCurrentSelect) ? View.VISIBLE : View.GONE);
            mTvName.setText(name);
        }

        @OnClick(R.id.fl_check)
        void onSelected() {
            if (mAdapter.isEnableSelect) {
                mAdapter.setCurrentSelect(getPosition());
            }
        }
    }
}
