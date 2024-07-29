package API_Stream.Actividad;

import java.util.Arrays;

public class ActividadAplanarMatrices {
    public static void main(String[] args) {
        String[][] Lenguajes = {{"Java", "Groovy"}, {"Php"}, {"C#", "Python", "Groovy"},
                {"Java", "Javascript", "Kotlin"},
                {"Javascript"}, {}};

        Arrays.stream(Lenguajes)                                //Se crea un Stream a partir de cada arreglo
                                                                    // del arreglo de arreglos
                .flatMap(Arreglo -> Arrays.stream(Arreglo))     //Se obtiene un Stream con cada arreglo
                .distinct()                                     //Se filtra
                .forEach(System.out::println);                  //Se imprime

    }
}
