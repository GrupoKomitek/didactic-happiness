package io.github.epelde.didactichappiness.ui.gorka.main;

/**
 * Created by Gorka on 27/09/2016.
 *
 * Contrato para la pantalla del Oráculo en la cual se escribe la pregunta
 */
public interface MainContract {

    /**
     * Vista para preguntar al Oráculo
     */
    public interface MainView{

        /**
         * Se clickea el botón de consulta al oráculo
         */
        void clickOraculo();

        /**
         * Se comienza a escribir la pregunta
         */
        void startTiping();

        /**
         * Se tiene respuesta del oráculo
         * @param messageId
         */
        void goResponse(int messageId);
    }

    /**
     * Presenter para preguntar al Oráculo
     */
    public interface MainPresenter{

        /**
         * Se comienza a escribir la pregunta
         */
        void onTiping();

        /**
         * Se manda una pregunta al oráculo
         * @param question
         */
        void oraculoClicked(String question);
    }
}
