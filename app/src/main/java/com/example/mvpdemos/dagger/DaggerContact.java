package com.example.mvpdemos.dagger;

import com.example.mvpdemos.BasePresenter;
import com.example.mvpdemos.BaseView;
import com.example.mvpdemos.model.bean.GankItemBean;

import java.util.List;

/**
 * Created by zhuangsj on 16-9-26.
 */

public interface DaggerContact {

    interface View extends BaseView {
        void showContent(List<GankItemBean> list);
    }

    interface Presenter extends BasePresenter<View> {
        void getGankData(String tech);
    }
}