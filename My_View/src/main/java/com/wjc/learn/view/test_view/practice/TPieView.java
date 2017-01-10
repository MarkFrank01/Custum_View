package com.wjc.learn.view.test_view.practice;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;

import com.wjc.learn.data.PieData;

import java.util.ArrayList;

/**
 * Project_NAME : Costum_View
 * Package_NAME : com.wjc.learn.view.test_view.practice
 * File_NAME : TPieView
 * Created by WJC on 2017/11/19 21:03
 * Describe : TODO
 */

public class TPieView extends View {

    //颜色表
    private int[] mColors = {0xFFCCFF00, 0xFF6495ED, 0xFFE32636, 0xFF800000, 0xFF808000, 0xFFFF8C69, 0xFF808080,
            0xFFE6B800, 0xFF7CFC00};
    //数据
    private ArrayList<PieData> mData;
    //百分比
    private float mPercenter;
    //初始角度
    private int mStartAngle = 0;
    //宽和高
    private int mWidth, mHeight;
    //画笔
    private Paint mPaint = new Paint();

    public TPieView(Context context) {
        this(context, null);
    }

    public TPieView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        mPaint.setStyle(Paint.Style.FILL);
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
        if (mData == null) {
            return;
        }
        //当前起始角度
        int mCurrentAngle = mStartAngle;
        //将画布坐标原点移到中心原点
        canvas.translate(mWidth / 2, mHeight / 2);
        //饼状图半径
        float r = (float) (Math.min(mWidth, mHeight) / 2 * 0.8);
        //饼状图绘制区域
        RectF rectF = new RectF(-r, -r, r, r);

        //开始绘制
        for (int i = 0; i < mData.size(); i++) {
            PieData pieData = mData.get(i);
            mPaint.setColor(pieData.getColor());
            canvas.drawArc(rectF, mCurrentAngle, pieData.getAngle(), true, mPaint);
            mCurrentAngle += pieData.getAngle();
        }
    }

    //设置起始角度
    public void setStartAngle(int mStartAngle) {
        this.mStartAngle = mStartAngle;
        invalidate();
    }

    //设置起始数据
    public void setData(ArrayList<PieData> mData) {
        this.mData = mData;
        initData(mData);
        invalidate();
    }

    private void initData(ArrayList<PieData> mData) {
        //数据有误
        if (mData == null && mData.size() == 0) {
            return;
        }

        float sumValue = 0;
        for (int i = 0; i < mData.size(); i++) {
            PieData pieData = mData.get(i);

            //计算数值和
            sumValue += pieData.getValue();

            //设置颜色
            int j = i % mColors.length;
            pieData.setColor(mColors[j]);
        }

        float sumAngle = 0;
        for (int i = 0; i < mData.size(); i++) {
            PieData pieData = mData.get(i);

            float percentage = pieData.getValue() / sumValue;
            float angle = percentage * 360;

            pieData.setPercentage(percentage);
            pieData.setAngle(angle);

            sumAngle += angle;
            Log.e("Angle", pieData.getAngle() + "AAA");
        }
    }
}
