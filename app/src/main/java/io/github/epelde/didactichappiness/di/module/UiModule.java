package io.github.epelde.didactichappiness.di.module;

import android.support.v7.widget.RecyclerView;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import io.github.epelde.didactichappiness.business.GetEdificiosInteractorImpl;
import io.github.epelde.didactichappiness.business.IOracleProcessorInteractor;
import io.github.epelde.didactichappiness.ui.alberto.EdificioContract;
import io.github.epelde.didactichappiness.ui.alberto.EdificioPresenter;
import io.github.epelde.didactichappiness.ui.alberto.adapter.EdificioAdapter;
import io.github.epelde.didactichappiness.ui.gorka.main.MainContract;
import io.github.epelde.didactichappiness.ui.gorka.main.MainPresenter;
import io.github.epelde.didactichappiness.ui.gorka.response.ResponseContract;
import io.github.epelde.didactichappiness.ui.gorka.response.ResponsePresenter;

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
    @Provides
    @Singleton
    public ResponseContract.ResponsePresenter provideResponsePresenter(){
        ResponsePresenter rp = new ResponsePresenter();
        return rp;
    }

    @Provides
    @Singleton
    public EdificioAdapter provideEdificioAdapter() {
        return new EdificioAdapter();
    }

    @Singleton
    @Provides
    public RecyclerView.RecycledViewPool provideRecycledViewPool() {
        return new RecyclerView.RecycledViewPool();
    }

    @Provides
    @Singleton
    public EdificioContract.EdificioPresenter provideEdificiosPresenter(GetEdificiosInteractorImpl getEdificiosInteractor) {
        return new EdificioPresenter(getEdificiosInteractor);
    }
}
