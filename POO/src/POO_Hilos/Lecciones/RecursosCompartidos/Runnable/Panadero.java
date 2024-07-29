package POO_Hilos.Lecciones.RecursosCompartidos.Runnable;

import POO_Hilos.Lecciones.RecursosCompartidos.Panadería;

import java.util.concurrent.ThreadLocalRandom;

public class Panadero implements Runnable{
        //Atributos de Panadero
    private Panadería MiPanadería;

        //Constructores de Panadero
    public Panadero(Panadería panadería) {
        this.MiPanadería = panadería;
    }
    //Asignadores de atributos de Panadero (setter)
    //Lectores de atributos de Panadero (getter)
        //Métodos de Panadero
    @Override
    public void run() {
        for(int i= 0; i < 10; i++){
            this.MiPanadería.Hornear("pan n°" + (i+1));
            try {
                Thread.sleep(ThreadLocalRandom.current().nextInt(500,2000)); //Pausita mientras hornea el pan
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
