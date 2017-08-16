package com.hs.mylib.RecyclerView.test;



import android.app.Activity;
import android.os.Bundle;

import com.hs.mylib.R;

import android.support.v7.widget.CardView;



/**
 * Created by dsw on 2015/10/2.
 */
public class DetailActivity extends Activity {
    private CardView cardView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cardview);
    }
}
