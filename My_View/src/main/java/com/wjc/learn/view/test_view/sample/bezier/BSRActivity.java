package com.wjc.learn.view.test_view.sample.bezier;

import android.support.annotation.IdRes;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import com.wjc.learn.R;

public class BSRActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        final bsrLearn bsrLearn = new bsrLearn(this);
        setContentView(bsrLearn);
//        final bsrTwo bsrTwo = new bsrTwo(this);
//        setContentView(bsrTwo);
    }
}
