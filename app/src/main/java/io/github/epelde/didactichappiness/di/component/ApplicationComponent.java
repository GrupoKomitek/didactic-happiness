package io.github.epelde.didactichappiness.di.component;

import javax.inject.Singleton;

import dagger.Component;
import io.github.epelde.didactichappiness.di.module.BusinessModule;
import io.github.epelde.didactichappiness.di.module.DataModule;
import io.github.epelde.didactichappiness.di.module.UiModule;
import io.github.epelde.didactichappiness.ui.DidacticActivity;
import io.github.epelde.didactichappiness.ui.DidacticContract;
import io.github.epelde.didactichappiness.ui.gorka.main.MainActivity;

/**
 * Created by Gorka on 18/10/2016.
 */
@Singleton
@Component(modules={DataModule.class, BusinessModule.class, UiModule.class})
public interface ApplicationComponent {
    void inject(MainActivity activity);
}
