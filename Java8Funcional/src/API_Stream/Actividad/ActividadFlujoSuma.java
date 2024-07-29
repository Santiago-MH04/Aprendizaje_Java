package API_Stream.Actividad;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.DoubleStream;
import java.util.stream.Stream;

public class ActividadFlujoSuma {
    public static void main(String[] args) {
            //Crear el Stream (generate) o un DoubleStream.range(1, 100)
        AtomicInteger Semilla = new AtomicInteger(0);
        Double Maromas = Stream.generate(Semilla::incrementAndGet)
                .limit(100)                                         //Eliminar los múltiplos de 10
                .filter(i -> (i % 10) != 0)                                 //Transformar a tipo Double, dividiendo entre 2
                .map(i -> {
                    return ((double)i)/2;
                }).reduce(0d, Double::sum);

        System.out.println("Resultado suma = " + Maromas);
    }
}
