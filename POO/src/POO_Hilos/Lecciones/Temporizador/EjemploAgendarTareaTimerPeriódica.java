package POO_Hilos.Lecciones.Temporizador;

import java.awt.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.atomic.AtomicInteger;

public class EjemploAgendarTareaTimerPeriódica {
    public static void main(String[] args) {

        Toolkit Sonidito = Toolkit.getDefaultToolkit();
        AtomicInteger ContadorAtómico = new AtomicInteger(3);

        Timer Temporizador = new Timer();
        Temporizador.schedule(new TimerTask() {
            //private int Contador = 3;
            @Override
            public void run() {
                int i = ContadorAtómico.getAndDecrement();
                if(i > 0) {
                    Sonidito.beep();
                    System.out.println("Tarea periódica n° " + (Math.abs((3-i) + 1)) + ". Fecha tarea periódica:  " + LocalDateTime.now() +
                            ".\tNombre del hilo: " + Thread.currentThread().getName());
                    //Contador--; //Para no tener que depender de una instancia particular en cada clase anónima
                } else {
                    System.out.println("Finaliza el tiempo");
                    Temporizador.cancel();
                }
            }
        }, 0, 10000);

        System.out.println("Agendar una tarea inmediata que se repite cada 10s");
    }
}
