import java.util.GregorianCalendar;

public class Fecha {
    private GregorianCalendar calendar;

    // Constructor por defecto
    public Fecha() {
        this.calendar = new GregorianCalendar();
    }

    // Constructor con parámetros (día, mes, año)
    public Fecha(int dia, int mes, int año) {
        if (esFechaValida(dia, mes, año)) {
            this.calendar = new GregorianCalendar(año, mes - 1, dia); // Meses en Java se cuentan desde 0 (enero) a 11 (diciembre)
        } else {
            System.out.println("Fecha no válida.");
            this.calendar = new GregorianCalendar();
        }
    }

    // Constructor copia
    public Fecha(Fecha otraFecha) {
        this.calendar = (GregorianCalendar) otraFecha.calendar.clone();
    }

    // Métodos de acceso (getters y setters)
    public int getDia() {
        return this.calendar.get(GregorianCalendar.DAY_OF_MONTH);
    }

    public void setDia(int dia) {
        if (esFechaValida(dia, getMes(), getAnio())) {
            this.calendar.set(GregorianCalendar.DAY_OF_MONTH, dia);
        } else {
            System.out.println("Fecha no válida.");
        }
    }

    public int getMes() {
        return this.calendar.get(GregorianCalendar.MONTH) + 1; // Se suma 1 porque en Java los meses van de 0 a 11
    }

    public void setMes(int mes) {
        if (esFechaValida(getDia(), mes, getAnio())) {
            this.calendar.set(GregorianCalendar.MONTH, mes - 1);
        } else {
            System.out.println("Fecha no válida.");
        }
    }

    public int getAnio() {
        return this.calendar.get(GregorianCalendar.YEAR);
    }

    public void setAnio(int anio) {
        if (esFechaValida(getDia(), getMes(), anio)) {
            this.calendar.set(GregorianCalendar.YEAR, anio);
        } else {
            System.out.println("Fecha no válida.");
        }
    }

    // Método para comprobar si la fecha es válida
    private boolean esFechaValida(int dia, int mes, int anio) {
        try {
            new GregorianCalendar(anio, mes - 1, dia); // Intenta crear una fecha con los parámetros
            return true;
        } catch (IllegalArgumentException e) {
            return false;
        }
    }

    // Método para sumar un día a la fecha actual
    public void sumarUnDia() {
        this.calendar.add(GregorianCalendar.DAY_OF_MONTH, 1);
    }

    // Método toString
    @Override
    public String toString() {
        return String.format("%02d/%02d/%04d", getDia(), getMes(), getAnio());
    }

    public static void main(String[] args) {
        // Ejemplo de uso:
        Fecha fecha1 = new Fecha(29, 2, 2024); // Fecha válida, año bisiesto
        System.out.println("Fecha 1: " + fecha1);  // Salida: Fecha 1: 29/02/2024

        Fecha fecha2 = new Fecha(31, 4, 2022); // Fecha no válida, abril solo tiene 30 días
        System.out.println("Fecha 2: " + fecha2);  // Salida: Fecha 2: Fecha no válida.

        fecha1.sumarUnDia();
        System.out.println("Fecha 1 después de sumar un día: " + fecha1);  // Salida: Fecha 1 después de sumar un día: 01/03/2024
    }
}