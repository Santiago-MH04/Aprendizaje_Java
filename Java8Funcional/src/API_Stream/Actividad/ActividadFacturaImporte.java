package API_Stream.Actividad;

import API_Stream.Actividad.Modelo.Producto;

import java.util.ArrayList;
import java.util.List;

public class ActividadFacturaImporte {
    public static void main(String[] args) {
            //Crear y poblar la lista de productos
        List<Producto> Factura = new ArrayList<>();
        Factura.add(new Producto("Monello", 25000d, 2));
        Factura.add(new Producto("Félix", 3000d, 8));
        Factura.add(new Producto("Churu", 12000d, 1));
        Factura.add(new Producto("Free Miau", 57000d, 2));

            //Crear el Stream que devuelve el importe de la factura
        double TotalFactura = Factura.stream()
                .peek(p -> System.out.println(p.getNombreProducto()))
                .map(ip -> ((double)ip.getCantidad())* ip.getPrecio())  //Por cada producto, suma las cantidades por los precios
                .reduce(0d, Double::sum);                        //Obtiene un double con dicha cantidad

        System.out.println("El total de la factura es: $" + TotalFactura);
    }
}
