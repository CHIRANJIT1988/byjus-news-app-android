package com.byjus.news.data.dao;

import androidx.room.TypeConverter;

import com.byjus.news.model.Article;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;

public class ArticleSourceTypeConverter {

    @TypeConverter
    public static Article.Source stringToArticleSource(String json) {
        Gson gson = new Gson();
        Type type = new TypeToken< Article.Source>() {}.getType();
        return gson.fromJson(json, type);
    }

    @TypeConverter
    public static String ArticleSourceToString(Article.Source source) {
        Gson gson = new Gson();
        Type type = new TypeToken< Article.Source>() {}.getType();
        return gson.toJson(source, type);
    }
}
