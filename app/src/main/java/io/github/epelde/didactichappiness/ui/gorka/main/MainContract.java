package io.github.epelde.didactichappiness.ui.gorka.main;

/**
 * Created by Gorka on 27/09/2016.
 */
public interface MainContract {

    public interface MainView{
        void clickOraculo();
        void startTiping();
    }

    public interface MainPresenter{
        void onTiping();
        void oraculoClicked();
    }
}
