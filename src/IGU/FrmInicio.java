package IGU;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.ArrayList;

import javax.swing.*;

import Back.Cliente;

public class FrmInicio extends JFrame {

    static ImageIcon imgUsuario, imgLupa;
    static JLabel lblUsuario;
    JPanel panel;
    static JButton registrarCliente, buscarCliente;
    static ArrayList<Cliente> Clientes = new ArrayList<Cliente>();
    JScrollPane tablaClientes;

    public FrmInicio() {
        // Panel
        panel = new JPanel();
        add(panel);

        // Botones
        imgUsuario = new ImageIcon("./src/IGU/image/Usuarios.png");
        registrarCliente = new JButton("Registrar Cliente ", imgUsuario);
        registrarCliente.setBounds(100, 100, 10, 30);
        registrarCliente.addActionListener(
                new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        setVisible(false);
                        new FrmRegistro(FrmInicio.this);

                    }
                });

        panel.add(registrarCliente);

        imgLupa = new ImageIcon("./src/IGU/image/lupa.png");
        buscarCliente = new JButton("Buscar Cliente ", imgLupa);
        buscarCliente.setBounds(100, 150, 10, 30);
        buscarCliente.addActionListener(
                new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        String nombre = JOptionPane.showInputDialog("Nombre");
                        ArrayList<String[]> ClientesFiltrados = CSVUtils.buscarPorNombre(nombre);
                        if (tablaClientes != null) {
                            panel.remove(tablaClientes);
                        }
                        // Crear una nueva tabla y agregarla al panel
                        tablaClientes = new FrmTabla().TablaClientes(ClientesFiltrados);
                        panel.add(tablaClientes);
                        // Actualizar el panel para mostrar la nueva tabla
                        panel.revalidate();
                        panel.repaint();
                    }
                });

        panel.add(buscarCliente);

        // tabla
        if (new File("./src/IGU/Clientes.csv").exists()) {
            tablaClientes = new FrmTabla().TablaClientes();
            panel.add(tablaClientes);
        } else {
            JLabel mensaje = new JLabel("No hay Clientes registrados");
            mensaje.setBounds(100, 250, 10, 30);
            panel.add(mensaje);
        }

        // Imagenes

        // config ventana
        setTitle("Clientes");
        setSize(500, 600);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);
        setResizable(false);

    }

    public static void initialize() {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new FrmInicio();
            }
        });
    }
}
