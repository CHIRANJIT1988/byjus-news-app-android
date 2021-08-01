package com.byjus.news.view.details;

import android.os.Bundle;
import android.view.View;

import com.byjus.news.R;
import com.byjus.news.databinding.ActivityArticleDetailsBinding;
import com.byjus.news.model.Article;
import com.byjus.news.view.base.BaseViewModelActivity;
import com.byjus.news.viewmodel.details.ArticleDetailsViewModel;

public class ArticleDetailsActivity extends BaseViewModelActivity<ArticleDetailsViewModel, ActivityArticleDetailsBinding> {

    @Override
    protected Class<ArticleDetailsViewModel> getViewModel() {
        return ArticleDetailsViewModel.class;
    }

    @Override
    protected int getLayoutRes() {
        return R.layout.activity_article_details;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        dataBinding.setViewModel(viewModel);
        dataBinding.setLifecycleOwner(this);

        Article article = (Article) getIntent().getSerializableExtra("ARTICLE");
        viewModel.setArticle(article);
    }

    public void onBackButtonClick(View view) {
        finish();
    }
}