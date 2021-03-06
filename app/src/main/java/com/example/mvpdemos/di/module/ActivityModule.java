package com.example.mvpdemos.di.module;

import android.app.Activity;

import com.example.mvpdemos.di.ActivityScope;

import dagger.Module;
import dagger.Provides;

/**
 *
 */

@Module
public class ActivityModule {
    private Activity mActivity;

    public ActivityModule(Activity activity) {
        this.mActivity = activity;
    }

    @Provides
    @ActivityScope
    public Activity provideActivity() {
        return mActivity;
    }
}
