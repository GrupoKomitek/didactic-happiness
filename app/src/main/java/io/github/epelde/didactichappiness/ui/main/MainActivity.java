package io.github.epelde.didactichappiness.ui.main;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import io.github.epelde.didactichappiness.R;

public class MainActivity extends AppCompatActivity implements MainContract.MainView {

    @BindView(R.id.button_agus)
    Button agusButton;
    @BindView(R.id.button_alberto)
    Button albertoButton;
    @BindView(R.id.button_alex)
    Button alexButton;
    @BindView(R.id.button_arkaitz)
    Button arkaitzButton;
    @BindView(R.id.button_gorka)
    Button gorkaButton;
    MainContract.MainPresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        presenter = new MainPresenter();
        presenter.attachView(this);
    }

    @Override
    protected void onPause() {
        super.onPause();
        if (isFinishing()) {
            presenter.detachView();
        }
    }

    @OnClick({ R.id.button_agus, R.id.button_alberto, R.id.button_alex, R.id.button_arkaitz, R.id.button_gorka })
    public void onClickButton(Button button) {
        switch (button.getId()) {
            case R.id.button_agus:
                presenter.onClickAgusButton();
                break;
            case R.id.button_alberto:
                presenter.onClickAlbertoButton();
                break;
            case R.id.button_alex:
                presenter.onClickAlexButton();
                break;
            case R.id.button_arkaitz:
                presenter.onClickArkaitzButton();
                break;
            case R.id.button_gorka:
                presenter.onClickGorkaButton();
                break;
        }
    }

    @Override
    public void launchAgusActivity() {
        launchActivity(io.github.epelde.didactichappiness.ui.agus.MainActivity.class);
    }

    @Override
    public void launchAlbertoActivity() {
        launchActivity(io.github.epelde.didactichappiness.ui.alberto.MainActivity.class);
    }

    @Override
    public void launchAlexActivity() {
        launchActivity(io.github.epelde.didactichappiness.ui.alex.MainActivity.class);
    }

    @Override
    public void launchArkaitzActivity() {
        launchActivity(io.github.epelde.didactichappiness.ui.arkaitz.MainActivity.class);
    }

    @Override
    public void launchGorkaActivity() {
        launchActivity(io.github.epelde.didactichappiness.ui.gorka.main.MainActivity.class);
    }

    private void launchActivity(Class activity) {
        startActivity(new Intent(this, activity));
    }
}
