package POO_Hilos.Lecciones.RecursosCompartidos;

import POO_Hilos.Lecciones.RecursosCompartidos.Runnable.*;

import java.util.concurrent.ThreadLocalRandom;

public class EjemploProductorConsumidorJava8 {
    public static void main(String[] args) {
        Panadería P = new Panadería();

            //Programación lambda con clases anónimas
                //Para el panadero
        new Thread( () -> {
            for(int i= 0; i < 10; i++){
                P.Hornear("pan n°" + (i+1));
                try {
                    Thread.sleep(ThreadLocalRandom.current().nextInt(500,2000)); //Pausita mientras hornea el pan
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        } ).start();

                //Para el cliente
        new Thread( () -> {
            for(int i = 0; i < 10; i++){
                P.Consumir();
                try {
                    Thread.sleep(ThreadLocalRandom.current().nextInt(500,2000)); //Pausita mientras se come el pan
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        } ).start();
    }
}
