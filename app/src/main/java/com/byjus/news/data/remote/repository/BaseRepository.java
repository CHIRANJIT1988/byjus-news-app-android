package com.byjus.news.data.remote.repository;

import com.byjus.news.data.AndroidDisposable;
import com.byjus.news.data.ApiService;

import javax.inject.Inject;

public abstract class BaseRepository {

    @Inject
    AndroidDisposable disposables;

    public final ApiService apiService;

    BaseRepository(ApiService service) {
        this.apiService = service;
    }

    public AndroidDisposable getDisposables() {
        return disposables;
    }
}