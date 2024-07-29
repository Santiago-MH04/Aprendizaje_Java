package FlujosDeControl;

import javax.swing.*;
import java.util.Scanner;

public class DíasDelMes {
    public static void main(String[] args) {
        String unTexto = JOptionPane.showInputDialog("Ingrese el mes y el año que quiere analizar. \nEjemplo: Abril/1997");
        String[] elTexto = unTexto.split("/");

        int año = 0, mes = 0, losDías= 0;

        elTexto[0] = elTexto[0].toLowerCase();
        switch (elTexto[0]){
            case ("enero")  : mes = 1; break;
            case ("febrero"): mes = 2; break;
            case ("marzo"): mes = 3; break;
            case ("abril"): mes = 4; break;
            case ("mayo"): mes = 5; break;
            case ("junio"): mes = 6; break;
            case ("julio"): mes = 7; break;
            case ("agosto"): mes = 8; break;
            case ("septiembre"): mes = 9; break;
            case ("octubre"): mes = 10; break;
            case ("noviembre"): mes = 11; break;
            case ("diciembre"): mes = 12; break;
        }

        año = Integer.parseInt(elTexto[1]);
        boolean esBisiesto = false;

        if (año % 400 == 0 || (año % 4 == 0 && !(año % 100 == 0))){
            esBisiesto = true;
        }

        if (mes == 1 || mes == 3 || mes == 5 || mes == 7 || mes == 8 || mes == 10 || mes == 12){
            losDías = 31;
        }   else if (mes == 4 || mes == 6 || mes == 9 || mes == 11) {
            losDías = 30;
        }   else if (mes == 2) {
            if (esBisiesto == true){
                losDías = 29;
            }   else    {
                losDías = 28;
            }
        }
        System.out.println("El " + mes + "° mes del año " + año + " tiene " + losDías + " días");
        System.out.println((esBisiesto == true)?("Este año es bisiesto"):("Este año no es bisiesto"));
    }
}
