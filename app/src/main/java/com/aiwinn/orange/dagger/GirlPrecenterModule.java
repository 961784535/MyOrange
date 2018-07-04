package com.aiwinn.orange.dagger;

import com.aiwinn.orange.activity.MainActivity;
import com.aiwinn.orange.presenter.GirlPresenter;

import dagger.Module;
import dagger.Provides;

/**
 * @data: 2018/7/4
 * @author: ArJun
 * 描述:
 */
@Module
public class GirlPrecenterModule {
    MainActivity mainActivity;
    public GirlPrecenterModule(MainActivity mainActivity){
        this.mainActivity=mainActivity;
    }
    @Provides
    public GirlPresenter provideGirlPrecenter(){
        return new GirlPresenter(mainActivity);
    }
}
