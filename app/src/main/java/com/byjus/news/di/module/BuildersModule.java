package com.byjus.news.di.module;

import com.byjus.news.view.home.HomeActivity;
import com.byjus.news.view.module.HomeActivityModule;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;

@Module
public abstract class BuildersModule {

    @ContributesAndroidInjector(modules = HomeActivityModule.class)
    abstract HomeActivity homeActivity();
}