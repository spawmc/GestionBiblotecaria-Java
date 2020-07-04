package files;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.OutputStream;

public class AñadirContenido extends ObjectOutputStream {

    protected AñadirContenido() throws IOException, SecurityException {
        super();
    }

    public AñadirContenido(OutputStream out) throws IOException {
        super(out);
    }

    /**
     * {@code reset()} nos ayudará a poder evitar que al volver escribir un archivo
     * binario se genere una almohadilla como se genera el inicio de cada escritura,
     * esto para poder seguir añadiendo más información al mismo archivo
     */
    @Override
    protected void writeStreamHeader() throws IOException {
        reset();
    }

}