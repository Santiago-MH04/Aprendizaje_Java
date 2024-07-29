package POO_AppFacturas.Modelo;

public class ÍtemFactura {
        //Atributos clase ÍtemFactura
    private Producto Producto;
    private int Cantidad;

        //Constructores de Producto
    public ÍtemFactura(Producto producto, int cantidad) {
        this.Producto = producto;
        this.Cantidad = cantidad;
    }

        //Asignadores de atributos (setter)
    public void setProducto(Producto producto) {
        this.Producto = producto;
    }
        public void setCantidad(int cantidad) {
            this.Cantidad = cantidad;
        }

        //Lectores de atributos (getter)
    public Producto getProducto() {
        return this.Producto;
    }
        public int getCantidad() {
            return this.Cantidad;
        }

        //Métodos de ÍtemFactura
    public float calcularImporte(){
        return this.Cantidad * this.Producto.getPrecio();
    }
    @Override
    public String toString() {
        return this.Producto.toString() +
                "\t" + this.Cantidad +
                "\t" + calcularImporte();
    }
}
