package com.aiwinn.orange;

import android.app.Application;

import com.blankj.utilcode.util.Utils;

/**
 * Name:   MyApplication
 * Author: shenjun
 * Email:  jun.shen@aiwinn.com
 * Date:   2018-04-09 10:54
 */
public class MyApplication extends Application {


    @Override
    public void onCreate() {
        super.onCreate();
        Utils.init(this);
    }
}
