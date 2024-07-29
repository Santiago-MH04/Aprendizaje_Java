package API_Stream.Lecciones;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class EjemploStream {
    public static void main(String[] args) {
            //Creación directa
        Stream<String> Nombres = Stream.of("Quesozuelos" , "Colín Colín", "Elías Floriciento", "Manuelitas torombolitas", "Santiaguito");
        //Nombres.forEach(System.out::println); //Operador terminal

            //Transformar un arreglo en un Stream
        String[] Familia = {"Quesozuelos" , "Colín Colín", "Elías Floriciento", "Manuelitas torombolitas", "Santiaguito"};
        Nombres = Arrays.stream(Familia);
        Nombres.forEach(System.out::println);   //Operador terminal

            //Crear un Stream con Stream builder ---> Recursivo
        Stream<String> LosNombres = Stream.<String>builder().add("Quesozuelos")
                .add("Colín Colín")
                .add("Elías Floriciento")
                .add("Manuelitas torombolitas")
                .add("Santiaguito").build();
        LosNombres.forEach(System.out::println);

            //A partir de un elemento Collections ---> No recursivo
        List<String> NombresFamilia = new ArrayList<>();
            NombresFamilia.add("Quesozuelos");
            NombresFamilia.add("Colín Colín");
            NombresFamilia.add("Elías Floriciento");
            NombresFamilia.add("Manuelitas torombolitas");
            NombresFamilia.add("Santiaguito");

        Stream<String> MiFamilia = NombresFamilia.stream();
        NombresFamilia.stream().forEach(System.out::println);   //Operador terminal
    }
}
