package com.wjc.learn.view.myview1_1.practice;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

/**
 * Project_NAME : todoapp
 * Package_NAME : com.wjc.learn.view.myview1_1
 * File_NAME : Practice1DrawColorView
 * Created by WJC on 2017/11/7 14:43
 * Describe : TODO
 */

public class Practice1DrawColorView extends View{
    Paint textPaint = new Paint();

    public Practice1DrawColorView(Context context) {
        super(context);
    }

    public Practice1DrawColorView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public Practice1DrawColorView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    {
        textPaint.setColor(Color.WHITE);
        textPaint.setTextSize(50);
        textPaint.setTextAlign(Paint.Align.CENTER);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        //将View涂成黄色

        canvas.drawColor(Color.BLACK);
        canvas.drawText("我喜欢黑色，嘻嘻",300,300,textPaint);
    }
}
