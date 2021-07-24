package com.byjus.news.helper.network;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

public class NetworkUtils {
    private Context context;

    public NetworkUtils(Context context) {
        this.context = context;
    }

    public boolean isOnline() {
        try {
            ConnectivityManager connectivity = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
            NetworkInfo networkInfo = connectivity.getActiveNetworkInfo();
            return networkInfo != null && networkInfo.isAvailable() && networkInfo.isConnected();
        }
        catch (Exception e) {
            e.printStackTrace();
        }

        return false;
    }
}
