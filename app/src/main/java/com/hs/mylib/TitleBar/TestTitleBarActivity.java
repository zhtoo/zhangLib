package com.hs.mylib.TitleBar;

import android.os.Bundle;
import android.view.View;

import com.hs.mylib.R;

/**
 * 作者：zhanghaitao on 2017/8/15 15:47
 * 邮箱：820159571@qq.com
 */

public class TestTitleBarActivity extends BaseActivity {

    private Boolean isShow = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test_title_bar);
        isShowLeftView(true);

        setTitleTextColor(R.color.white);
        setTitle("测试标题");
        setTitleBackground(R.drawable.ic_title_bar_bg);
        setRightStatus("保存");
        setRightStatus(R.drawable.ic_dot);
        setRightStatus("分类", R.drawable.ic_arrow_right);
    }

    @Override
    public void onRightForward(View forwardView) {
        if (isShow) {
            setRightImage(R.drawable.ic_arrow_right);
            isShow = false;
        } else {
            setRightImage(R.drawable.ic_arrow_down);
            isShow = true;
        }

    }

    @Override
    public boolean savaData() {
        return false;
    }
}
