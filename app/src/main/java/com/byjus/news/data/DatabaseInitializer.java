package com.byjus.news.data;

import com.byjus.news.data.local.AppDatabase;

import javax.inject.Inject;

public class DatabaseInitializer {
    private static final String TAG = DatabaseInitializer.class.getName();

    @Inject
    AppDatabase db;

    @Inject
    public DatabaseInitializer(AppDatabase database) {
        this.db = database;
    }


    public long countArticles() {
        return db.articleDao().count();
    }
}
