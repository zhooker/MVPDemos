package com.example.mvpdemos.di.module;

import com.example.mvpdemos.App;
import com.example.mvpdemos.di.ContextLife;
import com.example.mvpdemos.model.http.RetrofitHelper;
import javax.inject.Singleton;
import dagger.Module;
import dagger.Provides;

/**
 *
 */

@Module
public class AppModule {
    private final App application;

    public AppModule(App application) {
        this.application = application;
    }

    @Provides
    @Singleton
    @ContextLife("Application")
    App provideApplicationContext() {
        return application;
    }

    @Provides
    @Singleton
    RetrofitHelper provideRetrofitHelper() {
        return new RetrofitHelper();
    }
}
