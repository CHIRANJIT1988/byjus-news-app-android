package com.byjus.news.model;

import com.google.gson.Gson;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class ArticleTest {

    private static final String JSON_DATA = "{\n" +
            "            \"source\": {\n" +
            "                \"id\": null,\n" +
            "                \"name\": \"FOX 7 Austin\"\n" +
            "            },\n" +
            "            \"author\": \"FOX 7 Austin\",\n" +
            "            \"title\": \"TESLA building solar-powered neighborhood...\",\n" +
            "            \"description\": \"The initiative, provisionally named SunHouse at Easton Park, will be the first Tesla Solar neighborhood and the nation’s most sustainable residential community.\",\n" +
            "            \"url\": \"https://www.fox7austin.com/news/tesla-launches-initiative-to-build-first-solar-neighborhood-in-austin\",\n" +
            "            \"urlToImage\": \"https://images.foxtv.com/static.fox5ny.com/www.fox5ny.com/content/uploads/2021/07/1280/720/GettyImages-187005526_1555969552377_7141953_ver1.0.jpg?ve=1&tl=1\",\n" +
            "            \"publishedAt\": \"2021-07-11T18:19:37Z\",\n" +
            "            \"content\": \"AUSTIN, Texas - Tesla Energy, Brookfield Asset Management Inc., and Dacra announced in a press release Friday a new initiative to bring a large-scale sustainable neighborhood to Austin.\\r\\nThe initiati… [+3980 chars]\"\n" +
            "        }";

    private Article article;

    @Before
    public void setUp() {
        article = new Gson().fromJson(JSON_DATA, Article.class);
    }

    @Test
    public void test_NonNull() {
        Assert.assertNotNull(article);
    }

    @Test
    public void test_getSource() {
        Assert.assertNotNull(article.getSource());
    }

    @Test
    public void test_setSource() {

    }

    @Test
    public void test_getAuthor() {
        Assert.assertEquals("FOX 7 Austin", article.getAuthor());
    }

    @Test
    public void test_setAuthor() {

    }

    @Test
    public void test_getTitle() {
        Assert.assertEquals("TESLA building solar-powered neighborhood...", article.getTitle());
    }

    @Test
    public void test_setTitle() {

    }

    @Test
    public void test_getDescription() {
        Assert.assertEquals("The initiative, provisionally named SunHouse at Easton Park, will be the " +
                "first Tesla Solar neighborhood and the nation’s most sustainable residential community.", article.getDescription());
    }

    @Test
    public void test_setDescription() {

    }

    @Test
    public void test_getUrl() {
        Assert.assertEquals("https://www.fox7austin.com/news/tesla-launches-initiative-to-build-" +
                "first-solar-neighborhood-in-austin", article.getUrl());
    }

    @Test
    public void test_setUrl() {

    }

    @Test
    public void test_getUrlToImage() {
        Assert.assertEquals("https://images.foxtv.com/static.fox5ny.com/www.fox5ny.com/content/uploads/2021/07/" +
                "1280/720/GettyImages-187005526_1555969552377_7141953_ver1.0.jpg?ve=1&tl=1", article.getUrlToImage());
    }

    @Test
    public void test_setUrlToImage() {

    }

    @Test
    public void test_getPublishedAt() {
        Assert.assertEquals("2021-07-11T18:19:37Z", article.getPublishedAt());
    }

    @Test
    public void test_setPublishedAt() {

    }

    @Test
    public void test_getContent() {
        Assert.assertEquals("AUSTIN, Texas - Tesla Energy, Brookfield Asset Management Inc., and Dacra announced in a " +
                "press release Friday a new initiative to bring a large-scale sustainable neighborhood to " +
                "Austin.\r\nThe initiati… [+3980 chars]", article.getContent());
    }

    @Test
    public void test_setContent() {

    }

    @After
    public void tearDown() {

    }
}
