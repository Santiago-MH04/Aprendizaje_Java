package Arreglos;

import java.util.Random;

public class ContadorDeFrecuencia {
    public static void main(String[] args) {

            //Ingresar los números en [1,9]
        Random numeritos = new Random();
        int[] Lista = new int[10];

        System.out.println("La lista con los números en [1,9] es: ");
        for (int i = 0; i < Lista.length; i++){
            Lista[i] = 1 + numeritos.nextInt(9);
            System.out.print(Lista[i] + " ");
        }

            //Contar la frecuencia de cada número
        int [] frecuencia = new int[Lista.length];
        int moda = Lista[0];
        int cantidad = cuentahuevos(Lista[0], Lista);
        System.out.println();

        for (int j = 0; j < Lista.length; j++){
            frecuencia[j] = cuentahuevos(Lista[j], Lista);
            moda = (frecuencia[j] > cantidad)? Lista[j] : moda;
            cantidad = (frecuencia[j] > cantidad)? frecuencia[j] : cantidad;
        }

            //Imprimir la moda, y su frecuencia
        System.out.println("\nEl número más presente en la lista es el " + moda + ", con " + cantidad + " apariciones");
    }

    public static int cuentahuevos(int x, int[] arreglo){
        int s = 0;
        int c = 0;
        while (s < arreglo.length){
            c = (arreglo[s] == x)?(c + 1):c;
            s++;
        }
        return c;
    }
}
