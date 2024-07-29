package API_Stream.Lecciones;

import API_Stream.Lecciones.Modelo.Usuario;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.stream.Stream;

public class EjemploStream_Parallel {
    public static void main(String[] args) {

        List<Usuario> ListaUsuarios = new ArrayList<>();
            ListaUsuarios.add(new Usuario("Cocacolín", "Torombolín"));
            ListaUsuarios.add(new Usuario("Quesozuelos", "Torombozuelos"));
            ListaUsuarios.add(new Usuario("Manuelitas", "Torombolitas"));
            ListaUsuarios.add(new Usuario("Elías", "Floriciento"));
            ListaUsuarios.add(new Usuario("Santiaguito", "Bonito"));
            ListaUsuarios.add(new Usuario("Quesozuelos", "Pechochuelos"));
            ListaUsuarios.add(new Usuario("Quesozuelos", "Quesosaurio"));

        long t1 = System.currentTimeMillis();
        String Usuarios_ListaAString = ListaUsuarios.stream()
                .parallel()                                         //Crea un carrete de procesos que buscan la instrucción dada
                .map( u -> (u.toString().toUpperCase()) )
                .peek(NombreCompleto -> {
                    System.out.println("Nombre hilo: " + Thread.currentThread().getName()
                            + ". Nombre usuario: " + NombreCompleto);
                })
                .flatMap(nombre -> {                                //Este FlatMap devuelve una instancia de String
                    try {
                        TimeUnit.SECONDS.sleep(1);
                        if(nombre.contains("Quesozuelos".toUpperCase())){
                            return Stream.of(nombre);
                        }
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                    return Stream.empty();
                })
                .findAny().orElse("");      //Devuelve de manera aleatoria a cualquier Usuario con nombre Quesozuelos

        long t2 = System.currentTimeMillis();
        System.out.println("Tiempo transurrido: " + (t2 - t1) + "ms");
        System.out.println(Usuarios_ListaAString);

        /*ListaUsuarios.stream().map(u -> (u.getNombre().concat(" ")      //Con esta instanciación no se puede aplicar un Map,
                                                                            // sólo es al vuelo. Este Map transforma de Usuario a String
                                            .concat(u.getApellido())
                                                .toUpperCase()) )
                              .flatMap(nombre -> {                          //Este FlatMap devuelve una instancia de String
                                  if(nombre.contains("Quesozuelos".toUpperCase())){
                                      return Stream.of(nombre);
                                  }
                                  return Stream.empty();
                              })
                              .map(String::toLowerCase)                     //El operador Map también es recursivo
                              .forEach(System.out::println);*/
    }
}
