package io.github.epelde.didactichappiness.di.component;

import javax.inject.Singleton;

import dagger.Component;
import io.github.epelde.didactichappiness.di.module.BusinessMockModule;
import io.github.epelde.didactichappiness.di.module.DataMockModule;
import io.github.epelde.didactichappiness.di.module.UiMockModule;
import io.github.epelde.didactichappiness.ui.gorka.main.MainActivityTester;

/**
 * Created by Gorka on 24/10/2016.
 */
@Singleton
@Component(modules={DataMockModule.class, BusinessMockModule.class, UiMockModule.class})
public interface ApplicationMockComponent extends ApplicationComponent {
    void inject(MainActivityTester activity);
}
