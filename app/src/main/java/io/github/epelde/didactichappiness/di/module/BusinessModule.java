package io.github.epelde.didactichappiness.di.module;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import io.github.epelde.didactichappiness.business.GetEdificiosInteractorImpl;
import io.github.epelde.didactichappiness.business.IOracleProcessorInteractor;
import io.github.epelde.didactichappiness.business.OracleProcessorInteractor;
import io.github.epelde.didactichappiness.data.FirebaseAccess;

/**
 * Created by Gorka on 18/10/2016.
 */

@Module
public class BusinessModule {

    @Provides
    @Singleton
    IOracleProcessorInteractor provideIOracleProcessorInteractor(){
        return new OracleProcessorInteractor();
    }

    @Singleton
    @Provides
    public GetEdificiosInteractorImpl provideGetEdificiosInteractorImpl(FirebaseAccess firebaseAccess) {
        return new GetEdificiosInteractorImpl(firebaseAccess);
    }
}
