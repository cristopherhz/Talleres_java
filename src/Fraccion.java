
public class Fraccion {
    private int numerador;
    private int denominador;

    // Constructor por defecto
    public Fraccion() {
        this.numerador = 0;
        this.denominador = 1;
    }

    // Constructor con parámetros
    public Fraccion(int numerador, int denominador) {
        if (denominador != 0) {
            this.numerador = numerador;
            this.denominador = denominador;
            simplificar();
        } else {
            System.out.println("Denominador no puede ser cero. Se establecerá a 1 por defecto.");
            this.numerador = numerador;
            this.denominador = 1;
        }
    }

    // Métodos de acceso (getters y setters)
    public int getNumerador() {
        return this.numerador;
    }

    public void setNumerador(int numerador) {
        this.numerador = numerador;
        simplificar();
    }

    public int getDenominador() {
        return this.denominador;
    }

    public void setDenominador(int denominador) {
        if (denominador != 0) {
            this.denominador = denominador;
            simplificar();
        } else {
            System.out.println("Denominador no puede ser cero. No se realizará cambio.");
        }
    }

    // Método para simplificar la fracción
    private void simplificar() {
        int gcd = calcularMCD(this.numerador, this.denominador);
        this.numerador /= gcd;
        this.denominador /= gcd;
    }

    // Método para calcular el máximo común divisor (MCD)
    private int calcularMCD(int a, int b) {
        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return Math.abs(a);
    }

    // Sobrecarga de operadores para sumar fracciones
    public Fraccion sumar(Fraccion otraFraccion) {
        int nuevoNumerador = this.numerador * otraFraccion.denominador + otraFraccion.numerador * this.denominador;
        int nuevoDenominador = this.denominador * otraFraccion.denominador;
        return new Fraccion(nuevoNumerador, nuevoDenominador);
    }

    // Sobrecarga de operadores para sumar fracción y número entero
    public Fraccion sumar(int numero) {
        return sumar(new Fraccion(numero, 1));
    }

    // Sobrecarga de operadores para restar fracciones
    public Fraccion restar(Fraccion otraFraccion) {
        int nuevoNumerador = this.numerador * otraFraccion.denominador - otraFraccion.numerador * this.denominador;
        int nuevoDenominador = this.denominador * otraFraccion.denominador;
        return new Fraccion(nuevoNumerador, nuevoDenominador);
    }

    // Sobrecarga de operadores para restar fracción y número entero
    public Fraccion restar(int numero) {
        return restar(new Fraccion(numero, 1));
    }

    // Sobrecarga de operadores para multiplicar fracciones
    public Fraccion multiplicar(Fraccion otraFraccion) {
        int nuevoNumerador = this.numerador * otraFraccion.numerador;
        int nuevoDenominador = this.denominador * otraFraccion.denominador;
        return new Fraccion(nuevoNumerador, nuevoDenominador);
    }

    // Sobrecarga de operadores para multiplicar fracción y número entero
    public Fraccion multiplicar(int numero) {
        return multiplicar(new Fraccion(numero, 1));
    }

    // Sobrecarga de operadores para dividir fracciones
    public Fraccion dividir(Fraccion otraFraccion) {
        if (otraFraccion.numerador != 0) {
            int nuevoNumerador = this.numerador * otraFraccion.denominador;
            int nuevoDenominador = this.denominador * otraFraccion.numerador;
            return new Fraccion(nuevoNumerador, nuevoDenominador);
        } else {
            System.out.println("No se puede dividir por cero. Se devolverá una fracción nula.");
            return new Fraccion();
        }
    }

    // Sobrecarga de operadores para dividir fracción y número entero
    public Fraccion dividir(int numero) {
        return dividir(new Fraccion(numero, 1));
    }

    // Método toString
    @Override
    public String toString() {
        return numerador + "/" + denominador;
    }

    public static void main(String[] args) {
        // Ejemplo de uso:
        Fraccion fraccion1 = new Fraccion(1, 3);
        Fraccion fraccion2 = new Fraccion(2, 5);

        // Sumar fracciones
        Fraccion sumaFracciones = fraccion1.sumar(fraccion2);
        System.out.println("Suma de fracciones: " + sumaFracciones);  // Salida: Suma de fracciones: 11/15

        // Sumar fracción y número entero
        Fraccion sumaEntero = fraccion1.sumar(2);
        System.out.println("Suma de fracción y número entero: " + sumaEntero);  // Salida: Suma de fracción y número entero: 7/3

        // Restar fracciones
        Fraccion restaFracciones = fraccion1.restar(fraccion2);
        System.out.println("Resta de fracciones: " + restaFracciones);  // Salida: Resta de fracciones: 1/15

        // Restar fracción y número entero
        Fraccion restaEntero = fraccion1.restar(1);
        System.out.println("Resta de fracción y número entero: " + restaEntero);  // Salida: Resta de fracción y número entero: -2/3

        // Multiplicar fracciones
        Fraccion productoFracciones = fraccion1.multiplicar(fraccion2);
        System.out.println("Producto de fracciones: " + productoFracciones);  // Salida: Producto de fracciones: 2/15

        // Multiplicar fracción y número entero
        Fraccion productoEntero = fraccion1.multiplicar(3);
        System.out.println("Producto de fracción y número entero: " + productoEntero);  // Salida: Producto de fracción y número entero: 1

        // Dividir fracciones
        Fraccion divisionFracciones = fraccion1.dividir(fraccion2);
        System.out.println("División de fracciones: " + divisionFracciones);  // Salida: División de fracciones: 5/6

        // Dividir fracción y número entero
        Fraccion divisionEntero = fraccion1.dividir(2);
        System.out.println("División de fracción y número entero: " + divisionEntero);  // Salida: División de fracción y número entero: 1/6
    }
}