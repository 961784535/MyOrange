package com.aiwinn.orange.view;

import com.aiwinn.orange.bean.Girl;

import java.util.List;
/**
 * 所有的UI逻辑
 */
public interface IGirlView {
    /**
     * 显示listView中的数据(用回调)
     */
    void showGirls(List<Girl> girls);
}
