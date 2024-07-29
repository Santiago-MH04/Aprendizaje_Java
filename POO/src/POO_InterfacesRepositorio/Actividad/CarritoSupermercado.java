package POO_InterfacesRepositorio.Actividad;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class CarritoSupermercado <T extends Producto>{
        //Atributos de CarritoSupermercado
    private List<BolsaSupermercado<T>> Compra;

        //Constructores de CarritoSupermercado
    public CarritoSupermercado() {
        this.Compra = new ArrayList<BolsaSupermercado<T>>();
    }
        public CarritoSupermercado(List<BolsaSupermercado<T>> compra) {
            this();
            this.Compra = compra;
        }
    //Asignadores de atributos de CarritoSupermercado (setter)
        //Lectores de atributos de CarritoSupermercado (getter)
    public List<BolsaSupermercado<T>> getCompra() {
        return this.Compra;
    }

        //Métodos de CarritoSupermercado
    public /*<T extends Producto>*/ void addBolsa(BolsaSupermercado</*T*/ ? extends Producto> bolsa){
        this.Compra.add((BolsaSupermercado<T>)bolsa);
    }
    public static String Fecha(){
        LocalDate data = LocalDate.now();
        DateTimeFormatter forma = DateTimeFormatter.ofPattern("EEEE, dd 'de' MMMM yyyy");
        String Fecha = forma.format(data);
        return Fecha.toLowerCase();
    }

    public static <T extends Producto> String Factura(CarritoSupermercado<T> Carrito){
        StringBuilder Detalle = new StringBuilder("Resumen de productos del supermercado")
                .append("\nFecha: " + Fecha());
            Detalle.append("\n");
        for (BolsaSupermercado<T> bolsa : Carrito.getCompra()) { //Cuidado con recorrer la lista, que no la clase
            for (T producto : bolsa.getObjetos()) {
                Detalle.append(producto.DetalleProducto());
                Detalle.append("\n");
            }
            Detalle.append("\n");
        }
        return Detalle.toString();
    }
}
