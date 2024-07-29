package API_Stream.Lecciones;

import API_Stream.Lecciones.Modelo.Factura;
import API_Stream.Lecciones.Modelo.Usuario;

import java.util.Arrays;
import java.util.List;

public class EjemploStream_FlatMap_Factura {
    public static void main(String[] args) {
            //Crear a los usuarios
        Usuario u1 = new Usuario("Pepito", "Pérez");
        Usuario u2 = new Usuario("Pepa", "Pombo");

            //Añadir los artículos a la factura
        u1.addFactura(new Factura("Comida para los gatos"));
        u1.addFactura(new Factura("Juguetes para los gatos"));

        u2.addFactura(new Factura("Muebles para escritorio"));
        u2.addFactura(new Factura("Maricaditas varias"));

            //Crear la lista con los usuarios
        List<Usuario> ListaUsuarios = Arrays.asList(u1, u2);

        ListaUsuarios.stream()
                //.map(Usuario::getFacturas)
                .flatMap(u -> u.getFacturas().stream())         //Se puede hacer esto, dado que getFacturas()
                                                                // devuelve una lista de facturas, y generamos un Stream
                                                                // de facturas
                //.flatMap(List::stream)
                .forEach(f -> System.out.println("Cliente: ".concat(f.getUsuarioFactura().toString()).concat("\n")
                        .concat(f.getDescripción())));
    }
}
