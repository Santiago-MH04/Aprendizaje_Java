package API_Stream.Lecciones;

import API_Stream.Lecciones.Modelo.Usuario;

import java.util.IntSummaryStatistics;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class EjemploStream_OperadorDistinct_UsuarioSum {
    public static void main(String[] args) {
            //Creación y modificación directa usando Map
        IntStream LongitudNombres = Stream.of("Quesozuelos Pechochuelos", "Colín Colín", "Elías Floriciento",
                        "Manuelitas torombolitas", "Santiaguito Bonitico", "Quesozuelos Pechochuelos",
                        "Quesozuelos Pechochuelos")
                .map(Nombre -> new Usuario(Nombre.split(" ")[0], Nombre.split(" ")[1]))
                .distinct()
                .mapToInt(u -> u.toString().length())  //Para calcular la cantidad de caracteres de cada nombre del Stream
                .peek(System.out::println);

        //LongitudNombres.forEach(System.out::println); //Con este operador final, no puedo tener otros operadores finales
                                                        // en el código sin caer en un error
        IntSummaryStatistics Stats = LongitudNombres.summaryStatistics();
        System.out.println("Total caracteres del Stream: " + Stats.getSum());
        System.out.println("Nombre más largo: " + Stats.getMax());
        System.out.println("Nombre más corto: " + Stats.getMin());
        System.out.println("Promedio de caracteres por nombre: " + Stats.getAverage());

    }
}
