package com.hs.mylib.RecyclerView.test2;


import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.view.Menu;
import android.view.MenuItem;

import com.hs.mylib.R;

/**
 * @author Mr.Zheng
 * @date 2014年10月24日 下午12:55:08
 */
public class CardViewActivity extends Activity {
	private CardView mCardView;

	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_cardview1);
		initViews();
	}

	private void initViews() {
		mCardView = (CardView) findViewById(R.id.card_view);
		// mCardView.setXXX
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		getMenuInflater().inflate(R.menu.cardview, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		switch (item.getItemId()) {
		case R.id.RecyclerView:
			startActivity(new Intent(this, RecyclerViewActivity.class));
			break;

		default:
			break;
		}
		return super.onOptionsItemSelected(item);
	}
}
