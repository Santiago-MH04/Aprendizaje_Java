package Operadores;

public class OperadoresAsignación {
    public static void main(String[] args) {

        int i = 2;
        int j = i + 2;
        System.out.println("i = " + i);
        System.out.println("j = " + j);

        i += 2; // i = i + 2; con = como operador de asignación
        System.out.println("El nuevo valor de i es: " + i);

            //Los operadores compuestos se leen de izquierda a derecha, sean +=, -=, /=; *=; %=
        System.out.println("El operador compuesto += también sirve para concatenar strings");
    }
}

