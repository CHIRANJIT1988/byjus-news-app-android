package com.byjus.news.model;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "news_headlines")
public class NewsModel {

    @PrimaryKey(autoGenerate = true)
    private int id;
}