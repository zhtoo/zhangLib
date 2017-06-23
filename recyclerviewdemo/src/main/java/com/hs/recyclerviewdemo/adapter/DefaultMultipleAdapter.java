package com.hs.recyclerviewdemo.adapter;

import android.content.Context;


public class DefaultMultipleAdapter extends MultiSettingSelectAdapter<String> {

    public DefaultMultipleAdapter(Context context) {
        super(context);
    }

    @Override
    public String getItemTitle(int position) {
        return getItemData(position);
    }
}
