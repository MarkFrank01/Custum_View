package com.wjc.learn.widget.test_view.sample;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.util.Log;
import android.util.TypedValue;
import android.view.View;

import com.wjc.learn.R;

/**
 * Project_NAME : Costum_View
 * Package_NAME : com.wjc.learn.view.test_view.sample
 * File_NAME : CustomCircle
 * Created by WJC on 2017/11/19 10:23
 * Describe : TODO
 */

public class CustomCircle extends View {

    // 第一种颜色
    int mFirstColor;
    // 第二种颜色
    int mSecondColor;
    // 圆环宽度
    int mCircleWidth;
    // 速度
    private int mSpeed;
    // 当前进度
    private int mProgress;
    // 是否开始下一步
    private boolean isNext;
    // 画笔
    private Paint mPaint;
    // 用来开关线程
    private boolean isContinue;

    public CustomCircle(Context context) {
        this(context, null);
    }

    public CustomCircle(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    /**
     * 2、在View的构造方法中获得我们自定义的属性
     */
    public CustomCircle(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        final TypedArray typedArray = context.getTheme().obtainStyledAttributes(attrs, R.styleable.CustomProgressBar, defStyleAttr, 0);
        int indexCount = typedArray.getIndexCount();
        for (int i = 0; i < indexCount; i++) {
            int arr = typedArray.getIndex(i);
            switch (arr) {
                case R.styleable.CustomProgressBar_firstColor://第一种颜色
                    mFirstColor = typedArray.getColor(arr, Color.BLUE);
                    break;
                case R.styleable.CustomProgressBar_secondColor://第二种颜色
                    mSecondColor = typedArray.getColor(arr, Color.BLUE);
                    break;
                case R.styleable.CustomProgressBar_circleWidth://圆环宽度
                    mCircleWidth = typedArray.getDimensionPixelSize(arr, (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_PX, 20, getResources().getDisplayMetrics()));
                    break;
                case R.styleable.CustomProgressBar_speed://速度
                    mSpeed = typedArray.getInt(arr, 20);
                    break;
            }
        }

        typedArray.recycle();
        mPaint = new Paint();
        isContinue = true;
        // 绘图线程
        new Thread() {
            public void run() {
                while (isContinue) {
                    mProgress++;
                    if (mProgress == 360) {
                        mProgress = 0;
                        isNext = !isNext;
                    }
                    Log.e("--------", "在执行..");
                    postInvalidate();

                    try {
                        Thread.sleep(20);// 这里优化了一下,值越大,速度越快
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }

            }
        }.start();
    }

    /**
     * 4、重写onDraw
     */
    @Override
    protected void onDraw(Canvas canvas) {
//        super.onDraw(canvas);
        // 这里使用width主要是用来防止用户使用wrap_content,会占满整个屏幕宽,默认为200dp
        int center = width / 2;// 获取圆心的x坐标         getMeasuredWidth()也行!!!!
        Log.e("------------->", "getWidth():" + center);
        int radius = center - mCircleWidth / 2;// b半径
        mPaint.setStrokeWidth(mCircleWidth);//设置圆环的宽度
        mPaint.setAntiAlias(true);//抗锯齿
        mPaint.setStyle(Paint.Style.STROKE);//设置空心

        // 用于定义圆弧的形状和大小的界限
        RectF rectF = new RectF(center - radius, center - radius, center + radius, center + radius);

        if (!isNext) {// 第一个颜色的圈跑完,第二个颜色跑
            mPaint.setColor(mFirstColor);// 设置圆环的颜色
            canvas.drawCircle(center, center, radius, mPaint);// 画圆环
            mPaint.setColor(mSecondColor);// 设置圆环的颜色
            canvas.drawArc(rectF, -90, mProgress, false, mPaint);// 根据进度画圆弧
        } else {
            mPaint.setColor(mSecondColor);
            canvas.drawCircle(center, center, radius, mPaint);
            mPaint.setColor(mFirstColor);
            canvas.drawArc(rectF, -90, mProgress, false, mPaint);
        }
    }

    // 用来关闭线程
    public void setContinue(boolean aContinue) {
        isContinue = aContinue;
    }

    private int width;

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
//        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        int modeWidth = MeasureSpec.getMode(widthMeasureSpec);
        int sizeWidth = MeasureSpec.getSize(widthMeasureSpec);

        if (modeWidth == MeasureSpec.EXACTLY) {
            width = sizeWidth;
        } else {//默认宽度
            width = (int) getContext().getResources().getDimension(R.dimen.activity_horizontal_margin);
        }
        Log.e("------------->", "width:" + width);
        setMeasuredDimension(width, width);
    }
}
