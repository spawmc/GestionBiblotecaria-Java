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