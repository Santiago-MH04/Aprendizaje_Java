package Matrices;

public class EjemploMatrices {
    public static void main(String[] args) {
            //Matrices numéricas
        int[][] números = new int [2][4];
        System.out.println("número de filas = " + números.length);
        System.out.println("número de columnas = " + números[0].length);

            //Matrices de strings
        String[][] nombres = new String[3][2];

        nombres[0][0]= "Pepe";
        nombres[0][1]= "Pepa";
        nombres[1][0]= "Josefa";
        nombres[1][1]= "Paco";
        nombres[2][0]= "Lucas";
        nombres[2][1]= "Pancha";

            //Iterando con un for
        System.out.println("\nCompletando la matriz usando un for");
        for (int i = 0; i < nombres.length; i++){
            for (int j = 0; j < nombres[i].length; j++){            //nombres[i].length hace referencia a la cantidad de elementos en la (i-1)-ésima fila
                System.out.print(nombres[i][j] + "\t");
            }
            System.out.println();
        }

            //Iterando con un foreach
        System.out.println("\nCompletando la matriz usando un for each");
        for (String[] fila : nombres){
            for (String columna : fila){
                System.out.print(columna + "\t");
            }
            System.out.println();
        }
    }
}