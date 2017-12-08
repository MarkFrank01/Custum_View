package com.wjc.learn.view.test_view.sample;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

/**
 * Project_NAME : Costum_View
 * Package_NAME : com.wjc.learn.view.test_view.sample
 * File_NAME : CustomLine
 * Created by WJC on 2017/11/22 20:32
 * Describe : TODO
 */

public class CustomLine extends View {

    Paint mPaint = new Paint();
    private int mWidth;
    private int mHeight;

    public CustomLine(Context context) {
        this(context, null);
    }

    public CustomLine(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        mPaint.setColor(Color.BLACK);
        mPaint.setStyle(Paint.Style.STROKE);
        mPaint.setStrokeWidth(10);
    }

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);
        mWidth = w;
        mHeight = h;
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        canvas.translate(mWidth / 2, mHeight / 2);
        canvas.scale(1,-1);

        Path path = new Path();
        path.lineTo(100,100);

        RectF rectF = new RectF(0,0,300,300);

//        path.addArc(rectF,0,270);
        path.arcTo(rectF,0,270);
        canvas.drawPath(path,mPaint);

    }
}
