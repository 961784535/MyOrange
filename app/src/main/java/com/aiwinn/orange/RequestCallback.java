package com.aiwinn.orange;

/**
 * Name:   RequestCallback
 * Author: shenjun
 * Email:  jun.shen@aiwinn.com
 * Date:   2018-03-29 10:28
 * 回调接口
 */
public interface RequestCallback<T> {
    void onSuccess(T datas);

    void onFailure(String msg);
}
