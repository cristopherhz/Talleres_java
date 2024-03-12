import java.util.Random;

public class Persona {
    private String nombre;
    private int edad;
    private String DNI;
    private char sexo;
    private double peso;
    private double altura;

    private static final char SEXO_DEFECTO = 'H';
    private static final int PESO_IDEAL_BAJO = -1;
    private static final int PESO_IDEAL_NORMAL = 0;
    private static final int PESO_IDEAL_ALTO = 1;

    public Persona() {
        this("", 0, SEXO_DEFECTO, 0, 0);
    }

    public Persona(String nombre, int edad, char sexo) {
        this(nombre, edad, sexo, 0, 0);
    }

    public Persona(String nombre, int edad, char sexo, double peso, double altura) {
        this.nombre = nombre;
        this.edad = edad;
        this.sexo = comprobarSexo(sexo);
        this.peso = peso;
        this.altura = altura;
        this.DNI = generaDNI();
    }

    public int calcularIMC() {
        double imc = peso / Math.pow(altura, 2);

        if (imc < 20) {
            return PESO_IDEAL_BAJO;
        } else if (imc >= 20 && imc <= 25) {
            return PESO_IDEAL_NORMAL;
        } else {
            return PESO_IDEAL_ALTO;
        }
    }

    public boolean esMayorDeEdad() {
        return edad >= 18;
    }

    private char comprobarSexo(char sexo) {
        return (sexo == 'H' || sexo == 'M') ? sexo : SEXO_DEFECTO;
    }

    private String generaDNI() {
        Random rand = new Random();
        int numeroDNI = rand.nextInt(90000000) + 10000000;
        char letra = "TRWAGMYFPDXBNJZSQVHLCKE".charAt(numeroDNI % 23);
        return Integer.toString(numeroDNI) + letra;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public void setSexo(char sexo) {
        this.sexo = comprobarSexo(sexo);
    }

    public void setPeso(double peso) {
        this.peso = peso;
    }

    public void setAltura(double altura) {
        this.altura = altura;
    }

    @Override
    public String toString() {
        return "Nombre: " + nombre + "\nEdad: " + edad + "\nDNI: " + DNI + "\nSexo: " + sexo
                + "\nPeso: " + peso + " kg\nAltura: " + altura + " m";
    }
}

