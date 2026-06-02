import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner teclado = new Scanner(System.in);
        System.out.println("=== Registro de Estudiantes ===");
        System.out.print("Nombre: ");
        String nombre = teclado.nextLine();
        System.out.print("Edad: ");
        int edad = teclado.nextInt();
        System.out.print("Indice: ");
        double indice = teclado.nextDouble();

        try {
            ValidadorEstudiante.validarEstudiante(
                    nombre,
                    edad,
                    indice);
            Estudiante estudiante = new Estudiante(nombre, edad, indice);
            System.out.println(
                    "Estudiante registrado correctamente.");
        } catch (EstudianteInvalidoException e) {
            System.out.println(
                    e.getMessage());

        } finally {
            System.out.println(
                    "Proceso finalizado.");
            teclado.close();
        }
    }
}