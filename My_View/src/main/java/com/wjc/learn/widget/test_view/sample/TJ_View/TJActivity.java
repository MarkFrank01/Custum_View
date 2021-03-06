package com.wjc.learn.widget.test_view.sample.TJ_View;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;

public class TJActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        final TJ_View tj_view = new TJ_View(this);
        setContentView(tj_view);
        @SuppressLint("HandlerLeak") final Handler handler = new Handler() {
            private float degress = 0;

            @Override
            public void handleMessage(Message msg) {
                super.handleMessage(msg);
                tj_view.setRotate(degress += 5);
                this.sendEmptyMessageDelayed(0, 80);
            }
        };
        handler.sendEmptyMessageDelayed(0, 20);
    }
}
