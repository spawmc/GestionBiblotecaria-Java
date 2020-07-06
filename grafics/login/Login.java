package grafics.login;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
//Events
import java.awt.event.ActionListener;

public class Login extends JFrame {

    private JButton ingresar;
    private JButton salir;

    public Login() {
        super("Inicio");
        setLayout(new BorderLayout());

        // Panel norte
        JPanel panelNorte = _crearPanelNorte();
        add(panelNorte, BorderLayout.NORTH);

        // Panel Central
        JPanel panelCentral = _crearPanelCentral();
        add(panelCentral, BorderLayout.CENTER);

        pack();
        setLocationRelativeTo(null);
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    private JPanel _crearPanelCentral() {
        JPanel p = new JPanel(new FlowLayout(FlowLayout.CENTER));
        JPanel centralPanel = new JPanel();
        centralPanel.setLayout(new BoxLayout(centralPanel, BoxLayout.Y_AXIS));
        ingresar = new JButton("Ingresar");
        ingresar.addActionListener(new EscuchaIngresar());
        salir = new JButton("Salir");
        salir.addActionListener(new EscuchaSalir());
        centralPanel.add(ingresar);
        centralPanel.add(salir);

        // Configuraciones
        p.setBackground(new Color(32, 64, 81)); // Color oscuro
        centralPanel.setBackground(new Color(32, 64, 81));

        ingresar.setBackground(new Color(132, 169, 172)); // Color claro
        ingresar.setForeground(new Color(32, 64, 81)); // Color oscuro

        salir.setBackground(new Color(132, 169, 172)); // Color claro
        salir.setForeground(new Color(32, 64, 81)); // Color oscuro

        p.add(centralPanel);
        return p;
    }

    private JPanel _crearPanelNorte() {
        JPanel p = new JPanel(new FlowLayout());
        JLabel saludo = new JLabel("Bienvenido");

        //Modificando el tamaño de la fuente
        Font fontAux = saludo.getFont();
        saludo.setFont(new Font(fontAux.getFontName(), fontAux.getStyle(), 50));

        // Configuraciones
        p.setBackground(new Color(32, 64, 81)); // Color oscuro
        saludo.setForeground(Color.WHITE); // Color claro

        p.add(saludo);

        return p;
    }

    /**
     * Controladores
     */
    class EscuchaIngresar implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent arg0) {
            // TODO Auto-generated method stub
            System.out.println("Ingresar");

        }

    }

    class EscuchaSalir implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            System.exit(0);
        }

    }

}// Final class
