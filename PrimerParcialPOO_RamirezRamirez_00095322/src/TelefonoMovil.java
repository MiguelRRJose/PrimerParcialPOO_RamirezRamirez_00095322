public class TelefonoMovil extends ArticuloElectronicoAbstracto {
    private String tamanoPantalla;
    private String procesador;

    public TelefonoMovil(String nombre, String modelo, String descripcion, double precio, String tamanoPantalla, String procesador) {
        super(nombre, modelo, descripcion, precio);
        this.tamanoPantalla = tamanoPantalla;
        this.procesador = procesador;
    }

    @Override
    public String toString() {
        return super.toString() + "\n" +
                "Tamaño de Pantalla: " + tamanoPantalla + "\n" +
                "Procesador: " + procesador;
    }
}
