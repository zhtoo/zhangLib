package com.hs.mylib.NavigationBar.title;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;

import com.hs.mylib.R;

import java.util.ArrayList;
import java.util.List;

/**
 * 作者：zhanghaitao on 2017/8/15 09:41
 * 邮箱：820159571@qq.com
 */

public class NavigationBarActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_navigation_bar);
        TabLayout tabLayout = (TabLayout) findViewById(R.id.tab);
        ViewPager viewpager = (ViewPager) findViewById(R.id.viewpager);

//      tabLayout.setTabTextColors(Color.WHITE, Color.GRAY);//设置文本在选中和为选中时候的颜色
//      tabLayout.setSelectedTabIndicatorColor(Color.WHITE);//设置选中时的指示器的颜色
//      tabLayout.setTabMode(TabLayout.MODE_SCROLLABLE);//可滑动，默认是FIXED

        List<Fragment> fragments = new ArrayList<>();
        fragments.add(new BlankFragment());
        fragments.add(new BlankFragment());
        fragments.add(new BlankFragment());

        TitleFragmentPagerAdapter adapter = new TitleFragmentPagerAdapter(getSupportFragmentManager(), fragments, new String[]{"第一栏", "第二栏", "第三栏"});
        viewpager.setAdapter(adapter);

        tabLayout.setupWithViewPager(viewpager);

    }
}
