package Variables;

import java.util.Locale;
import java.util.Scanner;

import java.util.*;
import java.lang.*;
import java.io.*;


public class DetalleDeFactura {
    public static void main(String[] args) {

        Scanner miFactura = new Scanner(System.in).useLocale(Locale.US);

        System.out.println("Bienvenido a su generador de facturas. Por favor ingrese los precios de los dos productos que acaba de comprar");
        System.out.println("Primer producto: $");
        double miProducto1 = miFactura.nextDouble();
        System.out.println("Segundo producto: $");
        double miProducto2 = miFactura.nextDouble();

        double subTotal = miProducto1 + miProducto2;
        double impuesto = Math.round((0.19*subTotal)*100.0)/100.0;
            // Con esta línea se redondea a dos cifras
        double Total = subTotal + impuesto;

        String Mensaje = "Resumen de factura \n";
        Mensaje += "La factura se clasifica de la siguiente manera: \n";
        Mensaje += "Producto 1: $" + miProducto1 + "\n";
        Mensaje += "Producto 2: $" + miProducto2 + "\n";
        Mensaje += "Subtotal: $" + subTotal + "\n";
        Mensaje += "Impuestos: $" + impuesto + "\n";
        Mensaje += "Total: $" + Total;

        System.out.println(Mensaje);
    }
}
