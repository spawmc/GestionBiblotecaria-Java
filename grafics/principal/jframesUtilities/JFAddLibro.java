package grafics.principal.jframesUtilities;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.BoxLayout;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.TextField;

public class JFAddLibro extends JFrame {

	public JFAddLibro() {
		super("Agregar libro");
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
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	private TextField textTitulo;
	private TextField textAño;
	private TextField textClasificacion;
	private TextField textEdicion;
	private TextField textIsbn;
	private TextField textAutor;
	private TextField textArea;
	private TextField textSubarea;

	private JButton jBRegistrar;
	private JButton jBCancelar;

	private JPanel _crearPanelSur() {
		JPanel p = new JPanel(new FlowLayout());
		jBRegistrar = new JButton("Registrar");
		jBCancelar = new JButton("Cancelar");

		p.add(jBCancelar);
		p.add(jBRegistrar);

		return p;
	}

	private JPanel _crearPanelCentral() {
		JPanel p = new JPanel(new BorderLayout());
		JPanel panelCentralIzquierdo = new JPanel();
		panelCentralIzquierdo.setLayout(new BoxLayout(panelCentralIzquierdo, BoxLayout.Y_AXIS));
		panelCentralIzquierdo.add(new JLabel(" Titulo: "));
		panelCentralIzquierdo.add(new JLabel(" Año: "));
		panelCentralIzquierdo.add(new JLabel(" Clasificacion: "));
		panelCentralIzquierdo.add(new JLabel(" Edición: "));
		panelCentralIzquierdo.add(new JLabel(" ISBN: "));
		panelCentralIzquierdo.add(new JLabel(" Autor: "));
		panelCentralIzquierdo.add(new JLabel(" Area: "));
		panelCentralIzquierdo.add(new JLabel(" SubArea: "));

		int tam_textFields = 20;

		textTitulo = new TextField(tam_textFields);
		textAño = new TextField(tam_textFields);
		textClasificacion = new TextField(tam_textFields);
		textEdicion = new TextField(tam_textFields);
		textIsbn = new TextField(tam_textFields);
		textAutor = new TextField(tam_textFields);
		textArea = new TextField(tam_textFields);
		textSubarea = new TextField(tam_textFields);

		JPanel panelCentralDerecho = new JPanel();
		panelCentralDerecho.setLayout(new BoxLayout(panelCentralDerecho, BoxLayout.Y_AXIS));
		panelCentralDerecho.add(textTitulo);
		panelCentralDerecho.add(textAño);
		panelCentralDerecho.add(textClasificacion);
		panelCentralDerecho.add(textEdicion);
		panelCentralDerecho.add(textIsbn);
		panelCentralDerecho.add(textAutor);
		panelCentralDerecho.add(textArea);
		panelCentralDerecho.add(textSubarea);

		p.add(panelCentralDerecho, BorderLayout.EAST);
		p.add(panelCentralIzquierdo, BorderLayout.WEST);
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

	public static void main(String[] args) {
		new JFAddLibro();
	}

}