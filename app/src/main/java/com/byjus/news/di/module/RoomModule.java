package com.byjus.news.di.module;

import android.content.Context;

import androidx.room.Room;

import com.byjus.news.data.dao.NewsDao;
import com.byjus.news.data.local.AppDatabase;
import com.byjus.news.di.annotation.ApplicationContext;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
public class RoomModule {

    @Singleton
    @Provides
    AppDatabase provideRoomDatabase(@ApplicationContext Context context) {
        return Room.databaseBuilder(context, AppDatabase.class, "db-news-headlines")
                // allow queries on the main thread.
                // Don't do this on a real app! See PersistenceBasicSample for an example.
                .allowMainThreadQueries()
                .build();
    }

    @Singleton
    @Provides
    NewsDao provideNewsDao(AppDatabase database) {
        return database.newsDao();
    }
}