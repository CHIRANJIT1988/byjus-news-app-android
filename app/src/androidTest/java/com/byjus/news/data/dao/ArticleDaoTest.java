package com.byjus.news.data.dao;

import androidx.room.Room;
import androidx.test.InstrumentationRegistry;

import com.byjus.news.data.local.AppDatabase;
import com.byjus.news.model.Article;
import com.google.gson.Gson;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNotNull;

@RunWith(JUnit4.class)
public class ArticleDaoTest {

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

    private ArticleDao articleDao;
    private AppDatabase appDatabase;
    private Article article;

    @Before
    public void initDb() {
        appDatabase = Room.inMemoryDatabaseBuilder(InstrumentationRegistry.getContext(), AppDatabase.class)
                .allowMainThreadQueries()
                .build();
        articleDao = appDatabase.articleDao();
        article = new Gson().fromJson(JSON_DATA, Article.class);
    }

    @Test
    public void test_ArticleDaoNonNull() {
        assertNotNull(articleDao);
    }

    @Test
    public void test_DatabaseNonNull() {
        assertNotNull(appDatabase);
    }

    @Test
    public void test_ArticleDaoCountSuccess() {
        articleDao.insert(article);
        long count = articleDao.count();
        assertEquals(1, count);
    }

    @Test
    public void test_ArticleDaoCountFailure() {
        long count = articleDao.count();
        assertNotEquals(2, count);
    }

    @Test
    public void test_ArticleDaoInsertTest() {
        long id = articleDao.insert(article);
        assertNotEquals(0, id);
    }

    @Test
    public void test_ArticleDaoDeleteAllTest() {
        articleDao.deleteAll();
        assertEquals(0, articleDao.count());
    }

    @Test
    public void test_ArticleDaoInsertAllTest() {
        List<Article> articleList = new ArrayList<>();
        articleList.add(article);
        articleList.add(article);
        articleDao.insertAll(articleList);
        assertEquals(2, articleDao.count());
    }

    @After
    public void closeDb() {
        appDatabase.close();
    }
}
