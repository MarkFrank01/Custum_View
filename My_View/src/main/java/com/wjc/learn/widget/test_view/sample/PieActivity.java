package com.wjc.learn.widget.test_view.sample;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.wjc.learn.data.PieData;

import java.util.ArrayList;

public class PieActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        PieView view = new PieView(this);
        setContentView(view);

        ArrayList<PieData> mData = new ArrayList<>();
        PieData pieData = new PieData("sloop", 60);
        PieData pieData2 = new PieData("sloop", 30);
        PieData pieData3 = new PieData("sloop", 40);
        PieData pieData4 = new PieData("sloop", 50);
        PieData pieData5 = new PieData("sloop", 20);
        mData.add(pieData);
        mData.add(pieData2);
        mData.add(pieData3);
        mData.add(pieData4);
        mData.add(pieData5);
        view.setData(mData);
    }
}
