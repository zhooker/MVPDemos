package com.example.mvpdemos.dagger;

import com.example.mvpdemos.di.RxPresenter;
import com.example.mvpdemos.model.bean.GankItemBean;
import com.example.mvpdemos.model.http.GankHttpResponse;
import com.example.mvpdemos.model.http.RetrofitHelper;
import com.example.mvpdemos.util.RxUtil;

import java.util.List;

import javax.inject.Inject;

import rx.Subscription;
import rx.functions.Action1;

/**
 *
 */

public class TechPresenter extends RxPresenter<DaggerContact.View> implements DaggerContact.Presenter {

    public static final String TECH_ANDROID = "Android";
    public static final String TECH_IOS = "iOS";
    public static final String TECH_WEB = "前端";
    private static final int NUM_OF_PAGE = 5;

    private RetrofitHelper mRetrofitHelper;

    private int currentPage = 1;
    private String currentTech = TECH_ANDROID;

    @Inject
    public TechPresenter(RetrofitHelper mRetrofitHelper) {
        this.mRetrofitHelper = mRetrofitHelper;
    }


    @Override
    public void getGankData(String tech) {
        currentPage = 1;
        currentTech = tech;
        Subscription rxSubscription = mRetrofitHelper.fetchTechList(tech, NUM_OF_PAGE, currentPage)
                .compose(RxUtil.<GankHttpResponse<List<GankItemBean>>>rxSchedulerHelper())
                .compose(RxUtil.<List<GankItemBean>>handleResult())
                .subscribe(new Action1<List<GankItemBean>>() {
                    @Override
                    public void call(List<GankItemBean> gankItemBeen) {
                        mView.showContent(gankItemBeen);
                    }
                }, new Action1<Throwable>() {
                    @Override
                    public void call(Throwable throwable) {
                        mView.showError("数据加载失败 : " + throwable.getMessage());
                    }
                });
        addSubscrebe(rxSubscription);
    }
}
