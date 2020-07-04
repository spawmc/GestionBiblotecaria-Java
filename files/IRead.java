package files;

import java.io.IOException;
import java.util.ArrayList;

import ejemplares.Libro;
import ejemplares.Tesis;
import usuarios.Estudiante;
import usuarios.Profesor;

public interface IRead {

   /**
    * Se encarga de traer los datos del archivo que contenga datos sobre los libros
    * 
    * @return retorna un {@code ArrayList<Libro>}
    * @throws IOException            Se lanza {@code IOException} en caso de que no
    *                                se pueda leer el archivo, con la espera de ser
    *                                atrapado por un cuadro de dialgo
    * @throws ClassNotFoundException Se lanza {@code ClassNotFoundException} cuando
    *                                el tipo de dato a castear no es el correcto
    */
   ArrayList<Libro> leerDatosLibros() throws IOException, ClassNotFoundException;

   /**
    * Se encarga de traer los datos del archivo que contenga datos sobre los Tesis
    * 
    * @return retorna un {@code ArrayList<Tesis>}
    * @throws IOException            Se lanza {@code IOException} en caso de que no
    *                                se pueda leer el archivo, con la espera de ser
    *                                atrapado por un cuadro de dialgo
    * @throws ClassNotFoundException Se lanza {@code ClassNotFoundException} cuando
    *                                el tipo de dato a castear no es el correcto
    */
   ArrayList<Tesis> leerDatosTesis() throws IOException, ClassNotFoundException;

   /**
    * Se encarga de traer los datos del archivo que contenga datos sobre los
    * Estudiantes
    * 
    * @return retorna un {@code ArrayList<Estudiante>}
    * @throws IOException            Se lanza {@code IOException} en caso de que no
    *                                se pueda leer el archivo, con la espera de ser
    *                                atrapado por un cuadro de dialgo
    * @throws ClassNotFoundException Se lanza {@code ClassNotFoundException} cuando
    *                                el tipo de dato a castear no es el correcto
    */
   ArrayList<Estudiante> leerDatosEstudiantes() throws IOException, ClassNotFoundException;

   /**
    * Se encarga de traer los datos del archivo que contenga datos sobre los
    * Profesores
    * 
    * @return retorna un {@code ArrayList<Profesor>}
    * @throws IOException            Se lanza {@code IOException} en caso de que no
    *                                se pueda leer el archivo, con la espera de ser
    *                                atrapado por un cuadro de dialgo
    * @throws ClassNotFoundException Se lanza {@code ClassNotFoundException} cuando
    *                                el tipo de dato a castear no es el correcto
    */
   ArrayList<Profesor> leerDatosProfesores() throws IOException, ClassNotFoundException;
}