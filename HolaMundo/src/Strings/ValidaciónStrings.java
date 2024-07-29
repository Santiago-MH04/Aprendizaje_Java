package Strings;

import java.util.Scanner;

public class ValidaciónStrings {
    public static void main(String[] args) {

        Scanner unCurso = new Scanner(System.in);

        System.out.println("Ingrese su cadena de caracteres para el curso");
        String elCurso = unCurso.toString();
        boolean esNulo = elCurso == null;
        System.out.println("esNulo = " + esNulo);

        if (esNulo){
            elCurso = "Programación Java";
        }

            //Validar por longitud de caracteres
        boolean esVacío = elCurso.length() == 0;
        System.out.println("elCurso = " + elCurso);;
        System.out.println("esVacío = " + esVacío);
        System.out.println("Número de caracteres en elCurso = " + elCurso.length());

            //Validar por ausencia o presencia de contenido
        boolean otroVacío = elCurso.isEmpty();
        System.out.println("otroVacío = " + otroVacío);

            //Validar por espacios en blanco
        boolean esBlanco = elCurso.isBlank();
        System.out.println("esBlanco = " + esBlanco);

        if (esBlanco == false){
            System.out.println(elCurso.toUpperCase());
            System.out.println("Bienvenidos al curso ".concat(elCurso));
        }
    }
}
