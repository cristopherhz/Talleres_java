import java.util.Scanner;

public class EjecutablePersona {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Ingrese nombre:");
        String nombre = scanner.nextLine();

        System.out.println("Ingrese edad:");
        int edad = scanner.nextInt();

        System.out.println("Ingrese sexo (H/M):");
        char sexo = scanner.next().charAt(0);

        System.out.println("Ingrese peso:");
        double peso = scanner.nextDouble();

        System.out.println("Ingrese altura:");
        double altura = scanner.nextDouble();

        Persona persona1 = new Persona(nombre, edad, sexo, peso, altura);
        Persona persona2 = new Persona(nombre, edad, sexo);
        Persona persona3 = new Persona();

        persona2.setPeso(70);
        persona2.setAltura(1.75);

        System.out.println("\n--- Resultados ---");
        mostrarResultado(persona1);
        mostrarResultado(persona2);
        mostrarResultado(persona3);

        scanner.close();
    }

    private static void mostrarResultado(Persona persona) {
        System.out.println("\n" + persona.toString());
        System.out.println("IMC: " + interpretarIMC(persona.calcularIMC()));
        System.out.println("Es mayor de edad: " + persona.esMayorDeEdad());
    }

    private static String interpretarIMC(int resultadoIMC) {
        switch (resultadoIMC) {
            case -1:
                return "Por debajo del peso ideal.";
            case 0:
                return "En peso ideal.";
            case 1:
                return "Con sobrepeso.";
            default:
                return "Resultado de IMC no válido.";
        }
    }
}

