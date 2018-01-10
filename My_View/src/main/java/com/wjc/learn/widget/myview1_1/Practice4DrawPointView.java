package com.wjc.learn.widget.myview1_1;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

/**
 * Created by WJC on 2017/10/21.
 */

public class Practice4DrawPointView extends View{
    public Practice4DrawPointView(Context context) {
        super(context);
    }

    public Practice4DrawPointView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public Practice4DrawPointView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        //画点,
        // 一个方形点  BUTT , SQUARE
        // 一个圆点 ROUND
        Paint paint =new Paint();
        paint.setStrokeWidth(50);
        paint.setStrokeCap(Paint.Cap.ROUND);
        canvas.drawPoint(50,50,paint);

        paint.setStrokeCap(Paint.Cap.BUTT);
        canvas.drawPoint(200,200,paint);

        paint.setStrokeCap(Paint.Cap.SQUARE);
        canvas.drawPoint(50,200,paint);
    }
}
