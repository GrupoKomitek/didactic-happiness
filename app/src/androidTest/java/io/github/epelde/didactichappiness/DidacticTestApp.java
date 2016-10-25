package io.github.epelde.didactichappiness;

import android.app.Application;
import android.test.ApplicationTestCase;

import io.github.epelde.didactichappiness.di.component.ApplicationComponent;
import io.github.epelde.didactichappiness.di.component.DaggerApplicationMockComponent;

/**
 *
 */
public class DidacticTestApp extends DidacticApp {

    @Override
    public ApplicationComponent getApplicationComponent(){
        return DaggerApplicationMockComponent.create();
    }
}