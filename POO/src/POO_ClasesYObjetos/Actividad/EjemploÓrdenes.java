package POO_ClasesYObjetos.Actividad;

import java.time.LocalDateTime;

public class EjemploÓrdenes {
    public static void main(String[] args) {

        OrdenCompra Compra1 = new OrdenCompra("Lista del mercado");
            Compra1.setCliente(new Cliente("Queso", "Colín"));
            Compra1.setFecha(LocalDateTime.now());
                 //Productos de la orden y poblando con el método addProducto
            Compra1.addProducto(new Producto("Nutrire","Monello", 25500)).
                    addProducto(new Producto("Purina","Félix", 3500)).
                    addProducto(new Producto("Inaba","Churu", 12000)).
                    addProducto(new Producto("Cipa","Free Miau", 50000));

        OrdenCompra Compra2 = new OrdenCompra("Maricaditas varias");
            Compra2.setCliente(new Cliente("Manuelitas", "Torombolitas"));
            Compra2.setFecha(LocalDateTime.now());
                //Productos de la orden y poblando con el método addProducto
            Compra2.addProducto(new Producto("Nissan","Pintura Nissan March", 300000)).
                    addProducto(new Producto("Apple","Pantalla iFono", 250000)).
                    addProducto(new Producto("Adidas","Zapatos", 200000)).
                    addProducto(new Producto("Laboratorios Funat","Proteína en polvo", 30000));

        OrdenCompra Compra3 = new OrdenCompra("Compre y devuélvase a comprar lo que se me olvidó");
            Compra3.setCliente(new Cliente("Elías", "Floriciento"));
            Compra3.setFecha(LocalDateTime.now());
                //Productos de la orden y poblando con el método addProducto
            Compra3.addProducto(new Producto("Henna","Henna borgoña", 15000)).
                    addProducto(new Producto(null,"Cilantro", 500)).
                    addProducto(new Producto("Bosi","Zapatos", 370000)).
                    addProducto(new Producto("P&G","HeversSchovers", 15000));

        OrdenCompra[] órdenes = {Compra1, Compra2, Compra3};

        OrdenCompra ResumenCompra = new OrdenCompra(null);
        System.out.println("Compra en el almacén HolaMundo");
        System.out.println(ResumenCompra.setFecha(LocalDateTime.now()));
        for (OrdenCompra urdinare: órdenes) {
            System.out.println(urdinare);
        }
    }
}
