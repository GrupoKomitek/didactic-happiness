package io.github.epelde.didactichappiness.ui.gorka.response;

/**
 * Created by Gorka on 03/10/2016.
 */
public interface ResponseContract {

    public interface ResponseView{
        void onVolverClicked();
    }
    public interface ResponsePresenter{
        void goMain();
    }
}
