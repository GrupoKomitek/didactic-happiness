package io.github.epelde.didactichappiness.di.module;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import io.github.epelde.didactichappiness.business.IOracleProcessorInteractor;
import io.github.epelde.didactichappiness.data.IOracleRepository;
import io.github.epelde.didactichappiness.data.OracleRepository;
import io.github.epelde.didactichappiness.ui.gorka.main.MainActivity;
import io.github.epelde.didactichappiness.ui.gorka.main.MainContract;
import io.github.epelde.didactichappiness.ui.gorka.main.MainPresenter;

/**
 * Created by Gorka on 18/10/2016.
 */

@Module
public class UiModule {

    @Provides
    @Singleton
    public MainContract.MainPresenter provideMainPresenter(IOracleProcessorInteractor opi){
        MainPresenter mp = new MainPresenter();
        mp.setOpi(opi);
        return mp;
    }
}
