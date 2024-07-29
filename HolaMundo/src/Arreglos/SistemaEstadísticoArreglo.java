package Arreglos;

import java.util.Random;

public class SistemaEstadísticoArreglo {
    public static void main(String[] args) {
            //Generar Números aleatorios en [-10,10]
        Double[] Lista = new Double[7];
        Random random = new Random();
        for(int i = 0; i < Lista.length; i++){
            //Lista[i] = Math.random();
            Lista[i] = 2*random.nextDouble(10) - 10;
        }

            //Imprimir lista
        int l = 0;
        System.out.println("La lista generada es: ");
        while (l < Lista.length){
            System.out.println(Lista[l]);
            l++;
        }

            //Mostrar Promedio de los positivos
        System.out.println("\r\nEl promedio de los números positivos es: ");
        promediopos(Lista);
        //promedio("positivos",Lista);

            //Mostrar promedio de los negativos
        System.out.println("\r\nEl promedio de los números negativos es: ");
        promedioneg(Lista);
        //promedio("negativos",Lista);

            //Contar los ceros
        System.out.println("\r\nEl número de ceros en la lista es: ");
        cuentaceros(Lista);
    }


    /*public static Double promedio(String tipo, Double[] arreglo) {
        Double a = 0d;
        Double cantidad = 0d;

        switch (tipo) {
            case ("positivos"):
                for (Double i : arreglo) {
                    if (i > 0) {
                        a += i;
                        cantidad++;
                    }
                }
                break;

            case ("negativos"):
                for (Double i : arreglo) {
                    if (i < 0) {
                        a += i;
                        cantidad++;
                    }
                }
                break;

            System.out.println(a/cantidad);
            return (a/cantidad);
        }
    }*/ //Me sigue faltando una expresión

    public static Double promediopos(Double[] arreglo){
        Double a = 0d;
        Double cantidad = 0d;
        for (Double i : arreglo) {
            if (i > 0) {
                a += i;
                cantidad++;
            }
        }
        System.out.println(a/cantidad);
        return (a/cantidad);
    }

    public static Double promedioneg(Double[] arreglo){
        Double a = 0d;
        Double cantidad = 0d;
        for (Double i : arreglo) {
            if (i < 0) {
                a += i;
                cantidad++;
            }
        }
        System.out.println(a/cantidad);
        return (a/cantidad);
    }

    public static int cuentaceros(Double[] arreglo){
        int a = 0;
        for (Double i : arreglo) {
            if (i == 0) {
                a += i;
            }
        }
        System.out.println(a);
        return (a);
    }
}

