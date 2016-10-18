package io.github.epelde.didactichappiness.ui.gorka.response;

import io.github.epelde.didactichappiness.ui.DidacticContract;

/**
 * Created by Gorka on 03/10/2016.
 */
public interface ResponseContract extends DidacticContract {

    public interface ResponseView extends DidacticContract.DidacticContractView{
        void onVolverClicked();
    }
    public interface ResponsePresenter extends DidacticContract.DidacticContractPresenter{
        void goMain();
    }
}
