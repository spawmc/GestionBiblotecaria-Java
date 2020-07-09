package grafics.principal.jframesUtilities.prestamos;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import ejemplares.Libro;
import ejemplares.Tesis;
import files.ArchivoBinario;
import grafics.principal.PrincipalFrame;
import usuarios.Estudiante;
import usuarios.Profesor;
import util.Gerente;
import util.Mensajero;
import util.UtilJList;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.io.IOException;
import java.util.ArrayList;
import java.awt.Color;

import java.awt.event.*;

public class PrestarLibro extends JFrame {

	private ArchivoBinario file = new ArchivoBinario();

	private ArrayList<Estudiante> estudiantes = null;
	private ArrayList<Profesor> profesores = null;
	private ArrayList<Libro> libros = null;

	private JButton jBCancelar;

	private JList<String> jLEstudiantes = null;
	private JList<String> jlProfesores = null;

	public PrestarLibro() {
		super("Prestar libro");
		setLayout(new BorderLayout());

		JPanel panelNorte = _crearPanelNorte();
		add(panelNorte, BorderLayout.NORTH);

		JPanel panelCentro = _crearPanelCentral();
		add(panelCentro, BorderLayout.CENTER);

		JPanel panelSur = _crearPanelSur();
		add(panelSur, BorderLayout.SOUTH);

		pack();
		setLocationRelativeTo(null);
		setVisible(true);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
	}

	public void cargarLibros() {
		try {
			System.out.println("Cargando libros");
			setLibros(file.leerDatosLibros());
		} catch (ClassNotFoundException | IOException e) {
			JOptionPane.showConfirmDialog(null, "No se ha podido leer o encontrar el archivo :( ", "ERROR",
					JOptionPane.WARNING_MESSAGE);
			e.printStackTrace();
		}
	}

	public JList<String> getJlProfesores() {
		return jlProfesores;
	}

	public void setJlProfesores(JList<String> jlProfesores) {
		this.jlProfesores = jlProfesores;
	}

	public JList<String> getjLEstudiantes() {
		return jLEstudiantes;
	}

	public void setjLEstudiantes(JList<String> jLEstudiantes) {
		this.jLEstudiantes = jLEstudiantes;
	}

	public ArrayList<Libro> getLibros() {
		return libros;
	}

	public void setLibros(ArrayList<Libro> libros) {
		this.libros = libros;
	}

	public void cargarProfesores() {
		try {
			System.out.println("Cargando profesoress");
			setProfesores(file.leerDatosProfesores());
		} catch (ClassNotFoundException | IOException e) {
			JOptionPane.showConfirmDialog(null, "No se ha podido leer o encontrar el archivo :( ", "ERROR",
					JOptionPane.WARNING_MESSAGE);
			e.printStackTrace();
		}
	}

	public void cargarEstudiantes() {
		try {
			System.out.println("Cargando estudiantesssss");
			setEstudiantes(file.leerDatosEstudiantes());
		} catch (ClassNotFoundException | IOException e) {
			JOptionPane.showConfirmDialog(null, "No se ha podido leer o encontrar el archivo :( ", "ERROR",
					JOptionPane.WARNING_MESSAGE);
			e.printStackTrace();
		}
	}

	private JPanel _crearPanelSur() {
		JPanel p = new JPanel(new FlowLayout(FlowLayout.CENTER));
		jBCancelar = new JButton("Cancelar");
		jBCancelar.addActionListener(new EscuchaCancelar());
		p.add(jBCancelar);
		return p;
	}

