package com.wjc.learn.widget.test_view.sample;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

/**
 * Project_NAME : Costum_View
 * Package_NAME : com.wjc.learn.view.test_view.sample
 * File_NAME : CustomSkew
 * Created by WJC on 2017/11/21 9:45
 * Describe : TODO
 */

public class CustomSkew extends View {

    private Paint mPaint = new Paint();
    private int mWidth;
    private int mHeight;

    public CustomSkew(Context context) {
        super(context);
    }

    public CustomSkew(Context context, @Nullable AttributeSet attrs) {
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
        RectF rectF = new RectF(0,0,200,200);

        mPaint.setColor(Color.BLACK);
        canvas.drawRect(rectF,mPaint);

        canvas.skew(1,0);
        canvas.skew(0,1);

        mPaint.setColor(Color.BLUE);
        canvas.drawRect(rectF,mPaint);
    }
}
