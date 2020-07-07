package usuarios;

import ejemplares.Libro;

public class Profesor extends Usuario {
	private String numeroDePersonal;
	private String facultad;
	private int numeroDeEjemplares = 0;

	public Profesor() {
	}

	public String getFacultad() {
		return facultad;
	}

	public void setFacultad(String facultad) {
		this.facultad = facultad;
	}

	/**
	 * 
	 * @param nombre
	 * @param direccion
	 * @param telefono
	 * @param numeroDePersonal
	 */
	public Profesor(String nombre, String direccion, long telefono, String numeroDePersonal, String facultad) {
		super(nombre, direccion, telefono);
		this.numeroDePersonal = numeroDePersonal;
		this.facultad = facultad;
	}

	@Override
	public void addLibroEnPosesion(Libro libro) {
		if (numeroDeEjemplares <= 5)
			super.addLibroEnPosesion(libro);
		else
			System.out.println("No se pueden agregar más libros");
	}

	@Override
	public String toString() {
		return super.toString() + "\nNumero de personal: " + getNumeroDePersonal();
	}

	public int getNumeroDeEjemplares() {
		return numeroDeEjemplares;
	}

	public void setNumeroDeEjemplares(int numeroDeEjemplares) {
		this.numeroDeEjemplares = numeroDeEjemplares;
	}

	public String getNumeroDePersonal() {
		return numeroDePersonal;
	}

	public void setNumeroDePersonal(String numeroDePersonal) {
		this.numeroDePersonal = numeroDePersonal;
	}

	/**
	 * Se debe de crear un objeto de la clase Estudiante vacio para comparar
	 * 
	 * @param obj Es el objeto de {@code Object} que se debe pasar para comparar si
	 *            es de la clase Profesor
	 * @return retorna true si el objeto pasado como parametro es parte de la misma
	 *         clase
	 */
	@Override
	public boolean equals(Object obj) {
		if (obj instanceof Profesor) {
			return true;
		} else {
			return false;
		}
	}
}// Final class