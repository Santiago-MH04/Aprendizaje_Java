package API_Stream.Lecciones;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Stream;

public class EjemploStream_StreamInfinto_Generate {
    public static void main(String[] args) {
        AtomicInteger Contador = new AtomicInteger(0);
        Stream.generate(() -> {             //El método Stream.generate() tiene por argumento una expresión lambda
            // del tipo Supplier
            try {
                TimeUnit.SECONDS.sleep(2);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            return Contador.incrementAndGet();
        }).limit(20).forEach(System.out::println);
    }
}
