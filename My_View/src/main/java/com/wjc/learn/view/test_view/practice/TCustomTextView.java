package com.wjc.learn.view.test_view.practice;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.View;

import com.wjc.learn.R;

import java.util.HashSet;
import java.util.Random;
import java.util.Set;

/**
 * Project_NAME : Costum_View
 * Package_NAME : com.wjc.learn.view.test_view.practice
 * File_NAME : TCustomTextView
 * Created by WJC on 2017/11/19 14:10
 * Describe : TODO
 */

public class TCustomTextView extends View {

    //文字
    private String mText;

    //颜色
    private int mTextColor;

    //文字大小
    private int mTextSize;

    //画笔
    private Paint mPaint;

    private Rect mBound;

    public TCustomTextView(Context context) {
        this(context, null);
    }

    public TCustomTextView(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public TCustomTextView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);

        TypedArray a = context.getTheme().obtainStyledAttributes(attrs, R.styleable.CustomTitleView, defStyleAttr, 0);
        int n = a.getIndexCount();
        for (int i = 0; i < n; i++) {
            int attr = a.getIndex(i);
            switch (attr) {
                case R.styleable.CustomTitleView_titleText:
                    mText = a.getString(attr);
                    break;
                case R.styleable.CustomTitleView_titleTextColor:
                    mTextColor = a.getColor(attr, Color.BLACK);
                    break;
                case R.styleable.CustomTitleView_titleTextSize:
                    mTextSize = a.getDimensionPixelSize(attr, (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_SP,
                            16, getResources().getDisplayMetrics()));
                    break;
            }
        }
        a.recycle();

        mPaint = new Paint();
        mPaint.setTextSize(mTextSize);
        mPaint.setColor(mTextColor);
        mBound = new Rect();
        mPaint.getTextBounds(mText, 0, mText.length(), mBound);

        setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                mText = randomText();
                postInvalidate();
            }
        });
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        onSource(widthMeasureSpec, heightMeasureSpec);
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
                float textWidth = mPaint.measureText(mText);
                width = (int) (getPaddingRight() + getPaddingRight() + textWidth);
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
                float textHeight = Math.abs((fontMetrics.bottom - fontMetrics.top));
                height = (int) (getPaddingTop() + getPaddingBottom() + textHeight);
        }

        setMeasuredDimension(width, height);
    }


    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        mPaint.setColor(Color.BLACK);
        mPaint.setAntiAlias(true);
        mPaint.setTextAlign(Paint.Align.LEFT);

        canvas.drawRect(0, 0, getMeasuredWidth(), getMeasuredHeight(), mPaint);
        mPaint.setColor(mTextColor);

        canvas.drawText(mText, getWidth() / 2 - mBound.width() / 2, getHeight() / 2 + mBound.height() / 2, mPaint);
    }

    private String randomText() {
        Random random = new Random();
        Set<Integer> set = new HashSet<>();
        while (set.size() < 4) {
            int randomInt = random.nextInt(10);
            set.add(randomInt);
        }

        StringBuffer stringBuffer = new StringBuffer();
        for (Integer i : set) {
            stringBuffer.append("" + i);
        }

        return stringBuffer.toString();
    }
}
