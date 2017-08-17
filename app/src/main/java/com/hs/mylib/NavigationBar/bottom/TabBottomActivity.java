package com.hs.mylib.NavigationBar.bottom;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.hs.mylib.NavigationBar.title.BlankFragment;
import com.hs.mylib.NavigationBar.title.TitleFragmentPagerAdapter;
import com.hs.mylib.R;

import java.util.ArrayList;
import java.util.List;

/**
 * 作者：zhanghaitao on 2017/8/15 10:04
 * 邮箱：820159571@qq.com
 */

public class TabBottomActivity extends AppCompatActivity {

    private final static String TAG = "TabBottomActivity";

   private int normal ;
   private int select ;

    private TabLayout tabLayout;
    private ViewPager viewpager;
    private TitleFragmentPagerAdapter adapter;
    private String[] titles;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bottom_tab);

        normal = getResources().getColor(R.color.tab_text_normal);
        select = getResources().getColor(R.color.tab_text_select);

        tabLayout = (TabLayout) findViewById(R.id.tab);
        viewpager = (ViewPager) findViewById(R.id.viewpager);

        tabLayout.addTab(tabLayout.newTab().setText("Tab 4"));
        tabLayout.addTab(tabLayout.newTab().setText("Tab 4"));
        tabLayout.addTab(tabLayout.newTab().setText("Tab 4"));
        tabLayout.addTab(tabLayout.newTab().setText("Tab 4"));

        List<Fragment> fragments = new ArrayList<>();
        fragments.add(new BlankFragment());
        fragments.add(new BlankFragment());
        fragments.add(new BlankFragment());
        fragments.add(new BlankFragment());

        titles = new String[]{"首页", "流量", "社区", "关于"};
        adapter = new TitleFragmentPagerAdapter(getSupportFragmentManager(), fragments, titles);
        viewpager.setAdapter(adapter);

        tabLayout.setupWithViewPager(viewpager);

        setupTabIcons(tabLayout.getSelectedTabPosition());

        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                changeTabSelect(tab);
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {
                changeTabNormal(tab);
            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });

//        viewpager.setCurrentItem(2);
    }

    private void changeTabSelect(TabLayout.Tab tab) {
        View view = tab.getCustomView();
        TextView txt_title = (TextView) view.findViewById(R.id.tab_text);
        txt_title.setTextColor(select);
    }

    private void changeTabNormal(TabLayout.Tab tab) {
        View view = tab.getCustomView();
        TextView txt_title = (TextView) view.findViewById(R.id.tab_text);
        txt_title.setTextColor(normal);
    }

    private void setupTabIcons(int selectedPosition) {
        tabLayout.getTabAt(0).setCustomView(getTabView(selectedPosition,0));
        tabLayout.getTabAt(1).setCustomView(getTabView(selectedPosition,1));
        tabLayout.getTabAt(2).setCustomView(getTabView(selectedPosition,2));
        tabLayout.getTabAt(3).setCustomView(getTabView(selectedPosition,3));
    }

    public View getTabView(int selectedPosition,int position) {
        Log.e(TAG, "选中的位置：" + selectedPosition);
        View view = LayoutInflater.from(this).inflate(R.layout.item_tab, null);
        TextView txt_title = (TextView) view.findViewById(R.id.tab_text);
        txt_title.setText(titles[position]);
        txt_title.setTextColor(position == selectedPosition ? select : normal);

        ImageView img_title = (ImageView) view.findViewById(R.id.tab_icon);
        img_title.setImageResource(R.drawable.bottom_tab_selector_bg);
        return view;
    }
}
