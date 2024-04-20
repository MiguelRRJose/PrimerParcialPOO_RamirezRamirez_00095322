import java.util.Scanner;


public class Main {
    public static void main(String[] args) {
        GestorInventario gestorInventario = new GestorInventario();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\n=== Sistema de Gestión de Inventario ElectroMart ===");
            System.out.println("1. Agregar Artículo");
            System.out.println("2. Modificar Artículo");
            System.out.println("3. Ver Inventario");
            System.out.println("4. Salir");

            System.out.print("Ingrese su opción: ");
            int opcion = scanner.nextInt();

            switch (opcion) {
                case 1:
                    agregarArticuloMenu(gestorInventario, scanner);
                    break;
                case 2:
                    modificarArticuloMenu(gestorInventario, scanner);
                    break;
                case 3:
                    gestorInventario.mostrarInventario();
                    break;
                case 4:
                    System.out.println("Saliendo...");
                    System.exit(0);
                default:
                    System.out.println("Opción inválida. Por favor ingrese una opción válida.");
            }
        }
    }

    private static void agregarArticuloMenu(GestorInventario gestorInventario, Scanner scanner) {
        System.out.println("\nAgregar Artículo:");
        System.out.println("1. Teléfono Móvil");
        System.out.println("2. Laptop");
        System.out.print("Seleccione el tipo de artículo que desea agregar: ");
        int tipoArticulo = scanner.nextInt();
        scanner.nextLine(); // Consumir el salto de línea

        switch (tipoArticulo) {
            case 1:
                agregarTelefonoMovil(gestorInventario, scanner);
                break;
            case 2:
                agregarLaptop(gestorInventario, scanner);
                break;
            default:
                System.out.println("Tipo de artículo inválido.");
        }
    }

    private static void agregarTelefonoMovil(GestorInventario gestorInventario, Scanner scanner) {
        System.out.print("Nombre del teléfono móvil: ");
        String nombre = scanner.nextLine();
        System.out.print("Modelo del teléfono móvil: ");
        String modelo = scanner.nextLine();
        System.out.print("Marca del teléfono móvil: ");
        String marca = scanner.nextLine();
        System.out.print("Almacenamiento del teléfono móvil: ");
        String almacenamiento = scanner.nextLine();
        System.out.print("Precio del teléfono móvil: ");
        double precio = scanner.nextDouble();

        Articulo telefonoMovil = new TelefonoMovil(nombre, modelo, marca, almacenamiento, precio);
        gestorInventario.agregarArticulo(telefonoMovil);
        System.out.println("Teléfono móvil agregado correctamente.");
    }

    private static void agregarLaptop(GestorInventario gestorInventario, Scanner scanner) {
        System.out.print("Nombre de la laptop: ");
        String nombre = scanner.nextLine();
        System.out.print("Modelo de la laptop: ");
        String modelo = scanner.nextLine();
        System.out.print("Marca de la laptop: ");
        String marca = scanner.nextLine();
        System.out.print("Procesador de la laptop: ");
        String procesador = scanner.nextLine();
        System.out.print("Precio de la laptop: ");
        double precio = scanner.nextDouble();

        Articulo laptop = new Laptop(nombre, modelo, marca, procesador, precio);
        gestorInventario.agregarArticulo(laptop);
        System.out.println("Laptop agregada correctamente.");
    }

    private static void modificarArticuloMenu(GestorInventario gestorInventario, Scanner scanner) {
        System.out.print("Ingrese el número del artículo que desea modificar: ");
        int indice = scanner.nextInt();
        scanner.nextLine(); // Consumir el salto de línea

        if (indice >= 1 && indice <= gestorInventario.obtenerTamanoInventario()) {
            System.out.println("Seleccione el tipo de artículo que desea modificar:");
            System.out.println("1. Teléfono Móvil");
            System.out.println("2. Laptop");
            System.out.print("Seleccione: ");
            int tipoArticulo = scanner.nextInt();
            scanner.nextLine(); // Consumir el salto de línea

            switch (tipoArticulo) {
                case 1:
                    modificarTelefonoMovil(gestorInventario, scanner, indice - 1);
                    break;
                case 2:
                    modificarLaptop(gestorInventario, scanner, indice - 1);
                    break;
                default:
                    System.out.println("Tipo de artículo inválido.");
            }
        } else {
            System.out.println("Número de artículo inválido.");
        }
    }

    private static void modificarTelefonoMovil(GestorInventario gestorInventario, Scanner scanner, int indice) {
        Articulo articulo = gestorInventario.obtenerArticulo(indice);
        if (articulo instanceof TelefonoMovil) {
            System.out.println("Modificar Teléfono Móvil:");
            System.out.print("Nuevo nombre: ");
            String nombre = scanner.nextLine();
            System.out.print("Nuevo modelo: ");
            String modelo = scanner.nextLine();
            System.out.print("Nueva marca: ");
            String marca = scanner.nextLine();
            System.out.print("Nuevo almacenamiento: ");
            String almacenamiento = scanner.nextLine();
            System.out.print("Nuevo precio: ");
            double precio = scanner.nextDouble();

            TelefonoMovil nuevoTelefonoMovil = new TelefonoMovil(nombre, modelo, marca, almacenamiento, precio);
            gestorInventario.modificarArticulo(indice, nuevoTelefonoMovil);
            System.out.println("Teléfono móvil modificado correctamente.");
        } else {
            System.out.println("El artículo seleccionado no es un teléfono móvil.");
        }
    }

    private static void modificarLaptop(GestorInventario gestorInventario, Scanner scanner, int indice) {
        Articulo articulo = gestorInventario.obtenerArticulo(indice);
        if (articulo instanceof Laptop) {
            System.out.println("Modificar Laptop:");
            System.out.print("Nuevo nombre: ");
            String nombre = scanner.nextLine();
            System.out.print("Nuevo modelo: ");
            String modelo = scanner.nextLine();
            System.out.print("Nueva marca: ");
            String marca = scanner.nextLine();
            System.out.print("Nuevo procesador: ");
            String procesador = scanner.nextLine();
            System.out.print("Nuevo precio: ");
            double precio = scanner.nextDouble();

            Laptop nuevaLaptop = new Laptop(nombre, modelo, marca, procesador, precio);
            gestorInventario.modificarArticulo(indice, nuevaLaptop);
            System.out.println("Laptop modificada correctamente.");
        } else {
            System.out.println("El artículo seleccionado no es una laptop.");
        }
    }
}
