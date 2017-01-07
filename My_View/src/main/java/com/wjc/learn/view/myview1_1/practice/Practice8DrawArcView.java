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

public class Practice8DrawArcView extends View {

    public Practice8DrawArcView(Context context) {
        super(context);
    }

    public Practice8DrawArcView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public Practice8DrawArcView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        //画弧形和扇形
        Paint paint =new Paint();
        paint.setStyle(Paint.Style.FILL);

        //绘制扇形
        canvas.drawArc(200,100,800,500,-110,100,true,paint);

        //绘制弧形
        canvas.drawArc(200,100,800,500,20,140,false,paint);

        paint.setStyle(Paint.Style.STROKE);

        //绘制不封口弧形
        canvas.drawArc(200,100,800,500,180,60,false,paint);


    }
}
