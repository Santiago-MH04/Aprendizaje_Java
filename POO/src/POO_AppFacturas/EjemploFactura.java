package POO_AppFacturas;

import POO_AppFacturas.Modelo.*;
import java.util.Scanner;

public class EjemploFactura {
    public static void main(String[] args) {

        Cliente cliente = new Cliente();
        cliente.setNombre("Quesozuelos");
        cliente.setNIT("290517-0001");

        Scanner s = new Scanner(System.in);
        System.out.println("Ingresar la descripción de la factura: ");
        String desc = s.nextLine();
        Factura factura = new Factura(desc, cliente);

        Producto producto;
        String nombre;
        float precio;
        int cantidad;

        System.out.println();

        for (int i = 0; i < 5; i++){
            producto = new Producto();

            System.out.print("Ingrese el producto # " + producto.getCódigo() + ": ");
            nombre = s.next();
            producto.setNombre(s.next());

            System.out.print("Ingrese el precio: ");
            precio = s.nextFloat();
            producto.setPrecio(precio);

            System.out.print("Ingrese la cantidad: ");
            cantidad = s.nextInt();

            ÍtemFactura ítem = new ÍtemFactura(producto, cantidad);
            factura.addÍtemFactura(ítem);

            System.out.println();
            s.nextLine();
        }
        System.out.println(factura);
    }
}
