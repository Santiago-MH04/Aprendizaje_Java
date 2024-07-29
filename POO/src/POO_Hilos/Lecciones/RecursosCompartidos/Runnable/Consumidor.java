package POO_Hilos.Lecciones.RecursosCompartidos.Runnable;

import POO_Hilos.Lecciones.RecursosCompartidos.Panadería;

public class Consumidor implements Runnable{
        //Atributos de Consumidor
    private Panadería LaPanadería;

        //Constructores de Consumidor
    public Consumidor (Panadería panadería) {
        this.LaPanadería = panadería;
    }
    //Asignadores de atributos de Consumidor (setter)
    //Lectores de atributos de Consumidor (getter)
        //Métodos de Consumidor
    @Override
    public void run() {
        for(int i = 0; i < 10; i++){
            LaPanadería.Consumir();
        }
    }
}
