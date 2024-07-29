package API_Stream.Lecciones;

import API_Stream.Lecciones.Modelo.Usuario;

import java.util.Optional;
import java.util.stream.Stream;

public class EjemploStream_OperadorFilter_Single {
    public static void main(String[] args) {
            //Creación y modificación directa usando Map
        Stream<Usuario> Nombres = Stream.of("Quesozuelos Pechochuelos" , "Colín Colín", "Elías Floriciento", "Manuelitas torombolitas", "Santiaguito Bonitico", "Manuelitas Feítas")
                .map(Nombre -> new Usuario(Nombre.split(" ")[0], Nombre.split(" ")[1]))
                /*.peek(System.out::println)*/   //Para que no imprima la dirección de memoria del objeto Usuario
                .filter(u -> u.getNombre().equals("Manuelas"));

        //Nombres.forEach(System.out::println);

            //Uso del Optional para "evitar" arrojar excepciones
        Optional<Usuario> UsuarioEncontrado = Nombres.findFirst();
        //System.out.println(UsuarioEncontrado.orElse(new Usuario("Pepito", "Pérez"))); //Así se obtiene un único objeto
        //System.out.println(UsuarioEncontrado.orElseThrow(); //El ElseThrow lanza una excepción

            //Otras dos formas de representar el mismo fenómeno
        System.out.println(UsuarioEncontrado.orElseGet(() -> new Usuario("Pepito", "Pérez")));
        if(UsuarioEncontrado.isPresent()){  //Método encontrado a partir de Java 11
            System.out.println(UsuarioEncontrado);
        } else{
            System.out.println("No se ha encontrado a dicho usuario");
        }

        //List<Usuario> ListaNombres = Nombres.toList();        //Este es un operador terminal
        //List<Usuario> ListaNombres = Nombres.collect(Collectors.toList());
        //ListaNombres.forEach(System.out::println);
    }
}
