package API_Stream.Lecciones;

import API_Stream.Lecciones.Modelo.Usuario;

import java.util.Optional;
import java.util.stream.Stream;

public class EjemploStream_OperadorDistinct {
    public static void main(String[] args) {
            //Creación y modificación directa usando Map
        Stream.of("Quesozuelos Pechochuelos" , "Colín Colín", "Elías Floriciento", "Quesozuelos Pechochuelos", "Manuelitas torombolitas", "Santiaguito Bonitico", "Manuelitas Feítas", "Quesozuelos Pechochuelos")
                .distinct()     //Manda a volar elementos repetidos dentro del Stream
                .forEach(System.out::println);


    }
}
