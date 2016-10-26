package io.github.epelde.didactichappiness.ui.alberto;

import android.databinding.ObservableArrayList;
import android.databinding.ObservableField;
import android.util.Log;

import com.firebase.client.DataSnapshot;

import io.github.epelde.didactichappiness.business.GetEdificiosInteractorImpl;
import io.github.epelde.didactichappiness.data.entities.Edificio;
import rx.Subscriber;
import rx.Subscription;

/**
 * Created by alaria on 22/09/2016.
 */

public class EdificioPresenter implements EdificioContract.EdificioPresenter {

    private static final String LOG_TAG = EdificioPresenter.class.getSimpleName();
    private EdificioContract.EdificioView edificioView;
    private GetEdificiosInteractorImpl getEdificiosInteractor;
    private Subscription subscription;
    private ObservableArrayList<Edificio> listaEdificios;
    private ObservableField<String> mensajeError;

    public EdificioPresenter(GetEdificiosInteractorImpl getEdificiosInteractor) {

        //getEdificiosInteractor = new GetEdificiosInteractorImpl();
        this.getEdificiosInteractor = getEdificiosInteractor;
        listaEdificios = new ObservableArrayList();
        mensajeError = new ObservableField();
    }

    @Override
    public void attachEdificioView(EdificioContract.EdificioView edificioView) {
        this.edificioView = edificioView;
    }

    @Override
    public void detachEdificioView() {
            this.edificioView = null;
    }

    @Override
    public void unsuscribeEdificioSuspciption() {
        if (!subscription.isUnsubscribed()) {
            subscription.unsubscribe();
        }
    }

    @Override
    public void initPresenter() {
        Log.d(LOG_TAG, "setSpinner true");
        setSpinner(true);

        Log.d(LOG_TAG, "Recuperar Edificios");
        subscription = getEdificiosInteractor.getEdificios().subscribe(subscriber);
    }

    private void setSpinner(boolean loadingSpinner) {
        if (edificioView != null) {
            this.edificioView.setSpinner(loadingSpinner);
        }
    }

    private Subscriber subscriber = new Subscriber<DataSnapshot>() {
        @Override
        public void onNext(DataSnapshot snapshot) {
            Log.d(LOG_TAG, "onNext");
            listaEdificios.clear();
            for (DataSnapshot dataSnapshot : snapshot.getChildren()) {
                //Log.d(LOG_TAG, "RECUPERANDO EDIFICIOS");
                listaEdificios.add(dataSnapshot.getValue(Edificio.class));
            }

            edificioView.printEdificios(listaEdificios);
            Log.d(LOG_TAG, "setSpinner false");
            setSpinner(false);
        }

        @Override
        public void onCompleted() {
            Log.d(LOG_TAG, "onCompleted");
        }

        @Override
        public void onError(Throwable e) {
            Log.d(LOG_TAG, "onError");
            setSpinner(false);
            mensajeError.set(e.getMessage());
            edificioView.mostrarErrorRecuperarEdificios(mensajeError);
            edificioView.onBackPressed();
        }
    };
}
