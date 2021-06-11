package com.byjus.news;

import android.app.Activity;
import android.app.Application;

import com.byjus.news.di.ApplicationInjector;
import com.byjus.news.di.component.ApplicationComponent;

import javax.inject.Inject;

import dagger.android.AndroidInjector;
import dagger.android.DispatchingAndroidInjector;
import dagger.android.HasActivityInjector;

public class ByjuApplication extends Application implements HasActivityInjector {

    private static ByjuApplication sInstance;
    private static ApplicationComponent applicationComponent;

    public static ByjuApplication getInstance() {
        return sInstance;
    }

    private static synchronized void setInstance(ByjuApplication app) {
        sInstance = app;
    }

    @Inject
    DispatchingAndroidInjector<Activity> activityDispatchingInjector;

    @Override
    public void onCreate() {
        super.onCreate();
        initializeComponent();
        setInstance(this);
    }

    private void initializeComponent() {
        applicationComponent = ApplicationInjector.init(this);
    }

    public static ApplicationComponent getApplicationComponent() {
        return applicationComponent;
    }

    @Override
    public AndroidInjector<Activity> activityInjector() {
        return activityDispatchingInjector;
    }
}