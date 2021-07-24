package com.byjus.news.helper.network;

import java.io.IOException;

import javax.inject.Inject;

import okhttp3.Interceptor;
import okhttp3.Response;

public class ConnectivityInterceptor implements Interceptor {

    private NetworkUtils networkUtils;

    @Inject
    public ConnectivityInterceptor(NetworkUtils networkUtils) {
        this.networkUtils = networkUtils;
    }

    @Override
    public Response intercept(Chain chain) throws IOException {
        if (!networkUtils.isOnline()) {
            throw new NoConnectivityException();
        }

        return chain.proceed(chain.request());
    }

    public static class NoConnectivityException extends IOException {
        @Override
        public String getMessage() {
            return "No network available, please check your WiFi or Data connection";
        }
    }
}