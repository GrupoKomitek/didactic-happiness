package io.github.epelde.didactichappiness.ui.gorka.response;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.ActivityOptionsCompat;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import io.github.epelde.didactichappiness.DidacticApp;
import io.github.epelde.didactichappiness.R;
import io.github.epelde.didactichappiness.ui.DidacticActivity;
import io.github.epelde.didactichappiness.ui.gorka.main.MainActivity;
import io.github.epelde.didactichappiness.ui.gorka.main.MainContract;
import io.github.epelde.didactichappiness.ui.gorka.main.MainPresenter;

/**
 * Created by Gorka on 27/09/2016.
 */
public class ResponseActivity extends DidacticActivity<ResponseContract.ResponsePresenter> implements ResponseContract.ResponseView{


    static final String ORACLE_MESSAGE_EXTRA_TAG = "ORACLE_MESSAGE_EXTRA_TAG";
    @BindView(R.id.oracle_text_response)
    TextView responseText;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_response_gorka);
        ButterKnife.bind(this);
        ((DidacticApp) getApplication()).getApplicationComponent().inject(this);
        presenter.attachView(this);
        init(getIntent().getStringExtra(ResponseActivity.ORACLE_MESSAGE_EXTRA_TAG));
    }

    public static void navigate(AppCompatActivity activity,String oracleMessage) {
        Intent intent = new Intent(activity, ResponseActivity.class);
        intent.putExtra(ORACLE_MESSAGE_EXTRA_TAG, oracleMessage);
        ActivityCompat.startActivity(activity, intent, null);
    }

    public void init(String oracleMessage){
        responseText.setText(oracleMessage);
    }


    @OnClick(R.id.oracle_button_back)
    @Override
    public void onVolverClicked() {
        presenter.goMain();
        MainActivity.navigate(this);
    }
}
