package com.aiwinn.orange.presenter;

import com.aiwinn.orange.bean.Girl;
import com.aiwinn.orange.model.IGirlModel;
import com.aiwinn.orange.model.impl.IGirlModelImpl;
import com.aiwinn.orange.view.IGirlView;
import com.sj.mycore.net.rx.databus.RegisterRxBus;

import java.lang.ref.WeakReference;
import java.util.ArrayList;

/**
 * 所有的业务逻辑都在表示层完成
 */
public class GirlPresenter <T extends IGirlView>{

    // 1.view层的引用
    WeakReference<T> mView;
    // 2.model曾的引用
   IGirlModel iGirlModel=new IGirlModelImpl();

    public GirlPresenter(T mView) {
        this.mView = new WeakReference<T>(mView);
        iGirlModel.loadGirlData();
    }

    @RegisterRxBus()
    public void getShowGirlsData(ArrayList<Girl> list){
        mView.get().showGirls(list);
    }

    //3.执行UI逻辑操作    public void fetch(){
    ////        if(mView!=null && iGirlModel!=null){
    ////            iGirlModel.loadGril(new IGirlModel.GirlOnLoadListener() {
    ////                @Override
    ////                public void onComplete(List<Girl> list) {
    ////                   mView.get().showGirls(list);
    ////                }
    ////            });
    ////        }
    ////    }
//

}
