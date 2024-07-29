package POO_Hilos.Lecciones.RecursosCompartidos;

import POO_Hilos.Lecciones.RecursosCompartidos.Runnable.*;

public class EjemploProductorConsumidor {
    public static void main(String[] args) {
        Panadería P = new Panadería();

        new Thread(new Panadero(P)).start();
        new Thread(new Consumidor(P)).start();
    }
}
