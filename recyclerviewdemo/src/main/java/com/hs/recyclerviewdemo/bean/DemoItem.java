package com.hs.recyclerviewdemo.bean;

import android.database.Cursor;

import com.hs.recyclerviewdemo.db.ItemsDataHelper;

public class DemoItem {
    public int id;
    public String title;

    public DemoItem() {
    }

    public DemoItem(int id, String title) {
        this.id = id;
        this.title = title;
    }

    public static DemoItem fromCursor(Cursor cursor) {
        DemoItem demoItem = new DemoItem();
        demoItem.id = cursor.getInt(cursor.getColumnIndex(ItemsDataHelper.ItemsDBInfo.ID));
        demoItem.title = cursor.getString(cursor.getColumnIndex(ItemsDataHelper.ItemsDBInfo.TITLE));
        return demoItem;
    }
}
