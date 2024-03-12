public class Libro {
    private String titulo;
    private String isbn;
    private String autor;

    // Constructor por defecto
    public Libro() {
        this.titulo = "";
        this.isbn = "";
        this.autor = "";
    }

    // Constructor con parámetros
    public Libro(String titulo, String isbn, String autor) {
        this.titulo = titulo;
        this.isbn = isbn;
        this.autor = autor;
    }

    // Métodos de acceso (getters y setters)
    public String getTitulo() {
        return this.titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getIsbn() {
        return this.isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getAutor() {
        return this.autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    // Método de préstamo
    public void prestamo() {
        System.out.println("El libro \"" + this.titulo + "\" ha sido prestado.");
    }

    // Método de devolución
    public void devolucion() {
        System.out.println("El libro \"" + this.titulo + "\" ha sido devuelto.");
    }

    // Método toString
    @Override
    public String toString() {
        return "\"" + this.titulo + "\", " + this.isbn + ", " + this.autor;
    }

    public static void main(String[] args) {
        // Ejemplo de uso:
        Libro libro1 = new Libro("Harry Potter", "9780545582889", "Rowling, J. K.");

        System.out.println("Información del libro:");
        System.out.println(libro1.toString());  // Salida: "Harry Potter", 9780545582889, Rowling, J. K.

        libro1.prestamo();
        libro1.devolucion();
    }
}