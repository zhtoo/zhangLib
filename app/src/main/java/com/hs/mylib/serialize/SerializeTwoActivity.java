package com.hs.mylib.serialize;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

import com.hs.mylib.R;

/**
 * 作者：zhanghaitao on 2017/8/4 10:22
 * 邮箱：820159571@qq.com
 */

public class SerializeTwoActivity extends AppCompatActivity {

    private SerializeBean serialize;
    private TextView text;
    private ParcelableBean parcelable;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_serialize_two);
        text = (TextView) findViewById(R.id.serialize_two);

       /* serialize = (SerializeBean) getIntent().getSerializableExtra("SER_KEY");
        if (serialize != null) {
            text.setText(serialize.getName() + serialize.getState()+"");
        }*/

        parcelable = getIntent().getParcelableExtra("SER_KEY");
        if (parcelable != null) {
            text.setText(parcelable.getName() + parcelable.getState()+"");
        }




    }

    public void skip2O(View view) {
        /*serialize.setName("李四");
        serialize.setState("亚健康");
        Intent intent = new Intent(this, SerializeOneActivity.class);
        startActivity(intent);*/

        parcelable.setName("李四");
        parcelable.setState("亚健康");
        Intent intent = new Intent(this, SerializeOneActivity.class);
        startActivity(intent);
    }

}
