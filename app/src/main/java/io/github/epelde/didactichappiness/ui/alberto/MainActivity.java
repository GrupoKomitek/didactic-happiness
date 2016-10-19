package io.github.epelde.didactichappiness.ui.alberto;

import android.databinding.ObservableArrayList;
import android.databinding.ObservableField;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.firebase.client.Firebase;

import butterknife.BindView;
import butterknife.ButterKnife;
import io.github.epelde.didactichappiness.R;
import io.github.epelde.didactichappiness.data.entities.Edificio;
import io.github.epelde.didactichappiness.ui.alberto.adapter.EdificioAdapter;

/**
 * Created by epelde on 26/9/16.
 */
public class MainActivity  extends AppCompatActivity implements EdificioContract.EdificioView,
        EdificioAdapter.EdificioClickListener{

    private static final String LOG_TAG = MainActivity.class.getSimpleName();
    private EdificioAdapter mEdificioAdapter;
    private EdificioContract.EdificioPresenter edificioPresenter;

    @BindView(R.id.alberto_main_progress_bar)
    ProgressBar spinner;
    //@BindView(R.id.alberto_main_toolbar) Toolbar toolbar;
    //@BindView(R.id.cofradia_drawer_layout) DrawerLayout drawer;
    //@BindView(R.id.cofradia_navigation_view) NavigationView navigationView;
    @BindView(R.id.alberto_main_recycler_view)
    RecyclerView mRecyclerView;
    @BindView(R.id.home_top_imagen)
    ImageView mTopImagen;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_alberto);
        ButterKnife.bind(this);
        Firebase.setAndroidContext(this);

        //setSupportActionBar(toolbar);

        //ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        //drawer.addDrawerListener(toggle);
        //toggle.syncState();

        //navigationView.setItemIconTintList(null);
        //navigationView.setNavigationItemSelectedListener(this);

        Log.d(LOG_TAG, "initRecyclerViewCofradias");
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
    }

    @Override
    public void printEdificios(ObservableArrayList<Edificio> mEdificios) {
        Log.d(LOG_TAG, "PINTANDO EDIFICIOS (printCofradias): "+mEdificios.size()+" ELEMENTOS");
        ((EdificioAdapter) mRecyclerView.getAdapter()).addEdificios(mEdificios);
    }

    @Override
    public void mostrarErrorRecuperarEdificios(ObservableField<String> mensajeError) {
        Log.d(LOG_TAG, "ERROR AL RECUPERAR LAS EDIFICIOS (mostrarErrorRecuperarEdificios)");
        Toast.makeText(this, "Se ha producido un error al intentar recuperar los datos: " + mensajeError.get(), Toast.LENGTH_LONG).show();
    }

    private void initRecyclerViewEdificios() {
        mRecyclerView.setHasFixedSize(true);
        mRecyclerView.setRecycledViewPool(new RecyclerView.RecycledViewPool());
        mRecyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext(), LinearLayoutManager.VERTICAL, false));

        mEdificioAdapter = new EdificioAdapter(this);
        mRecyclerView.setAdapter(mEdificioAdapter);
    }

    private void initPresenter() {
        edificioPresenter = new EdificioPresenter();
        edificioPresenter.attachEdificioView(this);
        edificioPresenter.initPresenter();
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();

        finish();
    }


    @Override
    public void onClick(int position) {
        //Edificio selectedEdificio = mEdificioAdapter.getSelectedEdificio(position);
        //Intent intent = new Intent(MainActivity.this, DetailMainActivity.class);
        //intent.putExtra(Constants.REFERENCE.EDIFICIO, selectedEdificio);
        //startActivity(intent);
    }
}
