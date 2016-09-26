package io.github.epelde.didactichappiness.ui.main;

/**
 * Created by epelde on 26/9/16.
 */
public interface MainContract {

    public interface MainView {

        void launchAgusActivity();

        void launchAlbertoActivity();

        void launchAlexActivity();

        void launchArkaitzActivity();

        void launchGorkaActivity();
    }

    public interface MainPresenter {

        void attachView(MainContract.MainView view);

        void detachView();

        void onClickAgusButton();

        void onClickAlbertoButton();

        void onClickAlexButton();

        void onClickArkaitzButton();

        void onClickGorkaButton();
    }
}
