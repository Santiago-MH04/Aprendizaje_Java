package POO_Hilos.Lecciones.Executor;

import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;

public class EjemploScheduledExecutorServicePeriódico {
    public static void main(String[] args) throws InterruptedException {

        ScheduledExecutorService Ejecutor = Executors.newScheduledThreadPool(2);

        System.out.println("Simulando alguna tarea en el método main");

        AtomicInteger CuentaFríjoles = new AtomicInteger(5);
        //CountDownLatch Candado = new CountDownLatch(5); //Para repetir la ejecución de la tarea con una cuenta regresiva cual bandera.
                                                          // También sirve para usar de manera concurrente
        Future<?> Futuro = Ejecutor.scheduleAtFixedRate( () -> {
            System.out.println("Hola mundo, tarea... ");
            try {
                TimeUnit.MILLISECONDS.sleep(1000);
                CuentaFríjoles.getAndDecrement();
                //Candado.countDown();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }, 1000, 2000,TimeUnit.MILLISECONDS);

        while(CuentaFríjoles.get() >= 0){
            if (CuentaFríjoles.get() == 0){
                Futuro.cancel(true);
                CuentaFríjoles.getAndDecrement();
            }
        }
        //Candado.await();  //También se podría usar el shutdown, pero no es el propósito del ejercicio
        //Futuro.cancel(true);
        //TimeUnit.SECONDS.sleep(10);     //Pausa el hilo principal (método main) mientras los hilos se ejecutan
        System.out.println("Simulando alguna otra tarea en el método main");
        Ejecutor.shutdown();
    }
}
