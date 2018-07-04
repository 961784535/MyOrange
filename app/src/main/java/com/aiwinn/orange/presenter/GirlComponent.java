package com.aiwinn.orange.presenter;

import com.aiwinn.orange.activity.MainActivity;
import com.aiwinn.orange.dagger.GirlPrecenterModule;

import dagger.Component;

/**
 * @data: 2018/7/4
 * @author: ArJun
 * 描述:
 */
@Component(modules = GirlPrecenterModule.class)
public interface GirlComponent {
    void inject(MainActivity mainActivity);
}
