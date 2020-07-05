package ejemplares;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import usuarios.Estudiante;
import usuarios.Profesor;
import usuarios.Usuario;

/**
 * Implementa {@link IPrestamo} para definir las funciones que se encargan de
 * los prestamos
 * 
 */

public abstract class Ejemplar implements IPrestamo, Serializable {
	protected String titulo;
	protected short año;
	protected boolean prestado;
	protected ArrayList<Autor> autores;
	protected long tiempoPrestado;
	protected String clasificacion;

	/**
	 * 
	 * @param titulo
	 * @param año
	 * @param clasificacion
	 */
	public Ejemplar(String titulo, short año, String clasificacion) {
		this.titulo = titulo;
		this.año = año;
		this.setClasificacion(clasificacion);
	}

	public Ejemplar(){}

	/**
	 * {@inheritDoc}
	 * 
	 * @see SinDeudaException
	 */
	@Override
	public long precioDeuda(Object user) throws SinDeudaException {
		Usuario temE = new Estudiante();
		Usuario temP = new Profesor();
		long deuda = 0;

		if (temE.enDeuda() || temP.enDeuda()) {
			throw new SinDeudaException("Sin deuda");
		} else {
			if (user.equals(temE)) {
				if (getTiempoPrestado() > 3) {
					long tiempoSobrepasado = getTiempoPrestado() - 3;
					deuda = tiempoSobrepasado * 5;
				}
			} else if (user.equals(temP)) {
				if (getTiempoPrestado() > 5) {
					long tiempoSobrepasado = getTiempoPrestado() - 5;
					deuda = tiempoSobrepasado * 5;
				}
			}
		}

		return deuda;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void regresar(Date dateI, Date dateF) {
		long minutos = 0;
		if (dateI.getTime() > dateF.getTime()) {
			long milis = (dateF.getTime() - dateI.getTime());
			minutos = (milis / 1000) / 60;
		} else {
			setTiempoPrestado(minutos);
		}
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Date prestar(Date dateI) {
		return dateI;
	}

	@Override
	public String toString() {
		String string = "\nTitulo: " + getTitulo() + "\nAño: " + getAño() + "\nClasificacion: " + getClasificacion() + "\nAutor(es): ";

		if(autores.size() == 1){
			string += autores.get(0).getNombre();
		}else {
			for (int i = 0; i < autores.size(); i++) {
				if(i == 0){
					string += autores.get(i).getNombre();
				}else{
					string += "\t" + autores.get(i).getNombre();

				}
			}
		}
		return string;
	}

	public String getTitulo() {
		return titulo;
	}

	public short getAño() {
		return año;
	}

	public long getTiempoPrestado() {
		return tiempoPrestado;
	}

	public ArrayList<Autor> getAutores() {
		return autores;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public void setAño(short año) {
		this.año = año;
	}

	public void setTiempoPrestado(long tiempoPrestado) {
		this.tiempoPrestado = tiempoPrestado;
	}

	public void setAutores(ArrayList<Autor> autores) {
		this.autores = autores;
	}

	public String getClasificacion() {
		return clasificacion;
	}

	public void setClasificacion(String clasificacion) {
		this.clasificacion = clasificacion;
	}

	public boolean esPrestado() {
		return prestado;
	}

	public void setPrestado(boolean prestado) {
		this.prestado = prestado;
	}

}