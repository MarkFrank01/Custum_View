package com.wjc.learn.data;

import android.support.annotation.LayoutRes;

import java.io.Serializable;

/**
 * Project_NAME : todoapp
 * Package_NAME : com.wjc.learn.data
 * File_NAME : PageModel
 * Created by WJC on 2017/11/7 18:30
 * Describe : TODO
 */

public class PageModel implements Serializable{
    @LayoutRes
    private int sampleLayoutRes;
    @LayoutRes
    private int practiceLayoutRes;
    @LayoutRes
    private int titleRes;

    PageModel(int sampleLayoutRes, int practiceLayoutRes, int titleRes) {
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
