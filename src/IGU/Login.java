package IGU;

import javax.swing.*;

import Back.FileManager;

public class Login extends JFrame {

    JTextField usuario;
    JPasswordField contraseña;
    JLabel user, pass, titulo;
    JButton ingresar;

    public Login() {
        // color mas oscuro de fondo
        JPanel panel = new JPanel();
        panel.setBackground(new java.awt.Color(225, 225, 225));
        panel.setLayout(null);
        add(panel);

        titulo = new JLabel("Login");
        titulo.setBounds(175, 50, 100, 30);
        panel.add(titulo);

        user = new JLabel("Usuario");
        user.setBounds(100, 100, 100, 30);
        panel.add(user);
        usuario = new JTextField();
        usuario.setBounds(200, 100, 100, 30);
        panel.add(usuario);

        pass = new JLabel("Contraseña");
        pass.setBounds(100, 150, 100, 30);
        panel.add(pass);
        contraseña = new JPasswordField();
        contraseña.setBounds(200, 150, 100, 30);
        panel.add(contraseña);

        ingresar = new JButton("Ingresar");
        ingresar.setBounds(150, 200, 100, 30);
        ingresar.addActionListener(
                e -> {
                    if (Back.VerifyUser.verify(usuario.getText(), new String(contraseña.getPassword()))) {
                        dispose();
                        String logIngreso = "Usuario: " + usuario.getText() + " Fecha: " + java.time.LocalDate.now()
                                + " Hora: " + java.time.LocalTime.now() + "\n";
                        FileManager.write("src/ingresos.log", logIngreso);
                        new Inicio();
                    } else {
                        JOptionPane.showMessageDialog(null, "Usuario o contraseña incorrectos");
                    }

                });
        panel.add(ingresar);

        setTitle("Login");
        setSize(400, 300);
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
