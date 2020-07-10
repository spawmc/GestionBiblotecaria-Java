package util;

import usuarios.*;

import java.io.IOException;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import ejemplares.*;
import files.ArchivoBinario;

public class GestorDeEjemplares {
    private static GestorDeEjemplares gde;

    private ArrayList<Estudiante> estudiantes = null;
    private ArrayList<Profesor> profesores = null;
    private ArrayList<Libro> libros = null;
    private ArrayList<Tesis> tesis = null;

    private ArchivoBinario file = new ArchivoBinario();

    private GestorDeEjemplares() {
    }

    public static GestorDeEjemplares getInstance() {
        if (gde == null)
            gde = new GestorDeEjemplares();
        return gde;
    }

    public ArrayList<Tesis> getTesis() {
        return tesis;
    }

    public void setTesis(ArrayList<Tesis> tesis) {
        this.tesis = tesis;
    }

    public ArrayList<Libro> getLibros() {
        return libros;
    }

    public void setLibros(ArrayList<Libro> libros) {
        this.libros = libros;
    }

    public ArrayList<Profesor> getProfesores() {
        return profesores;
    }

    public void setProfesores(ArrayList<Profesor> profesores) {
        this.profesores = profesores;
    }

    public ArrayList<Estudiante> getEstudiantes() {
        return estudiantes;
    }

    public void setEstudiantes(ArrayList<Estudiante> estudiantes) {
        this.estudiantes = estudiantes;
    }

    public void guardarDatosLibro(ArrayList<Libro> libros_aux) {
        try {
            file.guardarDatosEjemplar(libros_aux, new ArrayList<Tesis>());
        } catch (IOException e) {
            JOptionPane.showConfirmDialog(null, "No se ha podido guardar la informacion :( ", "ERROR",
                    JOptionPane.WARNING_MESSAGE);
            e.printStackTrace();
        }
    }

    public void guardarDatosTesis(ArrayList<Tesis> tesis_aux) {
        try {
            file.guardarDatosEjemplar(new ArrayList<Libro>(), tesis_aux);
        } catch (IOException e) {
            JOptionPane.showConfirmDialog(null, "No se ha podido guardar la informacion :( ", "ERROR",
                    JOptionPane.WARNING_MESSAGE);
            e.printStackTrace();
        }
    }

    public void guardarDatosEstudiante(ArrayList<Estudiante> estudiante_aux) {
        try {
            file.guardarDatosUsuario(estudiante_aux, new ArrayList<Profesor>());
        } catch (IOException e) {
            JOptionPane.showConfirmDialog(null, "No se ha podido guardar la informacion :( ", "ERROR",
                    JOptionPane.WARNING_MESSAGE);
            e.printStackTrace();
        }
    }

    public void guardarDatosProfesor(ArrayList<Profesor> profesor_aux) {
        try {
            file.guardarDatosUsuario(new ArrayList<Estudiante>(), profesor_aux);
        } catch (IOException e) {
            JOptionPane.showConfirmDialog(null, "No se ha podido guardar la informacion :( ", "ERROR",
                    JOptionPane.WARNING_MESSAGE);
            e.printStackTrace();
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
}