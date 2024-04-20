public abstract class ArticuloElectronicoAbstracto implements ArticuloElectronico {
    protected String nombre;
    protected String modelo;
    protected String descripcion;
    protected double precio;

    public ArticuloElectronicoAbstracto(String nombre, String modelo, String descripcion, double precio) {
        this.nombre = nombre;
        this.modelo = modelo;
        this.descripcion = descripcion;
        this.precio = precio;
    }

    @Override
    public double obtenerPrecio() {
        return precio;
    }

    @Override
    public String obtenerDescripcion() {
        return descripcion;
    }

    @Override
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    @Override
    public void setPrecio(double precio) {
        this.precio = precio;
    }

    @Override
    public String obtenerModelo() {
        return modelo;
    }

    @Override
    public String toString() {
        return "Nombre: " + nombre + "\n" +
                "Modelo: " + modelo + "\n" +
                "Descripción: " + descripcion + "\n" +
                "Precio: $" + precio;
    }
}

