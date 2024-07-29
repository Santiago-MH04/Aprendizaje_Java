package API_Stream.Lecciones;

import java.util.IntSummaryStatistics;
import java.util.stream.DoubleStream;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class EjemploStream_OperadorRange {
    public static void main(String[] args) {
        //El operador Range sólo existe en Range de Integers, o IntStream;
        // Long, o LongStream;
        // Float, o FloatStream;
        // Double, o DoubleStream

        IntStream Númeritous = IntStream.range(5, 20)
                .peek(System.out::println);     //Manda a volar elementos repetidos dentro del Stream

        int NúmeritousReduce = Númeritous.sum();
        //int NúmeritousReduce = Númeritous.reduce(0, Integer::sum);  //Transformar todo el Stream en un solo elemento
        //int NúmeritousReduce = Númeritous.reduce(0, (a, b) -> a + b);  //Transformar todo el Stream en un solo elemento

        IntSummaryStatistics Stats = Númeritous.summaryStatistics();
        System.out.println("Máximo: " + Stats.getMax());
        System.out.println("Mínimo: " + Stats.getMin());
        System.out.println("Suma: " + Stats.getSum());
        System.out.println("Promedio: " + Stats.getAverage());
        System.out.println("Cantidad de elementos: " + Stats.getCount());

        System.out.println(NúmeritousReduce);
    }
}