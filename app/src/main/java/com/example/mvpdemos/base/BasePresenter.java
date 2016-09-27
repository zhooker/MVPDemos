package com.example.mvpdemos.base;

/**
 * Created by zhuangsj on 16-9-26.
 */

public interface BasePresenter<T extends BaseView> {

    void attachView(T view);

    void detachView();
}
