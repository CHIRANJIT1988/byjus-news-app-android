package com.byjus.news.data.remote.repository;

import androidx.lifecycle.MutableLiveData;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

public class NewsArticleRepositoryTest {

    //@Rule
    //public MockitoRule mockitoRule = MockitoJUnit.rule();

    @Mock
    NewsArticleRepository repository;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void test_NonNull() {
        Assert.assertNotNull(repository);
    }

    @Test
    public void test_getAllArticlesFromLocal() {
        Mockito.when(repository.getAllArticlesFromLocal()).thenReturn(new MutableLiveData<>());
    }

    @Test
    public void test_getAllArticlesFromRemote() {
        Mockito.when(repository.getAllArticlesFromRemote()).thenReturn(new MutableLiveData<>());
    }

    @After
    public void tearDown() {

    }
}