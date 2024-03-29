package com.byjus.news.view.home;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.byjus.news.databinding.AdapterNewsHeadingBinding;
import com.byjus.news.helper.DateUtils;
import com.byjus.news.model.Article;
import com.byjus.news.view.base.BaseAdapter;

import java.util.List;

import javax.inject.Inject;

public class NewsArticleAdapter extends BaseAdapter<NewsArticleAdapter.NewsArticleViewHolder, Article> {

    private final List<Article> articleList;
    private OnItemClicked callback;

    @Inject
    DateUtils dateUtils;

    @Inject
    public NewsArticleAdapter(List<Article> articleList) {
        this.articleList = articleList;
    }

    @NonNull
    @Override
    public NewsArticleViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return NewsArticleViewHolder.create(LayoutInflater.from(parent.getContext()), parent, callback);
    }

    @Override
    public void onBindViewHolder(@NonNull NewsArticleViewHolder holder, int position) {
        holder.onBind(articleList.get(position), dateUtils);
    }

    @Override
    public int getItemCount() {
        return articleList.size();
    }

    @Override
    public void setData(List<Article> data) {
        if(data == null) {
            return;
        }

        this.articleList.clear();
        this.articleList.addAll(data);

        notifyDataSetChanged();
    }

    static class NewsArticleViewHolder extends RecyclerView.ViewHolder {
        private static NewsArticleViewHolder create(LayoutInflater inflater, ViewGroup parent, OnItemClicked callback) {
            AdapterNewsHeadingBinding binding = AdapterNewsHeadingBinding.inflate(inflater, parent, false);
            return new NewsArticleViewHolder(binding, callback);
        }

        private final AdapterNewsHeadingBinding binding;

        NewsArticleViewHolder(AdapterNewsHeadingBinding binding, OnItemClicked callback) {
            super(binding.getRoot());
            this.binding = binding;

            binding.getRoot().setOnClickListener(v -> callback.onItemClick(binding.getModel()));
        }

        private void onBind(Article model, DateUtils dateUtils) {
            binding.setModel(model);
            binding.labelPublished.setText(dateUtils.getPublishedDate(model.getPublishedAt()));
            binding.executePendingBindings();
        }
    }

    public void setOnItemClickListener(OnItemClicked callback) {
        this.callback = callback;
    }

    public interface OnItemClicked {
        void onItemClick(Article model);
    }
}