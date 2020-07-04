package ejemplares;

import java.io.Serializable;
import java.util.ArrayList;

public class Area implements Serializable{
    private String nombre;
    private ArrayList<Area.SubArea> subAreas;

    public Area(String nombre) {
        this.nombre = nombre;
    }

    public Area(String nombre, ArrayList<SubArea> subAreas) {
        super();
        this.subAreas = subAreas;
    }

    public String getNombre() {
        return nombre;
    }

    public ArrayList<SubArea> getSubAreas() {
        return subAreas;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setSubAreas(ArrayList<SubArea> subAreas) {
        this.subAreas = subAreas;
    }

    public Area.SubArea getSubArea(int index) {
        return subAreas.get(index);
    }

    public void addSubArea(String nombre_subarea) {
        subAreas.add(new Area.SubArea(nombre_subarea));
    }

    public void addSubAreas(ArrayList<Area.SubArea> subarea){
        this.subAreas = subarea;
    }

    public String getNameAreaAndSubAreas() {
        String descriptionSubareas = "\nArea" + getNombre() + "\nSubAreas: \n";

        for (int i = 0; i < subAreas.size(); i++) {
            descriptionSubareas += "\n" + subAreas.get(i).getNombre();
        }

        return descriptionSubareas;
    }

    @Override
    public String toString() {
        return getNombre();
    }

    public static class SubArea implements Serializable{
        private String nombre;

        public SubArea(String nombre) {
            this.nombre = nombre;
        }

        public String getNombre() {
            return nombre;
        }

        public void setNombre(String nombre) {
            this.nombre = nombre;
        }

        @Override
        public String toString() {
            return getNombre();
        }
    }// Final SubArea
}// Final Area