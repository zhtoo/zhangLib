package com.hs.recyclerviewdemo.adapter;

import android.content.Context;


public class DefaultSingleAdapter extends SettingSingleSelectAdapter<String> {

    public DefaultSingleAdapter(Context context) {
        super(context);
    }

    @Override
    public String getItemTitle(int position) {
        return getItemData(position);
    }
}
