package com.hs.sqldemo;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.hs.sqldemo.db.DBActivity;
import com.hs.sqldemo.db.SQLDemo;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    Button button;
    Button button2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
       button=(Button) findViewById(R.id.button);
       button2=(Button) findViewById(R.id.button2);
        button.setOnClickListener(this);
        button2.setOnClickListener(this);

    }


    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.button:
                Intent intent = new Intent(this, DBActivity.class);
                startActivity(intent);
                break;
            case R.id.button2:
                Intent intent1 = new Intent(this, SQLDemo.class);
                startActivity(intent1);
                break;
        }
    }
}
