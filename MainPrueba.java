import java.io.IOException;
import java.util.ArrayList;

import ejemplares.Area;
import ejemplares.Autor;
import ejemplares.Libro;
import ejemplares.Tesis;
import files.ArchivoBinario;

public class MainPrueba {
    public static void main(String[] args) {
        ArrayList<Tesis.TipoTesis> tiposdetesis = new ArrayList<>();
        tiposdetesis.add(new Tesis.TipoTesis("Documental(teórica)"));
        tiposdetesis.add(new Tesis.TipoTesis("Investigación de campo8práctica"));
        tiposdetesis.add(new Tesis.TipoTesis("Teórico-práctica"));
        tiposdetesis.add(new Tesis.TipoTesis("Descriptiva"));
        tiposdetesis.add(new Tesis.TipoTesis("Analitica"));

        ArrayList<Autor> autores = new ArrayList<>();
        autores.add(new Autor("Arthur Schopenhauer"));

        ArrayList<Area> area = new ArrayList<>();
        area.add(new Area("Ciencias biológicas"));
        area.add(new Area("Ciencias sociales"));
        area.add(new Area("Humanidades y de las artes"));
        // area.get(0).addSubArea("biologia");
        // area.get(0).addSubArea("Bioquimica diagnóstica");
        // area.get(2).addSubArea("Filosofia");

        area.get(0).addSubAreas(makeSubArea());

        ArrayList<Libro> libros = new ArrayList<>();
        libros.add(new Libro("El arte de tener razón", (short) 1600, "De bolsillo", 3, "978-84-206-7410-0", autores,
                area.get(0), area.get(0).getSubArea(0)));

        System.out.println(libros.get(0));

        ArchivoBinario save = new ArchivoBinario();
        try {
            save.guardarDatosEjemplar(libros, new ArrayList<Tesis>());
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        

    }//Final main

    public static ArrayList<Area.SubArea> makeSubArea() {
        ArrayList<Area.SubArea> subareas = new ArrayList<>();
        subareas.add(new Area.SubArea("Biologia"));
        return subareas;
    }

}