package com.aiwinn.orange.model;

import com.aiwinn.orange.RequestCallback;
import com.aiwinn.orange.bean.User;

/**
 * Name:   LoginModel
 * Author: shenjun
 * Email:  jun.shen@aiwinn.com
 * Date:   2018-03-29 10:25
 * model层主要处理业务方法和实体模型
 * model层主要实现业务逻辑处理，在本文案例中，主要逻辑处理就是登录,抽取了一个接口和一个实现类，在login操作，模拟登录操作，Thread.sleep()模拟耗时，由于是耗时操作，通过一个回调接口通知登录状态
 */
public interface LoginModel {
    void login(String username,String password,RequestCallback<User> callback);
}
