package POO_Excepciones;

import javax.swing.*;

public class EjemploExcepciones {
    public static void main(String[] args) {

        Calculadora cal = new Calculadora();
        String Numerador = JOptionPane.showInputDialog("Ingrese un número entero (numerador): ");
        String Denominador = JOptionPane.showInputDialog("Ingrese un número entero (denominador): ");
        //int denominador;
        //double división;

        try{
            /*numerador = Integer.parseInt(Numerador);
            denominador = Integer.parseInt(Denominador);
            división = cal.dividir(numerador, denominador);
                System.out.println("División 1" + división)*/;
            double divi2 = cal.dividir(Numerador, Denominador);
            System.out.println("División 2" + divi2);
        } /*catch (NumberFormatException NFE){
            System.err.println("Excepción capturada en tiempo de ejecución. Por favor ingrese un valor numérico: " + NFE.getMessage());
            main(args);
        }*/ catch (FormatoNúmeroException FNE){
            System.err.println("Excepción capturada en tiempo de ejecución. Por favor ingrese un valor numérico válido: " + FNE.getMessage());
            FNE.printStackTrace(System.out);
            main(args);
        } catch (DivisiónPorCeroException D0){
            System.err.println("Excepción capturada en tiempo de ejecución: " + D0.getMessage());
            main(args);
        } finally {
            System.out.println("Es opcional, pero siempre se ejecuta, con o sin excepción");
        }
        System.out.println("Continuamos ejecutando la aplicación");
    }
}
