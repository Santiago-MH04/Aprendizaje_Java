package FlujosDeControl;

import javax.swing.*;
import java.util.InputMismatchException;
import java.util.Scanner;

public class CalcularNúmeroMenor {
    public static void main(String[] args) {
        //No sólo se le pide al usuario que ingrese mínimo 10 números enteros, sino que deben haber tantas iteraciones como elementos
        //Hacer el código dinámico
        //Manejar errores

        String laLista = null;
        String[] yaBonita = null;
        boolean bandera = false;

        Pregunta:
        while (!bandera) {
            laLista = JOptionPane.showInputDialog("Ingrese los números enteros que desee ordenar, separados por espacios. \nEjemplo: 57 66 96 76 46 28 35 42 84 31 2147483647");
            yaBonita = laLista.split(" ");
            bandera = (yaBonita.length >= 10) ? true : bandera;
            if (bandera) {
                break Pregunta;
            }
            JOptionPane.showMessageDialog(null, ("Usted debe ingresar mínimo 10 elementos a la lista"));
        }
        JOptionPane.showMessageDialog(null, ("Usted ha ingresado " + yaBonita.length + " números a la lista"));

            //Manejar el error (try-catch)
        int[] losNúmeros = new int[yaBonita.length];
        boolean seAprueba = false;
        do {
            try{
                for (int i = 0; i < yaBonita.length; i++) {
                    losNúmeros[i] = Integer.parseInt(yaBonita[i]);
                    seAprueba = (i == (yaBonita.length - 1))? true : seAprueba;
                }
            }   catch (NumberFormatException e){
                JOptionPane.showMessageDialog(null,"Error: por favor ingrese un número entero cuyo valor absoluto no supere " + Integer.MAX_VALUE);
                main(args);
                System.exit(0);
            }
        }   while (!seAprueba);

        int elMínimo = losNúmeros[0];
        int j = 0;
        Comparando:
        for (int i : losNúmeros) {
            elMínimo = (i < elMínimo) ? i : elMínimo;
        }
        JOptionPane.showMessageDialog(null, "El número menor en la lista proporcionada es " + elMínimo);
    }
}
