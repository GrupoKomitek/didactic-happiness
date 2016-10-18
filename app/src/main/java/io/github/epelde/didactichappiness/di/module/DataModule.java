package io.github.epelde.didactichappiness.di.module;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import io.github.epelde.didactichappiness.data.IOracleRepository;
import io.github.epelde.didactichappiness.data.OracleRepository;

/**
 * Created by Gorka on 18/10/2016.
 */

@Module
public class DataModule {

    @Provides
    @Singleton
    IOracleRepository provideIOracleRepository(){
        return new OracleRepository();
    }
}
