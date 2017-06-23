package com.hs.progress;

import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by zhanghaitao on 2017/6/9.
 */

public class CheckActivity extends AppCompatActivity implements View.OnClickListener {


    private LinearLayout mItem1;
    private LinearLayout mItem2;
    private LinearLayout mItem3;
    private LinearLayout mItem4;
    private ImageView mImage1;
    private ImageView mImage2;
    private ImageView mImage3;
    private ImageView mImage4;
    private TextView mText1;
    private TextView mText2;
    private TextView mText3;
    private TextView mText4;

    private List<Bean> beanAar = new ArrayList<>();
    private TextView title;
    private Button pre;
    private Button next;

    private ImageView[] mImageView;

    private Handler handler = new Handler();

    private static int possion = 0;
    private static int score = 0;

    private int[] possionAar = new int[]{-1, -1, -1, -1, -1};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_check);

        title = (TextView) findViewById(R.id.title);

        pre = (Button) findViewById(R.id.pre);
        next = (Button) findViewById(R.id.next);
        pre.setOnClickListener(this);
        next.setOnClickListener(this);

        mItem1 = (LinearLayout) findViewById(R.id.check_item1);
        mItem2 = (LinearLayout) findViewById(R.id.check_item2);
        mItem3 = (LinearLayout) findViewById(R.id.check_item3);
        mItem4 = (LinearLayout) findViewById(R.id.check_item4);

        mImage1 = (ImageView) findViewById(R.id.check_image1);
        mImage2 = (ImageView) findViewById(R.id.check_image2);
        mImage3 = (ImageView) findViewById(R.id.check_image3);
        mImage4 = (ImageView) findViewById(R.id.check_image4);

        mImageView = new ImageView[]{mImage1, mImage2, mImage3, mImage4};

        mText1 = (TextView) findViewById(R.id.check_text1);
        mText2 = (TextView) findViewById(R.id.check_text2);
        mText3 = (TextView) findViewById(R.id.check_text3);
        mText4 = (TextView) findViewById(R.id.check_text4);

        mItem1.setOnClickListener(this);
        mItem2.setOnClickListener(this);
        mItem3.setOnClickListener(this);
        mItem4.setOnClickListener(this);

        init();
        setData();
    }


    public void init() {
        beanAar.add(new Bean("1、您的年龄：", new String[]{"18-24", "25-30", "31-40", "41-50"}));
        beanAar.add(new Bean("2、您的身体健康状况：", new String[]{"非常好", "很好", "健康", "有毛病"}));
        beanAar.add(new Bean("3、您的投资年限", new String[]{"10年以上", "5-10年", "1-5年", "1年内"}));
        beanAar.add(new Bean("4、您的投资经验可以被概括为：", new String[]{"丰富：是一位积极和有经验的证券投资者，并倾向于自己作出投资决定", "一般：具有一定的证券投资经验，需要进一步的指导", "有限：有过购买国债，货币型基金等保本型金融产品投资经验", "无：除银行活期和投定期储蓄存款外，基本没有其他资经验"}));
        beanAar.add(new Bean("5、今后5年内您的预期收入：", new String[]{"预期收入将逐渐增加", "预期收入将保持稳定", "预期收入将不断减少"}));

    }


    private void setData() {
        title.setText(beanAar.get(possion).getTitle());
        mText1.setText(beanAar.get(possion).getSel()[0]);
        mText2.setText(beanAar.get(possion).getSel()[1]);
        mText3.setText(beanAar.get(possion).getSel()[2]);
        if (beanAar.get(possion).getSel().length < 4) {
            mItem4.setVisibility(View.GONE);
        } else {
            mItem4.setVisibility(View.VISIBLE);
            mText4.setText(beanAar.get(possion).getSel()[3]);
        }
    }

    /**
     * 点击事件
     *
     * @param v
     */
    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.check_item1:
                possionAar[possion] = 0;//记录当前的选择的下标
                hide(0);//只让当前状态为选择
                next();//执行下一步
                break;
            case R.id.check_item2:
                possionAar[possion] = 1;
                hide(1);
                next();
                break;
            case R.id.check_item3:
                possionAar[possion] = 2;
                hide(2);
                next();
                break;
            case R.id.check_item4:
                possionAar[possion] = 3;
                hide(3);
                next();
                break;
            case R.id.pre:
                pre();
                break;
            case R.id.next:
                next();
                break;
        }
    }

    /**
     * 下一步
     */
    private void next() {
        possion += 1;
        if (possion > 4) {
            addScore();
            Toast.makeText(this, "分数"+score, Toast.LENGTH_SHORT).show();
            return;
        }
        handler.postDelayed(new Runnable() {

            public void run() {
                hide();
                setData();
                // handler.removeCallbacksAndMessages(null);
            }
        }, 100);


    }

    /**
     * 上一步
     */
    private void pre() {
        possion -= 1;
        if (possion < 0) {
            possion = 4;
        }
        hide(possionAar[possion]);
        setData();
    }


    public void hide() {
        for (int i = 0; i < mImageView.length; i++) {
            mImageView[i].setImageResource(R.drawable.button_white);
        }
    }

    public void hide(int k) {
        for (int i = 0; i < mImageView.length; i++) {
            if (i == k) {
                mImageView[i].setImageResource(R.drawable.button_orange_1);
            } else {
                mImageView[i].setImageResource(R.drawable.button_white);
            }
        }
    }

    /**
     * 计算分数
     */
    public void addScore() {
        for (int i = 0; i < possionAar.length; i++) {
            if (possionAar[i] == -1) {
                score = 0;
                return;
            }
        }
        for (int i = 0; i < possionAar.length; i++) {
            switch (possionAar[i]) {
                case 0 :
                    score +=10;
                    break;
                case 1 :
                    score +=8;
                    break;
                case 2 :
                    score +=5;
                    break;
                case 3 :
                    score +=3;
                    break;
            }
        }

}

}
