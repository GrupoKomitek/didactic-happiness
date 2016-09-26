package io.github.epelde.didactichappiness.ui.main;

import android.util.Log;

/**
 * Created by epelde on 26/9/16.
 */
public class MainPresenter implements MainContract.MainPresenter {

    MainContract.MainView view;

    @Override
    public void attachView(MainContract.MainView view) {
        this.view = view;
    }

    @Override
    public void detachView() {
        this.view = null;
    }

    @Override
    public void onClickAgusButton() {
        view.launchAgusActivity();
    }

    @Override
    public void onClickAlbertoButton() {
        view.launchAlbertoActivity();
    }

    @Override
    public void onClickAlexButton() {
        view.launchAlexActivity();
    }

    @Override
    public void onClickArkaitzButton() {
        view.launchArkaitzActivity();
    }

    @Override
    public void onClickGorkaButton() {
        view.launchGorkaActivity();
    }
}
