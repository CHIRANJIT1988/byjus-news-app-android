package com.byjus.news.data.remote.repository;

import com.byjus.news.data.ApiService;

import javax.inject.Inject;

public class NewsHeadlineRepository extends BaseRepository {

    @Inject
    NewsHeadlineRepository(ApiService service) {
        super(service);
    }
}