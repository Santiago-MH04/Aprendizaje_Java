package Operadores;

import javax.swing.*;

public class OperadoresAritméticos {
    public static void main(String[] args) {

        int a = 4, b = 5, suma = a + b; //Si un conjunto de objetos pertenecen a la misma clase, se pueden escribir sin problemas en la misma línea, separados por coma, indicando la clase de objeto que son al principio

        System.out.println("suma = " + suma);
        System.out.println("La concatenación de a y b es:    " + a + b);

        int resta = a - b;
        System.out.println("resta = " + resta);
        System.out.println("(a-b) = " + (a-b));

        int multiplicación = a*b;
        System.out.println("multiplicación = " + multiplicación);

        int división = a/b;
        float divi = (float) a/b;
        System.out.println("División con tipo Integer = " + división);
        System.out.println("División con tipo Integer forzado a float = " + divi);

        int residuo = a % b;
        System.out.println("residuo = " + residuo);

        int unNúmero = Integer.parseInt(JOptionPane.showInputDialog("Ingrese un número entero"));
        if (unNúmero % 2 == 0){
            JOptionPane.showMessageDialog(null, "Su número es par");
        } else{
            JOptionPane.showMessageDialog(null, "Su número es impar");
        }
    }
}