package com.wjc.learn.widget.test_view.sample.bezier;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

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
