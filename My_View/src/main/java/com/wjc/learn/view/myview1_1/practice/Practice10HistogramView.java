package com.wjc.learn.view.myview1_1.practice;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

/**
 * Created by WJC on 2017/10/21.
 */

public class Practice10HistogramView extends View {

    private int width = 120;

    Paint paint = new Paint();

    public Practice10HistogramView(Context context) {
        super(context);
    }

    public Practice10HistogramView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public Practice10HistogramView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        //画直方图步奏
        // 1 .先绘制出坐标系
        // 2 .绘制出坐标量名称
        // 3 .最后绘制图形

        paint.setColor(Color.BLACK);
        paint.setStrokeWidth(1);

        //横坐标
        canvas.drawLine(50, 50, 50, 600, paint);

        //纵坐标
        canvas.drawLine(50, 600, 1000, 600, paint);

        paint.setTextSize(25);
        canvas.drawText("Froyo", 85, 650, paint);
        canvas.drawText("A", 85 + width, 650, paint);
        canvas.drawText("B", 85 + width * 2, 650, paint);
        canvas.drawText("C", 85 + width * 3, 650, paint);
        canvas.drawText("D", 85 + width * 4, 650, paint);
        canvas.drawText("E", 85 + width * 5, 650, paint);
        canvas.drawText("F", 85 + width * 6, 650, paint);

        paint.setColor(Color.GREEN);
        paint.setStrokeWidth(70);
        canvas.drawLine(110, 600, 110, 580, paint);
        canvas.drawLine(110 + (width), 600, 110 + (width), 550, paint);
        canvas.drawLine(110 + (width) * 2, 600, 110 + (width) * 2, 550, paint);
        canvas.drawLine(110 + (width) * 3, 600, 110 + (width) * 3, 450, paint);
        canvas.drawLine(110 + (width) * 4, 600, 110 + (width) * 4, 300, paint);
        canvas.drawLine(110 + (width) * 5, 600, 110 + (width) * 5, 250, paint);
        canvas.drawLine(110 + (width) * 6, 600, 110 + (width) * 6, 480, paint);

    }
}
