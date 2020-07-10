package grafics.principal.jframesUtilities.devoluciones;

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
import util.UtilJList;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.io.IOException;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class RegresarLibro extends JFrame {

	public RegresarLibro() {
		super("Regresar libro");
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

	private JButton jBRegresar;
	private JButton jBCancelar;
	private JButton jBsalir;

	private JPanel _crearPanelSur() {
		JPanel p = new JPanel(new FlowLayout());
		jBsalir = new JButton("Salir");
		jBsalir.addActionListener(new EscuchaSalir());
		p.add(jBsalir);
		return p;
	}

	private JPanel _crearPanelCentral() {
		JPanel p = new JPanel();
		JPanel panelJlist = _clearPanelJlist();
		JPanel panelButtons = new JPanel(new FlowLayout());
		jBRegresar = new JButton("Regresar");
		jBCancelar = new JButton("Cancelar");
		jBRegresar.addActionListener(new EscuchaRegresar());
		jBCancelar.addActionListener(new EscuchuchaCancelar());
		panelButtons.add(jBCancelar);
		panelButtons.add(jBRegresar);

		p.add(panelJlist, BorderLayout.NORTH);
		p.add(panelButtons, BorderLayout.CENTER);

		return p;
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

	ArchivoBinario file = new ArchivoBinario();

	ArrayList<Libro> libros = null;

	public ArrayList<Libro> getLibros() {
		return libros;
	}

	public void setLibros(ArrayList<Libro> libros) {
		this.libros = libros;
	}

	private JList<String> jlLibros;

	private String[] nombreLibrosFiltrado;

	private JPanel _clearPanelJlist() {
		JPanel p = new JPanel(new BorderLayout());
		p.add(new JLabel("Libros prestados"), BorderLayout.NORTH);
		cargarLibros();

		nombreLibrosFiltrado = new String[libros.size()];

		for (int i = 0; i < libros.size(); i++) {
			if (libros.get(i).esPrestado()) {
				nombreLibrosFiltrado[i] = libros.get(i).getTitulo();
			}
		}

		jlLibros = new JList<>(nombreLibrosFiltrado);
		jlLibros.setVisibleRowCount(10);

		JScrollPane jscroll = new JScrollPane(jlLibros);

		p.add(jscroll, BorderLayout.CENTER);

		return p;
	}

	private JPanel _crearPanelNorte() {
		JPanel p = new JPanel(new FlowLayout(FlowLayout.CENTER));
		p.setBackground(new Color(32, 64, 81));
		p.setForeground(Color.WHITE);
		JLabel title = new JLabel(this.getTitle());
		title.setForeground(Color.WHITE);
		p.add(title);
		return p;
	}

	class EscuchaRegresar implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			System.out.println("Regresar");
			int posicionList = jlLibros.getSelectedIndex();

			String[] nombresLibrosOriginal = new String[libros.size()];
			nombresLibrosOriginal = UtilJList.sacarNombreLibros(libros);

			int ward = 0;
			for (int i = 0; i < libros.size(); i++) {
				if (nombresLibrosOriginal.equals(nombreLibrosFiltrado)) {
					ward = i;
				}
			}

			libros.get(ward).setPrestado(false);
			try {
				file.guardarDatosEjemplar(libros, new ArrayList<Tesis>());
			} catch (IOException e1) {
				JOptionPane.showConfirmDialog(null, "No se ha podido guardar la informacion :( ", "ERROR",
						JOptionPane.WARNING_MESSAGE);
				e1.printStackTrace();
			}
		}

	}

	class EscuchuchaCancelar implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			System.out.println("Cancelar");
			if (jlLibros.isSelectionEmpty())
				jlLibros.clearSelection();
		}

	}

	class EscuchaSalir implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			System.out.println("Salir");
			new PrincipalFrame();
			dispose();

		}

	}

	public static void main(String[] args) {
		new RegresarLibro();
	}

}
