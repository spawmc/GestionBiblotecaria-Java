package files;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;

import ejemplares.Libro;
import ejemplares.Tesis;
import usuarios.Estudiante;
import usuarios.Profesor;

public interface ISave {

	/**
	 * Se encarga de guardar un archivo dependiendo del tipo de Usuario, con forme a
	 * esto se guardará en un un archivo diferente dependiendo del tipo de usuario
	 * 
	 * <h4>Se le debe mandar dos {@code ArrayList} uno donde este un
	 * {@code ArrayList} lleno, y otro vacio, esto para meter todo en un solo
	 * metodo</h4>
	 * <h5>El {@code ArrayList} vacio se utiliza solo para comprobar el tipo de
	 * {@code ArrayList} y el destino al que se debe escribir</h5>
	 * 
	 * @param estu recibe un {@code ArrayList<Estudiante>} para poder guardar los
	 *             datos
	 * @param prof recibe un {@code ArrayList<Profesor>} para poder guardar los
	 *             datos
	 * @throws FileNotFoundException Se lanza esta excepcion si no se encuentra el
	 *                               archivo, esto con la espera de ser capturado
	 *                               por un cuadro de dialogo
	 * @throws IOException           Se lanza esta excepcion en caso de que no se
	 *                               hayan podido escribir los {@code ArrayList} de
	 *                               objetos, esto con la espera de ser capturado
	 *                               por un cuadro de dialogo
	 */
	void guardarDatosUsuario(ArrayList<Estudiante> estu, ArrayList<Profesor> prof)
			throws FileNotFoundException, IOException;

	/**
	 * Se encarga de guardar un archivo dependiendo del tipo de Ejemplar, con forme a
	 * esto se guardará en un un archivo diferente dependiendo del tipo de Ejemplar
	 * 
	 * <h4>Se le debe mandar dos {@code ArrayList} uno donde este un
	 * {@code ArrayList} lleno, y otro vacio, esto para meter todo en un solo
	 * metodo</h4>
	 * <h5>El {@code ArrayList} vacio se utiliza solo para comprobar el tipo de
	 * {@code ArrayList} y el destino al que se debe escribir</h5>
	 * 
	 * @param estu recibe un {@code ArrayList<Libro>} para poder guardar los
	 *             datos
	 * @param prof recibe un {@code ArrayList<Tesis>} para poder guardar los
	 *             datos
	 * @throws FileNotFoundException Se lanza esta excepcion si no se encuentra el
	 *                               archivo, esto con la espera de ser capturado
	 *                               por un cuadro de dialogo
	 * @throws IOException           Se lanza esta excepcion en caso de que no se
	 *                               hayan podido escribir los {@code ArrayList} de
	 *                               objetos, esto con la espera de ser capturado
	 *                               por un cuadro de dialogo
	 */
	void guardarDatosEjemplar(ArrayList<Libro> libro, ArrayList<Tesis> tesis) throws FileNotFoundException, IOException;

}