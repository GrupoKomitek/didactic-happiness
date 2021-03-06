package io.github.epelde.didactichappiness.ui.alberto.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import io.github.epelde.didactichappiness.R;
import io.github.epelde.didactichappiness.data.entities.Edificio;

/**
 * Created by alaria on 25/04/2016.
 */
public class EdificioAdapter extends RecyclerView.Adapter<EdificioAdapter.Holder>{

    private static final String TAG = EdificioAdapter.class.getSimpleName();
    private EdificioClickListener edificioClickListener;
    private List<Edificio> mEdificios;

    @Inject
    public EdificioAdapter() {
        mEdificios = new ArrayList<>();
        //edificioClickListener = listener;
    }

    @Override
    public Holder onCreateViewHolder(ViewGroup parent, int viewType) {
        View row = LayoutInflater.from(parent.getContext()).inflate(R.layout.activity_main_alberto_card, parent, false);
        return new Holder(row);
    }

    @Override
    public void onBindViewHolder(Holder holder, int position) {

        Edificio currEdificio = mEdificios.get(position);

        holder.mEdificioName.setText(currEdificio.getNombre_lugar_cas());
    }

    @Override
    public int getItemCount() {
        return mEdificios.size();
    }

    public void addEdificios(List<Edificio> listaEdificio) {
        mEdificios.clear();
        mEdificios.addAll(listaEdificio);
        notifyDataSetChanged();
    }

    public Edificio getSelectedEdificio(int position) {
        return mEdificios.get(position);
    }

    public EdificioClickListener getEdificioClickListener() {
        return edificioClickListener;
    }

    public void setEdificioClickListener(EdificioClickListener edificioClickListener) {
        this.edificioClickListener = edificioClickListener;
    }

    public class Holder extends RecyclerView.ViewHolder implements View.OnClickListener {

        private TextView mEdificioName;

        public Holder(View itemView) {
            super(itemView);
            mEdificioName = (TextView) itemView.findViewById(R.id.card_edificio_nombre);
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            edificioClickListener.onClick(getLayoutPosition());
        }
    }

    public interface EdificioClickListener {
        void onClick(int position);
    }
}
