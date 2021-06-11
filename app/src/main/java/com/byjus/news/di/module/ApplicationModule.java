package com.byjus.news.di.module;

import android.app.Application;
import android.content.Context;

import com.byjus.news.di.annotation.ApplicationContext;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module(includes = ViewModelModule.class)
public class ApplicationModule {
    @Provides
    @Singleton
    @ApplicationContext
    Context provideContext(Application application) {
        return application;
    }
}