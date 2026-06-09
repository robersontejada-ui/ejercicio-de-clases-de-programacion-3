import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void guardarEstudiante(String matricula,
            String nombre,
            int edad)
            throws EstudianteException, IOException {
        if (matricula.isEmpty()) {
            throw new EstudianteException("La matricula esta vacia");
        }
        if (nombre.isEmpty()) {
            throw new EstudianteException("El nombre esta vacio");
        }
        if (edad <= 0) {
            throw new EstudianteException("La edad debe ser mayor que cero");
        }
        Estudiante estudiante = new Estudiante(matricula, nombre, edad);
        FileWriter archivo = new FileWriter("estudiante.txt", true);
        archivo.write(estudiante.toString() + "\n");

        archivo.close();
    }

    public static void main(String[] args) {

        Scanner teclado = new Scanner(System.in);

        int opcion = 0;

        do {

            System.out.println("\n===== MENU =====");
            System.out.println("1. Registrar estudiante");
            System.out.println("2. Salir");
            System.out.print("Opcion: ");
            try {
                opcion = Integer.parseInt(teclado.nextLine());
                switch (opcion) {

                    case 1:

                        System.out.print("Matricula: ");
                        String matricula = teclado.nextLine();
                        System.out.print("Nombre: ");
                        String nombre = teclado.nextLine();
                        System.out.print("Edad: ");
                        int edad = Integer.parseInt(teclado.nextLine());

                        guardarEstudiante(
                                matricula,
                                nombre,
                                edad);

                        System.out.println("Estudiante registrado");
                        break;

                    case 2:

                        System.out.println("Fin del programa");
                        break;

                    default:

                        System.out.println("Opcion incorrecta");
                }
            } catch (NumberFormatException e) {
                System.out.println("Debe escribir un numero valido");
            } catch (EstudianteException e) {
                System.out.println(e.getMessage());
            } catch (IOException e) {
                System.out.println("Error al guardar el archivo");
            } finally {
                System.out.println("Proceso terminado");
            }
        } while (opcion != 2);

        teclado.close();
    }
}