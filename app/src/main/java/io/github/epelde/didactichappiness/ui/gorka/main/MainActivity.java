package io.github.epelde.didactichappiness.ui.gorka.main;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import butterknife.BindArray;
import butterknife.BindString;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.OnEditorAction;
import butterknife.OnTextChanged;
import io.github.epelde.didactichappiness.DidacticApp;
import io.github.epelde.didactichappiness.R;
import io.github.epelde.didactichappiness.ui.DidacticActivity;
import io.github.epelde.didactichappiness.ui.DidacticPresenter;
import io.github.epelde.didactichappiness.ui.gorka.response.ResponseActivity;

/**
 * Created by epelde on 26/9/16.
 */
public class MainActivity extends DidacticActivity<MainContract.MainPresenter> implements MainContract.MainView{

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
    @BindArray(R.array.text_oracle_responses)
    String[] oracle_responses;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ((DidacticApp) getApplication()).getApplicationComponent().inject(this);
        presenter.attachView(this);
        setContentView(R.layout.activity_main_gorka);
        ButterKnife.bind(this);
        init();
    }

    public static void navigate(AppCompatActivity activity) {
        ActivityCompat.startActivity(activity, new Intent(activity,MainActivity.class), null);
    }

    public void init(){
        frontImage.setImageResource(R.drawable.sacred_chao_69);
    }


    @OnClick(R.id.oracle_button_consultar)
    @Override
    public void clickOraculo() {
        presenter.oraculoClicked(question.getText().toString());
    }

    @Override
    public void startTiping() {
        presenter.onTiping();
    }

    @Override
    public void setWelcomeText(boolean friend) {
        if(!friend)welcomeText.setText(writingMessage);
    }

    @Override
    public void goResponse(int messageId) {
        presenter.detach();
        ResponseActivity.navigate(this,oracle_responses[messageId]);
    }

    @OnTextChanged(R.id.oracle_text_consulta)
    public void onConsultaTextClicked(){
        startTiping();
    }
}
