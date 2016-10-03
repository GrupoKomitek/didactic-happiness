package io.github.epelde.didactichappiness.ui.gorka.main;

/**
 * Created by Gorka on 27/09/2016.
 */
public interface MainContract {

    public interface MainView{
        void clickOraculo();
        void startTiping();
        String[] giveResponsesSet();
        void goResponse(String oracleMessage);
    }

    public interface MainPresenter{
        void onTiping();
        void oraculoClicked(String question);
    }
}
