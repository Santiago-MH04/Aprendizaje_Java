package APIServlet.Session.Lecciones.Models;

import java.util.Objects;

public class ItemCarrito {
        //Atributos de ÍtemCarrito
    private Producto Producto;
    private int Cantidad;

        //Constructores de ÍtemCarrito
    public ItemCarrito(Producto producto, int cantidad) {
        this.Producto = producto;
        this.Cantidad = cantidad;
    }

        //Asignadores de atributos de ÍtemCarrito (setter)
    public void setProducto(APIServlet.Session.Lecciones.Models.Producto producto) {
        this.Producto = producto;
    }
        public void setCantidad(int cantidad) {
            this.Cantidad = cantidad;
        }

        //Lectores de atributos de ÍtemCarrito (getter)
    public Producto getProducto() {
        return this.Producto;
    }
        public int getCantidad() {
            return this.Cantidad;
        }

        //Métodos de ÍtemCarrito
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || this.getClass() != o.getClass()) return false;

        ItemCarrito that = (ItemCarrito) o;
        return Objects.equals(this.Producto.getID(), that.getProducto().getID())
                && Objects.equals(this.Producto.getNombre(), that.getProducto().getNombre());
    }
    public int getImporte(){
        return this.Cantidad * this.Producto.getPrecio();
    }
}
