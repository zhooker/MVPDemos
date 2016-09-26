package com.example.mvpdemos;

import android.app.Application;
import com.example.mvpdemos.di.component.AppComponent;
import com.example.mvpdemos.di.component.DaggerAppComponent;
import com.example.mvpdemos.di.module.AppModule;

/**
 * Created by zhuangsj on 16-9-26.
 */

public class App extends Application {

    private static App instance;

    @Override
    public void onCreate() {
        super.onCreate();
        instance = this;
    }

    public static AppComponent getAppComponent() {
        return DaggerAppComponent.builder()
                .appModule(new AppModule(instance))
                .build();
    }
}
