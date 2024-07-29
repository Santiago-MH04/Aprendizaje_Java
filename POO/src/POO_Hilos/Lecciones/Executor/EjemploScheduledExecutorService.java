package POO_Hilos.Lecciones.Executor;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class EjemploScheduledExecutorService {
    public static void main(String[] args) {

        ScheduledExecutorService Ejecutor = Executors.newScheduledThreadPool(2);

        System.out.println("Simulando alguna tarea en el método main");
        Ejecutor.schedule( () -> {
            System.out.println("Hola mundo, tarea... ");
            try {
                TimeUnit.MILLISECONDS.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }, 2000, TimeUnit.MILLISECONDS);
        Ejecutor.shutdown();

        System.out.println("Simulando alguna otra tarea en el método main");
    }
}
