package usuarios;

import java.io.Serializable;
import java.util.ArrayList;

import ejemplares.Libro;

public abstract class Usuario implements Serializable {
	protected String nombre;
	protected String direccion;
	protected long telefono;
	protected boolean deuda;
	protected ArrayList<Long> tiempoLibrosEnPosesion;

	public Usuario(String nombre, String direccion, long telefono) {
		this.nombre = nombre;
		this.direccion = direccion;
		this.telefono = telefono;
	}

	public void addLibroEnPosesion(Libro libro) {
		tiempoLibrosEnPosesion.add(libro.getTiempoPrestado());
	}

	public void eliminarLibroEnPosesion(int index) {
		tiempoLibrosEnPosesion.remove(index);
	}

	public ArrayList<Long> getTiempoLibrosEnPosesion() {
		return tiempoLibrosEnPosesion;
	}

	public void setTiempoLibrosEnPosesion(ArrayList<Long> tiempoLibrosEnPosesion) {
		this.tiempoLibrosEnPosesion = tiempoLibrosEnPosesion;
	}

	@Override
	public String toString() {
		return "\nNombre: " + getNombre() + "\nDireccion: " + getDireccion() + "\nTelefono " + getTelefono();
	}

	public boolean enDeuda() {
		return deuda;
	}

	public void setDeuda(boolean deuda) {
		this.deuda = deuda;
	}

	public Usuario() {
	}

	public String getNombre() {
		return nombre;
	}

	public String getDireccion() {
		return direccion;
	}

	public long getTelefono() {
		return telefono;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public void setTelefono(long telefono) {
		this.telefono = telefono;
	}

}