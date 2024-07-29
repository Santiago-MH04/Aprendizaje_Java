package Matrices;

import java.util.Scanner;

public class ImprimirUnaX {
    public static void main(String[] args) {

        boolean aprobado = true;
            //Pedir tamaño de la X a imprimir
        Scanner s = new Scanner(System.in);
        System.out.println("Por favor, ingrese el tamaño de la X a imprimir:");
        int t = s.nextInt();

        aprobado = (t > 0)? aprobado : false;
        if (!aprobado){
            System.err.println("¡ERROR! Tamaño incompatible");
            System.exit(1);
        }

            //Crear e imprimir la X
        for(int i = 0; i < t; i++){
            for(int j = 0; j < t; j++){
                if((i == j) || (j == t - 1 - i)){
                    System.out.print("X");
                } else {
                    System.out.print("_");
                }
            }
            System.out.println();
        }
    }
}
