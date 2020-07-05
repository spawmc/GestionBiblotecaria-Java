package ejemplares;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * Hereda de {@link Ejemplar}
 * 
 * @see Ejemplar
 */
public class Tesis extends Ejemplar {

    private String director;
    private TipoTesis tipoTesis;

    /**
     * 
     * @param titulo
     * @param año
     * @param clasificacion
     * @param director
     * @param tipoTesis
     * @param autores
     */
    public Tesis(String titulo, short año, String clasificacion, String director, TipoTesis tipoTesis,
            ArrayList<Autor> autores) {
        super(titulo, año, clasificacion);
        this.director = director;
        this.tipoTesis = tipoTesis;
        setAutores(autores);
    }

    public Tesis() {
    }

    @Override
    public String toString() {
        return super.toString() + "\nDirector: " + getDirector() + "\nTipo de tesis: " + getTipoTesis();
    }

    public String getDirector() {
        return director;
    }

    public TipoTesis getTipoTesis() {
        return tipoTesis;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public void setTipoTesis(TipoTesis tipoTesis) {
        this.tipoTesis = tipoTesis;
    }

    /**
     * Esta clase se utiliza para poder generar algunos tipos de tesis accediendo
     * desde la clase Tesis para evitar crear otra clase fuera del archivo
     */
    public static class TipoTesis implements Serializable {
        private String nombre;

        public TipoTesis(String nombre) {
            this.nombre = nombre;
        }

        public String getNombre() {
            return nombre;
        }

        public void setNombre(String nombre) {
            this.nombre = nombre;
        }

        @Override
        public String toString() {
            return getNombre();
        }
    }// Final TipoTesis
}// Final Tesis