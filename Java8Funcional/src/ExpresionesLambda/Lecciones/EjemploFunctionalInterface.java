package ExpresionesLambda.Lecciones;

import ExpresionesLambda.Lecciones.Aritmética.*;

public class EjemploFunctionalInterface {
    public static void main(String[] args) {

        Aritmética suma = (a, b) -> a + b;
        Aritmética producto = (a, b) -> a*b;

        Calculadora cal = new Calculadora();
        System.out.println(cal.Calcular(4, 6, suma));
        System.out.println(cal.Calcular(4, 6, producto));
        System.out.println(cal.Calcular(4,2, (a,b) -> Math.pow(a, 1/b)));   //Implementación al vuelo

        System.out.println(cal.Calcular(Math.PI/4, Math.PI/4, (a, b) -> Math.sin(a + b)));
    }
}
