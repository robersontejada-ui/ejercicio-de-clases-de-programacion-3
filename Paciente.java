public class Paciente {

    private String nombre;
    private double peso;
    private double altura;

    public Paciente(String nombre, double peso, double altura) {
        this.nombre = nombre;
        this.peso = peso;
        this.altura = altura;
    }

    public double calcularIMC() {

        return peso / (altura * altura);
    }

    public String estadoPeso() {

        double imc = calcularIMC();

        if (imc < 18.5) {
            return "Peso bajo";
        } else if (imc < 25) {
            return "Peso normal";
        } else {
            return "Sobrepeso";
        }
    }

    public void mostrarPaciente() {

        System.out.println("\nNombre: " + nombre);
        System.out.println("Peso: " + peso);
        System.out.println("Altura: " + altura);
        System.out.println("IMC: " + calcularIMC());
        System.out.println("Estado: " + estadoPeso());
    }
}
