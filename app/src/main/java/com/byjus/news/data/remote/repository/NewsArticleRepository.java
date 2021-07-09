package com.byjus.news.data.remote.repository;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.byjus.news.data.ApiService;

import javax.inject.Inject;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.observers.DisposableSingleObserver;
import io.reactivex.schedulers.Schedulers;

public class NewsArticleRepository extends BaseRepository {

    private static final String TAG = NewsArticleRepository.class.getSimpleName();

    @Inject
    NewsArticleRepository(ApiService service) {
        super(service);
    }

    public LiveData<NewsArticleResponse> getAllArticles() {
        final MutableLiveData<NewsArticleResponse> data = new MutableLiveData<>();
        disposables.add(apiService.getAllArticles()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                //.doOnSubscribe(d -> listener.onProgress())
                .subscribeWith(new DisposableSingleObserver<NewsArticleResponse>() {
                    @Override
                    public void onSuccess(NewsArticleResponse response) {
                        data.setValue(response);
                    }

                    @Override
                    public void onError(Throwable throwable) {
                        data.setValue(null);
                    }
                }));

        return data;
    }
}