package com.wjc.learn.data;

import android.support.annotation.LayoutRes;

import com.wjc.learn.R;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Project_NAME : todoapp
 * Package_NAME : com.wjc.learn.data
 * File_NAME : PageModel
 * Created by WJC on 2017/11/7 18:30
 * Describe : TODO
 */

public class PageModel implements Serializable{
    @LayoutRes
    int sampleLayoutRes;
    @LayoutRes
    int practiceLayoutRes;
    @LayoutRes
    int titleRes;

    public PageModel(int sampleLayoutRes, int practiceLayoutRes, int titleRes) {
        this.sampleLayoutRes = sampleLayoutRes;
        this.practiceLayoutRes = practiceLayoutRes;
        this.titleRes = titleRes;
    }

    public int getSampleLayoutRes() {
        return sampleLayoutRes;
    }

    public int getPracticeLayoutRes() {
        return practiceLayoutRes;
    }

    public int getTitleRes() {
        return titleRes;
    }

}
