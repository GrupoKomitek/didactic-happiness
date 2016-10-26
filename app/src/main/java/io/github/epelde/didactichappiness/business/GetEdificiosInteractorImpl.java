package io.github.epelde.didactichappiness.business;

import com.firebase.client.DataSnapshot;

import java.util.ArrayList;
import java.util.List;

import io.github.epelde.didactichappiness.data.FirebaseAccess;
import io.github.epelde.didactichappiness.data.entities.Edificio;
import rx.Observable;


/**
 * Created by alaria on 26/09/2016.
 */

public class GetEdificiosInteractorImpl implements GetEdificiosInteractor {

    private static final String LOG_TAG = GetEdificiosInteractorImpl.class.getSimpleName();
    private FirebaseAccess firebaseAccess;
    private String mensajeErrorFirebase;

    private List<Edificio> listaEdificios;

    public GetEdificiosInteractorImpl(FirebaseAccess firebaseAccess) {

        //this.firebaseAccess = new FirebaseDataAccess();
        this.firebaseAccess = firebaseAccess;
        listaEdificios = new ArrayList();
    }


    public Observable<DataSnapshot> getEdificios() {

    return firebaseAccess.getFirebaseDataSnapshot();
    }
}

