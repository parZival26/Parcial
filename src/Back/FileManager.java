package Back;

import java.io.File;
import java.util.Scanner;

public class FileManager {

    public static String read(String filename) {
        try {
            File file = new File(filename);
            if (file.exists()) {
                Scanner sc = new Scanner(file);
                String content = "";
                while (sc.hasNextLine()) {
                    content += sc.nextLine() + "\n";
                }
                sc.close();
                return content;
            } else {
                // crear el archivo
                File newFile = new File(filename);
                newFile.createNewFile();
                return "";
            }

        } catch (Exception e) {
            return "Error al leer el archivo";
        }
    }

    public static void write(String fileName, String context) {
        try {
            File file = new File(fileName);
            if (file.exists()) {
                java.io.FileWriter fw = new java.io.FileWriter(file);
                fw.write(context);
                fw.close();
            } else {
                // crear el archivo
                File newFile = new File(fileName);
                newFile.createNewFile();
                java.io.FileWriter fw = new java.io.FileWriter(newFile);
                fw.write(context);
                fw.close();
            }
        } catch (Exception e) {
            System.out.println("Error al escribir el archivo");
        }
    }

}
