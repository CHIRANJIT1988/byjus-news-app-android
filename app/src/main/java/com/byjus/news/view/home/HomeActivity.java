package com.byjus.news.view.home;

import android.content.Intent;
import android.os.Bundle;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.byjus.news.R;
import com.byjus.news.databinding.ActivityHomeBinding;
import com.byjus.news.model.Article;
import com.byjus.news.view.base.BaseViewModelActivity;
import com.byjus.news.view.details.ArticleDetailsActivity;
import com.byjus.news.viewmodel.home.HomeViewModel;

import javax.inject.Inject;
import javax.inject.Named;

public class HomeActivity extends BaseViewModelActivity<HomeViewModel, ActivityHomeBinding> {

    @Inject
    @Named("vertical")
    LinearLayoutManager layoutManager;

    @Inject
    NewsArticleAdapter adapter;

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

        dataBinding.setViewModel(viewModel);
        dataBinding.setLifecycleOwner(this);

        //Initialize Article Adapter
        initArticleAdapter(dataBinding.articleList);

        viewModel.getAllArticles().observe(this, data -> {

            if(data != null && data.getArticles() != null) {
                adapter.setData(data.getArticles());
            }
        });
    }

    /**
     * Initialize article adapter
     * @param recyclerView
     */
    private void initArticleAdapter(RecyclerView recyclerView) {
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(layoutManager);
        adapter.setOnItemClickListener(model ->  {
            Intent intent = new Intent(HomeActivity.this, ArticleDetailsActivity.class);
            intent.putExtra("ARTICLE", model);
            startActivity(intent);
        });
    }
}