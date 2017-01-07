package com.wjc.learn.view.myview1_1.practice;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

/**
 * Created by WJC on 2017/10/21.
 */

public class Practice5DrawOvalView  extends View{
    public Practice5DrawOvalView(Context context) {
        super(context);
    }

    public Practice5DrawOvalView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public Practice5DrawOvalView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        //画椭圆
        Paint paint = new Paint();
        paint.setStyle(Paint.Style.FILL);
        canvas.drawOval(50,50,350,200,paint);

        paint.setStyle(Paint.Style.STROKE);
        canvas.drawOval(400,50,700,200,paint);
    }
}
