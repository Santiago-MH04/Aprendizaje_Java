package POO_Hilos.Lecciones.RecursosSimples;

import POO_Hilos.Lecciones.RecursosSimples.Runnable.LetraTarea;

public class EjemploInterfazRunnable {
    public static void main(String[] args) {
        System.out.println("Varios hilos ejecutándose de manera concurrente se inician de manera aleatoria\n");
        new Thread(new LetraTarea("Elías Floriciento")).start(); //Otra forma de ejecutar un objeto que
                                                                 // implementa la interfaz runnable
        new Thread(new LetraTarea("Manuelitas Torombolitas")).start();
        new Thread(new LetraTarea("Santiaguito")).start();
    }
}
