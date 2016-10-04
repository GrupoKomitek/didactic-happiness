package io.github.epelde.didactichappiness.ui.gorka.response;

import io.github.epelde.didactichappiness.ui.BasePresenter;

/**
 * Created by Gorka on 03/10/2016.
 */
public class ResponsePresenter extends BasePresenter<ResponseContract.ResponseView> implements ResponseContract.ResponsePresenter {

    public ResponsePresenter(ResponseContract.ResponseView view) {
        super(view);
    }

    @Override
    public void goMain() {
    detach();
    }

    @Override
    public void detach() {
        this.detachView();
    }
}
