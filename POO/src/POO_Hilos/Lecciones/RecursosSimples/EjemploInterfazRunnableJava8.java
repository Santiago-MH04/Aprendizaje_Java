package POO_Hilos.Lecciones.RecursosSimples;

import java.util.Random;

public class EjemploInterfazRunnableJava8 {
    public static void main(String[] args) throws InterruptedException {
        System.out.println("Varios hilos ejecutándose de manera concurrente se inician de manera aleatoria\n");

        Thread main = Thread.currentThread();
            //Así, se pasa de instanciar la interfaz runnable, para ejecutarse con expresiones lambda
        Runnable Letras = () -> {
            String Nombre = Thread.currentThread().getName(); //Desacopla el nombre, y no es necesario crear un atributo nombre
            System.out.println("Se inicia el método run del hilo " + Nombre);
            Random equis = new Random();
            int LetEquis = 0;
            int Iteraciones = 0;
            char Ese = 0;

            while(Ese != 's'){
                try {
                    LetEquis = equis.nextInt(25 + 1) + 'a';
                    Ese = (char)LetEquis ;
                    System.out.println(Ese);
                    Thread.sleep(10);
                    Iteraciones++;
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
            String Número = (Iteraciones > 1)? "cuentas" : "cuenta";
            System.out.println("Se finaliza el método run del hilo " + Nombre +  ", para encontrar la letra 's', luego de " + Iteraciones +  " " + Número + ".");
            System.out.println(main.getState());
        };

        Thread L1 = new Thread(Letras, "Elías Floriciento"); //Otra forma de ejecutar un objeto que
                                                                   // implementa la interfaz runnable
        Thread L2 =new Thread(Letras, "Manuelitas Torombolitas");
        Thread L3 =new Thread(Letras, "Santiaguito");

        L1.start();
        L2.start();
        L3.start();

            //Hacer esperar la ejecución del método main
        //Thread.sleep(1000); //Por un tiempo determinado
        L1.join();           //Hasta que finalicen los otros procesos
        L2.join();
        L3.join();
        System.out.println("Continuando con la ejecución del método main " + main.getName());
    }
}
