package API_Stream.Lecciones;

import java.util.stream.Stream;

public class EjemploStream_OperadorReduce {
    public static void main(String[] args) {
            //Creación y modificación directa usando Map
        Stream<String> Nombres = Stream.of("Quesozuelos Pechochuelos" , "Colín Colín", "Elías Floriciento", "Quesozuelos Pechochuelos", "Manuelitas torombolitas", "Santiaguito Bonitico", "Manuelitas Feítas", "Quesozuelos Pechochuelos")
                .distinct();     //Manda a volar elementos repetidos dentro del Stream

        String ResultadoReduce = Nombres.reduce("ResultadoReduce", (a, b) -> a + ", "+ b);  //Transformar todo el Stream en un solo elemento
        System.out.println(ResultadoReduce);

        Stream<Integer> Númerous = Stream.of(1, 5, 4, 8, 7, 14, 13, 26)
                .distinct();     //Manda a volar elementos repetidos dentro del Stream

        int NúmerousReduce = Númerous.reduce(0, Integer::sum);  //Transformar todo el Stream en un solo elemento
        //int NúmerousReduce = Númerous.reduce(0, (a, b) -> a + b);  //Transformar todo el Stream en un solo elemento
        System.out.println(NúmerousReduce);
    }
}