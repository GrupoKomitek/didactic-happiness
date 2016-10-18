package io.github.epelde.didactichappiness.ui;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import javax.inject.Inject;

import butterknife.ButterKnife;
import io.github.epelde.didactichappiness.DidacticApp;
import io.github.epelde.didactichappiness.R;
import io.github.epelde.didactichappiness.di.component.ApplicationComponent;
import io.github.epelde.didactichappiness.ui.main.MainPresenter;

/**
 * Created by Gorka on 18/10/2016.
 */
public class DidacticActivity<T extends DidacticContract.DidacticContractPresenter> extends AppCompatActivity {

    @Inject
    public T presenter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }


}
