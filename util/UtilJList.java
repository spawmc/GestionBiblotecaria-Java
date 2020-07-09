package util;

import java.util.ArrayList;
import java.util.Iterator;

import ejemplares.Libro;
import ejemplares.Tesis;
import usuarios.Estudiante;
import usuarios.Profesor;

public class UtilJList {

	/**
	 * Funcion para convertir {@code ArrayList} de libros en {@code String[]} con el
	 * nombre de los libros
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
	 * Funcion para convertir {@code ArrayList} de tesis en {@code String[]} con el
	 * nombre de las tesis
	 * 
	 * @param arrayListLibros {@code ArrayList} de tesis
	 * @return {@code String[]} con los nombres de los tesis
	 */
	public static String[] sacarNombreTesis(ArrayList<Tesis> arrayListTesis) {
		String[] str = new String[arrayListTesis.size()];

		Iterator<Tesis> iter = arrayListTesis.iterator();

		int i = 0;
		while (iter.hasNext()) {
			str[i] = arrayListTesis.get(i).getTitulo();
			iter.next();
			i++;
		}

		return str;
	}

	/**
	 * Funcion para convertir {@code ArrayList} de libros en {@code String[]} con
	 * los nombres de los estudiantes
	 * 
	 * @param arraylistEstudiantes {@code ArrayList} de estudiantes
	 * @return {@code String[]} con los nombres de los estudiantes
	 */
	public static String[] sacarNombreEstudiantes(ArrayList<Estudiante> arraylistEstudiantes) {
		String[] str = new String[arraylistEstudiantes.size()];

		Iterator<Estudiante> iter = arraylistEstudiantes.iterator();

		int i = 0;
		while (iter.hasNext()) {
			str[i] = arraylistEstudiantes.get(i).getNombre();
			iter.next();
			i++;
		}

		return str;
	}

	/**
	 * Funcion para convertir {@code ArrayList} de libros en {@code String[]} con
	 * los nombres de los profesores
	 * 
	 * @param arraylistEstudiantes {@code ArrayList} de profesores
	 * @return {@code String[]} con los nombres de los Profesores
	 */
	public static String[] sacarNombreProfesores(ArrayList<Profesor> arrayListProfesores) {
		String[] str = new String[arrayListProfesores.size()];

		Iterator<Profesor> iter = arrayListProfesores.iterator();

		int i = 0;
		while (iter.hasNext()) {
			str[i] = arrayListProfesores.get(i).getNombre();
			iter.next();
			i++;
		}
		return str;
	}

}// Final class