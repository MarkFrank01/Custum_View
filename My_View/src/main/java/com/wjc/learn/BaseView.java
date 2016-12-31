package com.wjc.learn;

/**
 * Project_NAME : todoapp
 * Package_NAME : com.wjc.learn
 * File_NAME : BaseView
 * Created by WJC on 2017/11/1 10:35
 * Describe : TODO
 */

public interface BaseView<T> {

    void setPresenter(T presenter);
}
