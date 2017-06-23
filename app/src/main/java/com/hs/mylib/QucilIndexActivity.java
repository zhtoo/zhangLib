package com.hs.mylib;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.LinearLayout;


import com.hs.quickindex.IndexView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by zhanghaitao on 2017/5/24.
 */

public class QucilIndexActivity extends AppCompatActivity {

    private LinearLayout mContainer;
    private List<String> customs;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_qucik_index);
        mContainer = (LinearLayout) findViewById(R.id.my_index_container);
        customs = new ArrayList<>();
        initData();
        IndexView view = new IndexView(this, customs);
        mContainer.addView(view.getView());

    }

    private void initData() {
        customs.add("李伟");
        customs.add("张三");
        customs.add("阿三");
        customs.add("阿四");
        customs.add("段誉");
        customs.add("段正淳");
        customs.add("张三丰");
        customs.add("陈坤");
        customs.add("林俊杰1");
        customs.add("陈坤2");
        customs.add("王二a");
        customs.add("林俊杰a");
        customs.add("张四");
        customs.add("林俊杰");
        customs.add("王二");
        customs.add("王二b");
        customs.add("赵四");
        customs.add("杨坤");
        customs.add("赵子龙");
        customs.add("杨坤1");
        customs.add("李伟1");
        customs.add("宋江");
        customs.add("宋江1");
        customs.add("李伟3");
        customs.add("吖");
        customs.add("不知道");
        customs.add("蔡明");
        customs.add("董不");
        customs.add("额");
        customs.add("发");
        customs.add("个");
        customs.add("和");
        customs.add("int");
        customs.add("就");
        customs.add("看");
        customs.add("了");
        customs.add("没");
        customs.add("你");
        customs.add("哦");
        customs.add("怕");
        customs.add("去");
        customs.add("人");
        customs.add("是");
        customs.add("他");
        customs.add("use");
        customs.add("view");
        customs.add("我");
        customs.add("下");
        customs.add("有");
        customs.add("在");
    }

}
