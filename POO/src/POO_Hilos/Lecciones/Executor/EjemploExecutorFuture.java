package POO_Hilos.Lecciones.Executor;

import java.util.concurrent.*;

public class EjemploExecutorFuture {
    public static void main(String[] args) throws InterruptedException,
            ExecutionException,
            TimeoutException {

            //Executor se diferencia de ExecutorService en que el último gestiona tareas,
            // liberándonos de la camisa de fuerza que puede suponer la interfaz Runnable
        ExecutorService Ejecutor = Executors.newSingleThreadExecutor();

        Callable<String> Tarea = () -> {
            System.out.println("Inicio de la tarea...");
            try {
                String NombreHilo = Thread.currentThread().getName();
                System.out.println("Nombre del hilo en ejecución: " + NombreHilo);
                TimeUnit.SECONDS.sleep(3);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt(); //En caso de que haya un error, interrumpe la ejecución del hilo en cuestión
                throw new RuntimeException(e);
            }
            System.out.println("Finaliza la tarea...");
            return "Resultado de la simulación";
        };

        Future<String> Resultado = Ejecutor.submit(Tarea);
        Ejecutor.shutdown();    //Detiene al ExecutorService una vez todas las tareas que implemente hayan acabado
        System.out.println("Continuando con la ejecución del método main");

        //System.out.println(Resultado.isDone());
        while (!Resultado.isDone()){
            System.out.println("Tarea en ejecución...");
            TimeUnit.MILLISECONDS.sleep(1500);
        }
        //System.out.println("Continuando ...");
        System.out.println("Obtener resultado de la tarea: " + Resultado.get());  //Bloquea el hilo en ejecución (main) hasta que termine la tarea de los otros hilos,
                                                                                  // para poder continuar. Pero, no devuelve nada.
                                                                                  // No puede, por nada del mundo, demorar menos que la ejecución de la tarea,
                                                                                  // para que no arroje un TimeoutException
        System.out.println("¿Ha finalizado la tarea?: " + Resultado.isDone());
    }
}
