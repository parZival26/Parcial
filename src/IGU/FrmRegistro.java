package IGU;

import java.io.File;
import java.io.FileWriter;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
import java.awt.*;
import Back.Cliente;

public class FrmRegistro extends JFrame {

    JLabel lblDocumento, lblNombres, lblApellidos, lblEdad, lblIdCliente, lblTitulo;
    JTextField txtDocumento, txtNombres, txtApellidos, txtEdad, txtIdCliente;
    JButton btnRegistrar, btnRegresar;
    ImageIcon imgPen, imgBack;
    JPanel panel;

    public FrmRegistro(FrmInicio frmInicio) {

        // Panel
        panel = new JPanel();
        panel.setBackground(new Color(0, 34, 77));
        panel.setLayout(null);
        add(panel);
        lblTitulo = new JLabel("Registrar Usuarios");
        lblTitulo.setBounds(120, 10, 300, 30);
        lblTitulo.setFont(new Font("Verdana", Font.BOLD, 20));
        lblTitulo.setForeground(new Color(255, 32, 78));
        panel.add(lblTitulo);

        // inputs
        lblDocumento = new JLabel("Documento");
        lblDocumento.setBounds(90, 70, 80, 25);
        lblDocumento.setForeground(new Color(255, 32, 78));
        panel.add(lblDocumento);
        txtDocumento = new JTextField(15);
        txtDocumento.setBounds(180, 70, 150, 25);
        panel.add(txtDocumento);

        lblNombres = new JLabel("Nombres");
        lblNombres.setBounds(90, 110, 80, 25);
        lblNombres.setForeground(new Color(255, 32, 78));
        panel.add(lblNombres);
        txtNombres = new JTextField(15);
        txtNombres.setBounds(180, 110, 150, 25);
        panel.add(txtNombres);

        lblApellidos = new JLabel("Apellidos");
        lblApellidos.setBounds(90, 150, 80, 25);
        lblApellidos.setForeground(new Color(255, 32, 78));
        panel.add(lblApellidos);
        txtApellidos = new JTextField(15);
        txtApellidos.setBounds(180, 150, 150, 25);
        panel.add(txtApellidos);

        lblEdad = new JLabel("Edad");
        lblEdad.setBounds(90, 190, 80, 25);
        lblEdad.setForeground(new Color(255, 32, 78));
        panel.add(lblEdad);
        txtEdad = new JTextField(15);
        txtEdad.setBounds(180, 190, 150, 25);
        panel.add(txtEdad);

        lblIdCliente = new JLabel("Id Cliente");
        lblIdCliente.setBounds(90, 230, 80, 25);
        lblIdCliente.setForeground(new Color(255, 32, 78));
        panel.add(lblIdCliente);
        txtIdCliente = new JTextField(15);
        txtIdCliente.setBounds(180, 230, 150, 25);
        panel.add(txtIdCliente);

        // Botones

        imgPen = new ImageIcon("./src/IGU/image/pen.png");
        btnRegistrar = new JButton("Registrar", imgPen);
        btnRegistrar.setBounds(130, 290, 100, 30);
        btnRegistrar.setBackground(new Color(160, 21, 62));
        btnRegistrar.setForeground(Color.WHITE);
        btnRegistrar.addActionListener(
                e -> {
                    Cliente cliente = new Cliente(Integer.parseInt(txtIdCliente.getText()),
                            Integer.parseInt(txtDocumento.getText()), txtNombres.getText(), txtApellidos.getText(),
                            Integer.parseInt(txtEdad.getText()));
                    JOptionPane.showMessageDialog(null, "Cliente registrado");
                    ingresarCliente(cliente);

                    dispose();
                    frmInicio.setVisible(true);
                    if (frmInicio.tablaClientes != null) {
                        frmInicio.panel.remove(frmInicio.tablaClientes);
                    }
                    // Crear una nueva tabla y agregarla al panel
                    frmInicio.tablaClientes = new FrmTabla().TablaClientes();
                    frmInicio.panel.add(frmInicio.tablaClientes);
                    // Actualizar el panel para mostrar la nueva tabla
                    frmInicio.panel.revalidate();
                    frmInicio.panel.repaint();
                });
        panel.add(btnRegistrar);

        imgBack = new ImageIcon("./src/IGU/image/back.png");
        btnRegresar = new JButton("Regresar", imgBack);
        btnRegresar.setBounds(260, 290, 100, 30);
        btnRegresar.setBackground(new Color(160, 21, 62));
        btnRegresar.setForeground(Color.WHITE);
        btnRegresar.addActionListener(
                new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        setVisible(false);
                        frmInicio.setVisible(true);

                    }
                });

        panel.add(btnRegresar);

        setTitle("Registrar Usuario");
        setSize(500, 400);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);
        setResizable(false);
    }

    private static void ingresarCliente(Cliente cliente) {
        File f = new File("./src/IGU/Clientes.csv");
        if (!f.exists()) {
            try {
                f.createNewFile();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        try (FileWriter fw = new FileWriter(f, true)) {
            fw.write(cliente.toCSV() + "\n");

        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
