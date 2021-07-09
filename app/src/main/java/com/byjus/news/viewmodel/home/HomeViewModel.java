package com.byjus.news.viewmodel.home;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.LiveData;

import com.byjus.news.data.remote.repository.NewsArticleResponse;
import com.byjus.news.data.remote.repository.NewsArticleRepository;
import com.byjus.news.viewmodel.base.BaseViewModel;

import javax.inject.Inject;

public class HomeViewModel extends BaseViewModel {

    private NewsArticleRepository repository;

    @Inject
    public HomeViewModel(@NonNull Application application, NewsArticleRepository repository) {
        super(application);
        this.repository = repository;
    }

    public LiveData<NewsArticleResponse> getAllArticles() {
        return repository.getAllArticles();
    }
}
