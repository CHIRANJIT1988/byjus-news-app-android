package com.byjus.news.di.module;

import java.text.SimpleDateFormat;

import javax.inject.Named;
import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
public class DatetimeFormatterModule {

    @Provides
    @Named("yyyy-MM-dd'T'HH:mm:ss")
    @Singleton
    SimpleDateFormat provide_DTF_yyyy_MM_dd_HH_mm_ss() {
        return new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss");
    }

    @Provides
    @Named("yyyy-MM-dd")
    @Singleton
    SimpleDateFormat provide_DTF_yyyy_MM_dd() {
        return new SimpleDateFormat("yyyy-MM-dd");
    }
}