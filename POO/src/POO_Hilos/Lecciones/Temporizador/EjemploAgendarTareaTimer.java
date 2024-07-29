package POO_Hilos.Lecciones.Temporizador;

import java.time.LocalDate;
import java.util.Timer;
import java.util.TimerTask;

public class EjemploAgendarTareaTimer {
    public static void main(String[] args) {

        Timer Temporizador = new Timer();
        Temporizador.schedule(new TimerTask() {
            @Override
            public void run() {
                System.out.println("Fecha tarea:  " + LocalDate.now() +
                        ".\nNombre del hilo: " + Thread.currentThread().getName());
                System.out.println("Finaliza el tiempo");
                Temporizador.cancel();
            }
        }, 5000);

        System.out.println("Agendar otra tarea para cinco segundos más...");
    }
}
