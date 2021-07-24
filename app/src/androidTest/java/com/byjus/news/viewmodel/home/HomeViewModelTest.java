package com.byjus.news.viewmodel.home;

import androidx.lifecycle.MutableLiveData;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class HomeViewModelTest {

    @Mock
    HomeViewModel homeViewModel;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void test_NonNull() {
        Assert.assertNotNull(homeViewModel);
    }

    @Test
    public void test_getAllArticles() {
        Mockito.when(homeViewModel.getAllArticles()).thenReturn(new MutableLiveData<>());
    }
}