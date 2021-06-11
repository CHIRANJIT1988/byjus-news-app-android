package com.byjus.news.data.local;


import androidx.room.Database;
import androidx.room.RoomDatabase;

import com.byjus.news.data.dao.NewsDao;
import com.byjus.news.model.NewsModel;

//@Database(entities = {NewsModel.class}, version = 1, exportSchema = false)
public abstract class AppDatabase extends RoomDatabase {

    public abstract NewsDao newsDao();
}