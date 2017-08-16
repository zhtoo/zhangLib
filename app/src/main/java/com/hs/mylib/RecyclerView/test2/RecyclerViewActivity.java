package com.hs.mylib.RecyclerView.test2;



import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuItem;

import com.hs.mylib.R;
import com.hs.mylib.RecyclerView.widgets.CustomLinearLayoutManager;

public class RecyclerViewActivity extends Activity {
	private RecyclerView mRecyclerViewHorizontal;
	private RecyclerView mRecyclerViewVertical;
	private RecyclerView.Adapter mAdapter;
//	private RecyclerView.LayoutManager mLayoutManager;
	CustomLinearLayoutManager mLayoutManager;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_recyclerview);
		initViews();
	}

	private void initViews() {
		/* 水平的RecyclerView */
		mRecyclerViewHorizontal = (RecyclerView) findViewById(R.id.my_recycler_view_horizontal);
		// use this setting to improve performance if you know that changes
		// in content do not change the layout size of the RecyclerView
		mRecyclerViewHorizontal.setHasFixedSize(true);
		// use a linear layout manager
//		mLayoutManager = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
		mLayoutManager = new CustomLinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
		mRecyclerViewHorizontal.setLayoutManager(mLayoutManager);
		// specify an adapter (see also next example)
		String[] myHorizontalDataset = new String[15];

		for (int i = 0; i < 15; i++) {
			myHorizontalDataset[i] = "Horizontal RecyclerView text " + (i + 1);
		}
		mAdapter = new MyAdapter(myHorizontalDataset);
		mRecyclerViewHorizontal.setAdapter(mAdapter);
		/* 垂直的Recyclerview */
		mRecyclerViewVertical = (RecyclerView) findViewById(R.id.my_recycler_view_vertical);
		mRecyclerViewVertical.setHasFixedSize(true);
		mLayoutManager = new CustomLinearLayoutManager(this);
		mRecyclerViewVertical.setLayoutManager(mLayoutManager);
		String[] myVerticalDataset = new String[30];

		for (int i = 0; i < 30; i++) {
			myVerticalDataset[i] = "Vertical RecyclerView text " + (i + 1);
		}
		mAdapter = new MyAdapter(myVerticalDataset);
		mRecyclerViewVertical.setAdapter(mAdapter);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		getMenuInflater().inflate(R.menu.recyclerview, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		switch (item.getItemId()) {
		case R.id.CardView:
			startActivity(new Intent(this, CardViewActivity.class));
			break;

		default:
			break;
		}
		return super.onOptionsItemSelected(item);
	}
}
