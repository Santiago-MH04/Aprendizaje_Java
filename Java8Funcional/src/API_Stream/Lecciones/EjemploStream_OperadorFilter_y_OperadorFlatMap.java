package API_Stream.Lecciones;

import API_Stream.Lecciones.Modelo.Usuario;

import java.util.stream.Stream;

public class EjemploStream_OperadorFilter_y_OperadorFlatMap {
    public static void main(String[] args) {
            //Creación y modificación directa usando Map
        Stream<Usuario> Nombres = Stream.of("Quesozuelos Pechochuelos" , "Colín Colín", "Elías Floriciento", "Manuelitas torombolitas", "Santiaguito Bonitico", "Manuelitas Feítas")
                .map(Nombre -> new Usuario(Nombre.split(" ")[0], Nombre.split(" ")[1]))
                //.filter(u -> u.getNombre().equals("Manuelitas"))
                .flatMap(u -> {
                    if(u.getNombre().equalsIgnoreCase("Manuelitas")){
                        return Stream.of(u);
                    }
                    return Stream.empty();  //Se crea un Stream en un caso o el otro. Se cumple la misma función del filter
                })
                .peek(System.out::println);
        Nombres.forEach(System.out::println); //Operador terminal
        //System.out.println(Nombres.count());

        //List<Usuario> ListaNombres = Nombres.toList();
        //List<Usuario> ListaNombres = Nombres.collect(Collectors.toList());
        //ListaNombres.forEach(System.out::println); //Operador terminal
    }
}
