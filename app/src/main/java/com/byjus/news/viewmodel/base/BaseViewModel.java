package com.byjus.news.viewmodel.base;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.MutableLiveData;

public abstract class BaseViewModel extends AndroidViewModel {

    public MutableLiveData<Boolean> mProgress = new MutableLiveData<>();

    public BaseViewModel(@NonNull Application application) {
        super(application);
    }

    public MutableLiveData<Boolean> getProgress() {
        return mProgress;
    }

    public void setProgress(MutableLiveData<Boolean> mProgress) {
        this.mProgress = mProgress;
    }
}