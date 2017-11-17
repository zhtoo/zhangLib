package com.hs.progress;

import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.PaintFlagsDrawFilter;
import android.graphics.Shader;
import android.graphics.Typeface;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;

/**
 * Created by AndroidStudio on 2017/6/8.
 */
public class ColorProgressBar extends View {

    private static final String TAG = "ColorProgressBar";
    private float width;//布局宽度
    private float height;//布局高度


    //最大进度值0-100
    private float maxProgress = 100;
    private float minProgress = 0;
    //尺寸转换比例
    private float k;


    //默认进度5等分
    private int Equal = 5;
    private int scaleWidth = 5;

    private float curProgress = 0;
    private float startProgress = 0;

    private float currentProgress = 0;

    //画笔
    private Paint backgroundPaint;//底部背景的画笔
    private Paint progressPaint;//进度条的画笔
    private Paint textPaint;
    private Paint scalePaint;
    //抗锯齿
    private PaintFlagsDrawFilter mDrawFilter;

    //渐变颜色选择
    private int[] colors = new int[]{Color.GREEN, Color.YELLOW, Color.RED, Color.RED};

    private ValueAnimator progressAnimator;//执行动画
    private float curValues;//执行动画的动态值
    private int wrap_content = 600;
    private float minTextWidth;
    private float maxTextWidth;
    private float mTextHeight;
    private float lenth;


    public ColorProgressBar(Context context) {
        super(context, null);
        initView();
    }

    public ColorProgressBar(Context context, AttributeSet attrs) {
        super(context, attrs, 0);
        initCofig(context, attrs);
        initView();
    }

    public ColorProgressBar(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initCofig(context, attrs);
        initView();
    }

    /**
     * 初始化布局配置
     *
     * @param context
     * @param attrs
     */
    private void initCofig(Context context, AttributeSet attrs) {

    }

    /**
     * 初始化视图
     */
    private void initView() {

        backgroundPaint = new Paint();
        backgroundPaint.setAntiAlias(true);
        backgroundPaint.setStyle(Paint.Style.FILL);
        backgroundPaint.setColor(Color.GRAY);


        progressPaint = new Paint();
        progressPaint.setAntiAlias(true);
        progressPaint.setStyle(Paint.Style.FILL);
        progressPaint.setStrokeCap(Paint.Cap.ROUND);
        progressPaint.setStrokeWidth(dipToPx(5));
        progressPaint.setColor(Color.GREEN);


        textPaint = new Paint();
        textPaint.setAntiAlias(true);
        textPaint.setColor(Color.BLACK);
        textPaint.setTextSize(36);//字体大小
        textPaint.setTypeface(Typeface.DEFAULT);

        scalePaint = new Paint();
        scalePaint.setAntiAlias(true);//防锯齿
        scalePaint.setColor(Color.WHITE);
        scalePaint.setStyle(Paint.Style.FILL_AND_STROKE);//充满并且描边
        scalePaint.setStrokeCap(Paint.Cap.ROUND);

        mDrawFilter = new PaintFlagsDrawFilter(0, Paint.ANTI_ALIAS_FLAG | Paint.FILTER_BITMAP_FLAG);

    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        /**在这里可以设置+获取控件的宽高*/
        int viewWidth = measureWidth(widthMeasureSpec);
        int viewHeight = measureHeight(heightMeasureSpec);
        this.width = viewWidth;
        this.height = viewHeight;
        //设置宽高
        setMeasuredDimension(viewWidth, viewHeight);
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        Log.e(TAG, "onMeasure就在这里做数据的初始化");

        minTextWidth = textPaint.measureText("" + minProgress) / 2;
        maxTextWidth = textPaint.measureText("" + maxProgress) / 2;
        mTextHeight = getFontHeight(textPaint);

    }

    /**
     * 测量宽度
     *
     * @param widthMeasureSpec
     * @return
     */
    private int measureWidth(int widthMeasureSpec) {
        int widthSpecMode = MeasureSpec.getMode(widthMeasureSpec);
        int widthSpecSize = MeasureSpec.getSize(widthMeasureSpec);
        if (widthSpecMode == MeasureSpec.AT_MOST || widthSpecMode == MeasureSpec.UNSPECIFIED) {
            //默认wrap_content为自己定义的高度
            return wrap_content;
        } else {
            return widthSpecSize;
        }
    }

