package io.github.epelde.didactichappiness.ui.gorka.response;

import io.github.epelde.didactichappiness.ui.DidacticContract;
import io.github.epelde.didactichappiness.ui.DidacticPresenter;

/**
 * Created by Gorka on 03/10/2016.
 */
public class ResponsePresenter extends DidacticPresenter<ResponseContract.ResponseView> implements ResponseContract.ResponsePresenter {

    public ResponsePresenter(){};

    @Override
    public void goMain() {
    detach();
    }

    @Override
    public void attachView(DidacticContract.DidacticContractView dcv) {
        this.view = (ResponseContract.ResponseView)dcv;
    }
}
