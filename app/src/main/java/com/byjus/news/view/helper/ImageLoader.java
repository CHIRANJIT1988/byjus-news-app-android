package com.byjus.news.view.helper;

import android.widget.ImageView;

import androidx.databinding.BindingAdapter;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;

public class ImageLoader {

    @BindingAdapter("bannerUrl")
    public static void setArticleBanner(ImageView imageView, String url) {
        RequestOptions options = new RequestOptions().override(400, 400);
        Glide.with(imageView.getContext()).asBitmap().load(url).apply(options).into(imageView);
    }
}