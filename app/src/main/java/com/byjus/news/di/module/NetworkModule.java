package com.byjus.news.di.module;

import android.content.Context;

import com.byjus.news.data.ApiConstants;
import com.byjus.news.data.ApiService;
import com.byjus.news.data.remote.RequestInterceptor;
import com.byjus.news.di.annotation.ApplicationContext;
import com.byjus.news.helper.network.ConnectivityInterceptor;
import com.byjus.news.helper.network.NetworkUtils;
import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;

import java.util.concurrent.TimeUnit;

import javax.inject.Named;
import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

@Module
public class NetworkModule {

    @Provides
    @Singleton
    OkHttpClient provideOkHttpClient(@ApplicationContext Context context, RequestInterceptor requestInterceptor, ConnectivityInterceptor connectivityInterceptor) {
        OkHttpClient.Builder okHttpClient = new OkHttpClient.Builder();
        okHttpClient.connectTimeout(ApiConstants.CONNECT_TIMEOUT, TimeUnit.MILLISECONDS);
        okHttpClient.readTimeout(ApiConstants.READ_TIMEOUT, TimeUnit.MILLISECONDS);
        okHttpClient.writeTimeout(ApiConstants.WRITE_TIMEOUT, TimeUnit.MILLISECONDS);
        okHttpClient.addInterceptor(requestInterceptor);
        okHttpClient.addInterceptor(connectivityInterceptor);
        return okHttpClient.build();
    }

    @Provides
    @Singleton
    ApiService provideApiInterface(OkHttpClient okHttpClient, @Named("baseURL") String baseUrl) {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(baseUrl)
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .client(okHttpClient)
                .build();

        return retrofit.create(ApiService.class);
    }

    @Provides
    @Singleton
    @Named("baseURL")
    String provideApiURL() {
        return ApiConstants.BASE_URL;
    }

    @Provides
    @Singleton
    RequestInterceptor provideRequestInterceptor() {
        return new RequestInterceptor();
    }

    @Provides
    @Singleton
    ConnectivityInterceptor provideConnectivityInterceptor(NetworkUtils networkUtils) {
        return new ConnectivityInterceptor(networkUtils);
    }

    @Provides
    @Singleton
    NetworkUtils provideNetworkUtils(@ApplicationContext Context context) {
        return new NetworkUtils(context);
    }
}