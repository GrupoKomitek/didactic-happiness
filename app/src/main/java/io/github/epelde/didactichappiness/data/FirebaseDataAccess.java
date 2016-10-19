package io.github.epelde.didactichappiness.data;

import android.util.Log;

import com.firebase.client.DataSnapshot;
import com.firebase.client.Firebase;
import com.firebase.client.FirebaseError;
import com.firebase.client.ValueEventListener;

import io.github.epelde.didactichappiness.ui.alberto.constants.Constants;
import rx.Observable;
import rx.Subscriber;


/**
 * Created by alaria on 27/09/2016.
 */

public class FirebaseDataAccess implements FirebaseAccess {

    private static final String LOG_TAG = FirebaseDataAccess.class.getSimpleName();
    private Firebase myFirebaseRef;


    public Observable<DataSnapshot> getFirebaseDataSnapshot () {

        //Log.d(LOG_TAG, "URL: " + Constants.ConfigFireBase.FIREBASE_URL + Constants.ConfigFireBase.FIREBASE_CHILD_EDIFICIOS);
        myFirebaseRef = new Firebase(Constants.ConfigFireBase.FIREBASE_URL + Constants.ConfigFireBase.FIREBASE_CHILD_EDIFICIOS);

        return Observable.create(new Observable.OnSubscribe<DataSnapshot>() {
            @Override
            public void call(final Subscriber subscriber) {
                myFirebaseRef.addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(DataSnapshot dataSnapshot) {
                        Log.d(LOG_TAG, "onDataChange");
                        subscriber.onNext(dataSnapshot);
                    }

                    @Override
                    public void onCancelled(FirebaseError error) {
                        Log.d(LOG_TAG, "onCancelled ERROR: " + error.getMessage());

                        Throwable fireBaseError = new Throwable(error.getMessage());
                        subscriber.onError(fireBaseError);
                    }
                });
            }
        });
    }
}
