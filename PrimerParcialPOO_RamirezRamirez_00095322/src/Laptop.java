public class Laptop extends ArticuloElectronicoAbstracto {
    private String tamanoPantalla;
    private String procesador;
    private int ram;
    private int almacenamiento;

    public Laptop(String nombre, String modelo, String descripcion, double precio, String tamanoPantalla, String procesador, int ram, int almacenamiento) {
        super(nombre, modelo, descripcion, precio);
        this.tamanoPantalla = tamanoPantalla;
        this.procesador = procesador;
        this.ram = ram;
        this.almacenamiento = almacenamiento;
    }

    @Override
    public String toString() {
        return super.toString() + "\n" +
                "Tamaño de Pantalla: " + tamanoPantalla + "\n" +
                "Procesador: " + procesador + "\n" +
                "RAM: " + ram + "GB\n" +
                "Almacenamiento: " + almacenamiento + "GB";
    }
}
