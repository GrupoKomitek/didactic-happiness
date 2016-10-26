package io.github.epelde.didactichappiness.di.module;

import org.mockito.Mockito;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import io.github.epelde.didactichappiness.business.IOracleProcessorInteractor;
import io.github.epelde.didactichappiness.ui.gorka.main.MainContract;
import io.github.epelde.didactichappiness.ui.gorka.main.MainPresenter;
import io.github.epelde.didactichappiness.ui.gorka.response.ResponseContract;
import io.github.epelde.didactichappiness.ui.gorka.response.ResponsePresenter;

/**
 * Created by Gorka on 18/10/2016.
 */

@Module
public class UiMockModule {

    @Provides
    @Singleton
    public MainContract.MainPresenter provideMainPresenter(IOracleProcessorInteractor opi){
        MainPresenter mp = Mockito.mock(MainPresenter.class);
        mp.setOpi(opi);
        return mp;
    }
    @Provides
    @Singleton
    public ResponseContract.ResponsePresenter provideResponsePresenter(){
        return Mockito.mock(ResponsePresenter.class);
    }
}
