package io.github.epelde.didactichappiness.ui.gorka.main;

import io.github.epelde.didactichappiness.ui.DidacticContract;

/**
 * Created by Gorka on 27/09/2016.
 *
 * Contract for question typing screen
 */
public interface MainContract extends DidacticContract{

    /**
     * Oracle's question typing view
     */
    public interface MainView extends DidacticContract.DidacticContractView{

        /**
         * Oracle consulting button clicked
         */
        void clickOraculo();

        /**
         * On start typing question
         */
        void startTiping();

        /**
         * Welcome message configuration
         */
        void setWelcomeText(boolean friend);

        /**
         * When Oracle's response is retrieved
         * @param messageId
         */
        void goResponse(int messageId);
    }

    /**
     * Presenter for asking Oracle
     */
    public interface MainPresenter extends DidacticContract.DidacticContractPresenter{

        /**
         * On start typing the question
         */
        void onTiping();

        /**
         * Sends question to Oracle
         * @param question
         */
        void oraculoClicked(String question);
    }
}
