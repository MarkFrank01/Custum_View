package com.wjc.learn.login;

import com.wjc.learn.BasePresenter;
import com.wjc.learn.BaseView;

/**
 * Project_NAME : todoapp
 * Package_NAME : com.wjc.learn.login
 * File_NAME : LoginContract
 * Created by WJC on 2017/11/6 13:56
 * Describe : TODO
 */

public interface LoginContract {

    interface View extends BaseView<Presenter>{
        void openMainActivity();

        void onError(int message);
    }

    interface Presenter extends BasePresenter{
        void onServerLoginClick(String email, String password);

        void onGithubClick();

        void onBlogClick();

    }
}
