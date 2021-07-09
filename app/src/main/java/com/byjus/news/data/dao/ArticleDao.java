package com.byjus.news.data.dao;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import com.byjus.news.model.Article;

import java.util.List;

@Dao
public interface ArticleDao {

    @Query("SELECT * FROM Article")
    List<Article> getAll();

    @Query("SELECT COUNT(*) FROM Article")
    int count();

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    long insert(Article model);

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    long[] insertAll(List<Article> model);

    @Delete
    void delete(Article model);
}