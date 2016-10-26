package co.edu.uniquindio.android.electiva.vozarron.fragment;


import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import co.edu.uniquindio.android.electiva.vozarron.R;
import co.edu.uniquindio.android.electiva.vozarron.vo.Entrenador;

/**
 * A simple {@link Fragment} subclass.
 */
public class DetalleDeEntrenadorFragment extends Fragment implements View.OnClickListener{

    private Entrenador entrenador;
    private TextView txtNombre;
    private Button btnIrVideo;
    public DetalleDeEntrenadorFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_detalle_de_entrenador, container, false);
    }

    public void mostrarPersonaje (Entrenador entrenador) {
        this.entrenador = entrenador;
        txtNombre = (TextView)
                getView().findViewById(R.id.titulo_de_detalle_personaje);
        txtNombre.setText(entrenador.getNombre());
        btnIrVideo = (Button)
                getView().findViewById(R.id.btn_ir_a_trailes);
        btnIrVideo.setOnClickListener(this);
    }
    @Override
    public void onClick(View v) {
        Intent intent = new Intent(Intent.ACTION_VIEW,
                Uri.parse(entrenador.getUrl()));
        startActivity(intent);
    }
}
