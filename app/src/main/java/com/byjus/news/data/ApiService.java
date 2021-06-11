package com.byjus.news.data;

import com.byjus.news.model.NewsModel;

import java.util.List;

import io.reactivex.Single;
import retrofit2.http.GET;

public interface ApiService {

    @GET("everything/")
    Single<List<NewsModel>> getAllNewsHeadlines();
}