package util;

import java.io.IOException;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import ejemplares.Libro;
import ejemplares.Tesis;
import files.ArchivoBinario;
import usuarios.Estudiante;
import usuarios.Profesor;

public class Administrador {

	private ArrayList<Libro> libros;
	private ArrayList<Tesis> tesis;
	private ArrayList<Profesor> profesores;
	private ArrayList<Estudiante> estudiantes;

	ArchivoBinario files;

	public void añadirEstudiante(Estudiante estudianteaux) {
		files = new ArchivoBinario();
		estudiantes = new ArrayList<>();
		try {
			estudiantes = files.leerDatosEstudiantes();
		} catch (ClassNotFoundException | IOException e) {
			JOptionPane.showConfirmDialog(null, "No se ha podido leer o encontrar el archivo :( ", "ERROR",
					JOptionPane.WARNING_MESSAGE);
			e.printStackTrace();
		}
		estudiantes.add(estudianteaux);

		try {
			files.guardarDatosUsuario(estudiantes, new ArrayList<Profesor>());
		} catch (IOException e) {
			JOptionPane.showMessageDialog(null, "No se ha podigo guardar correctamente", "Error de E/S",
					JOptionPane.ERROR_MESSAGE);
			e.printStackTrace();
		}

	}

	public void añadirProfesor(Profesor prof) {
		files = new ArchivoBinario();
		profesores = new ArrayList<>();

		try {
			profesores = files.leerDatosProfesores();
		} catch (ClassNotFoundException | IOException e) {
			JOptionPane.showConfirmDialog(null, "No se ha podido leer o encontrar el archivo :( ", "ERROR",
					JOptionPane.WARNING_MESSAGE);
			e.printStackTrace();
		}
		profesores.add(prof);
		try {
			files.guardarDatosUsuario(new ArrayList<Estudiante>(), profesores);
		} catch (IOException e) {
			JOptionPane.showMessageDialog(null, "No se ha podigo guardar correctamente", "Error de E/S",
					JOptionPane.ERROR_MESSAGE);
			e.printStackTrace();
		}

	}

	/**
	 * Se encarga de leer el archivo binario correspondiente, despues lo trae, añade
	 * el libro y lo vuelve a guardar
	 * 
	 * @param libro
	 */
	public void añadirLibro(Libro libro) {
		files = new ArchivoBinario();
		libros = new ArrayList<>();
		try {
			libros = files.leerDatosLibros();
		} catch (ClassNotFoundException | IOException e) {
			JOptionPane.showConfirmDialog(null, "No se ha podido leer o encontrar el archivo :( ", "ERROR",
					JOptionPane.WARNING_MESSAGE);
			e.printStackTrace();
		}
		libros.add(libro);
		try {
			files.guardarDatosEjemplar(libros, new ArrayList<Tesis>());
		} catch (IOException e) {
			JOptionPane.showMessageDialog(null, "No se ha podigo guardar correctamente", "Error de E/S",
					JOptionPane.ERROR_MESSAGE);
			e.printStackTrace();
		}
	}

	/**
	 * Se encarga de leer el archivo binario correspondiente, despues lo trae, añade
	 * la tesis y lo vuelve a guardar
	 * 
	 * @param tesisaux
	 */
	public void añadirTesis(Tesis tesisaux) {
		files = new ArchivoBinario();
		tesis = new ArrayList<>();
		try {
			tesis = files.leerDatosTesis();
		} catch (ClassNotFoundException | IOException e) {
			JOptionPane.showConfirmDialog(null, "No se ha podido leer o encontrar el archivo :( ", "ERROR",
					JOptionPane.WARNING_MESSAGE);
			e.printStackTrace();
		}

		tesis.add(tesisaux);
		try {
			files.guardarDatosEjemplar(new ArrayList<Libro>(), tesis);
		} catch (IOException e) {
			JOptionPane.showMessageDialog(null, "No se ha podigo guardar correctamente", "Error de E/S",
					JOptionPane.ERROR_MESSAGE);
			e.printStackTrace();
		}

	}

	public ArrayList<Libro> getLibros() {
		return libros;
	}

	public ArrayList<Tesis> getTesis() {
		return tesis;
	}

	public ArrayList<Profesor> getProfesores() {
		return profesores;
	}

	public ArrayList<Estudiante> getEstudiantes() {
		return estudiantes;
	}

	public void setLibros(ArrayList<Libro> libros) {
		this.libros = libros;
	}

	public void setTesis(ArrayList<Tesis> tesis) {
		this.tesis = tesis;
	}

	public void setProfesores(ArrayList<Profesor> profesores) {
		this.profesores = profesores;
	}

	public void setEstudiantes(ArrayList<Estudiante> estudiantes) {
		this.estudiantes = estudiantes;
	}
}