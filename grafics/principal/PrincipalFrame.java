package grafics.principal;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import ejemplares.Libro;
import ejemplares.Tesis;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.util.ArrayList;

import util.UtilJList;

//Events
import java.awt.event.*;

import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

public class PrincipalFrame extends JFrame {

	private JButton jBAñadirUsuario;
	private JButton jBAñadirTesis;
	private JButton jBAñadirLibro;
	private JButton jBMostrarEjemplaresPrestados;

	private JButton jBSalir;

	private JButton jBPrestar;
	private JButton jBCancelar;

	// Componenetes del panel
	private JList<String> listaLibros;
	private JList<String> listaTesis;
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

		pack();
		setLocationRelativeTo(null);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}// Final constructor

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

	private JPanel _crearPanelCentralDerecho() {
		JPanel p = new JPanel();
		p.setLayout(new FlowLayout());
		jBPrestar = new JButton("Prestar");
		jBCancelar = new JButton("Cancelar");
		jBCancelar.addActionListener(new EscuchaCancelar());
		jBPrestar.addActionListener(new EscuchaPrestar());

		p.add(jBCancelar);
		p.add(jBPrestar);

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

	private JPanel _crearPanelCentralIzquierdo() {
		JPanel p = new JPanel(new BorderLayout());
		// Paneles divisores para los list y los su titulo
		JPanel panelIzquierdo = new JPanel();
		JPanel panelDerecho = new JPanel();
		// Panel para dividir el sector del libro y su titulo
		JPanel panelJListLibros = new JPanel(new BorderLayout());
		JPanel panelJListTesis = new JPanel(new BorderLayout());

		/*
		 * Se traen los lirbos con las siguentes funciones y se saca el nombre de cada
		 * uno de ellos
		 */
		libros = Libro.makeBookList();
		String[] nombreLibros = new String[libros.size()];
		nombreLibros = UtilJList.sacarNombreLibros(libros);

		/*
		 * Se traen las tesis con las siguentes funciones y se saca el nombre de cada
		 * uno de ellos
		 */
		tesis = Tesis.makeTesisList();
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
			listaTesis.clearSelection(); // Quitar la seleccion de tesis
		}

	} // Final class EscuchaSelecionLibro

	class EscuchaSeleccionTesis implements ListSelectionListener {

		@Override
		public void valueChanged(ListSelectionEvent e) {
			int index = listaTesis.getSelectedIndex();
			jlTitulo.setText(": Titulo: " + tesis.get(index).getTitulo());
			jlAño.setText(" Año: " + tesis.get(index).getAño());
			jlClasificacion.setText(" Clasificacion: " + tesis.get(index).getClasificacion());
			jlDirector.setText(" Director: " + tesis.get(index).getDirector());
			jlTipoTesis.setText(" Tipo de tesis: " + tesis.get(index).getTipoTesis());
			jlAutores.setText(" Autores: " + tesis.get(index).getAutores());
			jlEdicion.setText("");
			jlIsbn.setText("");
			jlArea.setText("");
			jlSubarea.setText("");
			listaTesis.clearSelection(); // Quita la seleccion de libro
		}

	}

	class EscuchaCancelar implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent arg0) {
			System.out.println("Cancelar");
		}

	}

	class EscuchaPrestar implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent arg0) {
			System.out.println("Prestar");
		}

	}

	class EscuchaAñadirUsuario implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			System.out.println("Añadir usuario");
		}

	}

	class EscuchaAñadirTesis implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			System.out.println("Añadir tesis");
		}

	}

	class EscuchaAñadirLibro implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			System.out.println("Añadir libro");
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

}// Final class