	private JPanel _crearPanelCentral() {
		JPanel p = new JPanel(new BorderLayout());
		// Paneles divisores para loas Jlist y su titulo
		JPanel panelIzquierdo = new JPanel(new BorderLayout());
		JPanel panelDerecho = new JPanel(new BorderLayout());
		// Titulos Jpanels
		panelIzquierdo.add(new JLabel("Estudiantes"), BorderLayout.NORTH);
		panelDerecho.add(new JLabel("Profesores"), BorderLayout.NORTH);
		// JPanels contenedores de JList
		JPanel panelJListEstudiantes = new JPanel(new FlowLayout());
		JPanel panelJListProfesores = new JPanel(new FlowLayout());

		cargarEstudiantes();
		String[] nombreEstudiantes = new String[estudiantes.size()];
		nombreEstudiantes = UtilJList.sacarNombreEstudiantes(estudiantes);

		cargarProfesores();
		String[] nombreProfesores = new String[profesores.size()];
		nombreProfesores = UtilJList.sacarNombreProfesores(profesores);

		jLEstudiantes = new JList<>(nombreEstudiantes);
		jlProfesores = new JList<>(nombreProfesores);

		jLEstudiantes.setVisibleRowCount(10);
		jlProfesores.setVisibleRowCount(10);

		JScrollPane jscrollDesplazamientoEstudiantes = new JScrollPane(jLEstudiantes);
		JScrollPane jscrollDesplazamientoProfesor = new JScrollPane(jlProfesores);

		panelJListEstudiantes.add(jscrollDesplazamientoEstudiantes);
		panelJListProfesores.add(jscrollDesplazamientoProfesor);

		JPanel botonesEstudiantes = new JPanel(new FlowLayout());
		JPanel botonesProfesor = new JPanel(new FlowLayout());
		jBCancelarE = new JButton("Cancelar");
		jBCancelarP = new JButton("Cancelar");
		jBPrestarE = new JButton("Prestar");
		jBPrestarP = new JButton("Prestar");

		jBCancelarE.addActionListener(new EscuchaCancelarE());
		jBCancelarP.addActionListener(new EscuchaCancelarP());
		jBPrestarE.addActionListener(new EscuchaPrestarE());
		jBPrestarP.addActionListener(new EscuchaPrestarP());

		botonesEstudiantes.add(jBCancelarE);
		botonesEstudiantes.add(jBPrestarE);
		botonesProfesor.add(jBCancelarP);
		botonesProfesor.add(jBPrestarP);

		panelIzquierdo.add(botonesEstudiantes, BorderLayout.SOUTH);
		panelDerecho.add(botonesProfesor, BorderLayout.SOUTH);
		panelIzquierdo.add(panelJListEstudiantes, BorderLayout.CENTER);
		panelDerecho.add(panelJListProfesores, BorderLayout.CENTER);

		p.add(panelIzquierdo, BorderLayout.WEST);
		p.add(panelDerecho, BorderLayout.EAST);
		return p;

	}

	JButton jBCancelarE = null;
	JButton jBPrestarE = null;
	JButton jBCancelarP = null;
	JButton jBPrestarP = null;

	private JPanel _crearPanelNorte() {
		JPanel p = new JPanel(new FlowLayout(FlowLayout.CENTER));
		p.setBackground(new Color(32, 64, 81));
		p.setForeground(Color.WHITE);
		p.add(new JLabel(this.getTitle()));
		return p;
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

	class EscuchaCancelar implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			System.out.println("Cancelar");
			dispose();
		}

	}

	class EscuchaPrestarE implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			System.out.println("prestar");
			cargarLibros();
			System.out.println(jLEstudiantes.getSelectedIndex() + "posicion en la lista de estudiantes");
			Mensajero index = Mensajero.getInstance();
			System.out.println(index.getPosicion() + "posicion en la lista de libros");
			if (!jLEstudiantes.isSelectionEmpty()) {
				if (!(libros.get(index.getPosicion()).esPrestado())) {
					Gerente gen = new Gerente();
					gen.agregarLibroAEstudiante(index.getPosicion(), jLEstudiantes.getSelectedIndex());
					JOptionPane.showConfirmDialog(null, "Se a guardado la información del prestamo");
					dispose();

				} else {
					JOptionPane.showMessageDialog(null, "El libro ya ha sido prestado");
				}
			} else {
				JOptionPane.showMessageDialog(null, "Seleccione un estudiante");
			}

		}

	}

	class EscuchaPrestarP implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			System.out.println("prestar");
			cargarLibros();
			Mensajero index = Mensajero.getInstance();
			System.out.println(index.getPosicion());

			if (!(libros.get(index.getPosicion()).esPrestado())) {
				Gerente gen = new Gerente();
				gen.agregarLibroAProfesor(index.getPosicion(), jlProfesores.getSelectedIndex());
				JOptionPane.showConfirmDialog(null, "Se a guardado la información del prestamo");
				dispose();

			} else {
				JOptionPane.showMessageDialog(null, "El libro ya ha sido prestado");
			}

		}

	}

	class EscuchaCancelarE implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			if (!jLEstudiantes.isSelectionEmpty()) {
				jLEstudiantes.clearSelection();
			}

		}

	}

	class EscuchaCancelarP implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			if (!jlProfesores.isSelectionEmpty()) {
				jLEstudiantes.clearSelection();
			}
		}

	}

	public static void main(String[] args) {
		new PrestarLibro();
	}

}