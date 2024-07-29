package API_Stream.Lecciones;

import API_Stream.Lecciones.Modelo.Usuario;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class EjemploStream_OperadorMap {
    public static void main(String[] args) {

            //Creación y modificación directa usando Map
                //Recordar que un flujo no se ejecuta si no lo invoca una función final, tal como el .forEach()
        Stream<Usuario> Nombres = Stream.of("Quesozuelos Pechochuelos" , "Colín Colín", "Elías Floriciento", "Manuelitas Torombolitas", "Santiaguito Bonitico")
                .map(Nombre -> new Usuario(Nombre.split(" ")[0], Nombre.split(" ")[1]))
                .peek(System.out::println) //Operador intermedio... NO DEVUELVE NADA. Pero qué gran ayuda saber que la clase Usuario contiene el método toString()
                .map(usuario -> {
                    String NombreUsuario = usuario.getNombre().toUpperCase();
                    usuario.setNombre(NombreUsuario);
                    return usuario;
                });
        //Nombres.forEach(System.out::println);

        List<Usuario> ListaNombres = Nombres.toList();
        //List<Usuario> ListaNombres = Nombres.collect(Collectors.toList());
        ListaNombres.forEach(System.out::println);

                /*String s = "";
                Integer[] a = {5, 8, 9, 0, 66, 18};

                for (int i = 1; i < a.length; i++){
                    if ((a[i] % 2 == 0) && (a[i-1] % 3 == 0)){
                        s += a[i]/2;
                    } else {
                       s += 2*a[i];
                    }
                }
                //goto_url("multisoft.se/" + s);
                System.out.println(s);*/

        //Una forma de evitar funcionar con un elemento void es no referenciando
        /*Stream.of("Quesozuelos" , "Colín Colín", "Elías Floriciento", "Manuelitas torombolitas", "Santiaguito")
                .map(nombre -> {
                    return nombre.toUpperCase();
                }).forEach(System.out::println);*/
    }
}
