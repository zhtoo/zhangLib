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

public class SerializeOneActivity extends AppCompatActivity {

    private SerializeBean serialize;
    private TextView text;
    private ParcelableBean parcelable;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_serialize_one);
        text = (TextView) findViewById(R.id.serialize_one);

       /* serialize = new SerializeBean();
        serialize.setName("张三");
        serialize.setState("健康");
        text.setText(serialize.getName()+serialize.getState()+"");*/

        parcelable = new ParcelableBean();
        parcelable.setName("张三");
        parcelable.setState("健康");
        text.setText(parcelable.getName() + parcelable.getState() + "");

    }


    @Override
    protected void onRestart() {
       /* if(serialize!=null){
            text.setText(serialize.getName()+serialize.getState()+"");
        }*/
        if (parcelable != null) {
            text.setText(parcelable.getName() + parcelable.getState() + "");
        }
        super.onRestart();
    }

    public void skip2T(View view) {
        /*Intent intent = new Intent(this, SerializeTwoActivity.class);
        Bundle bundle = new Bundle();
        bundle.putSerializable("SER_KEY", serialize);
        intent.putExtras(bundle);
        startActivity(intent);*/

        Intent intent = new Intent(this, SerializeTwoActivity.class);
        Bundle bundle = new Bundle();
        bundle.putParcelable("SER_KEY", parcelable);
        intent.putExtras(bundle);
        startActivity(intent);
    }

}
