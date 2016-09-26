package com.example.mvpdemos.di.component;

import com.example.mvpdemos.App;
import com.example.mvpdemos.di.ContextLife;
import com.example.mvpdemos.di.module.AppModule;
import com.example.mvpdemos.model.http.RetrofitHelper;

import javax.inject.Singleton;

import dagger.Component;

/**
 *
 */

@Singleton
@Component(modules = AppModule.class)
public interface AppComponent {

    @ContextLife("Application")
    App getContext();

    RetrofitHelper retrofitHelper();

}
