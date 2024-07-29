package API_Stream.Lecciones;

import API_Stream.Lecciones.Modelo.Usuario;

import java.util.Optional;
import java.util.stream.Stream;

public class EjemploStream_OperadorDistinct_Usuario {
    public static void main(String[] args) {
            //Creación y modificación directa usando Map
        Stream<Usuario> Nombres = Stream.of("Quesozuelos Pechochuelos", "Colín Colín", "Elías Floriciento",
                        "Manuelitas torombolitas", "Santiaguito Bonitico", "Quesozuelos Pechochuelos",
                        "Quesozuelos Pechochuelos")
                .map(Nombre -> new Usuario(Nombre.split(" ")[0], Nombre.split(" ")[1]))
                .distinct();
        Nombres.forEach(System.out::println);
    }
}
