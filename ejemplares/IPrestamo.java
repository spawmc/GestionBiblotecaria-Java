package ejemplares;

import java.util.Date;

public interface IPrestamo {

	/**
	 * Se encarga de capturar el momento en el que se realiza el prestamo
	 * 
	 * @param dateI Objeto {@code Date} con el que se guarda el momento en el que se
	 *              realiza el prestamo
	 * @return retorna la hora en la que se realizó el prestamo, esto es opcional en
	 *         caso de que se requiera tener la hora guardadad en otro lugar
	 */
	Date prestar(Date dateI);

	/**
	 * Se encarga de detener el tiempo donde se regresa el libro
	 * 
	 * @param dateI Objeto {@code Date} con el tiempo de inicio del prestamo
	 * @param dateF Objeto {@code Date} con el tiempo final del prestamo (En
	 *              minutos)
	 */
	void regresar(Date dateI, Date dateF);

	/**
	 * Este metodo se encarga de verificar el precio de los dias que a sobrepasado
	 * desde el momento del prestamo En caso de que no haya sido prestado se lanza
	 * la excepcion
	 * <h2>SinPrestarException</h2>
	 * 
	 * 
	 * @param user
	 * @return Retorana la cantidad de pesos que debe el usuario, de acuerdo al tipo
	 *         de usuaio que sea (Estduainte o Profesor)
	 * 
	 * @throws SinDeudaException Se lanza cuando el usuario no tiene ninguna deuda
	 * 
	 */
	long precioDeuda(Object user) throws SinDeudaException;
}