package com.byjus.news.di.module;

import com.byjus.news.view.details.ArticleDetailsActivity;
import com.byjus.news.view.home.HomeActivity;
import com.byjus.news.view.module.ArticleDetailsActivityModule;
import com.byjus.news.view.module.HomeActivityModule;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;

@Module
public abstract class BuildersModule {

    @ContributesAndroidInjector(modules = HomeActivityModule.class)
    abstract HomeActivity homeActivity();

    @ContributesAndroidInjector(modules = ArticleDetailsActivityModule.class)
    abstract ArticleDetailsActivity articleDetailsActivity();
}