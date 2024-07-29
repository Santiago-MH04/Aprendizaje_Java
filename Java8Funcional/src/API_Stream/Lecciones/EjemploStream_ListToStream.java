package API_Stream.Lecciones;

import API_Stream.Lecciones.Modelo.Usuario;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class EjemploStream_ListToStream {
    public static void main(String[] args) {

        List<Usuario> ListaUsuarios = new ArrayList<>();
            ListaUsuarios.add(new Usuario("Cocacolín", "Torombolín"));
            ListaUsuarios.add(new Usuario("Quesozuelos", "Torombozuelos"));
            ListaUsuarios.add(new Usuario("Manuelitas", "Torombolitas"));
            ListaUsuarios.add(new Usuario("Elías", "Floriciento"));
            ListaUsuarios.add(new Usuario("Santiaguito", "Bonito"));
            ListaUsuarios.add(new Usuario("Quesozuelos", "Pechochuelos"));
            ListaUsuarios.add(new Usuario("Quesozuelos", "Quesosaurio"));

        Stream<String> Usuarios_ListaAStream = ListaUsuarios.stream().map(u -> (u.getNombre().concat(" ")   //Con esta instanciación no se puede aplicar un Map,
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
                .peek(System.out::println);

        Usuarios_ListaAStream.forEach(System.out::println);

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
