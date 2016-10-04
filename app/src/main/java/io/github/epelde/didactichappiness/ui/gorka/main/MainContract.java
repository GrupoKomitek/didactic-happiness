package io.github.epelde.didactichappiness.ui.gorka.main;

/**
 * Created by Gorka on 27/09/2016.
 *
 * Contract for question typing screen
 */
public interface MainContract {

    /**
     * Oracle's question typing view
     */
    public interface MainView{

        /**
         * Oracle consulting button clicked
         */
        void clickOraculo();

        /**
         * On start typing question
         */
        void startTiping();

        /**
         * When Oracle's response is retrieved
         * @param messageId
         */
        void goResponse(int messageId);
    }

    /**
     * Presenter for asking Oracle
     */
    public interface MainPresenter{

        /**
         * On start typing the question
         */
        void onTiping();

        /**
         * Sends question to Oracle
         * @param question
         */
        void oraculoClicked(String question);

        /**
         * Ends the presenter/view contract
         */
        void detach();
    }
}
