package com.byjus.news.di.module;

import com.byjus.news.model.Article;

import java.util.ArrayList;
import java.util.List;

import dagger.Module;
import dagger.Provides;

@Module
public class DataModule {

    @Provides
    List<Article> provideArticleList() {
        return new ArrayList<>();
    }
}