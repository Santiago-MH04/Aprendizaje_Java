package Variables;

import java.awt.*;
import java.util.InputMismatchException;
import java.util.Locale;
import java.util.Scanner;
import java.util.concurrent.LinkedTransferQueue;

public class ConversiónTipos {
    public static void main(String[] args) {

            //Para el número
        Scanner daNumber = new Scanner(System.in);
        System.out.println("Ingrese un número entero");
        String leNuméro = daNumber.next();

            //Para el valor de verdad
        //String Declaration = "True";
        Scanner Declaration = new Scanner(System.in);
        System.out.println("Ingrese un valor de verdad (true or false)");
        String Valor = Declaration.next();

            //Convertir a int
        int NumberInt = Integer.parseInt(leNuméro);
        System.out.println("NumberInt = " + NumberInt);

            //Convertir a double
        double NumberDouble = Double.parseDouble(leNuméro);
        System.out.println("NumberDouble = " + NumberDouble);

            //Convertir a Boolean
        Boolean SentenceBoolean = Boolean.parseBoolean(Valor);
        System.out.println("SentenceBoolean = " + SentenceBoolean);

            //Para convertir primitivos a String
        Scanner myScanner = new Scanner(System.in).useLocale(Locale.UK);
        System.out.println("Ingrese su tipo de primitivo como se le indica a continuación");

            //Convertir un double
        System.out.println("Ingrese aquí su tipo Double (sin el sufijo d). Ejemplo 1234.567");
        Double leDouble = myScanner.nextDouble();
        String miDouble =  Double.toString(leDouble);
        String otroDouble = String.valueOf(leDouble);
        /*Double unDouble = 1234.567d;
        String theDouble = unDouble.toString();*/
        System.out.println("La cadena de miDouble es " + miDouble);
        System.out.println("La cadena de otroDouble es " + otroDouble);
        //System.out.println("theDouble = " + theDouble);

            //Convertir un float
        System.out.println("Ingrese aquí su tipo float (con o sin notación científica-sin el sufijo f). Ejemplo 12345.678e-2");
        Float monFloat = myScanner.nextFloat();
        String miFloat = Float.toString(monFloat);
        String otroFloat = String.valueOf(monFloat);
        /*Float unFloat = 12345.678e-2f;
        String theFloat = unFloat.toString();*/
        System.out.println("La cadena de miFloat es " + miFloat);
        System.out.println("La cadena de otroFloat es " + otroFloat);
        //System.out.println("unFloat = " + theFloat);

            //También se pueden convertir los distintos tipos de primitivos entre sí, siempre y cuando sean compatibles
        int myInt = 0;
        int myShort = 0;
        int myChar = 0;

        myShort = (short)myInt;
        myChar = (char)myInt;
        boolean isValidInt = false;

        System.out.println("myInt = " + myInt);
        System.out.println("myShort = " + myShort);
        System.out.println("Ingrese aquí su número entero. Ejemplo 12345");

        do {
            try{
                Scanner sc = new Scanner(System.in);
                myInt = sc.nextInt();
                isValidInt = true;

            } catch (InputMismatchException e){
                System.out.println("Error: por favor ingrese un número entero menor a " + Integer.MAX_VALUE);
            }
        }
        while (isValidInt == false);
        System.out.println("myInt = " + myInt);
        System.out.println("myShort = " + myShort);
    }
}
