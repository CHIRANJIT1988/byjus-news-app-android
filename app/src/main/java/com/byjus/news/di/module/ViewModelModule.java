package com.byjus.news.di.module;

import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;

import com.byjus.news.viewmodel.ViewModelFactory;
import com.byjus.news.viewmodel.details.ArticleDetailsViewModel;
import com.byjus.news.viewmodel.home.HomeViewModel;

import dagger.Binds;
import dagger.Module;
import dagger.multibindings.IntoMap;

/**
 * Allows us to inject dependencies via constructor injection
 */
@Module
public abstract class ViewModelModule {

    @Binds
    @IntoMap
    @ViewModelKey(HomeViewModel.class)
    @SuppressWarnings("unused")
    abstract ViewModel bindsHomeViewModel(HomeViewModel homeViewModel);

    @Binds
    @IntoMap
    @ViewModelKey(ArticleDetailsViewModel.class)
    @SuppressWarnings("unused")
    abstract ViewModel articleDetailsViewModel(ArticleDetailsViewModel articleDetailsViewModel);

    @Binds
    @SuppressWarnings("unused")
    abstract ViewModelProvider.Factory bindsViewModelFactory(ViewModelFactory viewModelFactory);
}