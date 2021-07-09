package com.byjus.news.data;

import com.byjus.news.data.remote.repository.NewsArticleResponse;

import io.reactivex.Single;
import retrofit2.http.GET;

public interface ApiService {

    @GET("everything?q=tesla&from=2021-06-09&sortBy=publishedAt&apiKey=309f04df5726481897ff4fdc9857c12e")
    Single<NewsArticleResponse> getAllArticles();
}