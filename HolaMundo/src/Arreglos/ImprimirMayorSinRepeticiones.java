package Arreglos;

import java.util.Random;

public class ImprimirMayorSinRepeticiones {
    public static void main(String[] args) {
            //Declarar la lista
        int [] Lista = new int[7];
        int dim = Lista.length;

            //Poblar la lista
        Random equis = new Random();
        for(int i = 0; i < Lista.length; i++){
            Lista[i] = equis.nextInt(11,100);
            //Lista[i] = Math.random();
        }

            //Imprimir al número mayor
                //Imprimir la lista
        int ye = 0;
        System.out.println("Los números generados esta vez son..");
        while(ye < Lista.length){
            System.out.println(Lista[ye]);
            ye++;
        }

                //Imprimir el número mayor
        int max = Lista[0];
        for(int ele : Lista){
            max = (ele > max)? ele : max;
        }
        System.out.println("\nEl número mayor de la lista es = " + max);
    }
}
