package com.aiwinn.orange.presenter.impl;


import android.os.Handler;

import com.aiwinn.orange.RequestCallback;
import com.aiwinn.orange.bean.User;
import com.aiwinn.orange.model.LoginModel;
import com.aiwinn.orange.model.impl.LoginModelImpl;
import com.aiwinn.orange.presenter.LoginPresenter;
import com.aiwinn.orange.view.LoginView;

/**
 * Name:   LoginPresenterImpl
 * Author: shenjun
 * Email:  jun.shen@aiwinn.com
 * Date:   2018-03-29 10:34
 */
public class LoginPresenterImpl implements LoginPresenter {

    private LoginView loginView;
    private LoginModel loginModel;

    private Handler mHandler = new Handler();

    //在构造函数中初始化
    public LoginPresenterImpl(LoginView loginView) {
        this.loginModel = new LoginModelImpl();
        this.loginView = loginView;
    }

    @Override
    public void login() {
        loginView.showLoading();
        loginModel.login(loginView.getUserName(), loginView.getPassword(), new RequestCallback<User>() {
            @Override
            public void onSuccess(final User datas) {
                //登录成功
                mHandler.post(new Runnable() {
                    @Override
                    public void run() {
                        loginView.toMainActvity(datas);
                        loginView.hideLoading();
                    }
                });
            }

            @Override
            public void onFailure(final String msg) {
                //登录失败
                mHandler.post(new Runnable() {
                    @Override
                    public void run() {
                        loginView.showFailedError(msg);
                        loginView.hideLoading();
                    }
                });
            }
        });
    }
}
