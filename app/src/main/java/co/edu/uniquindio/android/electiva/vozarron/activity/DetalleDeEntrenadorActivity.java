package co.edu.uniquindio.android.electiva.vozarron.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import co.edu.uniquindio.android.electiva.vozarron.R;
import co.edu.uniquindio.android.electiva.vozarron.fragment.DetalleDeEntrenadorFragment;
import co.edu.uniquindio.android.electiva.vozarron.vo.Entrenador;

public class DetalleDeEntrenadorActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalle_de_entrenador);
        DetalleDeEntrenadorFragment detallePersonaje = (DetalleDeEntrenadorFragment) getSupportFragmentManager().findFragmentById(R.id.fragmento_detalle_entrenador);
        Entrenador entrenador = (Entrenador) getIntent().getExtras().get("per");
        detallePersonaje.mostrarPersonaje(entrenador);
    }
}
