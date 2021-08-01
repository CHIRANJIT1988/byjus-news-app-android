package com.byjus.news.viewmodel.details;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.MutableLiveData;

import com.byjus.news.helper.DateUtils;
import com.byjus.news.model.Article;
import com.byjus.news.viewmodel.base.BaseViewModel;

import javax.inject.Inject;

public class ArticleDetailsViewModel extends BaseViewModel {

    @Inject
    public MutableLiveData<Article> articleMutableLiveData;

    @Inject
    DateUtils dateUtils;

    @Inject
    public ArticleDetailsViewModel(@NonNull Application application) {
        super(application);
    }

    public MutableLiveData<Article> getArticleMutableLiveData() {
        return articleMutableLiveData;
    }

    public void setArticle(Article article) {
        this.articleMutableLiveData.setValue(article);
    }

    public String getPublishedDate(String publishedAt) {
        return dateUtils.getPublishedDate(publishedAt);
    }
}