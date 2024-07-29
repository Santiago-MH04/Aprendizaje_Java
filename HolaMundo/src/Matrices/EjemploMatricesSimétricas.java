package Matrices;

public class EjemploMatricesSimétricas {
    public static void main(String[] args) {

        int[][] A = {
                {1, 2, 3, 4},
                {2, 1, 0, 5},
                {3, 0, 1, 6},
                {4, 5, 6, 7},
        };

            //Recorrer la matriz para ver si es simétrica
        int i = 0;
        int j = 0;
        boolean Simetría = true;

        while(i < A.length && Simetría == true){
            while(j < i && Simetría == true){
                if (A[i][j] != A[j][i]){
                    Simetría = false;
                }
                j++;
            }
            i++;
        }
        String Mensaje = (Simetría == true)?("La matriz es simétrica"):("La matriz no es simétrica");
        System.out.println(Mensaje);
    }
}