package POO_Hilos.Lecciones.Executor;

import POO_Hilos.Lecciones.RecursosCompartidos.Panadería;
import POO_Hilos.Lecciones.RecursosCompartidos.Runnable.Consumidor;
import POO_Hilos.Lecciones.RecursosCompartidos.Runnable.Panadero;

import java.util.concurrent.*;

public class EjemploExecutorFutureProductorConsumidor {
    public static void main(String[] args) throws InterruptedException,
            ExecutionException,
            TimeoutException {

            //Executor se diferencia de ExecutorService en que el último gestiona tareas,
            // liberándonos de la camisa de fuerza que puede suponer la interfaz Runnable
        //ExecutorService Ejecutor = Executors.newSingleThreadExecutor(); //Así, se crea un carrete de hilos que ejecutan en serie
        //ExecutorService Ejecutor = Executors.newFixedThreadPool(3); //Así, se crea un carrete de hilos que ejecuta en paralelo cuantos hilos estén especificados en su argumento
        ThreadPoolExecutor Ejecutor = (ThreadPoolExecutor) Executors.newFixedThreadPool(2); //

            //Antes de ingresar los hilos al carrete
        System.out.println("Tamaño del carrete: " + Ejecutor.getPoolSize());
        System.out.println("Cantidad de tareas en cola: " + Ejecutor.getQueue().size());

        Panadería P = new Panadería();
        Runnable Productor = new Panadero(P);
        Runnable Cliente = new Consumidor(P);

            //Creando el carrete de hilos
        Future<?> Futuro1 = Ejecutor.submit(Productor);
        Future<?> Futuro2 = Ejecutor.submit(Cliente);

            //Después de ingresar los hilos al carrete
        System.out.println("Tamaño del carrete: " + Ejecutor.getPoolSize());
        System.out.println("Cantidad de tareas en cola: " + Ejecutor.getQueue().size());


        Ejecutor.shutdown();    //Detiene al ExecutorService una vez todas las tareas que implemente hayan acabado
        System.out.println("Continuando con la ejecución del método main");

        //System.out.println(Resultado.isDone());
        while (!(Futuro1.isDone() && Futuro2.isDone())){
            System.out.println(String.format("Resultado1: %s - Resultado2: %s",
                    Futuro1.isDone()? "ha finalizado" : "en proceso",
                    Futuro2.isDone()? "ha finalizado" : "en proceso"));
            TimeUnit.MILLISECONDS.sleep(1000);
        }

        //System.out.println("Continuando ...");
        System.out.println("Obtener Resultado de la tarea: " + Futuro1.get());  //Bloquea el hilo en ejecución (main) hasta que termine la tarea de los otros hilos,
                                                                                // para poder continuar. Pero, no devuelve nada.
                                                                                // No puede, por nada del mundo, demorar menos que la ejecución de la tarea,
                                                                                // para que no arroje un TimeoutException
        System.out.println("¿Ha finalizado la tarea?: " + (Futuro1.isDone()? "Sí" : "No"));

        System.out.println("Obtener Resultado2 de la tarea: " + Futuro2.get());  //Dado que se ejecutan de la interfaz Callable al vuelo,
                                                                                 // el método get devuelve lo que está en la instrucción return
        System.out.println("¿Ha finalizado la tarea?: " + (Futuro2.isDone()? "Sí" : "No"));
    }
}
