package com.byjus.news.data.dao;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import com.byjus.news.model.NewsModel;

import java.util.List;

@Dao
public interface NewsDao {

    @Query("SELECT * FROM news_headlines")
    List<NewsModel> getAll();

    @Query("SELECT COUNT(*) FROM news_headlines")
    int count();

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    long insert(NewsModel model);

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    long[] insertAll(List<NewsModel> model);

    @Delete
    void delete(NewsModel model);
}