    /**
     * 测量高度
     *
     * @param heightMeasureSpec
     * @return
     */
    private int measureHeight(int heightMeasureSpec) {
        int heightSpecMode = MeasureSpec.getMode(heightMeasureSpec);
        int heightSpecSize = MeasureSpec.getSize(heightMeasureSpec);
        if (heightSpecMode == MeasureSpec.AT_MOST ||
                heightSpecMode == MeasureSpec.UNSPECIFIED//这里是为了解决在Listview和ScrollView的嵌套
                ) {
            //默认wrap_content为自己定义的高度
            return wrap_content;
        } else {
            return heightSpecSize;
        }
    }


    @Override
    protected void onDraw(Canvas canvas) {
        canvas.setDrawFilter(mDrawFilter);


        float backgroudLenth = width - (minTextWidth + maxTextWidth);
        //每一个的长度
        lenth = (backgroudLenth - (Equal - 1) * scaleWidth) / Equal;


        //left, top, right, bottom, Paint


        for (int i = 0; i < 5; i++) {
            canvas.drawRect(minTextWidth + i * (lenth + scaleWidth),//
                    0,
                    minTextWidth + lenth + i * (lenth + scaleWidth),//
                    height - mTextHeight, backgroundPaint);// 长方形  
        }


        // 一个材质,打造出一个线性梯度沿著一条线。
        Shader mShader = new LinearGradient(minTextWidth, 0, width - maxTextWidth, height - mTextHeight,
                colors, null, Shader.TileMode.MIRROR);
        progressPaint.setShader(mShader);


        Log.e(TAG, "curValues:" + curValues);


        if (currentProgress > 0) {
            canvas.drawRect(minTextWidth /*+ max * (lenth + scaleWidth)*/,//
                    0,
                    curValues,
                    height - mTextHeight, progressPaint);// 长方形 

        }

        for (int i = 1; i < 5; i++) {
            canvas.drawRect(minTextWidth + i * (lenth + scaleWidth) - scaleWidth,//
                    0,
                    minTextWidth + i * (lenth + scaleWidth),//
                    height - mTextHeight, scalePaint);// 长方形  
        }


        //画文字
        int unitValue = (int) maxProgress / Equal;
        for (int i = 0; i <= Equal; i++) {
            canvas.drawText(String.valueOf(i * unitValue),
                    minTextWidth + i * (lenth + scaleWidth) - scaleWidth/2-getTextWidth(unitValue,i),
                    height-5,
                    textPaint);

        }


    }

    private float getTextWidth(int unitValue, int i ) {
       if(i == 0){
           return 0;
       }
        return textPaint.measureText( String.valueOf(i * unitValue))/2;

    }


    /**
     * 设置最大值
     *
     * @param maxProgress
     */
    public void setMaxProgress(float maxProgress) {
        this.maxProgress = maxProgress;
    }

    /**
     * 设置当前值
     *
     * @param current
     */
    public void setCurrentProgress(float current) {

        curValues = minTextWidth;
        int unitValue = (int) maxProgress / Equal;
        int max = (int) (current / unitValue);
        if (current >= maxProgress) {
            this.currentProgress = width - maxTextWidth;
        } else if (current <= 0) {
            this.currentProgress = 0;
        } else {
            this.currentProgress = minTextWidth + (current - max * unitValue) * lenth / unitValue + max * (lenth + scaleWidth);
        }
        setAnimation(minTextWidth, currentProgress);
    }


    /**
     * 为进度设置动画
     *
     * @param last
     * @param current
     */
    private void setAnimation(float last, final float current) {
        progressAnimator = ValueAnimator.ofFloat(last, current);
        progressAnimator.setDuration(500);
        progressAnimator.setTarget(current);
        progressAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {

            @Override
            public void onAnimationUpdate(ValueAnimator animation) {
                curValues = (float) animation.getAnimatedValue();
                if (curValues == current) {
                    currentProgress = 0;
                } else {
                    invalidate();
                }


            }
        });
        progressAnimator.start();
    }

    /**
     * dip 转换成px
     *
     * @param dip
     * @return
     */
    private int dipToPx(float dip) {
        float density = getContext().getResources().getDisplayMetrics().density;
        return (int) (dip * density + 0.5f * (dip >= 0 ? 1 : -1));
    }


    /**
     * @return 返回指定的文字高度
     */
    public float getFontHeight(Paint paint) {
        Paint.FontMetrics fm = paint.getFontMetrics();
        //文字基准线的下部距离-文字基准线的上部距离 = 文字高度
        return fm.descent - fm.ascent;
    }

}
