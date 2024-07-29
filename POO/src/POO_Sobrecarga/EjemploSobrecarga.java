package POO_Sobrecarga;

import POO_Sobrecarga.Métodos.*;
import static POO_Sobrecarga.Métodos.Calculadora.*;


public class EjemploSobrecarga {
    public static void main(String[] args) {
        Calculadora cal = new Calculadora();
            //Cuando se va a operar con un método estático, lo usual es
            //usar el nombre de la clase, y no instanciando un objeto de referencia
            //También se puede diseñar el objeto Calculadora de acceso privado, o la clase Calculadora como abstracta
            //Todo depende de las necesidades de diseño.

        System.out.println("Sumar enteros (int): " + cal.sumar(10, 5));
        System.out.println("Sumar flotantes (float): " + cal.sumar(10f, 5f));
        System.out.println("Sumar flotante-entero (float-int): " + cal.sumar(10f, 5));
        System.out.println("Sumar entero-flotante (int-float): " + cal.sumar(10, 5f));
        System.out.println("Sumar doble (double): " + cal.sumar(10d, 5d));
        System.out.println("Sumar string (String): " + cal.sumar("10", "5"));
        System.out.println("Sumar tres enteros (int): " + cal.sumar(10, 5, 3));

        System.out.println("Sumar formatos largos (long): " + cal.sumar(10l, 5l));
        System.out.println("Sumar enteros (int): " + cal.sumar(10, '@'));
        System.out.println("Sumar flotantes (float): " + cal.sumar(10f, '@'));

            //Usando el método sumar como propio de esta clase
        System.out.println("Sumar un número arbitrario de enteros n(int): " + sumar(1, 2, 3, 4, 5));


    }
}
