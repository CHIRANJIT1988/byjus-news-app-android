package com.byjus.news.viewmodel.home;

import android.app.Application;

import androidx.annotation.NonNull;

import com.byjus.news.viewmodel.base.BaseViewModel;

import javax.inject.Inject;

public class HomeViewModel extends BaseViewModel {

    @Inject
    public HomeViewModel(@NonNull Application application) {
        super(application);
    }
}
