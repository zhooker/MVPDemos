package com.example.mvpdemos.dagger;

import android.os.Bundle;
import android.widget.TextView;

import com.example.mvpdemos.App;
import com.example.mvpdemos.base.BaseActivity;
import com.example.mvpdemos.R;
import com.example.mvpdemos.di.component.ActivityComponent;
import com.example.mvpdemos.di.component.DaggerActivityComponent;
import com.example.mvpdemos.di.module.ActivityModule;
import com.example.mvpdemos.model.bean.GankItemBean;

import java.util.List;

import javax.inject.Inject;

public class DaggerActivity extends BaseActivity implements DaggerContact.View {

    private TextView tv;
    @Inject
    protected TechPresenter mPresenter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dagger);
        tv = (TextView) findViewById(R.id.text);

        getActivityComponent().inject(this);

        mPresenter.attachView(this);
        mPresenter.getGankData(TechPresenter.TECH_ANDROID);
    }

    @Override
    protected void onDestroy() {
        mPresenter.detachView();
        super.onDestroy();
    }

    @Override
    public void showContent(List<GankItemBean> list) {
        StringBuffer sb = new StringBuffer();
        for (GankItemBean item : list) {
            sb.append(item);
            sb.append("\n-----------------------------------\n");
        }
        tv.setText(sb.toString());
    }

    @Override
    public void showError(String msg) {
        tv.setText("showError  : " + msg);
    }

    protected ActivityComponent getActivityComponent() {
        return DaggerActivityComponent.builder()
                .appComponent(App.getAppComponent())
                .activityModule(getActivityModule())
                .build();
    }

    protected ActivityModule getActivityModule() {
        return new ActivityModule(this);
    }
}
