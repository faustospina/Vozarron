package co.edu.uniquindio.android.electiva.vozarron.util;

import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

import co.edu.uniquindio.android.electiva.vozarron.R;
import co.edu.uniquindio.android.electiva.vozarron.fragment.ListaDeEntrenadoresFragment;
import co.edu.uniquindio.android.electiva.vozarron.vo.Entrenador;

/**
 * Created by Manuel on 25/10/2016.
 */

public class AdaptadorEntrenador extends RecyclerView.Adapter<AdaptadorEntrenador.EntrenadorViewHolder> {
    private ArrayList<Entrenador> entrenadores;
    private static OnClickAdaptadorDeEntrenador listener;

    public AdaptadorEntrenador(ArrayList<Entrenador> entrenadores, ListaDeEntrenadoresFragment listaDePersonajesFragment) {
        this.entrenadores = entrenadores;
        listener = (OnClickAdaptadorDeEntrenador)
                listaDePersonajesFragment;
    }

    public interface OnClickAdaptadorDeEntrenador{
        public void onClickPosition(int pos);
    }

    @Override
    public EntrenadorViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.resumen_entrenadores, parent, false);
        EntrenadorViewHolder peliculaVH = new
                EntrenadorViewHolder(itemView);
        return peliculaVH;
    }

    @Override
    public void onBindViewHolder(EntrenadorViewHolder holder, int position) {
        Entrenador personaje =entrenadores.get(position);
        holder.binEntrenador(personaje);
    }

    @Override
    public int getItemCount() {
        return entrenadores.size();
    }

    public static class EntrenadorViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        private TextView txtNombreEntrenador;
        private TextView txtgenero;
        private TextView txthistoria;
        private TextView txtcolor;
        private TextView txtimagen;

        public EntrenadorViewHolder(View itemView) {
            super(itemView);
            itemView.setOnClickListener(this);
            txtNombreEntrenador = (TextView)
                    itemView.findViewById(R.id.nombre);
            txtgenero = (TextView)
                    itemView.findViewById(R.id.genero);
            txthistoria = (TextView)
                    itemView.findViewById(R.id.historia);

        }
        public void binEntrenador(Entrenador entrenador) {
            txtNombreEntrenador.setText(entrenador.getNombre());
            txtgenero.setText(entrenador.getGenero());
            txthistoria.setText(entrenador.getHistoria());

        }

        @Override
        public void onClick(View v) {
            listener.onClickPosition(getAdapterPosition());
        }
    }
}
