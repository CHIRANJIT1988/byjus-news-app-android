package com.byjus.news.di.module;

import com.byjus.news.data.ApiService;
import com.byjus.news.data.dao.ArticleDao;
import com.byjus.news.data.remote.repository.NewsArticleRepository;

import dagger.Module;
import dagger.Provides;

@Module
public class RepositoryModule {

    @Provides
    public NewsArticleRepository provideNewsArticleRepository(ApiService service, ArticleDao articleDao) {
        return new NewsArticleRepository(service, articleDao);
    }
}