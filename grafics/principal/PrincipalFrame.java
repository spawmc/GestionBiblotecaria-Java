package grafics.principal;

import javax.swing.BoxLayout;
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
import grafics.principal.jframesUtilities.JFAddLibro;
import grafics.principal.jframesUtilities.JFAddTesis;
import grafics.principal.jframesUtilities.JFAddUser;
import grafics.principal.jframesUtilities.prestamos.PrestarLibro;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.util.ArrayList;

import util.Mensajero;
import util.UtilJList;

//Events
import java.awt.event.*;
import java.io.IOException;

import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

public class PrincipalFrame extends JFrame {

	private JButton jBAñadirUsuario;
	private JButton jBAñadirTesis;
	private JButton jBAñadirLibro;
	private JButton jBMostrarEjemplaresPrestados;

	private JButton jBSalir;
	private JButton jBPrestarT;
	private JButton jBCancelarT;

	private JButton jBPrestarL;
	private JButton jBCancelarL;

	private Mensajero index = null;

	// Componenetes del panel
	private JList<String> listaLibros;
	private JList<String> listaTesis;

	public JList<String> getListaLibros() {
		return listaLibros;
	}

	public JList<String> getListaTesis() {
		return listaTesis;
	}

	// Manejador de archivos
	ArchivoBinario file = new ArchivoBinario();

	// Contenedores
	ArrayList<Libro> libros;
	ArrayList<Tesis> tesis;

	// Componentes
	JLabel displayLabeltoString;
	String textDisplayLabeltoString = "Detalles de los libros";
	// JLabels
	JLabel jlTitulo;
	JLabel jlAño;
	JLabel jlAutores;
	JLabel jlClasificacion;
	JLabel jlEdicion;
	JLabel jlIsbn;
	JLabel jlArea;
	JLabel jlSubarea;
	JLabel jlDirector;
	JLabel jlTipoTesis;
	JLabel jlPrestado;

	public PrincipalFrame() {
		super("Gestion Bibliotecaria");
		setLayout(new BorderLayout());

		JPanel panelNorte = _crearPanelNorte();
		add(panelNorte, BorderLayout.NORTH);

		JPanel panelCentral = _crearPanelCentral();
		add(panelCentral, BorderLayout.CENTER);

		JPanel panelSur = _crearPanelSur();
		add(panelSur, BorderLayout.SOUTH);

		setSize(900, 350);
		setLocationRelativeTo(null);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}// Final constructor

	public ArrayList<Libro> getLibros() {
		return libros;
	}

	public ArrayList<Tesis> getTesis() {
		return tesis;
	}

	public void setLibros(ArrayList<Libro> libros) {
		this.libros = libros;
	}

	public void setTesis(ArrayList<Tesis> tesis) {
		this.tesis = tesis;
	}

	private JPanel _crearPanelCentral() {
		JPanel p = new JPanel(new BorderLayout());

		JPanel panelCentralIzquierdo = _crearPanelCentralIzquierdo();
		JPanel panelCentralCentro = _crearPanelCentralCentro();
		JPanel panelCentralDerecho = _crearPanelCentralDerecho();

		p.add(panelCentralIzquierdo, BorderLayout.WEST);
		p.add(panelCentralCentro, BorderLayout.CENTER);
		p.add(panelCentralDerecho, BorderLayout.EAST);

		return p;
	}

	private JButton jBRegresarLibro = null;
	private JButton jBRegresarTesis = null;

	private JPanel _crearPanelCentralDerecho() {
		JPanel p = new JPanel(new BorderLayout());
		JPanel panelNorte = new JPanel(new FlowLayout());
		JPanel panelCentral = new JPanel();
		panelCentral.setLayout(new BoxLayout(panelCentral, BoxLayout.Y_AXIS));

		jBRegresarLibro = new JButton("Regresar libro");
		jBRegresarTesis = new JButton("Regresar tesis");
		panelNorte.add(new JLabel("        "));

		jBRegresarLibro.addActionListener(new EscuchaRegresarLibro());
		jBRegresarTesis.addActionListener(new EscuchaRegresarTesis());

		panelCentral.add(jBRegresarLibro);
		panelCentral.add(jBRegresarTesis);

		p.add(panelNorte, BorderLayout.NORTH);
		p.add(panelCentral, BorderLayout.CENTER);
		return p;
	}

