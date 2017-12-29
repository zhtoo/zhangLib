package com.zht.photoviewdemo;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.bumptech.glide.Glide;
import com.zht.photoviewdemo.view.PhotoView;

public class MainActivity extends AppCompatActivity {

    private ViewPager viewPager;


    private int[] viewSet = {
            R.drawable.ic1,
            R.drawable.ic2,
            R.drawable.ic3,
            R.drawable.ic4,
            R.drawable.ic5,
            R.drawable.ic6,
            R.drawable.ic7,
            R.drawable.ic8,
            R.drawable.ic9,
            R.drawable.ic10,
            R.drawable.ic11,
            R.drawable.ic12,
            R.drawable.ic13,
            R.drawable.ic14,
            R.drawable.ic15,
            R.drawable.ic16
    };


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        viewPager = (ViewPager) findViewById(R.id.main_viewpager);

        MyAdapter adapter = new MyAdapter(this);
        viewPager.setAdapter(adapter);

    }


    public class MyAdapter extends PagerAdapter {

        private Context context;

        public MyAdapter(Context context) {
            this.context = context;
        }

        @Override
        public int getCount() {
            return viewSet.length;
        }

        @Override
        public Object instantiateItem(ViewGroup container, int position) {
            View view = LayoutInflater.from(context).inflate(R.layout.item_viewpager,container,false);
            PhotoView mPhontoView = (PhotoView) view.findViewById(R.id.iv_photoView);
          //  mPhontoView.enable();   //设置可缩放

            Glide.with(context)
                    .load(viewSet[position])
                    .into(mPhontoView);
           // mPhontoView.setImageResource(viewSet[position]);

            container.addView(view);
            return view;
        }


        @Override
        public boolean isViewFromObject(View view, Object object) {
            return view == object;
        }

        @Override
        public void destroyItem(ViewGroup container, int position, Object object) {
           container.removeView((View) object);
        }

    }


}

