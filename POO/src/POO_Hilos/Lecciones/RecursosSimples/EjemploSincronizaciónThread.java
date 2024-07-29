package POO_Hilos.Lecciones.RecursosSimples;

import POO_Hilos.Lecciones.RecursosSimples.Runnable.ImprimirFrases;
import POO_Hilos.Lecciones.RecursosSimples.Runnable.Orden;


public class EjemploSincronizaciónThread {
    public static void main(String[] args) throws InterruptedException {
        String[] Frasesinhas = {"Hola, ", "¿qué tal?"};
        String[] Frasesoãs = {"¿Quién eres ", "tú?"};
        String[] Phrases = {"Muchas gracias, ", "amigo"};

            //Llamando a la clase que implementa runnable, en cualquiera de sus instancias
        System.out.println("A continuación, terrible desorden");

        Thread H1a = new Thread(new ImprimirFrases(Frasesinhas, Orden.ALE));
        H1a.start();
        Thread H2a = new Thread(new ImprimirFrases(Frasesoãs, Orden.ALE));
        H2a.start();
        Thread H3a =new Thread(new ImprimirFrases(Phrases, Orden.ALE));
        H3a.start();

        H1a.join();
        H2a.join();
        H3a.join();

        System.out.println();
        System.out.println("Ha llegado el modificador de acceso sincronizado al rescate");

        Thread H1b = new Thread(new ImprimirFrases(Frasesinhas, Orden.COH));
        H1b.start();
        Thread H2b = new Thread(new ImprimirFrases(Frasesoãs, Orden.COH));
        H2b.start();
        Thread H3b =new Thread(new ImprimirFrases(Phrases, Orden.COH));
        H3b.start();
    }

    public static void ImprimirFrasesMal (String[] Frases){
        System.out.print(Frases[0]);

        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            //throw new RuntimeException(e);
            e.printStackTrace();
        }
        System.out.println(Frases[1]);
    }

    public synchronized static void ImprimirFrasesBien (String[] Frases){
        System.out.print(Frases[0]);

        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            //throw new RuntimeException(e);
            e.printStackTrace();
        }
        System.out.println(Frases[1]);
    }
}
