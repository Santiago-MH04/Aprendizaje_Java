package Matrices;

public class EjemploMatrizTranspuesta {
    public static void main(String[] args) {

        int [][] B = {
                {1, 2, 3, 4},
                {5, 6, 7, 8},
                {9, 10, 11, 12},
                {13, 14, 15, 16},
        };

            //Imprimir los valores de la matriz
        int i = 0;
        int j = 0;
        System.out.println("Matriz antes de la transposición");
        while(i < B.length){
            Columnas:
            while(j < B[i].length){
                System.out.print(B[i][j] + "\t");
                if(j == B[i].length - 1){
                    j = 0;
                    break Columnas;
                }
                j++;
            }
            i++;
            System.out.println();
        }

            //Transponer los valores de la matriz
        for(i = 0; i < B.length;i++){
            for (j = 0; j < i; j++){
                int boya = B[i][j];
                B[i][j] = B[j][i];
                B[j][i] = boya;
            }
        }

            //Imprimir la matriz transpuesta
        System.out.println("\nMatriz luego de la transposición");
        for(int[] a : B){
            for (int b : a){
                System.out.print(b + "\t");
            }
            System.out.println();
        }
    }
}

