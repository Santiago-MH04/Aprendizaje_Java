package Arreglos;

import java.util.Random;

public class Histograma {
    public static void main(String[] args) {

            //Ingresar los números en [1,6]
        Random numeritos = new Random();
        int[] Lista = new int[12];

        System.out.println("La lista con los números en [1,6] es: ");
        for (int i = 0; i < Lista.length; i++){
            Lista[i] = 1 + numeritos.nextInt(6);    //El extremo superior no se incluye
            System.out.print(Lista[i] + " ");
        }

            //Contar la frecuencia de cada número, imprimiendo el histograma
        String [] frecuencia = new String[Lista.length];
        System.out.println();

        System.out.println("\nHistograma: ");
        for (int j = 0; j < 6; j++){
            frecuencia[j] = cuentaestrellas((j+1), Lista);
            System.out.println((j+1) + ": " + frecuencia[j]);
        }
    }
    public static String cuentaestrellas(int x, int[] arreglo){
        int s = 0;
        String c = "";
        while (s < arreglo.length){
            c = (arreglo[s] == x)?(c + "*") : c;
            s++;
        }
        return c;
    }
}
