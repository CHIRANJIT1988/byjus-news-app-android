package com.byjus.news.viewmodel.home;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.LiveData;

import com.byjus.news.data.remote.repository.BaseRepository;
import com.byjus.news.data.remote.repository.NewsArticleRepository;
import com.byjus.news.helper.network.NetworkUtils;
import com.byjus.news.model.Article;
import com.byjus.news.viewmodel.base.BaseViewModel;

import java.util.List;

import javax.inject.Inject;

public class HomeViewModel extends BaseViewModel {

    @Inject
    public NewsArticleRepository repository;
    @Inject
    public NetworkUtils networkUtils;

    @Inject
    public HomeViewModel(@NonNull Application application) {
        super(application);
    }

    public LiveData<List<Article>> getAllArticles() {
        repository.getStatusMutableLiveData().observeForever(status -> {
            if(status == BaseRepository.Status.PROGRESS) {
                getProgress().setValue(true);
            } else {
                getProgress().setValue(false);
            }
        });

        if(networkUtils.isOnline()) {
            return repository.getAllArticlesFromRemote();
        }
        return repository.getAllArticlesFromLocal();
    }
}