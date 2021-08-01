package com.byjus.news.data.dao;

import com.byjus.news.model.Article;
import com.google.gson.Gson;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class ArticleSourceTypeConverterTest {

    private Article.Source articleSource;
    private static final String JSON_DATA = "{\n" +
            "\t\"source\": {\n" +
            "\t\t\"id\": \"1\",\n" +
            "\t\t\"name\": \"FOX 7 Austin\"\n" +
            "\t}\n" +
            "}";

    @Before
    public void setUp() {
        articleSource = new Gson().fromJson(JSON_DATA, Article.Source.class);
    }

    @Test
    public void test_stringToArticleSource() {
        Article.Source source = ArticleSourceTypeConverter.stringToArticleSource(JSON_DATA);
        assertNotNull(source);
        assertEquals("1", source.getId());
        assertEquals("FOX 7 Austin", source.getName());

    }

    @Test
    public void test_ArticleSourceToString() {
        String source = ArticleSourceTypeConverter.ArticleSourceToString(articleSource);
        assertNotNull(source);
    }
}