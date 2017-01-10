package com.wjc.learn.view.test_view.sample;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

/**
 * Project_NAME : Costum_View
 * Package_NAME : com.wjc.learn.view.test_view.sample
 * File_NAME : CustomRotate
 * Created by WJC on 2017/11/21 9:38
 * Describe : TODO
 */

public class CustomRotate extends View {

    private Paint mPaint = new Paint();
    private int mWidth;
    private int mHeight;


    public CustomRotate(Context context) {
        super(context);
    }

    public CustomRotate(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        mPaint.setStyle(Paint.Style.STROKE);
        mPaint.setAntiAlias(true);
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

        canvas.drawCircle(0, 0, 400, mPaint);
        canvas.drawCircle(0, 0, 380, mPaint);

        for (int i = 0; i <= 360; i += 10) {
            canvas.drawLine(0,380,0,400,mPaint);
            canvas.rotate(10);
        }
    }
}
