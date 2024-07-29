package API_Stream.Lecciones;

import API_Stream.Lecciones.Modelo.Usuario;

import java.util.Optional;
import java.util.stream.Stream;

public class EjemploStream_OperadorFilter_Empty {
    public static void main(String[] args) {
            //Creación y modificación directa usando Map
        long CantidadNombres = Stream.of("Quesozuelos Pechochuelos" , "Colín Colín", "", "Manuelitas torombolitas", "Santiaguito Bonitico", "Manuelitas Feítas")
                .filter(String::isEmpty)
                .peek(System.out::println)
                .count();

        System.out.println("Cantidad de nombres vacíos: " + CantidadNombres);
    }
}
