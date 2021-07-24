package com.byjus.news.data.remote.repository;

import com.byjus.news.model.Article;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

public class NewsArticleResponseTest {

    private NewsArticleResponse newsArticleResponse;

    @Before
    public void setUp() {
        newsArticleResponse = new NewsArticleResponse();
    }

    @Test
    public void test_NonNull() {
        Assert.assertNotNull(newsArticleResponse);
    }

    @Test
    public void test_getStatus() {
        Assert.assertNull(newsArticleResponse.getStatus());
    }

    @Test
    public void setStatus() {
        newsArticleResponse.setStatus("OK");
        Assert.assertEquals("OK", newsArticleResponse.getStatus());
    }

    @Test
    public void getTotalResults() {
        Assert.assertEquals(0, newsArticleResponse.getTotalResults());
    }

    @Test
    public void setTotalResults() {
        newsArticleResponse.setTotalResults(10);
        Assert.assertEquals(10, newsArticleResponse.getTotalResults());
    }

    @Test
    public void getArticles() {
        Assert.assertNull(newsArticleResponse.getArticles());
    }

    @Test
    public void setArticles() {
        newsArticleResponse.setArticles(new ArrayList<>());
        Assert.assertEquals(0, newsArticleResponse.getArticles().size());
        newsArticleResponse.getArticles().add(new Article());
        Assert.assertEquals(1, newsArticleResponse.getArticles().size());
    }

    @After
    public void tearDown() {

    }
}