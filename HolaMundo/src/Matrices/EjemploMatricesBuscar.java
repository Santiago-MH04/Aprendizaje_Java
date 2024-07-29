package Matrices;

public class EjemploMatricesBuscar {
    public static void main(String[] args) {

        int[][] MatrizEntera = {
                {21, 8, 1961, 1},
                {20, 8, 1964, 2},
                {18, 4, 1995, 3},
                {4, 4, 1997, 4},
        };

        int Buscando = 1997;
        boolean hallado = false;

            //Buscar el elemento
        int i, j = 0;
        Recorrer:
        for(i = 0; i < MatrizEntera.length; i++){
            for (j = 0; j < MatrizEntera[i].length; j++){
                if(MatrizEntera[i][j] == Buscando){
                    hallado = true;
                    break Recorrer;
                }
            }
        }

        if(hallado){
            System.out.println("El elemento " + Buscando + " ha sido hallado en la posición " + "("+ i + "," + j + ") de la matriz");
        }else {
            System.out.println("El elemento " + Buscando + " no se encuentra en la matriz");
        }
    }
}