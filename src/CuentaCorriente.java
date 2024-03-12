public class CuentaCorriente {
    private double saldo;

    // Constructor por defecto
    public CuentaCorriente() {
        this.saldo = 0.0;
    }

    // Constructor con parámetros
    public CuentaCorriente(double saldoInicial) {
        this.saldo = saldoInicial;
    }

    // Constructor copia
    public CuentaCorriente(CuentaCorriente otraCuenta) {
        this.saldo = otraCuenta.getSaldo();
    }

    // Método de ingreso
    public void ingreso(double cantidad) {
        this.saldo += cantidad;
    }

    // Método de egreso
    public void egreso(double cantidad) {
        if (cantidad <= this.saldo) {
            this.saldo -= cantidad;
        } else {
            System.out.println("Saldo insuficiente para realizar el egreso.");
        }
    }

    // Método de reintegro
    public void reintegro(double cantidad) {
        this.ingreso(cantidad);  // Se puede implementar como un ingreso ya que es un reintegro al saldo.
    }

    // Método de transferencia
    public void transferencia(CuentaCorriente cuentaDestino, double cantidad) {
        if (cantidad <= this.saldo) {
            this.egreso(cantidad);
            cuentaDestino.ingreso(cantidad);
        } else {
            System.out.println("Saldo insuficiente para realizar la transferencia.");
        }
    }

    // Métodos de acceso (getters y setters)
    public double getSaldo() {
        return this.saldo;
    }

    public void setSaldo(double nuevoSaldo) {
        this.saldo = nuevoSaldo;
    }

    public static void main(String[] args) {
        // Ejemplo de uso:
        CuentaCorriente cuenta1 = new CuentaCorriente(1000.0);
        System.out.println("Saldo inicial de cuenta1: " + cuenta1.getSaldo());  // Salida: Saldo inicial de cuenta1: 1000.0

        CuentaCorriente cuenta2 = new CuentaCorriente();
        System.out.println("Saldo inicial de cuenta2: " + cuenta2.getSaldo());  // Salida: Saldo inicial de cuenta2: 0.0

        // Realizar operaciones
        cuenta1.egreso(200.0);
        cuenta2.ingreso(300.0);

        System.out.println("Saldo actual de cuenta1: " + cuenta1.getSaldo());  // Salida: Saldo actual de cuenta1: 800.0
        System.out.println("Saldo actual de cuenta2: " + cuenta2.getSaldo());  // Salida: Saldo actual de cuenta2: 300.0

        // Transferencia entre cuentas
        cuenta1.transferencia(cuenta2, 500.0);

        System.out.println("Saldo actual de cuenta1: " + cuenta1.getSaldo());  // Salida: Saldo actual de cuenta1: 300.0
        System.out.println("Saldo actual de cuenta2: " + cuenta2.getSaldo());  // Salida: Saldo actual de cuenta2: 800.0
    }
}
