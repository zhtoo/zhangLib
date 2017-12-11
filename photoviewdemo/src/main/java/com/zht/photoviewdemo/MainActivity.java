package com.zht.photoviewdemo;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.zht.photoviewdemo.view.PhotoView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        PhotoView mPhontoView = (PhotoView) findViewById(R.id.iv_photoView);
        mPhontoView.enable();   //设置可缩放

    }
}

