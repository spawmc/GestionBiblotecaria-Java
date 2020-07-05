package files;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

import ejemplares.Libro;
import ejemplares.Tesis;
import usuarios.Estudiante;
import usuarios.Profesor;

/**
 * Esta clase esta encargada de manejar cada uno de los archivos binarios de
 * objetos generados, ya sea entrada o salida utilizando {@code ArrayList} como
 * parametros y retornos, para un mejor manejo de los usuarios y ejemplares
 * 
 * @see {@link ISave} y {@link IRead}
 */
public class ArchivoBinario implements ISave, IRead {

    private final String ESTUDIANTES = "Estudiantes.bin";
    private final String PROFESORES = "Profesores.bin";
    private final String LIBROS = "Libros.bin";
    private final String TESIS = "Tesis.bin";

    /**
     * {@inheritDoc}
     */
    @Override
    public void guardarDatosUsuario(ArrayList<Estudiante> estu, ArrayList<Profesor> prof)
            throws FileNotFoundException, IOException {
        String tipoUsuario = "";
        if (prof.size() != 0) {
            tipoUsuario = PROFESORES;
        } else if (estu.size() != 0) {
            tipoUsuario = ESTUDIANTES;
        }

        FileOutputStream archivo = null;
        ObjectOutputStream escritura = null;

        try {
            archivo = new FileOutputStream(tipoUsuario);
            escritura = new ObjectOutputStream(archivo);

            if (tipoUsuario == ESTUDIANTES) {
                escritura.writeObject(estu);
            } else if (tipoUsuario == PROFESORES) {
                escritura.writeObject(prof);
            }

            escritura.close();

        } catch (FileNotFoundException e) {
            throw new FileNotFoundException("No se ha podido localizar el archivo");
        } catch (IOException e) {
            throw new IOException("No se ha podido escribir el archivo :(");
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void guardarDatosEjemplar(ArrayList<Libro> libro, ArrayList<Tesis> tesis)
            throws FileNotFoundException, IOException {
        String tipoUsuario = "";
        if (libro.size() != 0) {
            tipoUsuario = LIBROS;
        } else if (tesis.size() != 0) {
            tipoUsuario = TESIS;
        }

        FileOutputStream archivo = null;
        ObjectOutputStream escritura = null;

        try {
            archivo = new FileOutputStream(tipoUsuario);
            escritura = new ObjectOutputStream(archivo);

            if (tipoUsuario == LIBROS) {
                escritura.writeObject(libro);
            } else if (tipoUsuario == TESIS) {
                escritura.writeObject(tesis);
            }

            escritura.close();
        } catch (FileNotFoundException e) {
            throw new FileNotFoundException("No se ha podido localizar el archivo");
        } catch (IOException e) {
            e.printStackTrace();
            throw new IOException("No se ha podido escribir el archivo :(");
        }
    }

    /**
     * {@inheritDoc}
     */
    @SuppressWarnings("unchecked")
    @Override
    public ArrayList<Libro> leerDatosLibros() throws IOException, ClassNotFoundException {
        ArrayList<Libro> libros = new ArrayList<Libro>();

        try {
            ObjectInputStream lectura = new ObjectInputStream(new FileInputStream(LIBROS));
            libros = (ArrayList<Libro>) lectura.readObject();
            lectura.close();
        } catch (IOException e) {
            throw new IOException("Error al leer el archivo");
        } catch (ClassNotFoundException e) {
            throw new ClassNotFoundException("Error al leer los archivos, clases incorrectas");
        }
        return libros;
    }

    /**
     * {@inheritDoc}
     */
    @SuppressWarnings("unchecked")
    @Override
    public ArrayList<Tesis> leerDatosTesis() throws IOException, ClassNotFoundException {
        ArrayList<Tesis> tesis = new ArrayList<Tesis>();

        try {
            ObjectInputStream lectura = new ObjectInputStream(new FileInputStream(TESIS));
            tesis = (ArrayList<Tesis>) lectura.readObject();
            lectura.close();
        } catch (IOException e) {
            throw new IOException("Error al leer el archivo");
        } catch (ClassNotFoundException e) {
            throw new ClassNotFoundException("Error al leer los archivos, clases incorrectas");
        }
        return tesis;
    }

    /**
     * {@inheritDoc}
     */
    @SuppressWarnings("unchecked")
    @Override
    public ArrayList<Estudiante> leerDatosEstudiantes() throws IOException, ClassNotFoundException {
        ArrayList<Estudiante> estudiantes = new ArrayList<Estudiante>();

        try {
            ObjectInputStream lectura = new ObjectInputStream(new FileInputStream(ESTUDIANTES));
            estudiantes = (ArrayList<Estudiante>) lectura.readObject();
            lectura.close();
        } catch (IOException e) {
            throw new IOException("Error al leer el archivo");
        } catch (ClassNotFoundException e) {
            throw new ClassNotFoundException("Error al leer los archivos, clases incorrectas");
        }
        return estudiantes;
    }

    /**
     * {@inheritDoc}
     */
    @SuppressWarnings("unchecked")
    @Override
    public ArrayList<Profesor> leerDatosProfesores() throws IOException, ClassNotFoundException {
        ArrayList<Profesor> profesores = new ArrayList<Profesor>();

        try {
            ObjectInputStream lectura = new ObjectInputStream(new FileInputStream(PROFESORES));
            profesores = (ArrayList<Profesor>) lectura.readObject();
            lectura.close();
        } catch (IOException e) {
            throw new IOException("Error al leer el archivo");
        } catch (ClassNotFoundException e) {
            throw new ClassNotFoundException("Error al leer los archivos, clases incorrectas");
        }
        return profesores;
    }

}