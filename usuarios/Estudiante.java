package usuarios;

import java.util.ArrayList;

import ejemplares.Libro;
import ejemplares.Tesis;

public class Estudiante extends Usuario {
	private String matricula;
	private int numeroDeEjemplares = 0;
	private ArrayList<Tesis> tesis = new ArrayList<>();
	private ArrayList<Libro> libros = new ArrayList<>();

	public Estudiante() {
	}

	public ArrayList<Libro> getLibros() {
		return libros;
	}

	public void setLibros(ArrayList<Libro> libros) {
		this.libros = libros;
	}

	public ArrayList<Tesis> getTesis() {
		return tesis;
	}

	public void setTesis(ArrayList<Tesis> tesis) {
		this.tesis = tesis;
	}

	@Override
	public String toString() {
		return super.toString() + "\nMatricula: " + getMatricula();
	}

	@Override
	public void addLibroEnPosesion(Libro libro) {
		if (numeroDeEjemplares <= 3)
			super.addLibroEnPosesion(libro);
		else
			System.out.println("No se pueden agregar más libros");
	}

	public int getNumeroDeEjemplares() {
		return numeroDeEjemplares;
	}

	public void setNumeroDeEjemplares(int numeroDeEjemplares) {
		this.numeroDeEjemplares = numeroDeEjemplares;
	}

	/**
	 * 
	 * @param nombre
	 * @param direccion
	 * @param telefono
	 * @param matricula
	 */
	public Estudiante(String nombre, String direccion, Long telefono, String matricula) {
		super(nombre, direccion, telefono);
		this.matricula = matricula;
	}

	public String getMatricula() {
		return matricula;
	}

	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}

	/**
	 * Se debe de crear un objeto de la clase Estudiante vacio para comparar
	 * 
	 * @param obj Es el objeto de {@code Object} que se debe pasar para comparar si
	 *            es de la clase Estudiante
	 * @return retorna true si el objeto pasado como parametro es parte de la misma
	 *         clase
	 */
	@Override
	public boolean equals(Object obj) {
		if (obj instanceof Estudiante) {
			return true;
		} else {
			return false;
		}
	}
}// Final class