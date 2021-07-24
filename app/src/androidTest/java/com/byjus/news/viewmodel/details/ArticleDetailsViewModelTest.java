package com.byjus.news.viewmodel.details;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class ArticleDetailsViewModelTest {

    @Mock
    ArticleDetailsViewModel detailsViewModel;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void test_NonNull() {
        Assert.assertNotNull(detailsViewModel);
    }

    @Test
    public void test_getArticleMutableLiveData() {
        Assert.assertNotNull(detailsViewModel.articleMutableLiveData);
    }
}