package io.github.epelde.didactichappiness.ui;

/**
 * Created by Gorka on 18/10/2016.
 *
 * Generic contract to be extended by all contracts in application
 */
public interface DidacticContract {
    interface DidacticContractView{}
    interface DidacticContractPresenter{
        /**
         * Ends the presenter/view contract
         */
        void detach();
        /**
         * Starts the presenter/view contract
         */
        void attachView(DidacticContractView dcv);
    }
}
