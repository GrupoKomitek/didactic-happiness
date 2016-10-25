package io.github.epelde.didactichappiness.di.module;

import org.mockito.Mockito;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import io.github.epelde.didactichappiness.business.IOracleProcessorInteractor;
import io.github.epelde.didactichappiness.business.OracleProcessorInteractor;
import io.github.epelde.didactichappiness.data.IOracleRepository;

/**
 * Created by Gorka on 18/10/2016.
 */

@Module
public class BusinessMockModule{

    @Provides
    @Singleton
    IOracleProcessorInteractor provideIOracleProcessorInteractor(IOracleRepository iOracleRepository){
        OracleProcessorInteractor iopi = Mockito.mock(OracleProcessorInteractor.class);
        iopi.setOracleRepo(iOracleRepository);
        return iopi;
    }
}
