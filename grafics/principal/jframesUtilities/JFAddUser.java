package grafics.principal.jframesUtilities;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import grafics.principal.PrincipalFrame;
import grafics.principal.jframesUtilities.registroEstudiante.*;
import grafics.principal.jframesUtilities.registroProfesor.*;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;

//Events

import java.awt.event.ActionListener;

public class JFAddUser extends JFrame {

    private JButton jBEstudiante;
    private JButton jBProfesor;
    private JButton jBCancelar;

    public JFAddUser() {
        super("Añadir usuario");
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
        // TODO: Agregar la opcion de salir para que no cierre el programa, sino solo se
        // libere

    }

    private JPanel _crearPanelSur() {
        JPanel p = new JPanel();
        jBCancelar = new JButton("Cancelar");
        jBCancelar.addActionListener(new EscuchaJBCancelar());
        p.add(jBCancelar);
        return p;
    }

    private JPanel _crearPanelCentral() {
        JPanel p = new JPanel(new FlowLayout());
        jBEstudiante = new JButton("Estudiante");
        jBProfesor = new JButton("Profesor");

        // Action Listener
        jBEstudiante.addActionListener(new EscuchaJBEstudiante());
        jBProfesor.addActionListener(new EscuchaJBProfesor());

        p.add(jBEstudiante);
        p.add(jBProfesor);
        return p;
    }

    private JPanel _crearPanelNorte() {
        JPanel p = new JPanel(new FlowLayout());
        p.add(new JLabel("Seleccione el tipo de usuario"));
        return p;
    }

    class EscuchaJBEstudiante implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            new RegistroE();
            dispose();
        }

    }

    class EscuchaJBProfesor implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            new RegistroP();
        }

    }

    class EscuchaJBCancelar implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            new PrincipalFrame();
            dispose();
        }

    }

}