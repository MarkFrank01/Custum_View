package com.wjc.learn.widget.test_view.sample.circle;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.wjc.learn.R;

public class MagicCircleActivity extends AppCompatActivity {

    private Button button;
    private MagicCircle magicCircle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_magic_circle);
        magicCircle = (MagicCircle)findViewById(R.id.circle3);
        button = (Button) findViewById(R.id.btn_start);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                magicCircle.startAnimation();
            }
        });
    }
}
