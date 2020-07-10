package util;

import java.io.IOException;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import ejemplares.Area;
import ejemplares.Autor;
import ejemplares.Libro;
import ejemplares.Tesis;
import files.ArchivoBinario;
import usuarios.Estudiante;
import usuarios.Profesor;

/**
 * Esta clase
 * <h3>SOLAMENTE</h3> debe usarse para inicializar archivos, en caso de que los
 * archivos se hayan eliminado o dañado, o no existan, queda a responsabilidad
 * del programador
 */
public class Inicializador {
	ArchivoBinario file;

	ArrayList<Libro> libros;
	ArrayList<Tesis> tesis;
	ArrayList<Profesor> profesores;
	ArrayList<Estudiante> estudiantes;

	private void makeEstudiantes() {
		file = new ArchivoBinario();
		estudiantes = new ArrayList<>();

		estudiantes.add(new Estudiante("Perla Montoya", "Col. La pradera", 2281789966L, "ZS19472858"));

		try {
			file.guardarDatosUsuario(estudiantes, new ArrayList<Profesor>());
		} catch (IOException e) {
			JOptionPane.showMessageDialog(null, "No se ha podigo guardar correctamente", "Error de E/S",
					JOptionPane.ERROR_MESSAGE);
			e.printStackTrace();
		}

	}

	private void makeTesis() {
		file = new ArchivoBinario();
		tesis = new ArrayList<>();
		ArrayList<Autor> autores = new ArrayList<>();
		autores.add(new Autor("Miguel Hernandez"));

		tesis.add(new Tesis("Pulsos electromagneticos para IoT", (short) 2019, "Investigación experimental",
				"Jose Cordova Guevara", new Tesis.TipoTesis("Investigación"), autores));

		try {
			file.guardarDatosEjemplar(new ArrayList<Libro>(), tesis);
		} catch (IOException e) {
			JOptionPane.showMessageDialog(null, "No se ha podigo guardar correctamente", "Error de E/S",
					JOptionPane.ERROR_MESSAGE);
			e.printStackTrace();
		}
	}

	private void makeLibros() {
		file = new ArchivoBinario();
		libros = new ArrayList<>();
		ArrayList<Autor> autores = new ArrayList<>();
		autores.add(new Autor("Arthur Schopenhauer"));
		libros.add(new Libro("El arte de insultar", (short) 2011, "Libro de bolsillo", 5, "978-84-206-4332-8", autores,
				new Area("Humanidades y de las Artes"), new Area.SubArea("Filosofia")));
		try {
			file.guardarDatosEjemplar(libros, new ArrayList<Tesis>());
		} catch (IOException e) {
			JOptionPane.showMessageDialog(null, "No se ha podigo guardar correctamente", "Error de E/S",
					JOptionPane.ERROR_MESSAGE);
			e.printStackTrace();
		}
	}

	private void makeProfesor() {
		file = new ArchivoBinario();
		profesores = new ArrayList<>();
		profesores.add(new Profesor("Miguel Quinata Ortiz", "Col. Las Fuentes, Calle Fuente de Nayades", 2288384932L,
				"S12182411", "FEI"));
		try {
			file.guardarDatosUsuario(new ArrayList<Estudiante>(), profesores);
		} catch (IOException e) {
			JOptionPane.showMessageDialog(null, "No se ha podigo guardar correctamente", "Error de E/S",
					JOptionPane.ERROR_MESSAGE);
			e.printStackTrace();
		}

	}
/* 
	public static void main(String[] args) {
		Inicializador i = new Inicializador();
		// i.makeLibros();
		i.makeProfesor();
		i.makeEstudiantes();
		// i.makeTesis();
	} */

}