import java.util.ArrayList;
import java.util.Scanner;

class Producto {
    String nombre;
    double precio;

    public Producto(String nombre, double precio) {
        this.nombre = nombre;
        this.precio = precio;
    }
}

public class Tienda {
    static ArrayList<Producto> inventario = new ArrayList<>();
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int opcion;

        do {
            System.out.println("----- Tienda App -----");
            System.out.println("1. Agregar Producto");
            System.out.println("2. Modificar Precio");
            System.out.println("3. Eliminar Producto");
            System.out.println("4. Mostrar Productos");
            System.out.println("0. Salir");
            System.out.print("Seleccione una opción: ");

            opcion = scanner.nextInt();
            scanner.nextLine(); // Limpiar el buffer de entrada

            switch (opcion) {
                case 1:
                    agregarProducto();
                    break;
                case 2:
                    modificarPrecio();
                    break;
                case 3:
                    eliminarProducto();
                    break;
                case 4:
                    mostrarProductos();
                    break;
                case 0:
                    System.out.println("¡Hasta luego!");
                    break;
                default:
                    System.out.println("Opción no válida. Inténtelo de nuevo.");
            }
        } while (opcion != 0);
    }

    static void agregarProducto() {
        System.out.print("Ingrese el nombre del producto: ");
        String nombre = scanner.nextLine();
        System.out.print("Ingrese el precio del producto: ");
        double precio = scanner.nextDouble();

        Producto nuevoProducto = new Producto(nombre, precio);
        inventario.add(nuevoProducto);

        System.out.println("Producto agregado con éxito.");
    }

    static void modificarPrecio() {
        System.out.print("Ingrese el nombre del producto a modificar: ");
        String nombre = scanner.nextLine();

        for (Producto producto : inventario) {
            if (producto.nombre.equalsIgnoreCase(nombre)) {
                System.out.print("Ingrese el nuevo precio para " + producto.nombre + ": ");
                double nuevoPrecio = scanner.nextDouble();
                producto.precio = nuevoPrecio;
                System.out.println("Precio modificado con éxito.");
                return;
            }
        }

        System.out.println("Producto no encontrado.");
    }

    static void eliminarProducto() {
        System.out.print("Ingrese el nombre del producto a eliminar: ");
        String nombre = scanner.nextLine();

        for (Producto producto : inventario) {
            if (producto.nombre.equalsIgnoreCase(nombre)) {
                inventario.remove(producto);
                System.out.println("Producto eliminado con éxito.");
                return;
            }
        }

        System.out.println("Producto no encontrado.");
    }

    static void mostrarProductos() {
        System.out.println("----- Inventario -----");
        for (Producto producto : inventario) {
            System.out.println(producto.nombre + " - Precio: " + producto.precio);
        }
        System.out.println("-----------------------");
    }
}
