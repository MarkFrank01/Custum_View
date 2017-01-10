package com.wjc.learn.view.test_view.sample;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.View;

import com.wjc.learn.R;

import java.util.HashSet;
import java.util.Random;
import java.util.Set;

/**
 * Project_NAME : Costum_View
 * Package_NAME : com.wjc.learn.view.test_view
 * File_NAME : CustomTextView
 * Created by WJC on 2017/11/18 15:56
 * Describe : TODO
 */

public class CustomTextView extends View {

    //文字
    private String mTitleText;
    //文字颜色
    private int mTitleTextColor;
    //文本大小
    private int mTitleTextSize;

    /**
     * 绘制时控制文本绘制的范围
     */
    private Rect mBound;
    private Paint mPaint;

    public CustomTextView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public CustomTextView(Context context) {
        this(context, null);
    }

    /**
     * 获得我自定义的样式属性
     *
     * @param context
     * @param attrs
     * @param defStyle
     */
    public CustomTextView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);

        //获得我们所定义的自定义样式属性
        TypedArray a = context.getTheme().obtainStyledAttributes(attrs, R.styleable.CustomTitleView, defStyle, 0);
        int n = a.getIndexCount();
        for (int i = 0; i < n; i++) {
            int attr = a.getIndex(i);
            switch (attr) {
                case R.styleable.CustomTitleView_titleText:
                    mTitleText = a.getString(attr);
                    break;
                case R.styleable.CustomTitleView_titleTextColor:
                    // 默认颜色设置为黑色
                    mTitleTextColor = a.getColor(attr, Color.BLACK);
                    break;
                case R.styleable.CustomTitleView_titleTextSize:
                    // 默认设置为16sp，TypeValue也可以把sp转化为px
                    mTitleTextSize = a.getDimensionPixelSize(attr, (int) TypedValue.applyDimension(
                            TypedValue.COMPLEX_UNIT_SP, 16, getResources().getDisplayMetrics()));
                    break;

            }

        }
        a.recycle();


        // 获得绘制文本的宽和高
        mPaint = new Paint();
        mPaint.setTextSize(mTitleTextSize);
        mPaint.setColor(mTitleTextColor);
        mBound = new Rect();
        mPaint.getTextBounds(mTitleText, 0, mTitleText.length(), mBound);

        this.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View v) {
                mTitleText = randomText();
                postInvalidate();
            }

        });
    }

    /**
     * 当我们如果将布局文件的宽和高设置为wrap_content,会发现大小会占满，
     * 因为它的specMode是AT_MOST模式，在这种模式下，specSize是parentSize即
     * 父类容器剩余大小，和match_parent效果一致。
     * 当我们设置明确的宽度和高度时，系统帮我们测量的结果就是我们设置的结果，
     * 当我们设置为WRAP_CONTENT,或者MATCH_PARENT系统帮我们测量的结果就是MATCH_PARENT的长度。
     * <p>
     * 所以，当设置了WRAP_CONTENT时，我们需要自己进行测量，即重写onMeasure方法”：
     * 重写之前先了解MeasureSpec的specMode,一共三种类型：
     * EXACTLY：一般是设置了明确的值或者是MATCH_PARENT
     * AT_MOST：表示子布局限制在一个最大值内，一般为WARP_CONTENT
     * UNSPECIFIED：表示子布局想要多大就多大，很少使用
     */
    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
