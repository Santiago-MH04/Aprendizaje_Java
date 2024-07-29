package Matrices;

public class EjemploTransponerMatriz {
    public static void main(String[] args) {

        int[][] A, B;
        A = new int[8][4];
        B = new int[4][8];

            //Poblar la matriz A
        System.out.println("La matriz A:");
        for (int i = 0; i < A.length; i++){
            for (int j = 0; j < A[i].length; j++){
                A[i][j] = i + (3 * j);
                System.out.print(A[i][j] + "\t");
            }
            System.out.println();
        }

            //Recorrer la matriz A para poblar la matriz B
        for (int i = 0; i < A.length; i++){
            for (int j = 0; j < A[i].length; j++){
                B[j][i] = A[i][j];
            }
        }

            //Imprimir la matriz B
        System.out.println("\nLa matriz transpuesta de A es: ");
        for (int i = 0; i < B.length; i++){
            for (int j = 0; j < B[i].length; j++){
                System.out.print(B[i][j] + "\t");
            }
            System.out.println();
        }
    }
}
