package com.aiwinn.orange.model;

import com.aiwinn.orange.bean.Girl;

import java.util.List;

/**
 * model还是原来的model
 */
public interface IGirlModel{
    //也通过回调的方式返回数据
    void loadGril(GirlOnLoadListener girlOnLoadListener);
    //设置一个回调接口
    interface GirlOnLoadListener{
        void onComplete(List<Girl> list);
    }

    /**
     * rx +dagger 封装的调用形式
     */
    void loadGirlData();
}
