import java.util.ArrayList;
import java.util.Scanner;

public class EjercicioList {
    public static void main(String[] args) {
        ArrayList<Integer> numeros = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);

        System.out.println("Ingrese valores numéricos enteros (ingrese -99 para finalizar):");

        int valor;
        do {
            valor = scanner.nextInt();
            if (valor != -99) {
                numeros.add(valor);
            }
        } while (valor != -99);

        scanner.close();

        // Calcular el número de valores, la suma y la media
        int totalValores = numeros.size();
        int suma = 0;
        for (int num : numeros) {
            suma += num;
        }
        double media = totalValores > 0 ? (double) suma / totalValores : 0;

        // Mostrar resultados
        System.out.println("Número de valores leídos: " + totalValores);
        System.out.println("Suma de los valores: " + suma);
        System.out.println("Media de los valores: " + media);

        // Mostrar valores mayores que la media
        System.out.println("Valores mayores que la media:");
        for (int num : numeros) {
            if (num > media) {
                System.out.println(num);
            }
        }
    }
}

