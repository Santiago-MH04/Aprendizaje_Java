package POO_Hilos.Lecciones.RecursosSimples;

import POO_Hilos.Lecciones.RecursosSimples.Threads.NúmeroThread;

public class EjemploExtenderThread {
    public static void main(String[] args) throws InterruptedException {
        Thread Hilo = new NúmeroThread("Pepito Pérez");
            Hilo.start();
        //Thread.sleep(2);   //Hay dos Threads ejecutándose en simultánea, el main y el Hilo.
                             //Entonces, se da prioridad al principal de ambos, que en este caso,
                             //es el main.
        System.out.println();
        Thread Hilo2 = new NúmeroThread("Quesozuelos Torombozuelos");
            Hilo2.start();

        Thread Hilo3 = new NúmeroThread("Colín Colín");
            Hilo3.start();

        System.out.println(Hilo.getState());
    }
}
