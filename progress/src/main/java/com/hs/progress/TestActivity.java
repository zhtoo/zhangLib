package com.hs.progress;

import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by zhanghaitao on 2017/6/9.
 */

public class TestActivity extends AppCompatActivity implements RadioGroup.OnCheckedChangeListener, View.OnClickListener {


    private TextView title;
    private RadioGroup group;
    private JsonResult result;
    private int viewId[] = {-1, -1, -1, -1, -1, -1};
    private List<RadioButton> buttons = new ArrayList<>();
    private List<Bean> classAar = new ArrayList<>();


    private static int possion = 0;
    private int[] possionAar = new int[5];
    private RadioButton radio1;
    private RadioButton radio2;
    private RadioButton radio3;
    private RadioButton radio4;
    private Button pre;
    private Button next;

private Handler handler = new Handler();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test);
        initView();
        init();
        initDate();
    }

    public void init() {

        classAar.add(0, new Bean("1、您的年龄：", new String[]{"18-24", "25-30", "31-40", "41-50"}));
        classAar.add(1, new Bean("2、您的身体健康状况：", new String[]{"非常好", "很好", "健康", "有毛病"}));
        classAar.add(2, new Bean("3、您的投资年限", new String[]{"10年以上", "5-10年", "1-5年", "1年内"}));
        classAar.add(new Bean("4、您的投资经验可以被概括为：", new String[]{"丰富：是一位积极和有经验的证券投资者，并倾向于自己作出投资决定", "一般：具有一定的证券投资经验，需要进一步的指导", "有限：有过购买国债，货币型基金等保本型金融产品投资经验", "无：除银行活期和投定期储蓄存款外，基本没有其他资经验"}));
        classAar.add(new Bean("5、今后5年内您的预期收入：", new String[]{"预期收入将逐渐增加", "预期收入将保持稳定", "预期收入将不断减少"}));

    }

    private void initView() {
        title = (TextView) findViewById(R.id.title);
        group = (RadioGroup) findViewById(R.id.group);
        radio1 = (RadioButton) findViewById(R.id.radio1);
        radio2 = (RadioButton) findViewById(R.id.radio2);
        radio3 = (RadioButton) findViewById(R.id.radio3);
        radio4 = (RadioButton) findViewById(R.id.radio4);
        buttons.add(radio1);
        buttons.add(radio2);
        buttons.add(radio3);
        buttons.add(radio4);
        pre = (Button) findViewById(R.id.pre);
        next = (Button) findViewById(R.id.next);
        group.setOnCheckedChangeListener(this);
        radio1.setOnClickListener(this);
        radio2.setOnClickListener(this);
        radio3.setOnClickListener(this);
        radio4.setOnClickListener(this);
        pre.setOnClickListener(this);
        next.setOnClickListener(this);
    }

    private void initDate() {
        title.setText(classAar.get(possion).getTitle());
        radio1.setText(classAar.get(possion).getSel()[0]);
        radio2.setText(classAar.get(possion).getSel()[1]);
        radio3.setText(classAar.get(possion).getSel()[2]);
        if (classAar.get(possion).getSel().length < 4) {
            radio4.setVisibility(View.GONE);
        } else {
            radio4.setVisibility(View.VISIBLE);
            radio4.setText(classAar.get(possion).getSel()[3]);
        }
    }


    @Override
    public void onCheckedChanged(RadioGroup group, int checkedId) {
        possionAar[possion] = checkedId;
        for (int i = 0; i < buttons.size(); i++) {
            if (checkedId == buttons.get(i).getId()) {
                buttons.get(i).setChecked(true);
            }
        }
        handler.postDelayed(new Runnable() {

            public void run() {
                next();
                handler.removeCallbacksAndMessages(null);
            }
        }, 100);
    }


    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.pre:
                pre();
                break;
            case R.id.next:
                next();
                break;
            case R.id.radio1:
                radio1.setChecked(true);
                handler.postDelayed(new Runnable() {

                    public void run() {
                        next();
                        handler.removeCallbacksAndMessages(null);
                    }
                }, 1000);
                break;
            case R.id.radio2:
                radio2.setChecked(true);
                next();
                break;
            case R.id.radio3:
                radio3.setChecked(true);
                next();
                break;
            case R.id.radio4:
                radio4.setChecked(true);
                next();
                break;
        }
    }

    private void next() {
        possion += 1;
        if (possion > 4) {
            possion = 0;
        }
        hide();
        title.setText(classAar.get(possion).getTitle());
        radio1.setText(classAar.get(possion).getSel()[0]);
        radio2.setText(classAar.get(possion).getSel()[1]);
        radio3.setText(classAar.get(possion).getSel()[2]);
        if (classAar.get(possion).getSel().length < 4) {
            radio4.setVisibility(View.GONE);
        } else {
            radio4.setVisibility(View.VISIBLE);
            radio4.setText(classAar.get(possion).getSel()[3]);
        }

    }

    private void pre() {
        possion -= 1;
        if (possion < 0) {
            possion = 4;
        }
        hide();
        title.setText(classAar.get(possion).getTitle());
        radio1.setText(classAar.get(possion).getSel()[0]);
        radio2.setText(classAar.get(possion).getSel()[1]);
        radio3.setText(classAar.get(possion).getSel()[2]);
        if (classAar.get(possion).getSel().length < 4) {
            radio4.setVisibility(View.GONE);
        } else {
            radio4.setVisibility(View.VISIBLE);
            radio4.setText(classAar.get(possion).getSel()[3]);
        }
    }


    public void hide() {
        for (int i = 0; i < buttons.size(); i++) {
            buttons.get(i).setChecked(false);
        }
    }

}







