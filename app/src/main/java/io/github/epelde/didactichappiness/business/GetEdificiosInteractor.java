package io.github.epelde.didactichappiness.business;

import com.firebase.client.DataSnapshot;

import rx.Observable;

/**
 * Created by alaria on 26/09/2016.
 */

public interface GetEdificiosInteractor {

    Observable<DataSnapshot> getEdificios();
}
