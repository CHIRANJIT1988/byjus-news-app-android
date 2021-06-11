package com.byjus.news.data;

import javax.inject.Inject;

import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;

/**
 * This class is used to add and dispose disposable
 */

public class AndroidDisposable {

    private CompositeDisposable compositeDisposable;

    @Inject
    AndroidDisposable() {

    }

    /**
     * This method is used to add disposable
     */
    public void add(Disposable disposable) {
        if (compositeDisposable == null) {
            compositeDisposable = new CompositeDisposable();
        }

        compositeDisposable.add(disposable);
    }

    /**
     * This method is used to dispose disposables
     */
    public void dispose() {
        compositeDisposable.dispose();
        compositeDisposable = null;
    }
}
