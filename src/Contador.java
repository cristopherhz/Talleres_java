public class Contador {
    private int valor;

    // Constructor por defecto
    public Contador() {
        this.valor = 0;
    }

    // Constructor con parámetros
    public Contador(int valorInicial) {
        this.valor = valorInicial;
    }

    // Constructor copia
    public Contador(Contador otroContador) {
        this.valor = otroContador.valor;
    }

    // Getter
    public int obtenerValor() {
        return this.valor;
    }

    // Setter
    public void establecerValor(int nuevoValor) {
        this.valor = nuevoValor;
    }

    // Método para incrementar el valor
    public void incrementar() {
        this.valor++;
    }

    // Método para decrementar el valor
    public void decrementar() {
        this.valor--;
    }

    public static void main(String[] args) {
        // Ejemplo de uso:
        // Constructor por defecto
        Contador contador1 = new Contador();
        System.out.println("Valor inicial de contador1: " + contador1.obtenerValor());  // Salida: Valor inicial de contador1: 0

        // Constructor con parámetros
        Contador contador2 = new Contador(10);
        System.out.println("Valor inicial de contador2: " + contador2.obtenerValor());  // Salida: Valor inicial de contador2: 10

        // Incrementar y decrementar
        contador1.incrementar();
        contador2.decrementar();
        System.out.println("Nuevo valor de contador1: " + contador1.obtenerValor());  // Salida: Nuevo valor de contador1: 1
        System.out.println("Nuevo valor de contador2: " + contador2.obtenerValor());  // Salida: Nuevo valor de contador2: 9

        // Constructor copia
        Contador contadorCopia = new Contador(contador2);
        System.out.println("Valor de contadorCopia: " + contadorCopia.obtenerValor());  // Salida: Valor de contadorCopia: 9
    }
}