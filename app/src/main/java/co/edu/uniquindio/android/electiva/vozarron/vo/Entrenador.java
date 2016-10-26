package co.edu.uniquindio.android.electiva.vozarron.vo;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by Manuel on 25/10/2016.
 */

public class Entrenador implements Parcelable {

    private String nombre;
    private String genero;
    private String historia;
    private String color;
    private String imagen;
    private String url;
    private String id;

    public Entrenador(String nombre,String genero,String historia){
        this.nombre=nombre;
        this.genero=genero;
        this.historia=historia;
    }
    protected Entrenador(Parcel in) {
        id = in.readString();
        nombre = in.readString();
        genero = in.readString();
        historia = in.readString();
        url = in.readString();
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public void setImagen(String imagen) {
        this.imagen = imagen;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public void setHistoria(String historia) {
        this.historia = historia;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getGenero() {

        return genero;
    }

    public String getHistoria() {
        return historia;
    }

    public String getColor() {
        return color;
    }

    public String getImagen() {
        return imagen;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
    public static final Creator<Entrenador> CREATOR = new Creator<Entrenador>() {
        @Override
        public Entrenador createFromParcel(Parcel in) {
            return new Entrenador(in);
        }

        @Override
        public Entrenador[] newArray(int size) {
            return new Entrenador[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(id);
        dest.writeString(nombre);
        dest.writeString(genero);
        dest.writeString(historia);
        dest.writeString(url);
    }
}
