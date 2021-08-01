package com.byjus.news.data.remote.repository;

import androidx.annotation.NonNull;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.byjus.news.data.ApiService;
import com.byjus.news.data.dao.ArticleDao;
import com.byjus.news.model.Article;

import java.util.List;

import javax.inject.Inject;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.observers.DisposableSingleObserver;
import io.reactivex.schedulers.Schedulers;

public class NewsArticleRepository extends BaseRepository {

    private static final String TAG = NewsArticleRepository.class.getSimpleName();

    public MutableLiveData<Status> statusMutableLiveData = new MutableLiveData<>();

    @Inject
    public NewsArticleRepository(ApiService service, ArticleDao articleDao) {
        super(service, articleDao);
    }

    public MutableLiveData<Status> getStatusMutableLiveData() {
        return statusMutableLiveData;
    }

    public LiveData<List<Article>> getAllArticlesFromRemote() {
        final MutableLiveData<List<Article>> data = new MutableLiveData<>();
        apiService.getAllArticles()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .doOnSubscribe(d -> statusMutableLiveData.postValue(Status.PROGRESS))
                .subscribe(new DisposableSingleObserver<NewsArticleResponse>() {
                    @Override
                    public void onSuccess(@NonNull NewsArticleResponse response) {
                        statusMutableLiveData.postValue(Status.SUCCESS);
                        data.setValue(response.getArticles());
                        articleDao.deleteAll();
                        articleDao.insertAll(response.getArticles());
                    }
                    @Override
                    public void onError(@NonNull Throwable throwable) {
                        statusMutableLiveData.postValue(Status.FAILED);
                        data.setValue(null);
                    }
                });

        return data;
    }

    public LiveData<List<Article>> getAllArticlesFromLocal() {
        final MutableLiveData<List<Article>> data = new MutableLiveData<>();
        articleDao.getAll()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .doOnSubscribe(d -> statusMutableLiveData.postValue(Status.PROGRESS))
                .subscribe(new DisposableSingleObserver<List<Article>>() {
                    @Override
                    public void onSuccess(@NonNull List<Article> articleList) {
                        statusMutableLiveData.postValue(Status.SUCCESS);
                        data.setValue(articleList);
                    }
                    @Override
                    public void onError(@NonNull Throwable throwable) {
                        statusMutableLiveData.postValue(Status.FAILED);
                        data.setValue(null);
                    }
                });

        return data;
    }
}