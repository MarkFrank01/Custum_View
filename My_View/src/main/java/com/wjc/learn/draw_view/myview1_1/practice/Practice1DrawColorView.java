package com.wjc.learn.draw_view.myview1_1.practice;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

/**
 * Project_NAME : todoapp
 * Package_NAME : com.wjc.learn.draw_view.myview1_1
 * File_NAME : Practice1DrawColorView
 * Created by WJC on 2017/11/7 14:43
 * Describe : TODO
 */

public class Practice1DrawColorView extends View{
    public Practice1DrawColorView(Context context) {
        super(context);
    }

    public Practice1DrawColorView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public Practice1DrawColorView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        //将View涂成黄色

        canvas.drawColor(Color.YELLOW);
    }
}
