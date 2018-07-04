package com.aiwinn.orange.model.impl;

import com.aiwinn.orange.RequestCallback;
import com.aiwinn.orange.bean.User;
import com.aiwinn.orange.model.LoginModel;

/**
 * Name:   LoginModelImpl
 * Author: shenjun
 * Email:  jun.shen@aiwinn.com
 * Date:   2018-03-29 10:28
 */
public class LoginModelImpl implements LoginModel{

    @Override
    public void login(final String username, final String password, final RequestCallback<User> callback) {
        //模仿登录操作
        new Thread() {
            @Override
            public void run() {
                try {
                    Thread.sleep(2*1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                if ("1".equals(username) && "1".equals(password)) {
                    User user = new User();
                    user.setUsername(username);
                    user.setPassword(password);
                    callback.onSuccess(user);
                } else {
                    callback.onFailure("登录失败");
                }
            }
        }.start();
    }
}
