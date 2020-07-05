import java.io.IOException;
import java.util.ArrayList;

import ejemplares.Area;
import ejemplares.Tesis;
import files.ArchivoBinario;
import usuarios.Estudiante;
import usuarios.Profesor;

public class MainPrueba {
	public static void main(String[] args) {
		ArrayList<Tesis.TipoTesis> tiposdetesis = new ArrayList<>();
		tiposdetesis.add(new Tesis.TipoTesis("Documental(teórica)"));
		tiposdetesis.add(new Tesis.TipoTesis("Investigación de campo8práctica"));
		tiposdetesis.add(new Tesis.TipoTesis("Teórico-práctica"));
		tiposdetesis.add(new Tesis.TipoTesis("Descriptiva"));
		tiposdetesis.add(new Tesis.TipoTesis("Analitica"));

		ArrayList<Estudiante> listEstudiante = new ArrayList<>();
		listEstudiante.add(new Estudiante("Miguel", "Col Miguel Aleman", 2288480321L, "123423423"));

		for (int i = 0; i < listEstudiante.size(); i++) {
			System.out.println(listEstudiante.get(i));
		}

		ArchivoBinario file = new ArchivoBinario();

		ArrayList<Estudiante> tmpEstudiantes = new ArrayList<>();
		try {
			file.guardarDatosUsuario(listEstudiante, new ArrayList<Profesor>());
			tmpEstudiantes = file.leerDatosEstudiantes();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

		for (int i = 0; i < tmpEstudiantes.size(); i++) {
			System.out.println(tmpEstudiantes.get(i));
		}

		ArrayList<Profesor> listProfesor = new ArrayList<>();
		listProfesor.add(new Profesor("Arturo", "Col Miguel Aleman", 2288339945L, "11231231231232"));

		ArrayList<Profesor> tmpProfesor = new ArrayList<>();
		try {
			file.guardarDatosUsuario(new ArrayList<Estudiante>(), listProfesor);
			tmpProfesor = file.leerDatosProfesores();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

		for (int i = 0; i < tmpProfesor.size(); i++) {
			System.out.println(tmpProfesor.get(i));
		}

	}// Final main

	public static ArrayList<Area.SubArea> makeSubArea() {
		ArrayList<Area.SubArea> subareas = new ArrayList<>();
		subareas.add(new Area.SubArea("Biologia"));
		return subareas;
	}
}