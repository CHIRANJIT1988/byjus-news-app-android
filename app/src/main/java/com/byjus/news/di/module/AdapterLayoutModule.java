package com.byjus.news.di.module;

import android.content.Context;

import androidx.recyclerview.widget.LinearLayoutManager;

import com.byjus.news.di.annotation.ApplicationContext;

import javax.inject.Named;

import dagger.Module;
import dagger.Provides;

@Module
public class AdapterLayoutModule {

    @Provides
    @Named("vertical")
    LinearLayoutManager provideVerticalLayoutManager(@ApplicationContext Context context) {
        return new LinearLayoutManager(context);
    }
}