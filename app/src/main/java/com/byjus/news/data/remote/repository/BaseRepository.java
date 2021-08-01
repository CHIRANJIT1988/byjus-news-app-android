package com.byjus.news.data.remote.repository;

import com.byjus.news.data.AndroidDisposable;
import com.byjus.news.data.ApiService;
import com.byjus.news.data.dao.ArticleDao;

import javax.inject.Inject;

public abstract class BaseRepository {

    @Inject
    AndroidDisposable disposables;

    public final ApiService apiService;
    public final ArticleDao articleDao;

    BaseRepository(ApiService service, ArticleDao articleDao) {
        this.apiService = service;
        this.articleDao = articleDao;
    }

    public AndroidDisposable getDisposables() {
        return disposables;
    }

    public enum Status {
        PROGRESS,
        SUCCESS,
        FAILED
    }
}