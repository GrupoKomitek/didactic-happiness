package io.github.epelde.didactichappiness;

import android.app.Application;

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

    public ApplicationComponent getApplicationComponent() {
        return mApplicationComponent;
    }
}
