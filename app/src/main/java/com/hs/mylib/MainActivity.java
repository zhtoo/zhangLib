package com.hs.mylib;


import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    private ImageView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test);
        imageView = (ImageView) findViewById(R.id.iv_realNameStatus);
        String[] testArray = getResources().getStringArray(R.array.actions_text);
        for (String name:testArray){
            Log.d("我是测试",name);
        }

    }

    @Override
    public void onWindowFocusChanged(boolean hasFocus) {
        super.onWindowFocusChanged(hasFocus);
        imageView.setImageResource(R.drawable.account_register_2);
        AnimationDrawable animationDrawable = (AnimationDrawable)imageView.getDrawable();
        animationDrawable.start();
    }
}
