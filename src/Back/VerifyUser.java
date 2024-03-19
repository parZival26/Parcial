package Back;

public class VerifyUser {
    public static boolean verify(String nombre, String contraseña) {
        return FileManager.read("src/usuarios.txt").contains(nombre + " " + contraseña);
    }

}
