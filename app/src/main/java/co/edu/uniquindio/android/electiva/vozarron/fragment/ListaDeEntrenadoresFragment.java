package co.edu.uniquindio.android.electiva.vozarron.fragment;


import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

import co.edu.uniquindio.android.electiva.vozarron.R;
import co.edu.uniquindio.android.electiva.vozarron.util.AdaptadorEntrenador;
import co.edu.uniquindio.android.electiva.vozarron.vo.Entrenador;

/**
 * A simple {@link Fragment} subclass.
 */
public class ListaDeEntrenadoresFragment extends Fragment implements AdaptadorEntrenador.OnClickAdaptadorDeEntrenador{
    private RecyclerView ListadoDeEntrenadores;
    private AdaptadorEntrenador adaptador;

    public void setEntrenadores(ArrayList<Entrenador> entrenadores) {
        this.entrenadores = entrenadores;
    }

    private ArrayList<Entrenador> entrenadores;
    private OnEntrenadorSeleccionadoListener listener;

    public ListaDeEntrenadoresFragment() {
        // Required empty public constructor
    }

    @Override
    public void onClickPosition(int pos) {
        listener.onEntrenadorSeleccionado(pos);
    }

    public interface OnEntrenadorSeleccionadoListener {
        void onEntrenadorSeleccionado(int position);
    }
    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        Activity activity;
        if (context instanceof Activity){
            activity = (Activity) context;
            try {
                listener = (OnEntrenadorSeleccionadoListener) activity;
            } catch (ClassCastException e) {
                throw new ClassCastException(activity.toString() + " debe implementar la interfaz OnPersonajeSeleccionadoListener");
            }
        }
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setHasOptionsMenu(true);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_lista_de_entrenadores, container, false);
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        ListadoDeEntrenadores = (RecyclerView)getView().findViewById(R.id.listaEntrenadores);
        adaptador = new AdaptadorEntrenador(entrenadores,this);
        ListadoDeEntrenadores.setAdapter(adaptador);
        ListadoDeEntrenadores.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false));
    }
    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        super.onCreateOptionsMenu(menu, inflater);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.menu_agregar) {
            entrenadores.add(0, new Entrenador("Nuevo personaje","Regayton","Caca"));
            adaptador.notifyItemInserted(0);
        }
        if (id == R.id.menu_eliminar) {
            entrenadores.remove(0);
            adaptador.notifyItemRemoved(0);
        }
        if (id == R.id.menu_modificar) {
            Entrenador aux = entrenadores.get(1);
            entrenadores.set(1,entrenadores.get(2));
            entrenadores.set(2, aux);
            adaptador.notifyItemMoved(1, 2);
        }
        return super.onOptionsItemSelected(item);
    }
}
