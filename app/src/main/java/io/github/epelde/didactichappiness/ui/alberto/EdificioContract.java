package io.github.epelde.didactichappiness.ui.alberto;

import android.databinding.ObservableArrayList;
import android.databinding.ObservableField;

import io.github.epelde.didactichappiness.data.entities.Edificio;

/**
 * Created by alaria on 22/09/2016.
 */

public interface EdificioContract {

    interface EdificioView {

        void setSpinner(boolean loadingSpinner);

        void onBackPressed();

        void printEdificios(ObservableArrayList<Edificio> listaEdificios);

        void mostrarErrorRecuperarEdificios(ObservableField<String> mensajeError);

    }

    interface EdificioPresenter {

        void attachEdificioView(EdificioContract.EdificioView view);

        void detachEdificioView();

        void unsuscribeEdificioSuspciption();

        void initPresenter();
    }
}
