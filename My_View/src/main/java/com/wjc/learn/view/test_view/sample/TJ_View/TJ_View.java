package com.wjc.learn.view.test_view.sample.TJ_View;

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
 * Package_NAME : com.wjc.learn.view.test_view.sample.TJ_View
 * File_NAME : TJ_View
 * Created by WJC on 2017/11/22 21:15
 * Describe : TODO
 */

public class TJ_View extends View {

    private Paint whitePaint;
    private Paint blackPaint;
    private float degrees = 0;

    public TJ_View(Context context) {
        this(context, null);
    }

    public TJ_View(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public TJ_View(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initPaints();
    }

    private void initPaints() {
        whitePaint = new Paint();
        whitePaint.setAntiAlias(true);
        whitePaint.setColor(Color.WHITE);

        blackPaint = new Paint();
        blackPaint.setColor(Color.BLACK);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        int width = canvas.getWidth();
        int height = canvas.getHeight();

        canvas.translate(width / 2, height / 2);

        canvas.drawColor(Color.GRAY);
        canvas.rotate(degrees);

        //绘制两个半圆
        int radius = Math.min(width, height) / 2 - 100;
        RectF rectF = new RectF(-radius, -radius, radius, radius);
        canvas.drawArc(rectF, 90, 180, true, blackPaint);
        canvas.drawArc(rectF, -90, 180, true, whitePaint);

        //绘制两个小圆
        int smallRadius = radius / 2;
        canvas.drawCircle(0, -smallRadius, smallRadius, blackPaint);
        canvas.drawCircle(0, smallRadius, smallRadius, whitePaint);

        //绘制鱼眼
        canvas.drawCircle(0, smallRadius, smallRadius / 4, blackPaint);
        canvas.drawCircle(0, -smallRadius, smallRadius / 4, whitePaint);
    }

    public void setRotate(float degrees) {
        this.degrees = degrees;
        invalidate();
    }
}
