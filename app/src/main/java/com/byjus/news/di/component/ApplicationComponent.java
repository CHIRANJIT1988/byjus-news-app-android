package com.byjus.news.di.component;

import android.app.Application;

import com.byjus.news.ByjuApplication;
import com.byjus.news.di.module.AdapterLayoutModule;
import com.byjus.news.di.module.ApplicationModule;
import com.byjus.news.di.module.BuildersModule;
import com.byjus.news.di.module.DataModule;
import com.byjus.news.di.module.NetworkModule;
import com.byjus.news.di.module.RoomModule;

import javax.inject.Singleton;

import dagger.BindsInstance;
import dagger.Component;
import dagger.android.AndroidInjectionModule;
import dagger.android.support.AndroidSupportInjectionModule;

@Singleton
@Component(modules = {
        ApplicationModule.class,
        AndroidSupportInjectionModule.class,
        AndroidInjectionModule.class,
        AdapterLayoutModule.class,
        DataModule.class,
        BuildersModule.class,
        NetworkModule.class,
        RoomModule.class })
public interface ApplicationComponent {

    @Component.Builder
    interface Builder {
        @BindsInstance
        Builder application(Application application);

        ApplicationComponent build();
    }

    void inject(ByjuApplication application);
}