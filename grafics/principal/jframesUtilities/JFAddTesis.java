package grafics.principal.jframesUtilities;

import javax.swing.JFrame;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import ejemplares.Autor;
import ejemplares.Tesis;
import grafics.principal.PrincipalFrame;
import util.Administrador;

import javax.swing.BoxLayout;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.TextField;

import java.awt.event.*;
import java.util.ArrayList;

public class JFAddTesis extends JFrame {

    private TextField textTitulo;
    private TextField textClasificacion;
    private TextField textAño;
    private TextField textDirector;
    private TextField textTipoDeTesis;
    private TextField textAutor;

    public JFAddTesis() {
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

    private JPanel _crearPanelCentral() {
        JPanel p = new JPanel(new BorderLayout());
        JPanel panelCentralIzquierdo = new JPanel();
        panelCentralIzquierdo.setLayout(new BoxLayout(panelCentralIzquierdo, BoxLayout.Y_AXIS));
        panelCentralIzquierdo.add(new JLabel(" Titulo: "));
        panelCentralIzquierdo.add(new JLabel(" Año: "));
        panelCentralIzquierdo.add(new JLabel(" Clasificacion: "));
        panelCentralIzquierdo.add(new JLabel(" Director: "));
        panelCentralIzquierdo.add(new JLabel(" Tipo de tesis: "));
        panelCentralIzquierdo.add(new JLabel(" Autor: "));

        int tam_textFields = 20;

        textTitulo = new TextField(tam_textFields);
        textAño = new TextField(tam_textFields);
        textClasificacion = new TextField(tam_textFields);
        textDirector = new TextField(tam_textFields);
        textTipoDeTesis = new TextField(tam_textFields);
        textAutor = new TextField(tam_textFields);

        JPanel panelCentralDerecho = new JPanel();
        panelCentralDerecho.setLayout(new BoxLayout(panelCentralDerecho, BoxLayout.Y_AXIS));
        panelCentralDerecho.add(textTitulo);
        panelCentralDerecho.add(textAño);
        panelCentralDerecho.add(textClasificacion);
        panelCentralDerecho.add(textDirector);
        panelCentralDerecho.add(textTipoDeTesis);
        panelCentralDerecho.add(textAutor);

        p.add(panelCentralDerecho, BorderLayout.EAST);
        p.add(panelCentralIzquierdo, BorderLayout.WEST);
        return p;
    }

    private JButton jBRegistrar;
    private JButton jBCancelar;

    private JPanel _crearPanelSur() {
        JPanel p = new JPanel(new FlowLayout());
        jBRegistrar = new JButton("Registrar");
        jBCancelar = new JButton("Cancelar");

        // Actionlisteners
        jBRegistrar.addActionListener(new EscuchaRegistrar());
        jBCancelar.addActionListener(new EscuchaCancelar());

        p.add(jBCancelar);
        p.add(jBRegistrar);

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

    class EscuchaRegistrar implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            System.out.println("Registrar");
            Tesis tesis = new Tesis();
            Administrador admin = new Administrador();

            tesis.setTitulo(textTitulo.getText());
            tesis.setAño(Short.parseShort(textAño.getText()));
            tesis.setClasificacion(textClasificacion.getText());
            tesis.setTipoTesis(new Tesis.TipoTesis(textTipoDeTesis.getText()));
            ArrayList<Autor> autores = new ArrayList<>();
            autores.add(new Autor(textAutor.getText()));
            tesis.setAutores(autores);

            admin.añadirTesis(tesis);
            new PrincipalFrame();
            dispose();
        }

    }

    class EscuchaCancelar implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            System.out.println("Cancelar");
            new PrincipalFrame();
            dispose();
        }

    }

    public static void main(String[] args) {
        new JFAddTesis();
    }

}