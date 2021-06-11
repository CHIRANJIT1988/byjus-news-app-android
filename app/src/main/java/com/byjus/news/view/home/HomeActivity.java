package com.byjus.news.view.home;

import android.os.Bundle;

import com.byjus.news.R;
import com.byjus.news.databinding.ActivityHomeBinding;
import com.byjus.news.view.base.BaseViewModelActivity;
import com.byjus.news.viewmodel.home.HomeViewModel;

public class HomeActivity extends BaseViewModelActivity<HomeViewModel, ActivityHomeBinding> {

    @Override
    protected Class<HomeViewModel> getViewModel() {
        return HomeViewModel.class;
    }

    @Override
    protected int getLayoutRes() {
        return R.layout.activity_home;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }
}