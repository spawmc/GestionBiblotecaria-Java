package util;

/**
 * Clase que implementa singleton para poder comunicar la posicion del libro
 * seleccionado para poder prestarlo
 */
public class Mensajero {
    private static Mensajero msj;
    private int posicion;

    private Mensajero() {
    }

    public int getPosicion() {
        return posicion;
    }

    public void setPosicion(int posicion) {
        this.posicion = posicion;
    }

    public static Mensajero getInstance() {
        if (msj == null)
            msj = new Mensajero();
        return msj;
    }

}