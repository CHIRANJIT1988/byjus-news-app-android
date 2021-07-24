package com.byjus.news.data.remote;

import androidx.annotation.NonNull;

import java.io.IOException;

import javax.inject.Inject;
import javax.inject.Singleton;

import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;

@Singleton
public class RequestInterceptor implements Interceptor {

    @Inject
    public RequestInterceptor() {
        super();
    }

    @Override
    public Response intercept(@NonNull Interceptor.Chain chain) throws IOException {
        Request original = chain.request();
        Request.Builder requestBuilder = original.newBuilder()
                .addHeader("Accept", "application/json")
                .addHeader("Request-Type", "Android")
                .addHeader("Content-Type", "application/json; charset=utf-8");

        Request request = requestBuilder.build();

        return chain.proceed(request);
    }
}