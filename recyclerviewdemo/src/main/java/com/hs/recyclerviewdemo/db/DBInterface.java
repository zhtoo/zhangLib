package com.hs.recyclerviewdemo.db;

import android.content.ContentValues;
import android.support.v4.content.CursorLoader;

import java.util.List;


public interface DBInterface<T> {
    /**
     * 查询某一条记录
     *
     * @param id ID
     * @return T 返回查询到得第一条记录
     */
    public T query(String id);

    /**
     * 删除所有数据
     *
     * @return count 本次操作的条数
     */
    public int clearAll();

    /**
     * 批量插入数据
     *
     * @param listData 需要插入的数据列表
     */
    public void bulkInsert(List<T> listData);

    public ContentValues getContentValues(T data);

    public CursorLoader getCursorLoader();
}
