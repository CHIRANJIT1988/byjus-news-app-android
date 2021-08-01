package com.byjus.news.di.module;

import androidx.lifecycle.MutableLiveData;

import com.byjus.news.data.remote.repository.BaseRepository;
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

    @Provides
    MutableLiveData<Article> provideArticleMutableLiveData() {
        return new MutableLiveData<>();
    }

    @Provides
    MutableLiveData<BaseRepository.Status> provideStatusMutableLiveData() {
        return new MutableLiveData<>();
    }
}