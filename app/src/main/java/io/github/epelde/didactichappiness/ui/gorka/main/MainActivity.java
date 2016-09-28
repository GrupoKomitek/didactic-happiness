package io.github.epelde.didactichappiness.ui.gorka.main;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import butterknife.BindString;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import io.github.epelde.didactichappiness.R;

/**
 * Created by epelde on 26/9/16.
 */
public class MainActivity extends AppCompatActivity implements MainContract.MainView{

    @BindView(R.id.oracle_text_consulta)
    public EditText question;
    @BindView(R.id.oracle_image_front)
    public ImageView frontImage;
    @BindView(R.id.oracle_button_consultar)
    public Button goButton;
    @BindView(R.id.oracle_text_welcome)
    TextView welcomeText;
    @BindString(R.string.text_writing_user)
    String writingMessage;

    MainContract.MainPresenter mainPresenter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_gorka);
        ButterKnife.bind(this);
        mainPresenter = new MainPresenter(this);
        init();
    }

    public void init(){
        frontImage.setImageResource(R.drawable.sacred_chao_69);
    }

    @Override
    public void clickOraculo() {
        mainPresenter.oraculoClicked();
    }

    @Override
    public void startTiping() {
        mainPresenter.onTiping();
        welcomeText.setText(writingMessage);
    }

    @OnClick(R.id.oracle_button_consultar)
    public void onConsultaButtonClicked(){

    }
    @OnClick(R.id.oracle_text_consulta)
    public void onConsultaTextClicked(){
        startTiping();
    }
}
