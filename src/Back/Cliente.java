package Back;

public class Cliente {
    int id;
    int documento;
    String nombres;
    String apellidos;
    int edad;

    public Cliente(int id, int documento, String nombres, String apellidos, int edad) {
        this.id = id;
        this.documento = documento;
        this.nombres = nombres;
        this.apellidos = apellidos;
        this.edad = edad;
    }

    public String toCSV() {
        return id + "," + nombres + "," + apellidos + "," + edad + "," + documento;
    }
}
