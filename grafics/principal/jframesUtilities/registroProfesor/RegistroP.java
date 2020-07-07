package grafics.principal.jframesUtilities.registroProfesor;

//Componentes
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import grafics.principal.PrincipalFrame;
import usuarios.Profesor;
import util.Administrador;

import java.awt.TextField;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Label;
import java.awt.event.ActionEvent;
//Events
import java.awt.event.ActionListener;

public class RegistroP extends JFrame {
    private TextField textNum_personal;
    private TextField textNombre;
    private TextField textDireccion;
    private TextField textTelefono;
    private TextField textFacultad;

    // Paneles
    private JPanel panelCentralIzquierdo;
    private JPanel panelCentralDerecho;

    // Botones
    private JButton registrar;
    private JButton cancelar;

    public RegistroP() {
        super("Registro profesor");
        setLayout(new BorderLayout());

        // Panel norte
        JPanel panelNorte = _crearPanelNorte();
        add(panelNorte, BorderLayout.NORTH);

        // Panel central
        JPanel panelCentral = _crearPanelCentral();
        add(panelCentral, BorderLayout.CENTER);

        // Panel sur
        JPanel panelSur = _crearPanelSur();
        add(panelSur, BorderLayout.SOUTH);

        pack();
        setLocationRelativeTo(null);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    private JPanel _crearPanelSur() {
        JPanel p = new JPanel(new FlowLayout(FlowLayout.CENTER));

        registrar = new JButton("Registrar");
        registrar.addActionListener(new EscuchaRegistrar());
        registrar.setBackground(new Color(132, 169, 172));
        registrar.setForeground(new Color(32, 64, 81));

        cancelar = new JButton("Cancelar");
        cancelar.addActionListener(new EscuchaCancelar());
        cancelar.setBackground(new Color(132, 169, 172));
        cancelar.setForeground(new Color(32, 64, 81));

        p.setBackground(new Color(32, 64, 81));
        p.add(registrar);
        p.add(cancelar);

        return p;
    }

    private JPanel _crearPanelCentral() {
        JPanel p = new JPanel(new BorderLayout());
        // Panel izquierdo
        panelCentralIzquierdo = new JPanel();
        panelCentralIzquierdo.setLayout(new BoxLayout(panelCentralIzquierdo, BoxLayout.Y_AXIS));
        panelCentralIzquierdo.add(new Label("  Numero de personal"));
        panelCentralIzquierdo.add(new Label("  Nombre"));
        panelCentralIzquierdo.add(new Label("  Direccion"));
        panelCentralIzquierdo.add(new Label("  Telefono"));
        panelCentralIzquierdo.add(new Label("  Facultad"));

        // Configuraciones de background y foreground
        panelCentralIzquierdo.setBackground(new Color(59, 105, 120));
        panelCentralIzquierdo.setForeground(Color.WHITE);

        // Panel Derecho
        panelCentralDerecho = new JPanel();
        panelCentralDerecho.setLayout(new BoxLayout(panelCentralDerecho, BoxLayout.Y_AXIS));
        int tam_textField = 20;
        textNum_personal = new TextField(tam_textField);
        textNombre = new TextField(tam_textField);
        textDireccion = new TextField(tam_textField);
        textTelefono = new TextField(tam_textField);
        textFacultad = new TextField(tam_textField);

        panelCentralDerecho.add(textNum_personal);
        panelCentralDerecho.add(textNombre);
        panelCentralDerecho.add(textDireccion);
        panelCentralDerecho.add(textTelefono);
        panelCentralDerecho.add(textFacultad);

        // Configuraciones de background y foreground
        panelCentralDerecho.setBackground(new Color(59, 105, 120));
        textNum_personal.setBackground(new Color(132, 169, 172));
        textNombre.setBackground(new Color(132, 169, 172));
        textDireccion.setBackground(new Color(132, 169, 172));
        textTelefono.setBackground(new Color(132, 169, 172));
        textFacultad.setBackground(new Color(132, 169, 172));

        // Se agregan los elementos al panel principal
        p.add(panelCentralIzquierdo, BorderLayout.WEST);
        p.add(panelCentralDerecho, BorderLayout.EAST);

        return p;
    }

    private JPanel _crearPanelNorte() {
        JPanel p = new JPanel(new FlowLayout(FlowLayout.CENTER));
        p.setBackground(new Color(32, 64, 81));
        p.setForeground(Color.WHITE);
        p.add(new Label(this.getTitle()));
        return p;
    }

    /**
     * Controladores
     */
    class EscuchaRegistrar implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            Profesor prof = new Profesor();
            Administrador admin = new Administrador();

            prof.setNombre(textNombre.getText());
            prof.setDireccion(textDireccion.getText());
            prof.setTelefono(Long.parseLong(textTelefono.getText()));
            prof.setNumeroDePersonal(textNum_personal.getText());
            prof.setFacultad(textFacultad.getText());

            textNombre.setText("");
            textDireccion.setText("");
            textTelefono.setText("");
            textNum_personal.setText("");
            textFacultad.setText("");

            System.out.println(prof);
            admin.añadirProfesor(prof);
            new PrincipalFrame();
            dispose();
        }
    }

    class EscuchaCancelar implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            new PrincipalFrame();
            dispose();
        }

    }

    public static void main(String[] args) {
        new RegistroP();
    }
}