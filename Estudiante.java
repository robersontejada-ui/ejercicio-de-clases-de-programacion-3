public class Estudiante {

    private String nombre;
    private String apellido;
    private int edad;
    private String carrera;

    public Estudiante(String nombre, String apellido, int edad, String carrera) {

        this.nombre = nombre;
        this.apellido = apellido;
        this.edad = edad;
        this.carrera = carrera;

    }

    public String getNombre() {
        return nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public int getEdad() {
        return edad;
    }

    public String getCarrera() {
        return carrera;
    }

}