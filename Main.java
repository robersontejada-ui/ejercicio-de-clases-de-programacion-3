import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        ArrayList<Paciente> pacientes = new ArrayList<>();

        int opcion = 0;

        while (opcion != 3) {

            System.out.println("\n--- SISTEMA MEDICO ---");
            System.out.println("1. Registrar paciente");
            System.out.println("2. Mostrar pacientes");
            System.out.println("3. Salir");
            System.out.print("Opcion: ");

            if (sc.hasNextInt()) {

                opcion = sc.nextInt();
                sc.nextLine();

                switch (opcion) {

                    case 1:

                        System.out.print("Nombre: ");
                        String nombre = sc.nextLine();

                        System.out.print("Peso: ");
                        double peso = sc.nextDouble();

                        System.out.print("Altura: ");
                        double altura = sc.nextDouble();

                        Paciente p = new Paciente(nombre, peso, altura);

                        pacientes.add(p);

                        System.out.println("Paciente registrado.");

                        break;

                    case 2:

                        if (pacientes.isEmpty()) {

                            System.out.println("No hay pacientes registrados.");

                        } else {

                            for (Paciente paciente : pacientes) {

                                paciente.mostrarPaciente();
                            }
                        }

                        break;

                    case 3:

                        System.out.println("Programa finalizado.");
                        break;

                    default:

                        System.out.println("Opcion incorrecta.");
                }

            } else {

                System.out.println("Ingrese un numero valido.");
                sc.next();
            }
        }
    }
}