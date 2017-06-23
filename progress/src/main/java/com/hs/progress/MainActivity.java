package com.hs.progress;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    private ColorProgressBar bar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        bar = (ColorProgressBar)findViewById(R.id.bar);
    }

    public void click10(View view){
        Log.d("test","点击");
        bar.setMaxProgress(100);
        bar.setCurrentProgress(10);
    }

    public void click20(View view){
        Log.d("test","点击");
        bar.setMaxProgress(100);
        bar.setCurrentProgress(20);
    }


    public void click40(View view){
        Log.d("test","点击");
        bar.setMaxProgress(100);
        bar.setCurrentProgress(40);
    }

    public void click60(View view){
        Log.d("test","点击");
        bar.setMaxProgress(100);
        bar.setCurrentProgress(60);
    }

    public void click80(View view){
        Log.d("test","点击");
        bar.setMaxProgress(100);
        bar.setCurrentProgress(80);
    }
    public void click100(View view){
        Log.d("test","点击");
        bar.setMaxProgress(100);
        bar.setCurrentProgress(100);
    }
}
