package util;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;

import javax.swing.JOptionPane;

import ejemplares.Libro;
import ejemplares.Tesis;
import files.ArchivoBinario;
import usuarios.Estudiante;
import usuarios.Profesor;

public class Gerente {
    private ArrayList<Estudiante> estudiantes = null;
    private ArrayList<Profesor> profesores = null;
    private ArrayList<Libro> libros = null;
    private ArrayList<Tesis> tesis = null;

    private ArchivoBinario file = new ArchivoBinario();

    public void agregarLibroAEstudiante(int index, int indexE) {
        System.out.println("Se ejecuto agregarlibroestudiante");
        cargarLibros();
        // System.out.println("Cargando libros");
        cargarEstudiantes();
        // System.out.println("Cargando Estudiantes");
        if (estudiantes.get(indexE).getNumeroDeEjemplares() > 3) {
            JOptionPane.showConfirmDialog(null, "Lo sentimos, el usuario ya no puede adquirir más libros");
        } else {
            // System.out.println("Entrando al else");
            Date dateI = libros.get(index).prestar(new Date());
            libros.get(index).setTiempoPrestado((Long)(dateI);
            estudiantes.get(indexE).addLibroEnPosesion(libros.get(index));
            estudiantes.get(indexE).getLibros().add(libros.get(index));

            System.out.println(estudiantes.get(indexE).toString());
            estudiantes.get(indexE).setNumeroDeEjemplares(estudiantes.get(indexE).getNumeroDeEjemplares() + 1);
            try {
                file.guardarDatosUsuario(estudiantes, new ArrayList<Profesor>());
                file.guardarDatosEjemplar(libros, new ArrayList<Tesis>());
            } catch (IOException e) {
                JOptionPane.showMessageDialog(null, "No se ha podigo guardar correctamente", "Error de E/S",
                        JOptionPane.ERROR_MESSAGE);
                e.printStackTrace();
            }
        }

    }

    public void agregarTesisAEstudiante(int index, int indexE) {
        cargarTesis();
        cargarEstudiantes();
        if (estudiantes.get(indexE).getNumeroDeEjemplares() > 3) {
            JOptionPane.showConfirmDialog(null, "Lo sentimos, el usuario ya no puede adquirir más libros");
        } else {
            estudiantes.get(indexE).getTesis().add(tesis.get(index));
            estudiantes.get(indexE).setNumeroDeEjemplares(estudiantes.get(indexE).getNumeroDeEjemplares() + 1);
            tesis.get(index).setPrestado(true);
            try {
                file.guardarDatosEjemplar(new ArrayList<Libro>(), tesis);
                file.guardarDatosUsuario(estudiantes, new ArrayList<Profesor>());
            } catch (IOException e) {
                JOptionPane.showMessageDialog(null, "No se ha podigo guardar correctamente", "Error de E/S",
                        JOptionPane.ERROR_MESSAGE);
                e.printStackTrace();
            }

        }
    }

    public void agregarLibroAProfesor(int index, int indexP) {
        cargarLibros();
        cargarProfesores();
        if (profesores.get(index).getNumeroDeEjemplares() > 5) {
            JOptionPane.showConfirmDialog(null, "Lo sentimos, el usuario ya no puede adquirir más libros");
        } else {
            profesores.get(indexP).getLibros().add(libros.get(index));
            profesores.get(indexP).setNumeroDeEjemplares(profesores.get(indexP).getNumeroDeEjemplares() + 1);
            libros.get(index).setPrestado(true);
            try {
                file.guardarDatosUsuario(new ArrayList<Estudiante>(), profesores);
                file.guardarDatosEjemplar(libros, new ArrayList<Tesis>());
            } catch (IOException e) {
                JOptionPane.showMessageDialog(null, "No se ha podigo guardar correctamente", "Error de E/S",
                        JOptionPane.ERROR_MESSAGE);
                e.printStackTrace();
            }
        }

    }

    public void agregarTesisAProfesor(int index, int indexP) {
        cargarTesis();
        cargarProfesores();
        if (profesores.get(indexP).getNumeroDeEjemplares() > 5) {
            JOptionPane.showConfirmDialog(null, "Lo sentimos, el usuario ya no puede adquirir más libros");
        } else {
            profesores.get(indexP).getTesis().add(tesis.get(index));
            profesores.get(indexP).setNumeroDeEjemplares(profesores.get(indexP).getNumeroDeEjemplares() + 1);
            tesis.get(index).setPrestado(true);
            try {
                file.guardarDatosEjemplar(new ArrayList<Libro>(), tesis);
                file.guardarDatosUsuario(new ArrayList<Estudiante>(), profesores);
            } catch (IOException e) {
                JOptionPane.showMessageDialog(null, "No se ha podigo guardar correctamente", "Error de E/S",
                        JOptionPane.ERROR_MESSAGE);
                e.printStackTrace();
            }
        }

    }

    public void cargarLibros() {
        try {
            setLibros(file.leerDatosLibros());
        } catch (ClassNotFoundException | IOException e) {
            JOptionPane.showConfirmDialog(null, "No se ha podido leer o encontrar el archivo :( ", "ERROR",
                    JOptionPane.WARNING_MESSAGE);
            e.printStackTrace();
        }
    }

    public void cargarTesis() {
        try {
            setTesis(file.leerDatosTesis());
        } catch (ClassNotFoundException | IOException e) {
            JOptionPane.showConfirmDialog(null, "No se ha podido leer o encontrar el archivo :( ", "ERROR",
                    JOptionPane.WARNING_MESSAGE);
            e.printStackTrace();
        }
    }

    public void cargarProfesores() {
        try {
            setProfesores(file.leerDatosProfesores());
        } catch (ClassNotFoundException | IOException e) {
            JOptionPane.showConfirmDialog(null, "No se ha podido leer o encontrar el archivo :( ", "ERROR",
                    JOptionPane.WARNING_MESSAGE);
            e.printStackTrace();
        }
    }

    public void cargarEstudiantes() {
        try {
            setEstudiantes(file.leerDatosEstudiantes());
        } catch (ClassNotFoundException | IOException e) {
            JOptionPane.showConfirmDialog(null, "No se ha podido leer o encontrar el archivo :( ", "ERROR",
                    JOptionPane.WARNING_MESSAGE);
            e.printStackTrace();
        }
    }

    public void setEstudiantes(ArrayList<Estudiante> estudiantes) {
        this.estudiantes = estudiantes;
    }

    public void setProfesores(ArrayList<Profesor> profesores) {
        this.profesores = profesores;
    }

    public void setLibros(ArrayList<Libro> libros) {
        this.libros = libros;
    }

    public void setTesis(ArrayList<Tesis> tesis) {
        this.tesis = tesis;
    }

    public ArrayList<Estudiante> getEstudiantes() {
        return estudiantes;
    }

    public ArrayList<Profesor> getProfesores() {
        return profesores;
    }

    public ArrayList<Libro> getLibros() {
        return libros;
    }

    public ArrayList<Tesis> getTesis() {
        return tesis;
    }
}