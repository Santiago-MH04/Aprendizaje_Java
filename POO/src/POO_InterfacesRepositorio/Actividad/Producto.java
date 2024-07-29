package POO_InterfacesRepositorio.Actividad;

public abstract class Producto {
        //Atributos de Producto
    protected String Nombre;
    protected Double Precio;

        //Constructores de Producto
    public Producto() {
    }
    public Producto(String nombre, Double precio) {
        this();
        this.Nombre = nombre;
        this.Precio = precio;
    }

    //Asignadores de atributos de Producto (setter)
        //Lectores de atributos de Producto (getter)
    public String getNombre() {
        return this.Nombre;
    }
    public Double getPrecio() {
        return this.Precio;
    }

        //Métodos de Producto
    public String DetalleProducto(){
        return this.getNombre() +
                "\nPrecio: $" + this.getPrecio();
    }
}
