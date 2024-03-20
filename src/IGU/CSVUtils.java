package IGU;

import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

public abstract class CSVUtils {
    public static ArrayList<String[]> readCSV() {
        ArrayList<String[]> clientes = new ArrayList<>();
        try (Scanner scFile = new Scanner(new File("././src/IGU/Clientes.csv"))) {
            while (scFile.hasNextLine()) {
                String[] linea = scFile.nextLine().split(",");
                clientes.add(linea);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return clientes;

    }

    public static ArrayList<String[]> buscarPorNombre(String nombre) {
        ArrayList<String[]> clientes = readCSV();
        ArrayList<String[]> clientesFiltrados = new ArrayList<>();
        for (String[] cliente : clientes) {
            if (cliente[1].toLowerCase().contains(nombre.toLowerCase())) {
                clientesFiltrados.add(cliente);
            }
        }
        return clientesFiltrados;
    }
}
