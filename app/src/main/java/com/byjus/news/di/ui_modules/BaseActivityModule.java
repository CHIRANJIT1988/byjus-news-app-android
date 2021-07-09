package com.byjus.news.di.ui_modules;

import android.app.Activity;
import android.content.Context;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.LifecycleOwner;

import com.byjus.news.di.annotation.ActivityContext;

import dagger.Module;
import dagger.Provides;

@Module
public abstract class BaseActivityModule<T extends AppCompatActivity> {

    @Provides
    @ActivityContext
    public Context provideContext(T activity) { return activity; }

    @Provides
    public Activity provideActivity(T activity) { return activity; }

    @Provides
    public LifecycleOwner provideLifeCycleOwner(T activity) {
        return activity;
    }
}