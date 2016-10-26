package co.edu.uniquindio.android.electiva.vozarron.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuItem;

import java.util.ArrayList;

import co.edu.uniquindio.android.electiva.vozarron.R;
import co.edu.uniquindio.android.electiva.vozarron.fragment.DetalleDeEntrenadorFragment;
import co.edu.uniquindio.android.electiva.vozarron.fragment.ListaDeEntrenadoresFragment;
import co.edu.uniquindio.android.electiva.vozarron.util.AdaptadorEntrenador;
import co.edu.uniquindio.android.electiva.vozarron.vo.Entrenador;

public class EntrenadorActivity extends AppCompatActivity  implements ListaDeEntrenadoresFragment.OnEntrenadorSeleccionadoListener{
    private RecyclerView ListadoDeEntrenadores;
    private AdaptadorEntrenador adaptador;
    private ArrayList<Entrenador> entrenadores;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_entrenador);
        entrenadores = new ArrayList();
        entrenadores.add(new Entrenador("Rihanna","Pop","Huerfana" ));
        entrenadores.add(new Entrenador("Adele","Pop-Rock","Gorda" ));
        entrenadores.add(new Entrenador("Jhonny Rivera","Ranchera","Viejito" ));

        /*
        ListadoDeEntrenadores= (RecyclerView)
                findViewById(R.id.listaEntrenadores);
         adaptador = new
                AdaptadorEntrenador(entrenadores,);
        ListadoDeEntrenadores.setAdapter(adaptador);
        ListadoDeEntrenadores.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
        */
        ListaDeEntrenadoresFragment listaDePersonajesFragment = (ListaDeEntrenadoresFragment) getSupportFragmentManager().findFragmentById(R.id.fragmento_lista_entrenadores);
        listaDePersonajesFragment.setEntrenadores(entrenadores);
    }
    @Override
        public boolean onOptionsItemSelected(MenuItem item) {
        return super.onOptionsItemSelected(item);
    }
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu, menu);
        return true;
    }

    @Override
    public void onEntrenadorSeleccionado(int position) {
        boolean esFragmento = getSupportFragmentManager().findFragmentById(R.id.fragmento_detalle_entrenador) != null;
        if (esFragmento) {
            ((DetalleDeEntrenadorFragment) getSupportFragmentManager().findFragmentById(R.id.fragmento_detalle_entrenador)).mostrarPersonaje(entrenadores.get(position));
        } else {
            Intent intent = new Intent(this, DetalleDeEntrenadorActivity.class);
            intent.putExtra("per", entrenadores.get(position));
            startActivity(intent);
        }
    }
}
