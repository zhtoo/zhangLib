/**
 * FireZenk's Progress Bar <A highly customizable progress bar>
 * Copyright (C) 2012 Jorge Garrido Oval (aka: FireZenk)
 * <p>
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 * <p>
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 * <p>
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */

package com.hs.zhangyapeng.progressdemo;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.GradientDrawable.Orientation;
import android.os.Handler;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;

public class FZProgressBar extends LinearLayout {

    public enum Mode {ONESHOT}

    private LinearLayout bar;
    private LinearLayout limits;

    private Handler animation = new Handler();
    private Runnable basic_one;
    private Context  context;
    private int      LIMITS_WIDTH;

    //DEFAULT CONFIG
    private int   ANIMATION_DELAY   = 2;
    private int   ANIMATION_SPACING = 10;
    private int   BAR_SIZE_W        = 0; // 0 = FILL_PARENT
    private int   BAR_SIZE_H        = 200;
    private int   BAR_CORNER        = 0;
    private int   BAR_BACKGROUND    = Color.WHITE;
    private int[] COLORS            = {Color.BLACK, Color.TRANSPARENT};

    public FZProgressBar(Context context) {
        super(context);
        this.context = context;
        init();
    }

    public FZProgressBar(Context context, AttributeSet attrs) {
        super(context, attrs);
        this.context = context;
        init();
    }

    private void init() {
        limits = this;
        bar = new LinearLayout(context);
        this.addView(bar);
    }

    public void animation_config(int delay, int spacing) {
        ANIMATION_DELAY = delay;
        ANIMATION_SPACING = spacing;
    }

    @SuppressWarnings("deprecation")
    public void bar_config(int height, int width, int radius, int background_color, int[] progress_colors) {
        BAR_SIZE_H = height;
        BAR_SIZE_W = width;
        BAR_CORNER = radius;
        BAR_BACKGROUND = background_color;
        COLORS = progress_colors;

        LayoutParams limits_params = null;

        switch (BAR_SIZE_W) {
            case 0:
                limits_params = new LayoutParams(LayoutParams.FILL_PARENT, BAR_SIZE_H);
                break;
            default:
                limits_params = new LayoutParams(BAR_SIZE_W, BAR_SIZE_H);
                break;
        }

        //		底部的背景色
        limits.setLayoutParams(limits_params);
        limits.setBackgroundColor(BAR_BACKGROUND);

        LayoutParams bar_params = new LayoutParams(0, LayoutParams.FILL_PARENT);
        bar.setLayoutParams(bar_params);
    }

    public synchronized void animation_start(final Mode mode, final double num) {
        LIMITS_WIDTH = new Integer(limits.getWidth());


        basic_one = new Runnable() {
            private int i = 0;

            @Override
            public void run() {
                LayoutParams params = new LayoutParams(i += ANIMATION_SPACING, BAR_SIZE_H);

                bar.setLayoutParams(params);

                if (i < num)
                    animation.postDelayed(this, ANIMATION_DELAY);
            }
        };

        bar.setVisibility(View.VISIBLE);
        GradientDrawable gd = new GradientDrawable(Orientation.RIGHT_LEFT, COLORS);
        gd.setCornerRadius(BAR_CORNER);
        bar.setBackgroundDrawable(gd);

        animation.post(basic_one);

    }

    public synchronized void animation_stop() {
        animation.removeCallbacks(basic_one);
        LayoutParams params = new LayoutParams(0, BAR_SIZE_H);
        bar.setLayoutParams(params);
    }
}
