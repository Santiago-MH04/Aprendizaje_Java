package POO_Hilos.Lecciones.Executor;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class EjemploExecutor {
    public static void main(String[] args) throws InterruptedException {

            //Executor se diferencia de ExecutorService en que el último gestiona tareas,
            // liberándonos de la camisa de fuerza que puede suponer la interfaz Runnable
        ExecutorService Ejecutor = Executors.newSingleThreadExecutor();

        Runnable Tarea = () -> {
            System.out.println("Inicio de la tarea...");
            try {
                String NombreHilo = Thread.currentThread().getName();
                System.out.println("Nombre del hilo en ejecución: " + NombreHilo);
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt(); //En caso de que haya un error, interrumpe la ejecución del hilo en cuestión
                throw new RuntimeException(e);
            }
            System.out.println("Finaliza la tarea...");
        };

        Ejecutor.submit(Tarea);
        Ejecutor.shutdown();    //Detiene al ExecutorService una vez todas las tareas que implemente hayan acabado
        System.out.println("Continuando con la ejecución del método main 1");
        Ejecutor.awaitTermination(2, TimeUnit.SECONDS); //Espera a que finalicen todas las tareas
                                                               // para continuar con la ejecución del método main
        System.out.println("Continuando con la ejecución del método main 2");
    }
}
