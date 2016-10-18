package io.github.epelde.didactichappiness.ui.gorka.main;

import io.github.epelde.didactichappiness.business.IOracleProcessorInteractor;
import io.github.epelde.didactichappiness.business.OracleProcessorInteractor;
import io.github.epelde.didactichappiness.ui.DidacticContract;
import io.github.epelde.didactichappiness.ui.DidacticPresenter;

/**
 * Created by Gorka on 27/09/2016.
 */
public class MainPresenter extends DidacticPresenter<MainContract.MainView> implements MainContract.MainPresenter {

    private IOracleProcessorInteractor opi;

    public MainPresenter(){}

    @Override
    public void onTiping() {
    }

    @Override
    public void oraculoClicked(String question) {

        view.goResponse(getOpi().processQuestion(question));
    }

    @Override
    public void attachView(DidacticContract.DidacticContractView dcv) {
        this.view = (MainContract.MainView)dcv;
    }

    public IOracleProcessorInteractor getOpi() {
        return opi;
    }

    public void setOpi(IOracleProcessorInteractor opi) {
        this.opi = opi;
    }
}
