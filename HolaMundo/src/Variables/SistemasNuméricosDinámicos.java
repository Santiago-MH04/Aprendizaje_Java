package Variables;

import javax.swing.*;

public class SistemasNuméricosDinámicos {
    public static void main(String[] args) {

        String NúmeroString = JOptionPane.showInputDialog(null,"Ingrese un número entero");
        int RepresentaciónDecimal = 0;
        System.out.println("RepresentaciónDecimal = " + RepresentaciónDecimal);

        try{
            RepresentaciónDecimal = Integer.parseInt(NúmeroString);
            //Esta instrucción convierte el String a int para que Java lo pueda leer

        } catch (NumberFormatException e){
            JOptionPane.showMessageDialog(null,"Error: por favor ingrese un número entero");
            main(args);
            System.exit(0);
        }

            //Representar como un número binario
        String ResultadoBinario = "La representación de " + RepresentaciónDecimal + " en sistema binario es "+ Integer.toBinaryString(RepresentaciónDecimal);
        System.out.println(ResultadoBinario);

            //Representar como un número octal
        String ResultadoOctal = "La representación de " + RepresentaciónDecimal + " en sistema octal es "+ Integer.toOctalString(RepresentaciónDecimal);
        System.out.println(ResultadoOctal);

            //Representar como un número hexadecimal
        String ResultadoHexadecimal = "La representación de " + RepresentaciónDecimal + " en sistema hexadecimal es "+ Integer.toHexString(RepresentaciónDecimal);
        System.out.println(ResultadoHexadecimal);

        String ImpresiónPantalla = ResultadoBinario;
        ImpresiónPantalla += "\n" + ResultadoOctal;
        ImpresiónPantalla += "\n" + ResultadoHexadecimal;

        JOptionPane.showMessageDialog(null, ImpresiónPantalla);
    }
}

