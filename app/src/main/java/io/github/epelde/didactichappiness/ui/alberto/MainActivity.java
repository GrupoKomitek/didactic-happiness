package io.github.epelde.didactichappiness.ui.alberto;

import android.content.res.Configuration;
import android.databinding.ObservableArrayList;
import android.databinding.ObservableField;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.firebase.client.Firebase;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import io.github.epelde.didactichappiness.DidacticApp;
import io.github.epelde.didactichappiness.R;
import io.github.epelde.didactichappiness.data.entities.Edificio;
import io.github.epelde.didactichappiness.ui.alberto.adapter.EdificioAdapter;

/**
 * Created by epelde on 26/9/16.
 */
public class MainActivity  extends AppCompatActivity implements EdificioContract.EdificioView,
        EdificioAdapter.EdificioClickListener{

    private static final String LOG_TAG = MainActivity.class.getSimpleName();
    //private EdificioContract.EdificioPresenter edificioPresenter;

    @Inject
    EdificioContract.EdificioPresenter edificioPresenter;
    @Inject
    EdificioAdapter edificioAdapter;
    @Inject
    RecyclerView.RecycledViewPool recycledViewPool;

    @BindView(R.id.alberto_main_loading_text)
    TextView loadingText;
    @BindView(R.id.alberto_main_progress_bar)
    ProgressBar spinner;
    @BindView(R.id.alberto_main_recycler_view)
    RecyclerView mRecyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_alberto);

        ((DidacticApp) getApplication()).getApplicationComponent().inject(this);

        ButterKnife.bind(this);
        Firebase.setAndroidContext(this);

        Log.d(LOG_TAG, "initRecyclerViewEdificios");
        initRecyclerViewEdificios();

        Log.d(LOG_TAG, "initPresenter");
        initPresenter();
    }

    @Override
    protected void onPause() {
        super.onPause();
        if (isFinishing()) {
            //Liberamos la vista
            edificioPresenter.detachEdificioView();

            //Eliminamos la suscripción
            edificioPresenter.unsuscribeEdificioSuspciption();
        }
    }

    @Override
    public void setSpinner(boolean loadingSpinner) {
        spinner.setVisibility(loadingSpinner? View.VISIBLE : View.GONE);
        loadingText.setVisibility(loadingSpinner? View.VISIBLE : View.GONE);
    }

    @Override
    public void printEdificios(ObservableArrayList<Edificio> mEdificios) {
        Log.d(LOG_TAG, "PINTANDO EDIFICIOS (printEdificios): "+mEdificios.size()+" ELEMENTOS");
        ((EdificioAdapter) mRecyclerView.getAdapter()).addEdificios(mEdificios);
    }

    @Override
    public void mostrarErrorRecuperarEdificios(ObservableField<String> mensajeError) {
        Log.d(LOG_TAG, "ERROR AL RECUPERAR LAS EDIFICIOS (mostrarErrorRecuperarEdificios)");
        Toast.makeText(this, "Se ha producido un error al intentar recuperar los datos: " + mensajeError.get(), Toast.LENGTH_LONG).show();
    }

    private void initRecyclerViewEdificios() {
        mRecyclerView.setHasFixedSize(true);
        if (getScreenOrientation().equals("Landscrape")) {
            mRecyclerView.setLayoutManager(new GridLayoutManager(getApplicationContext(),2));
        }else{
            mRecyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext(), LinearLayoutManager.VERTICAL, false));
        }
        mRecyclerView.setRecycledViewPool(recycledViewPool);

        edificioAdapter.setEdificioClickListener(this);
        mRecyclerView.setAdapter(edificioAdapter);
    }

    private void initPresenter() {
        //edificioPresenter = new EdificioPresenter();
        edificioPresenter.attachEdificioView(this);
        edificioPresenter.initPresenter();
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();

        finish();
    }

/*    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);

        if (newConfig.orientation == Configuration.ORIENTATION_LANDSCAPE) {
            Toast.makeText(this, "landscape", Toast.LENGTH_LONG).show();

        } else if (newConfig.orientation == Configuration.ORIENTATION_PORTRAIT){
            Toast.makeText(this, "portrait", Toast.LENGTH_SHORT).show();
        }
    }*/

    private String getScreenOrientation() {
        int orientation = getResources().getConfiguration().orientation;
        String screenOrientation = "";
        switch (orientation) {
            case Configuration.ORIENTATION_UNDEFINED: screenOrientation = "Undefined"; break;
            case Configuration.ORIENTATION_LANDSCAPE: screenOrientation = "Landscrape"; break;
            case Configuration.ORIENTATION_PORTRAIT:  screenOrientation = "Portrait"; break;
        }
        //Toast.makeText(this, screenOrientation, Toast.LENGTH_LONG).show();
        return screenOrientation;
    }

    @Override
    public void onClick(int position) {
        //Edificio selectedEdificio = edificioAdapter.getSelectedEdificio(position);
        //Intent intent = new Intent(MainActivity.this, DetailMainActivity.class);
        //intent.putExtra(Constants.REFERENCE.EDIFICIO, selectedEdificio);
        //startActivity(intent);
    }
}
