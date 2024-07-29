package Arreglos;

public class EjemploArreglosOrdenPrincipioFinal {
    public static void main(String[] args) {

        int[] losNúmeros = new int[15];

            //Darle valor a los números
        for (int i = 0; i < losNúmeros.length; i++){
            losNúmeros[i]   = i + 1;
        }

            //Imprimir los números
        int Cuentas = 0;
        while (Cuentas < losNúmeros.length){
            System.out.println(losNúmeros[Cuentas]);
            Cuentas++;
        }

            //Imprimir los números en pares extremos
        Cuentas = 0;
        int Pepas = 0;
        do {
            Pepas = losNúmeros.length - 1 - Cuentas;
            if(Cuentas != Pepas) {
                System.out.print(losNúmeros[Cuentas] + " ");
                System.out.println(losNúmeros[Pepas]);
            } else {
                System.out.print("-" + losNúmeros[Cuentas] + "-");
            }
            Cuentas++;
        } while (Cuentas < Pepas);
    }
}
