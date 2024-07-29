package POO_Hilos.Lecciones.RecursosSimples.Threads;

import java.util.Random;

public class NúmeroThread extends Thread{
        //Atributos de NombreThread
    private final String SIN = "cuenta";
    private final String PLU = "cuentas";

    //Constructores de NombreThread
    public NúmeroThread(String nombre) {
        super(nombre);
    }

    //Asignadores de atributos de NombreThread (setter)
    //Lectores de atributos de NombreThread (getter)
        //Métodos de NombreThread
    @Override
    public void run() {
        System.out.println("Se inicia el método run del hilo " + this.getName());
        Random equis = new Random();
        int NumEquis = 0;
        int Iteraciones = 0;
        while(NumEquis != 10){
            try {
                NumEquis = 5 + equis.nextInt(10+1);
                System.out.println(NumEquis);
                Thread.sleep(10);
                Iteraciones++;
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        String Número = (Iteraciones > 1)? PLU : SIN;

        System.out.println("Se finaliza el método run del hilo " + this.getName() +  ", para elegir el número 10, luego de " + Iteraciones +  " " + Número + ".");
    }

}
