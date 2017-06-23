package com.hs.recyclerviewdemo.fragment;

import android.database.Cursor;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.LoaderManager;
import android.support.v4.content.Loader;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.hs.recyclerviewdemo.R;
import com.hs.recyclerviewdemo.adapter.ItemsAdapter;
import com.hs.recyclerviewdemo.bean.DemoItem;
import com.hs.recyclerviewdemo.db.ItemsDataHelper;

import java.util.ArrayList;

import butterknife.Bind;
import butterknife.ButterKnife;


public class ItemsFragment extends Fragment implements LoaderManager.LoaderCallbacks<Cursor> {
    @Bind(R.id.recycler_view)
    RecyclerView mRecyclerView;
    private ItemsDataHelper mDataHelper;
    private ItemsAdapter mAdapter;

    public static ItemsFragment newInstance() {
        return new ItemsFragment();
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mDataHelper = new ItemsDataHelper(getActivity());
    }

    private void loadItems() {
        String[] items = getActivity().getResources().getStringArray(R.array.items);
        ArrayList<DemoItem> demoItems = new ArrayList<>();
        for (int i = 0; i < items.length; i++) {
            demoItems.add(new DemoItem(i, items[i]));
        }
        mDataHelper.bulkInsert(demoItems);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_normal, container, false);
        ButterKnife.bind(this, rootView);
        return rootView;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        mAdapter = new ItemsAdapter(getActivity());
        mRecyclerView.setAdapter(mAdapter);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        getLoaderManager().initLoader(0, null, this);
    }

    @Override
    public Loader<Cursor> onCreateLoader(int id, Bundle args) {
        return mDataHelper.getCursorLoader();
    }

    @Override
    public void onLoadFinished(Loader<Cursor> loader, Cursor cursor) {
        if (cursor == null || cursor.getCount() == 0) {
            loadItems();
        } else {
            mAdapter.changeCursor(cursor);
        }
    }

    @Override
    public void onLoaderReset(Loader<Cursor> loader) {
        mAdapter.changeCursor(null);
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        ButterKnife.unbind(this);
    }
}
