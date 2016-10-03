package io.github.epelde.didactichappiness.ui.gorka.main;

import io.github.epelde.didactichappiness.business.OracleProcessorInteractor;
import io.github.epelde.didactichappiness.data.IOracleRepository;
import io.github.epelde.didactichappiness.data.OracleRepository;
import io.github.epelde.didactichappiness.ui.BasePresenter;

/**
 * Created by Gorka on 27/09/2016.
 */
public class MainPresenter extends BasePresenter<MainContract.MainView> implements MainContract.MainPresenter {

    public OracleProcessorInteractor opi;

    public MainPresenter(MainContract.MainView view){
        super(view);
        opi = new OracleProcessorInteractor(view.giveResponsesSet());
    }

    @Override
    public void onTiping() {

    }

    @Override
    public void oraculoClicked(String question) {

        view.goResponse(opi.processQuestion(question));
    }
}
