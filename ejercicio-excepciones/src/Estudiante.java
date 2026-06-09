public class Estudiante {
    private String matricula;
    private String nombre;
    private int edad;

    public Estudiante(String matricula, String nombre, int edad) {
        this.matricula = matricula;
        this.nombre = nombre;
        this.edad = edad;
    }

    @Override
    public String toString() {
        return matricula + "," + nombre + "," + edad;
    }
}