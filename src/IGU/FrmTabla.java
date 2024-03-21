package IGU;

import java.util.ArrayList;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;

import java.awt.*;

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

        tabla.setBackground(Color.WHITE);
        tabla.setGridColor(new Color(255, 32, 78));
        tabla.setSelectionBackground(new Color(135, 206, 235));
        tabla.setSelectionForeground(new Color(255, 32, 78));
        tabla.setFont(new Font("Verdana", Font.BOLD, 12));

        JTableHeader header = tabla.getTableHeader();
        header.setFont(new Font("Verdana", Font.BOLD, 14));
        header.setForeground(Color.WHITE);
        header.setBackground(new Color(160, 21, 62));

        UIManager.put("Button.background", new Color(160, 21, 62));
        UIManager.put("Button.foreground", Color.WHITE);
        UIManager.put("Button.font", new Font("Arial", Font.PLAIN, 12));

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

        tabla.setBackground(Color.WHITE);
        tabla.setGridColor(new Color(255, 32, 78));
        tabla.setSelectionBackground(new Color(135, 206, 235));
        tabla.setSelectionForeground(new Color(255, 32, 78));
        tabla.setFont(new Font("Verdana", Font.BOLD, 12));

        JTableHeader header = tabla.getTableHeader();
        header.setFont(new Font("Verdana", Font.BOLD, 14));
        header.setForeground(Color.WHITE);

        UIManager.put("Button.background", new Color(160, 21, 62));
        UIManager.put("Button.foreground", Color.WHITE);
        UIManager.put("Button.font", new Font("Arial", Font.PLAIN, 12));

        JScrollPane scroll = new JScrollPane(tabla);
        scroll.setBounds(10, 10, 500, 300);
        return scroll;

    }

}
