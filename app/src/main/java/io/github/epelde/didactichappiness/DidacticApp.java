package io.github.epelde.didactichappiness;

import android.app.Application;
import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.util.Log;

import io.github.epelde.didactichappiness.di.component.ApplicationComponent;
import io.github.epelde.didactichappiness.di.component.DaggerApplicationComponent;

/**
 * Created by Gorka on 18/10/2016.
 */
public class DidacticApp extends Application {

    private ApplicationComponent mApplicationComponent;

    @Override
    public void onCreate() {
        super.onCreate();
        mApplicationComponent = DaggerApplicationComponent.create();
    }

    ConnectivityManager connMgr = (ConnectivityManager)
            getSystemService(Context.CONNECTIVITY_SERVICE);
    NetworkInfo networkInfo = connMgr.getActiveNetworkInfo();
    boolean isConn = networkInfo.isConnected();

    public ApplicationComponent getApplicationComponent() {
        return mApplicationComponent;
    }
}
