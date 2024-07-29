package Operadores;

import javax.swing.*;

public class OrdenadorDeNúmeros {
    public static void main(String[] args) {

        //Crear el vector númerico, primero, como cadena de caracteres
        String laLista = JOptionPane.showInputDialog("Ingrese los números que desee ordenar, separados por comas (,). \nIndicar el punto decimal con un punto");
        String[] laMismaLista = laLista.split(",");
        Double[] elVectorNumérico = new Double[laMismaLista.length];


        System.out.println("Los números a organizar son");
        //Con la cadena de caracteres, crear el vector como un arreglo de números
        for(int i = 0; i < laMismaLista.length; i++){
            elVectorNumérico[i] = Double.parseDouble(laMismaLista[i]);
            System.out.println(elVectorNumérico[i]);
        }

        int cuentas = 0;
        for(int i = 0; i < (laMismaLista.length - 1); i++){
            for (int j = i + 1; j < laMismaLista.length; j++) {
                Double  unFlotador = null;
                unFlotador = (elVectorNumérico[j] < elVectorNumérico[i]) ? elVectorNumérico[i] : unFlotador;
                elVectorNumérico[i] = (elVectorNumérico[j] < elVectorNumérico[i]) ? elVectorNumérico[j] : elVectorNumérico[i];
                elVectorNumérico[j] = (unFlotador != null) ? unFlotador : elVectorNumérico[j];
                cuentas++;
            }
        }
        System.out.println("El método ha iterado " + cuentas + " veces.");

        System.out.println("La lista ordenada de estos números es: ");
        //Mostrar los números ordenados
        for (int i = 0; i < elVectorNumérico.length; i++){
            System.out.println(elVectorNumérico[i]);
        }
    }
}
