package com.byjus.news.data.local;


import androidx.room.Database;
import androidx.room.RoomDatabase;

import com.byjus.news.data.dao.ArticleDao;
import com.byjus.news.model.Article;

@Database(entities = {Article.class}, version = 1, exportSchema = false)
public abstract class AppDatabase extends RoomDatabase {

    public abstract ArticleDao articleDao();
}