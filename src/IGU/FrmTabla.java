package IGU;

import java.util.ArrayList;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class FrmTabla {

    static JTable tabla;
    static DefaultTableModel model;

    public JScrollPane TablaClientes() {
        model = new DefaultTableModel();
        tabla = new JTable(model);

        model.addColumn("ID");
        model.addColumn("Nombre");
        model.addColumn("Apellidos");
        model.addColumn("Edad");
        model.addColumn("Documento");

        ArrayList<String[]> propietarios = CSVUtils.readCSV();
        for (String[] propietario : propietarios) {
            model.addRow(propietario);
        }

        JScrollPane scroll = new JScrollPane(tabla);
        scroll.setBounds(10, 10, 500, 300);
        return scroll;

    }

    public JScrollPane TablaClientes(ArrayList<String[]> clientesFiltrados) {
        model = new DefaultTableModel();
        tabla = new JTable(model);

        model.addColumn("ID");
        model.addColumn("Nombre");
        model.addColumn("Apellidos");
        model.addColumn("Edad");
        model.addColumn("Documento");

        for (String[] cliente : clientesFiltrados) {
            model.addRow(cliente);
        }

        JScrollPane scroll = new JScrollPane(tabla);
        scroll.setBounds(10, 10, 500, 300);
        return scroll;

    }

}
