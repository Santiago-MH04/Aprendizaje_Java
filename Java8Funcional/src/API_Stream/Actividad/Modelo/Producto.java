package API_Stream.Actividad.Modelo;

public class Producto {
        //Atributos de Producto
    private String NombreProducto;
    private double Precio;
    private int Cantidad;

        //Constructores de Producto
    public Producto(String nombreProducto, double precio, int cantidad) {
        this.NombreProducto = nombreProducto;
        this.Precio = precio;
        this.Cantidad = cantidad;
    }

    //Asignadores de atributos de Producto (setter)
        //Lectores de atributos de Producto (getter)
    public String getNombreProducto() {
        return this.NombreProducto;
    }
        public double getPrecio() {
            return this.Precio;
        }
            public int getCantidad() {
                return this.Cantidad;
            }

    //Métodos de Producto
}
