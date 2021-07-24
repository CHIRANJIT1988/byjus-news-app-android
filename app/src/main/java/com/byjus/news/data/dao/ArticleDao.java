package com.byjus.news.data.dao;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import com.byjus.news.model.Article;

import java.util.List;

import io.reactivex.Single;

@Dao
public interface ArticleDao {

    @Query("SELECT * FROM news_articles")
    Single<List<Article>> getAll();

    @Query("SELECT COUNT(*) FROM news_articles")
    int count();

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    long insert(Article model);

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    long[] insertAll(List<Article> model);

    @Delete
    void delete(Article model);

    @Query("DELETE FROM news_articles")
    void deleteAll();
}