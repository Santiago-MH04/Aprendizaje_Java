package Strings;

import java.util.Scanner;

public class ProgramaManejoNombres {
    public static void main(String[] args) {

        Scanner miFamilia = new Scanner(System.in);
        System.out.println("Por favor indique los miembros de su familia, separados por el caracter &: ");

      /*System.out.println("Por favor indique cuántos miembros de su familia quiere transformar: ");
        int eFe = miFamilia.nextInt();

        String[] laFamilia = new String[eFe];
        // Al ingresar [efe] le estoy indicando a Java que este vector tiene eFe elementos
        int losElementos = laFamilia.length;

        for (int i = 0; i < eFe; i++){
            System.out.println("Por favor indique el nombre del " + (i+1)+ "°" + " miembro de su familia");
            laFamilia[i] = miFamilia.next();
                //Aquí, por cosas raras del destino, ejecuta diferente de corrido que con debugger
            System.out.println("laFamilia = " + laFamilia[i]);
        }*/

        String Familia = miFamilia.next();
        String[] estaFamilia = Familia.split("&");
        String[] lasTransformaciones1 = new String[estaFamilia.length];
        String[] lasTransformaciones2 = new String[estaFamilia.length];

        StringBuilder miManejoNombres = new StringBuilder();

        //System.out.println("\n" + "Los miembros de esta familia son: ");
        for (int i = 0; i < estaFamilia.length; i++){
            lasTransformaciones1[i] = String.valueOf(estaFamilia[i].charAt(1)).toUpperCase();
                //Pedir que me expliquen por qué esta línea salió así
            lasTransformaciones2[i] = estaFamilia[i].substring(estaFamilia[i].length()-2);
            miManejoNombres.append(lasTransformaciones1[i]).append(".").append(lasTransformaciones2[i]).append("_");

            //System.out.println(estaFamilia[i]);
        }
        miManejoNombres = miManejoNombres.append("\b");
        System.out.println("El manejo de nombres de este código resulta en: " + miManejoNombres);
    }
}
