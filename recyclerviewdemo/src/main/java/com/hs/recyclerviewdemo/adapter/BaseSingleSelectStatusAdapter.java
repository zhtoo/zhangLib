package com.hs.recyclerviewdemo.adapter;

import android.content.Context;
import android.widget.BaseAdapter;


public abstract class BaseSingleSelectStatusAdapter<T> extends BaseRecyclerAdapter<T> {
    protected int mCurrentSelect = -1;
    protected boolean isEnableSelect = true;

    public BaseSingleSelectStatusAdapter(Context context) {
        super(context);
    }

    public boolean isSelectDate() {
        return mCurrentSelect >= 0;
    }

    public void setEnableSelect(boolean isEnableSelect) {
        this.isEnableSelect = isEnableSelect;
    }

    public int getCurrentSelect() {
        return mCurrentSelect;
    }

    public void setCurrentSelect(int currentSelect) {
        notifyItemChanged(mCurrentSelect);
        this.mCurrentSelect = currentSelect;
        notifyItemChanged(mCurrentSelect);
    }
}
