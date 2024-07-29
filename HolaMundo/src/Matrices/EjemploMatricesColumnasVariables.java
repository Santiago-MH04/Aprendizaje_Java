package Matrices;

public class EjemploMatricesColumnasVariables {
    public static void main(String[] args) {

        int[][] matriz = new int[3][];

        matriz[0] = new int[2];
        matriz[1] = new int[3];
        matriz[2] = new int[4];

            //Imprimir las distintas dimensiones de esta matriz
        System.out.println("La matriz tiene " + matriz.length + " filas.");
        for (int i = 0; i < matriz.length; i++){
            System.out.println("La " + (i+1) +  "° fila de la matriz tiene " + matriz[i].length + " columnas.");
        }

            //Poblar los valores de la matriz
        for (int i = 0; i < matriz.length; i++){
            for (int j = 0; j < matriz[i].length; j++){
                matriz[i][j] = (i+1)*(j+i);
            }
        }

        System.out.println();

            //Imprimir la matriz
        for (int i = 0; i < matriz.length; i++){
            for (int j = 0; j < matriz[i].length; j++){
                System.out.print(matriz[i][j] + "\t");
            }
            System.out.println();
        }
    }
}
