package POO_Hilos.Lecciones.Executor;

import java.util.concurrent.*;

public class EjemploExecutorFuture2 {
    public static void main(String[] args) throws InterruptedException,
            ExecutionException,
            TimeoutException {

            //Executor se diferencia de ExecutorService en que el último gestiona tareas,
            // liberándonos de la camisa de fuerza que puede suponer la interfaz Runnable
        //ExecutorService Ejecutor = Executors.newSingleThreadExecutor(); //Así, se crea un carrete de hilos que ejecutan en serie
        //ExecutorService Ejecutor = Executors.newFixedThreadPool(3); //Así, se crea un carrete de hilos que ejecuta en paralelo cuantos hilos estén especificados en su argumento
        ThreadPoolExecutor Ejecutor = (ThreadPoolExecutor) Executors.newFixedThreadPool(2); //Esto es posible, porque la instancia newFixedThreadPool
                                                                                                     // devuelve un ThreadPoolExecutor. Sin embargo, hay que hacer un cast

            //Antes de ingresar los hilos al carrete
        System.out.println("Tamaño del carrete: " + Ejecutor.getPoolSize());
        System.out.println("Cantidad de tareas en cola: " + Ejecutor.getQueue().size());

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

        Callable<Integer> Tarea2 = () -> {
            System.out.println("Iniciando Tarea 2");
            TimeUnit.SECONDS.sleep(3);
            return 4;
        };

            //Creando el carrete de hilos
        Future<String> Resultado = Ejecutor.submit(Tarea);
        Future<String> Resultado2 = Ejecutor.submit(Tarea);
        Future<Integer> Resultado3 = Ejecutor.submit(Tarea2);

            //Después de ingresar los hilos al carrete
        System.out.println("Tamaño del carrete: " + Ejecutor.getPoolSize());
        System.out.println("Cantidad de tareas en cola: " + Ejecutor.getQueue().size());


        Ejecutor.shutdown();    //Detiene al ExecutorService una vez todas las tareas que implemente hayan acabado
        System.out.println("Continuando con la ejecución del método main");

        //System.out.println(Resultado.isDone());
        while (!(Resultado.isDone() && Resultado2.isDone() && Resultado3.isDone())){
            System.out.println(String.format("Resultado1: %s - Resultado2: %s - Resultado3: %s",
                    Resultado.isDone()? "ha finalizado" : "en proceso",
                    Resultado2.isDone()? "ha finalizado" : "en proceso",
                    Resultado3.isDone()? "ha finalizado" : "en proceso"));
            TimeUnit.MILLISECONDS.sleep(1000);
        }

        //System.out.println("Continuando ...");
        System.out.println("Obtener Resultado de la tarea: " + Resultado.get());    //Bloquea el hilo en ejecución (main) hasta que termine la tarea de los otros hilos,
                                                                                    // para poder continuar. Pero, no devuelve nada.
                                                                                    // No puede, por nada del mundo, demorar menos que la ejecución de la tarea,
                                                                                    // para que no arroje un TimeoutException
        System.out.println("¿Ha finalizado la tarea?: " + (Resultado.isDone()? "Sí" : "No"));

        System.out.println("Obtener Resultado2 de la tarea: " + Resultado2.get());  //Dado que se ejecutan de la interfaz Callable al vuelo,
                                                                                    // el método get devuelve lo que está en la instrucción return
        System.out.println("¿Ha finalizado la tarea?: " + (Resultado2.isDone()? "Sí" : "No"));

        System.out.println("Obtener Resultado3 de la tarea: " + Resultado3.get());
        System.out.println("¿Ha finalizado la tarea?: " + (Resultado3.isDone()? "Sí" : "No"));
    }
}
