package IGU;

import javax.swing.JLabel;

public class Inicio extends javax.swing.JFrame {

    JLabel mensaje;

    public Inicio() {
        initComponents();
        mensaje = new JLabel("Bienvenido");
        mensaje.setBounds(150, 100, 100, 30);
        getContentPane().add(mensaje);
    }

    private void initComponents() {
        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Inicio");
        setResizable(false);
        setSize(new java.awt.Dimension(400, 300));
        getContentPane().setLayout(null);
        setLocationRelativeTo(null);
        setVisible(true);
    }

}
