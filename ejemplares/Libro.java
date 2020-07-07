package ejemplares;

import java.util.ArrayList;

import ejemplares.Area.SubArea;

/**
 * Hereda de {@link Ejemplar}
 * 
 * @see Ejemplar
 */
public class Libro extends Ejemplar {
	private int edicion;
	private String isbn;
	private Area area;
	private Area.SubArea subarea;
	private int numEjemplares = 0;

	/**
	 * 
	 * @param titulo
	 * @param año
	 * @param clasificacion
	 * @param edicion
	 * @param isbn
	 * @param autores
	 * @param area
	 * @param subarea
	 */
	public Libro(String titulo, short año, String clasificacion, int edicion, String isbn, ArrayList<Autor> autores,
			Area area, SubArea subarea) {
		super(titulo, año, clasificacion);
		this.edicion = edicion;
		this.isbn = isbn;
		this.area = area;
		this.subarea = subarea;
		setAutores(autores);
		this.numEjemplares = 1;
	}

	/**
	 * funcion unicamente para testear
	 * 
	 * @return un {@code ArrayList} de libros
	 */
	public static ArrayList<Libro> makeBookList() {
		ArrayList<Libro> libros = new ArrayList<>();
		ArrayList<Autor> autores = new ArrayList<>();
		for (int i = 0; i < 3; i++) {
			autores.add(new Autor("Autor: " + i));
		}

		for (int i = 0; i < 20; i++) {
			libros.add(new Libro("Libro " + i+1, (short) (2005 + i), "De bolsillo", 2 + i, "123124412ASDAS", autores,
					new Area("Aasd"), new Area.SubArea("asdasd")));
		}

		return libros;
	}

	public int getNumEjemplares() {
		return numEjemplares;
	}

	public void setNumEjemplares(int numEjemplares) {
		this.numEjemplares = numEjemplares;
	}

	public Libro() {
	}

	@Override
	public String toString() {
		return super.toString() + "\nEdicion: " + getEdicion() + "\nIsbn: " + getIsbn() + "\nArea: " + getArea()
				+ "\nSub Area: " + getSubarea();
	}

	public SubArea getSubarea() {
		return subarea;
	}

	public void setSubarea(SubArea subarea) {
		this.subarea = subarea;
	}

	public int getEdicion() {
		return edicion;
	}

	public String getIsbn() {
		return isbn;
	}

	public Area getArea() {
		return area;
	}

	public void setEdicion(int edicion) {
		this.edicion = edicion;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	public void setArea(Area area) {
		this.area = area;
	}

}