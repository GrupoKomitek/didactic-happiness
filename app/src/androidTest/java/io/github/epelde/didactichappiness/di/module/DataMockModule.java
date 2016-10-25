package io.github.epelde.didactichappiness.di.module;


import org.mockito.Mockito;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import io.github.epelde.didactichappiness.data.IOracleRepository;
import io.github.epelde.didactichappiness.data.OracleRepository;

/**
 * Created by Gorka on 18/10/2016.
 */

@Module
public class DataMockModule {

    @Provides
    @Singleton
    IOracleRepository provideIOracleRepository(){
        return Mockito.mock(OracleRepository.class);
    }
}
