package IGU;

import javax.swing.*;

import Back.FileManager;
import java.awt.*;

public class Login extends JFrame {

    JTextField usuario;
    JPasswordField contraseña;
    JLabel user, pass, titulo;
    JButton ingresar;

    public Login() {
        // color mas oscuro de fondo
        JPanel panel = new JPanel();
        panel.setBackground(new java.awt.Color(0, 34, 77));
        panel.setLayout(null);
        add(panel);

        titulo = new JLabel("Login");
        titulo.setBounds(150, 55, 120, 30);
        titulo.setFont(new Font("Verdana", Font.BOLD, 30));
        titulo.setForeground(new Color(255, 32, 78));
        panel.add(titulo);

        user = new JLabel("Usuario");
        user.setBounds(95, 120, 100, 30);
        user.setForeground(new Color(255, 32, 78));
        panel.add(user);
        usuario = new JTextField();
        usuario.setBounds(170, 120, 100, 30);
        panel.add(usuario);

        pass = new JLabel("Contraseña");
        pass.setBounds(95, 160, 100, 30);
        pass.setForeground(new Color(255, 32, 78));
        panel.add(pass);
        contraseña = new JPasswordField();
        contraseña.setBounds(170, 160, 100, 30);
        panel.add(contraseña);

        ingresar = new JButton("Ingresar");
        ingresar.setBackground(new Color(160, 21, 62));
        ingresar.setForeground(Color.WHITE);
        ingresar.setBounds(140, 220, 100, 30);
        ingresar.addActionListener(
                e -> {
                    if (usuario.getText().isEmpty() || contraseña.getPassword().length == 0) {
                        JOptionPane.showMessageDialog(null, "Usuario o contraseña vacios");
                        return;
                    }

                    if (Back.VerifyUser.verify(usuario.getText(), new String(contraseña.getPassword()))) {
                        dispose();
                        String logIngreso = "Usuario: " + usuario.getText() + " Fecha: " + java.time.LocalDate.now()
                                + " Hora: " + java.time.LocalTime.now() + "\n";
                        FileManager.write("src/ingresos.log", logIngreso);
                        new FrmInicio();
                    } else {
                        JOptionPane.showMessageDialog(null, "Usuario o contraseña incorrectos");
                    }

                });
        panel.add(ingresar);

        setTitle("Login");
        setSize(400, 330);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
        setResizable(false);
        setLocationRelativeTo(null);

    }

    public static void initialize() {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new Login();
            }
        });
    }
}
