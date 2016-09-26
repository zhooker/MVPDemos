package com.example.mvpdemos.di.component;

import android.app.Activity;
import com.example.mvpdemos.dagger.DaggerActivity;
import com.example.mvpdemos.di.ActivityScope;
import com.example.mvpdemos.di.module.ActivityModule;

import dagger.Component;

/**
 *
 */

@ActivityScope
@Component(dependencies = AppComponent.class, modules = ActivityModule.class)
public interface ActivityComponent {

    Activity getActivity();

    void inject(DaggerActivity daggerActivity);
}
