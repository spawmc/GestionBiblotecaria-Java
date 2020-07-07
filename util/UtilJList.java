package util;

import java.util.ArrayList;

import ejemplares.Libro;
import ejemplares.Tesis;

public class UtilJList {


    /**
     * Funcion para convertir {@code ArrayList} de libros en {@code String[]}
     * 
     * @param arrayListLibros {@code ArrayList} de libros
     * @return {@code String[]} con los nombres de los libros
     */
    public static String[] sacarNombreLibros(ArrayList<Libro> arrayListLibros) {
        String[] str = new String[arrayListLibros.size()];
        for (int i = 0; i < arrayListLibros.size(); i++) {
            str[i] = arrayListLibros.get(i).getTitulo();
        }
        return str;
    }

    /**
     * Funcion para convertir {@code ArrayList} de tesis en {@code String[]}
     * 
     * @param arrayListLibros {@code ArrayList} de tesis
     * @return {@code String[]} con los nombres de los tesis
     */
    public static String[] sacarNombreTesis(ArrayList<Tesis> arrayListTesis) {
        String[] str = new String[arrayListTesis.size()];
        for (int i = 0; i < arrayListTesis.size(); i++) {
            str[i] = arrayListTesis.get(i).getTitulo();
        }
        return str;
    }

}// Final class