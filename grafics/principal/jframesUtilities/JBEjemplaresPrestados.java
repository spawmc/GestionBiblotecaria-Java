package grafics.principal.jframesUtilities;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import files.ArchivoBinario;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Color;
import java.awt.Font;
import java.util.ArrayList;

public class JBEjemplaresPrestados extends JFrame {

	private JButton jBAceptar;

	//Manejador de archivos
	ArchivoBinario file = new ArchivoBinario();

	private JList<String> listaLibros;
	private JList<String> listaTesis;

	ArrayList<Libro> libros;
	ArrayList<Tesis> tesis;

	public JBEjemplaresPrestados() {
		super("Ejemplares prestados");
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
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	}

	private JPanel _crearPanelSur() {
		JPanel p = new JPanel(new FlowLayout());
		jBAceptar = new JButton("Aceptar");
		p.add(jBAceptar);
		return p;
	}

	private JPanel _crearPanelCentral() {
		JPanel p = new JPanel(new BorderLayout());
		JPanel panelNorte = new JPanel(new FlowLayout());
		JPanel panelCentral = new JPanel(new FlowLayout());

		cargarLibros();
		String[] 
		//TODO: Pendiente, en todo caso sacarlo si no funciona


		p.add(panelNorte, BorderLayout.NORTH);
		p.add(panelCentral, BorderLayout.CENTER);
		return p;
	}

	private JPanel _crearPanelNorte() {
		JPanel p = new JPanel(new FlowLayout());
		JLabel saludo = new JLabel(this.getTitle());

		// Modificando el tamaño de la fuente
		Font fontAux = saludo.getFont();
		saludo.setFont(new Font(fontAux.getFontName(), fontAux.getStyle(), 28));

		// Configuraciones
		p.setBackground(new Color(32, 64, 81)); // Color oscuro
		saludo.setForeground(Color.WHITE); // Color claro

		p.add(saludo);

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

	public static void main(String[] args) {
		new JBEjemplaresPrestados();
	}

}