//        Onblog(widthMeasureSpec, heightMeasureSpec);
        onSource(widthMeasureSpec,heightMeasureSpec);

    }

    private void onSource(int widthMeasureSpec, int heightMeasureSpec) {
        int width = 0;
        int height = 0;

        //设置宽度
        int specMode = MeasureSpec.getMode(widthMeasureSpec);
        int specSize = MeasureSpec.getSize(widthMeasureSpec);
        switch (specMode) {
            case MeasureSpec.EXACTLY:
                width = getPaddingLeft() + getPaddingRight() + specSize;
                break;
            case MeasureSpec.AT_MOST:
            case MeasureSpec.UNSPECIFIED:
                //int textWidth = mRect.width()  这样测量会存在误差
                float textWidth = mPaint.measureText(mTitleText);
                width = (int) (getPaddingLeft() + getPaddingRight() + textWidth);
                break;
        }

        //设置高度
        specMode = MeasureSpec.getMode(heightMeasureSpec);
        specSize = MeasureSpec.getSize(heightMeasureSpec);
        switch (specMode) {
            case MeasureSpec.EXACTLY:
                height = getPaddingTop() + getPaddingBottom() + specSize;
                break;
            case MeasureSpec.AT_MOST:
            case MeasureSpec.UNSPECIFIED:
                Paint.FontMetrics fontMetrics = mPaint.getFontMetrics();
                float textHeight = Math.abs((fontMetrics.bottom-fontMetrics.top));
                height = (int)(getPaddingTop()+getPaddingBottom()+textHeight);
        }

        setMeasuredDimension(width,height);

    }

    private void Onblog(int widthMeasureSpec, int heightMeasureSpec) {
        int widthMode = MeasureSpec.getMode(widthMeasureSpec);
        int widthSize = MeasureSpec.getSize(widthMeasureSpec);
        int heightMode = MeasureSpec.getMode(heightMeasureSpec);
        int heightSize = MeasureSpec.getSize(heightMeasureSpec);
        int width;
        int height;
        if (widthMode == MeasureSpec.EXACTLY) {
            width = widthSize;
        } else {
            mPaint.setTextSize(mTitleTextSize);
            mPaint.getTextBounds(mTitleText, 0, mTitleText.length(), mBound);
            float textWidth = mBound.width();
            int desired = (int) (getPaddingLeft() + textWidth + getPaddingRight());
            width = desired;
        }

        if (heightMode == MeasureSpec.EXACTLY) {
            height = heightSize;
        } else {
            mPaint.setTextSize(mTitleTextSize);
            mPaint.getTextBounds(mTitleText, 0, mTitleText.length(), mBound);
            float textHeight = mBound.height();
            int desired = (int) (getPaddingTop() + textHeight + getPaddingBottom());
            height = desired;
        }


        setMeasuredDimension(width, height);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        mPaint.setColor(Color.YELLOW);
        mPaint.setAntiAlias(true);
        mPaint.setTextAlign(Paint.Align.LEFT);

        canvas.drawRect(0, 0, getMeasuredWidth(), getMeasuredHeight(), mPaint);
        mPaint.setColor(mTitleTextColor);

        // 画布,画Text  *****
        /**
         * 用的是其中一个drawText重载方法:canvas.drawText(String text,float x,float y,Paint paint);
         * x和y是绘制时的起点坐标, getWidth() / 2 - mRect.width() / 2 其实是为了居中绘制文本,
         * getWidth()是获取自定义View的宽度,
         * mRect.width()是获取文本的宽度,
         * 为什么不是直接getWidth() / 2?
         * 这样的话文本就是从水平方向中间位置向右绘制,绘制的文本就不是居中了,要减去mRect.width() / 2才水平居中.垂直方向同理.
         *
         * "0 + getPaddingLeft()": 绘制文本的起点X
         *   "0": 直接从"0"开始就可以(文字会自带一点默认间距)
         *
         * */

        canvas.drawText(mTitleText, getWidth() / 2 - mBound.width() / 2, getHeight() / 2 + mBound.height() / 2, mPaint);
    }

    private String randomText() {
        Random random = new Random();
        Set<Integer> set = new HashSet<Integer>();
        while (set.size() < 4) {
            int randomInt = random.nextInt(10);
            set.add(randomInt);
        }
        StringBuffer sb = new StringBuffer();
        for (Integer i : set) {
            sb.append("" + i);
        }

        return sb.toString();
    }
}
