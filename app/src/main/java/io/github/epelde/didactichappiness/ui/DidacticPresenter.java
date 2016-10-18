package io.github.epelde.didactichappiness.ui;


/**
 * Created by Gorka on 27/09/2016.
 *
 * Base Presenter
 */
public abstract class DidacticPresenter<T extends DidacticContract.DidacticContractView>  implements DidacticContract.DidacticContractPresenter{

    public T view;


    public DidacticPresenter(){}

    /**
     * Detaches the related view
     */
    @Override
    public void detach() {
        this.view=null;
    }
}