	private JPanel _crearPanelCentralCentro() {
		JPanel p = new JPanel(new BorderLayout());
		JPanel panelJLabel = new JPanel(new FlowLayout());
		JPanel panelJLabelDisplayToString = new JPanel();
		panelJLabelDisplayToString.setLayout(new BoxLayout(panelJLabelDisplayToString, BoxLayout.Y_AXIS));
		// Creacion Jlabels
		jlTitulo = new JLabel(" Titulo: ");
		jlAño = new JLabel(" Año: ");
		jlAutores = new JLabel(" Autores: ");
		jlClasificacion = new JLabel(" Clasificación: ");
		jlEdicion = new JLabel(" Edición: ");
		jlIsbn = new JLabel(" ISBN: ");
		jlArea = new JLabel(" Area: ");
		jlSubarea = new JLabel(" Sub-Area: ");
		jlDirector = new JLabel(" Director: ");
		jlTipoTesis = new JLabel(" Tipo de tesis: ");
		jlPrestado = new JLabel(" Prestado: ");

		// Agregacion al panel display
		panelJLabelDisplayToString.add(jlTitulo);
		panelJLabelDisplayToString.add(jlAño);
		panelJLabelDisplayToString.add(jlAutores);
		panelJLabelDisplayToString.add(jlClasificacion);
		panelJLabelDisplayToString.add(jlEdicion);
		panelJLabelDisplayToString.add(jlIsbn);
		panelJLabelDisplayToString.add(jlArea);
		panelJLabelDisplayToString.add(jlSubarea);
		panelJLabelDisplayToString.add(jlDirector);
		panelJLabelDisplayToString.add(jlTipoTesis);
		panelJLabelDisplayToString.add(jlPrestado);

		// panel Jlabel content
		panelJLabel.add(new JLabel("Detalles"));
		// Panel displaytoString

		p.add(panelJLabel, BorderLayout.NORTH);
		p.add(panelJLabelDisplayToString, BorderLayout.CENTER);
		return p;
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

	private JPanel _crearPanelCentralIzquierdo() {
		JPanel p = new JPanel(new BorderLayout());
		// Paneles divisores para los list y los su titulo
		JPanel panelIzquierdo = new JPanel();
		JPanel panelDerecho = new JPanel();
		// Panel para dividir el sector del libro y su titulo
		JPanel panelJListLibros = new JPanel(new BorderLayout());
		JPanel panelJListTesis = new JPanel(new BorderLayout());

		JPanel panelJListLibrosSur = new JPanel(new FlowLayout());
		JPanel panelJListTesisSur = new JPanel(new FlowLayout());
		// Se instancian botones del lado sur
		jBPrestarL = new JButton("Prestar libro");
		jBPrestarT = new JButton("Prestar tesis");
		jBCancelarL = new JButton("Cancelar");
		jBCancelarT = new JButton("Cancelar");

		jBPrestarL.addActionListener(new EscuchaPrestarL());
		jBPrestarT.addActionListener(new EscuchaPrestaT());
		jBCancelarL.addActionListener(new EscuchaCancelarL());
		jBCancelarT.addActionListener(new EscuchaCancelarT());

		panelJListLibrosSur.add(jBCancelarL);
		panelJListLibrosSur.add(jBPrestarL);

		panelJListTesisSur.add(jBCancelarT);
		panelJListTesisSur.add(jBPrestarT);

		/*
		 * Se traen los lirbos con las siguentes funciones y se saca el nombre de cada
		 * uno de ellos
		 */
		cargarLibros();
		String[] nombreLibros = new String[libros.size()];
		nombreLibros = UtilJList.sacarNombreLibros(libros);

		/*
		 * Se traen las tesis con las siguentes funciones y se saca el nombre de cada
		 * uno de ellos
		 */
		cargarTesis();
		String[] nombreTesis = new String[tesis.size()];
		nombreTesis = UtilJList.sacarNombreTesis(tesis);

		// Se crean los jlist
		listaLibros = new JList<>(nombreLibros);
		listaTesis = new JList<>(nombreTesis);
		// Tamaño de los elementos del JList
		listaLibros.setVisibleRowCount(10);
		listaTesis.setVisibleRowCount(10);
		// Se crea el ScrollPanel para los jlist
		JScrollPane jscrollDesplazamientoL = new JScrollPane(listaLibros);
		JScrollPane jscrollDesplazamientoT = new JScrollPane(listaTesis);
		// AccionesJList
		listaLibros.addListSelectionListener(new EscuchaSelecionLibro());
		listaTesis.addListSelectionListener(new EscuchaSeleccionTesis());

		// Se configuran los paneles y se agregan sus componentes
		panelJListLibros.add(new JLabel("Libros"), BorderLayout.NORTH);
		panelJListLibros.add(jscrollDesplazamientoL, BorderLayout.CENTER);
		panelJListTesis.add(new JLabel("Tesis"), BorderLayout.NORTH);
		panelJListTesis.add(jscrollDesplazamientoT, BorderLayout.CENTER);

		panelJListLibros.add(panelJListLibrosSur, BorderLayout.SOUTH);
		panelJListTesis.add(panelJListTesisSur, BorderLayout.SOUTH);

		// Se agregan a los paneles correspondientes
		panelIzquierdo.add(panelJListLibros, BorderLayout.WEST);
		panelDerecho.add(panelJListTesis, BorderLayout.CENTER);

		// Agregacion al panel principal
		p.add(panelIzquierdo, BorderLayout.WEST);
		p.add(panelDerecho, BorderLayout.CENTER);
		return p;
	}

	private JPanel _crearPanelSur() {
		JPanel p = new JPanel(new BorderLayout());
		JPanel panelIzquiero = new JPanel(new FlowLayout(FlowLayout.LEFT));
		JPanel panelDerecho = new JPanel(new FlowLayout(FlowLayout.RIGHT));
		jBAñadirUsuario = new JButton("Añadir usuario");
		jBAñadirTesis = new JButton("Añadir tesis");
		jBAñadirLibro = new JButton("Añadir libro");
		jBMostrarEjemplaresPrestados = new JButton("Ejemplares prestados");

		// Actions listeners
		jBAñadirUsuario.addActionListener(new EscuchaAñadirUsuario());
		jBAñadirTesis.addActionListener(new EscuchaAñadirTesis());
		jBAñadirLibro.addActionListener(new EscuchaAñadirLibro());
		jBMostrarEjemplaresPrestados.addActionListener(new EscuchaEjemplaresPrestados());

		panelIzquiero.add(jBAñadirUsuario);
		panelIzquiero.add(jBAñadirTesis);
		panelIzquiero.add(jBAñadirLibro);
		panelIzquiero.add(jBMostrarEjemplaresPrestados);

		jBSalir = new JButton("Salir");
		// Action Listeners
		jBSalir.addActionListener(new EscuchaSalir());
		panelDerecho.add(jBSalir);

		p.add(panelIzquiero, BorderLayout.WEST);
		p.add(panelDerecho, BorderLayout.EAST);

		return p;
	}

	private JPanel _crearPanelNorte() {
		JPanel p = new JPanel(new FlowLayout());
		JLabel saludo = new JLabel("Gestion biblotecaria");

		// Modificando el tamaño de la fuente
		Font fontAux = saludo.getFont();
		saludo.setFont(new Font(fontAux.getFontName(), fontAux.getStyle(), 45));

		// Configuraciones
		p.setBackground(new Color(32, 64, 81)); // Color oscuro
		saludo.setForeground(Color.WHITE); // Color claro

		p.add(saludo);

		return p;
	}

	/**
	 * En caso de ser seleccionado, modifica los JLabels de los componentes del
	 * libro, ademas de quitar la seleccion de tesis en caso de estar seleccionado
	 */
	class EscuchaSelecionLibro implements ListSelectionListener {

		@Override
		public void valueChanged(ListSelectionEvent e) {
			int index = listaLibros.getSelectedIndex();
			if (listaLibros.getSelectedIndex() != -1) {
				jlTitulo.setText(" Titulo: " + libros.get(index).getTitulo());
				jlAño.setText(" Año: " + libros.get(index).getAño());
				jlAutores.setText(" Autores: " + libros.get(index).getAutores());
				jlClasificacion.setText(" Clasificación: " + libros.get(index).getClasificacion());
				jlEdicion.setText(" Edición: " + libros.get(index).getEdicion());
				jlIsbn.setText(" ISBN: " + libros.get(index).getIsbn());
				jlArea.setText(" Area: " + libros.get(index).getArea());
				jlSubarea.setText(" Sub-Area: " + libros.get(index).getSubarea());
				jlDirector.setText("");
				jlTipoTesis.setText("");
				jlPrestado.setText(" Prestado: " + libros.get(index).esPrestado());
			} else {
				System.out.println("Sin seleccion");
			}
			if (!listaTesis.isSelectionEmpty()) {
				listaTesis.clearSelection(); // Quitar la seleccion de tesis
			}
		}

	} // Final class EscuchaSelecionLibro

	class EscuchaSeleccionTesis implements ListSelectionListener {

		@Override
		public void valueChanged(ListSelectionEvent e) {
			int index = listaTesis.getSelectedIndex();
			if (listaTesis.getSelectedIndex() != -1) {
				System.out.println("TESIS SELECTION" + index);
				jlTitulo.setText(" Titulo: " + tesis.get(index).getTitulo());
				jlAño.setText(" Año: " + tesis.get(index).getAño());
				jlClasificacion.setText(" Clasificacion: " + tesis.get(index).getClasificacion());
				jlDirector.setText(" Director: " + tesis.get(index).getDirector());
				jlTipoTesis.setText(" Tipo de tesis: " + tesis.get(index).getTipoTesis());
				jlAutores.setText(" Autores: " + tesis.get(index).getAutores());
				jlEdicion.setText("");
				jlIsbn.setText("");
				jlArea.setText("");
				jlSubarea.setText("");
			} else {
				System.out.println("Sin seleccion");
			}
			if (!listaTesis.isSelectionEmpty()) {
				listaTesis.clearSelection(); // Quita la seleccion de libro
			}
		}

	}

	class EscuchaCancelarT implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			if (!listaTesis.isSelectionEmpty()) {
				listaTesis.clearSelection();
			}
			jlTitulo.setText(" Titulo: ");
			jlAño.setText(" Año: ");
			jlAutores.setText(" Autores: ");
			jlClasificacion.setText(" Clasificación: ");
			jlEdicion.setText("");
			jlIsbn.setText("");
			jlArea.setText("");
			jlSubarea.setText("");
			jlDirector.setText(" Director: ");
			jlTipoTesis.setText(" Tipo de tesis: ");
			jlPrestado.setText(" Prestado: ");
		}

	}

	class EscuchaPrestaT implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			System.out.println("Escuchaprestar t");

		}

	}

	class EscuchaCancelarL implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent arg0) {
			if (!listaLibros.isSelectionEmpty()) {
				listaLibros.clearSelection();
			}
			jlTitulo.setText(" Titulo: ");
			jlAño.setText(" Año: ");
			jlAutores.setText(" Autores: ");
			jlClasificacion.setText(" Clasificación: ");
			jlEdicion.setText(" Edición: ");
			jlIsbn.setText(" ISBN: ");
			jlArea.setText(" Area: ");
			jlSubarea.setText(" Sub-Area: ");
			jlDirector.setText("");
			jlTipoTesis.setText("");
			jlPrestado.setText(" Prestado: ");
		}

	}

	class EscuchaPrestarL implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent arg0) {
			System.out.println("Prestarl");
			// int index_list = listaLibros.getSelectedIndex();
			if (listaLibros.getSelectedIndex() != -1) {
				if (libros.get(listaLibros.getSelectedIndex()).esPrestado()) {
					JOptionPane.showMessageDialog(null, "El libro ya ha sido prestado");
				} else {
					index = Mensajero.getInstance();
					System.out.println(listaLibros.getSelectedIndex());
					index.setPosicion(listaLibros.getSelectedIndex());
					new PrestarLibro();
				}
			} else {
				JOptionPane.showMessageDialog(null, "No ha seleccionado ningun libro");
			}

		}

	}

	class EscuchaAñadirUsuario implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			new JFAddUser();
			dispose();
		}

	}

	class EscuchaAñadirTesis implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			System.out.println("Añadir tesis");
			new JFAddTesis();
			dispose();
		}

	}

	class EscuchaAñadirLibro implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			System.out.println("Añadir libro");
			new JFAddLibro();
			dispose();
		}

	}

	class EscuchaEjemplaresPrestados implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			System.out.println("Mostrar ejemplares prestados");
		}

	}

	class EscuchaSalir implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			System.exit(0);
		}

	}

	class EscuchaRegresarLibro implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			System.out.println("Regresar libro");

		}

	}

	class EscuchaRegresarTesis implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			System.out.println("Regresar tesis");
		}

	}

	public static void main(String[] args) {
		new PrincipalFrame();
	}

}// Final class