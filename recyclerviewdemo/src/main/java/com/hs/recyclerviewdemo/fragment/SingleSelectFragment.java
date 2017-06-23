package com.hs.recyclerviewdemo.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.hs.recyclerviewdemo.R;
import com.hs.recyclerviewdemo.adapter.DefaultSingleAdapter;
import com.hs.recyclerviewdemo.view.DividerItemDecoration;

import java.util.ArrayList;
import java.util.Collections;

import butterknife.Bind;
import butterknife.ButterKnife;


public class SingleSelectFragment extends Fragment {
    @Bind(R.id.recycler_view)
    RecyclerView mRecyclerView;

    public SingleSelectFragment() {

    }

    public static SingleSelectFragment newInstance() {
        return new SingleSelectFragment();
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
        mRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));//这里用线性显示 类似于list view
        DefaultSingleAdapter adapter = new DefaultSingleAdapter(getActivity());
        ArrayList<String> items = new ArrayList<>();
        Collections.addAll(items, getActivity().getResources().getStringArray(R.array.titles));
        adapter.addItems(items);
        mRecyclerView.setAdapter(adapter);
        mRecyclerView.setItemAnimator(new DefaultItemAnimator());
        mRecyclerView.addItemDecoration(new DividerItemDecoration(getActivity(), LinearLayout.VERTICAL));
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        ButterKnife.unbind(this);
    }
}
