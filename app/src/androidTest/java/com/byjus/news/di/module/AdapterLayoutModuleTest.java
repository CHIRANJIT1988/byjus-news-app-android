package com.byjus.news.di.module;

import android.app.Application;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import javax.inject.Inject;

public class AdapterLayoutModuleTest {

    @Mock
    AdapterLayoutModule adapterLayoutModule;
    @Mock
    Application application;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void test_NonNull() {
        Assert.assertNotNull(adapterLayoutModule);
    }

    @Test
    public void test_provideVerticalLayoutManager() {
        adapterLayoutModule.provideVerticalLayoutManager(application.getApplicationContext());
    }

    @After
    public void tearDown() {

    }
}