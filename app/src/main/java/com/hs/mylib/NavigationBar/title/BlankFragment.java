package com.hs.mylib.NavigationBar.title;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * 作者：zhanghaitao on 2017/8/15 09:49
 * 邮箱：820159571@qq.com
 */

public class BlankFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        TextView view = new TextView(getActivity());
        view.setText(BlankFragment.class.getSimpleName());
        return view;
    }


}
