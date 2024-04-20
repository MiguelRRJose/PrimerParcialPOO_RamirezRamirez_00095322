import java.util.ArrayList;
import java.util.Scanner;

public class SistemaInventario {
    private ArrayList<ArticuloElectronico> inventario = new ArrayList<>();
    private Scanner scanner = new Scanner(System.in);

    public void ejecutar() {
        boolean salir = false;
        while (!salir) {
            System.out.println("\nSistema de Gestión de Inventario Electrónico");
            System.out.println("1. Agregar Artículo");
            System.out.println("2. Actualizar Artículo");
            System.out.println("3. Ver Todos los Artículos");
            System.out.println("4. Salir");
            System.out.print("Seleccione una opción: ");
            int opcion = scanner.nextInt();
            scanner.nextLine(); // Consumir el carácter nueva línea

            switch (opcion) {
                case 1:
                    agregarArticulo();
                    break;
                case 2:
                    actualizarArticulo();
                    break;
                case 3:
                    verTodosLosArticulos();
                    break;
                case 4:
                    salir = true;
                    break;
                default:
                    System.out.println("Opción inválida. Por favor, inténtelo de nuevo.");
            }
        }
        scanner.close();
    }

    private void agregarArticulo() {
        System.out.println("\nAgregar Artículo");
        System.out.println("1. Teléfono Móvil");
        System.out.println("2. Laptop");
        System.out.print("Seleccione una opción: ");
        int opcion = scanner.nextInt();
        scanner.nextLine(); // Consumir el carácter nueva línea

        System.out.print("Ingrese el Nombre: ");
        String nombre = scanner.nextLine();
        System.out.print("Ingrese el Modelo: ");
        String modelo = scanner.nextLine();
        System.out.print("Ingrese la Descripción: ");
        String descripcion = scanner.nextLine();
        System.out.print("Ingrese el Precio: $");
        double precio = scanner.nextDouble();
        scanner.nextLine(); // Consumir el carácter nueva línea

        switch (opcion) {
            case 1:
                System.out.print("Ingrese el Tamaño de Pantalla: ");
                String tamanoPantalla = scanner.nextLine();
                System.out.print("Ingrese el Procesador: ");
                String procesador = scanner.nextLine();
                inventario.add(new TelefonoMovil(nombre, modelo, descripcion, precio, tamanoPantalla, procesador));
                System.out.println("¡Teléfono Móvil agregado exitosamente!");
                break;
            case 2:
                System.out.print("Ingrese el Tamaño de Pantalla: ");
                tamanoPantalla = scanner.nextLine();
                System.out.print("Ingrese el Procesador: ");
                procesador = scanner.nextLine();
                System.out.print("Ingrese la RAM (GB): ");
                int ram = scanner.nextInt();
                System.out.print("Ingrese el Almacenamiento (GB): ");
                int almacenamiento = scanner.nextInt();
                inventario.add(new Laptop(nombre, modelo, descripcion, precio, tamanoPantalla, procesador, ram, almacenamiento));
                System.out.println("¡Laptop agregada exitosamente!");
                break;
            default:
                System.out.println("Opción inválida. Artículo no agregado.");
        }
    }

    private void actualizarArticulo() {
        if (inventario.isEmpty()) {
            System.out.println("El inventario está vacío. No hay nada que actualizar.");
            return;
        }

        System.out.println("\nActualizar Artículo");
        System.out.println("Seleccione un artículo para actualizar:");

        for (int i = 0; i < inventario.size(); i++) {
            System.out.println((i + 1) + ". " + inventario.get(i).obtenerDescripcion() + " - " + inventario.get(i).obtenerModelo());
        }

        System.out.print("Ingrese el número de artículo: ");
        int numeroArticulo = scanner.nextInt();
        scanner.nextLine(); // Consumir el carácter nueva línea

        if (numeroArticulo < 1 || numeroArticulo > inventario.size()) {
            System.out.println("Número de artículo inválido.");
            return;
        }

        ArticuloElectronico articulo = inventario.get(numeroArticulo - 1);
        System.out.print("Ingrese la nueva Descripción: ");
        String descripcion = scanner.nextLine();
        System.out.print("Ingrese el nuevo Precio: $");
        double precio = scanner.nextDouble();
        scanner.nextLine(); // Consumir el carácter nueva línea
        articulo.setDescripcion(descripcion);
        articulo.setPrecio(precio);
        System.out.println("¡Artículo actualizado exitosamente!");
    }

    private void verTodosLosArticulos() {
        if (inventario.isEmpty()) {
            System.out.println("El inventario está vacío.");
            return;
        }

        System.out.println("\nTodos los Artículos en el Inventario:");
        for (int i = 0; i < inventario.size(); i++) {
            System.out.println("\nArtículo " + (i + 1) + ":");
            System.out.println(inventario.get(i));
        }
    }

    public static void main(String[] args) {
        SistemaInventario sistemaInventario = new SistemaInventario();
        sistemaInventario.ejecutar();
    }
}
