package ejemplares;

import java.io.Serializable;

public class Autor implements Serializable {
    private String nombre;

    public Autor(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public String toString() {
        return nombre + "\t";
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
}