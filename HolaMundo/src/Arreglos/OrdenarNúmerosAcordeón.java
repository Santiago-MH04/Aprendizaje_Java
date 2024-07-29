package Arreglos;

import java.util.Scanner;

public class OrdenarNúmerosAcordeón {
    public static void main(String[] args) {
            //Leer números
        Scanner s = new Scanner(System.in);
        Double[] losNumeritos = new Double[10];

        System.out.println("Ingrese 10 números (no necesariamente en orden). Repeticiones válidas");
        for(int i = 0; i < 10; i++){
            System.out.print((i+1) + "° número: ");
            losNumeritos[i] = s.nextDouble();
        }

            //Ordenar números
        ordenar(losNumeritos);

            //Imprimir números
        System.out.println("\n El orden resultante de los números ingresados es: ");
        acordeón(losNumeritos);
    }
    public static void ordenar (Double[] lista) {
        for(int i = 0; i < (lista.length - 1); i++){
            for (int j = i+1; j < lista.length; j++){
                if(lista[i] > lista[j]){
                    Double Boya = lista[j];
                    lista[j] = lista[i];
                    lista[i] = Boya;
                }
            }
        }
    }
    public static void acordeón (Double[] lista){
        int talla = lista.length-1, i = 0;
        while (i < talla){
            System.out.println(lista[i] + " , " + lista[lista.length - 1 - i]);
            i++;
            talla--;
        }
    }
}