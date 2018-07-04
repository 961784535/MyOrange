package com.aiwinn.orange.view;

import com.aiwinn.orange.bean.User;

/**
 * Name:   LoginView
 * Author: shenjun
 * Email:  jun.shen@aiwinn.com
 * Date:   2018-03-29 10:31
 * 对于View层接口定义，首先考虑功能上的操作，然后考虑：
 * 该操作需要什么？（getUserName等）
 * 该操作的结果，对应的反馈？（toMainActivity等）
 * 该操作过程中交互友好？（ showLoading）
 *
 */
public interface LoginView {
    String getUserName();
    String getPassword();

    void showLoading();
    void hideLoading();

    void toMainActvity(User user);
    void showFailedError(String msg);

}
