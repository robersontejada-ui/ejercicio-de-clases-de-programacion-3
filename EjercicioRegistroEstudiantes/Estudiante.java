public class Estudiante {
    private String nombre;
    private int edad;
    private double indice;

    public Estudiante(String nombre, int edad, double indice) {
        this.nombre = nombre;
        this.edad = edad;
        this.indice = indice;
    }

    public String getNombre() {
        return nombre;
    }

    public int getEdad() {
        return edad;
    }

    public double getIndice() {
        return indice;
    }
}