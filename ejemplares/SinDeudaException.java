package ejemplares;

/**
 * Se lanza esta excepcion para indicar al programador que debe de agregar el
 * try_catch para en caso de ser lanzada, ponga el codigo para que el usuario
 * pague su deuda
 */
public class SinDeudaException extends Exception {
    public SinDeudaException(String mensaje) {
        super(mensaje);
    }
}
