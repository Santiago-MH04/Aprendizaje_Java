package Variables;

//import javax.swing.*;
import java.util.InputMismatchException;
import java.util.Scanner;

public class SistemasNuméricosDinámicosConsola {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        System.out.println("Ingrese un número entero");
        //String NúmeroString = scanner.nextLine();

        int RepresentaciónDecimal = 0;

        try{
            RepresentaciónDecimal = scanner.nextInt();
            //RepresentaciónDecimal = Integer.parseInt(NúmeroString);
                //Esta instrucción convierte el String a int para que Java lo pueda leer

        } catch (InputMismatchException e){
            System.out.println("Error: por favor ingrese un número entero");
            //JOptionPane.showMessageDialog(null, "Error: por favor ingrese un número entero");
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
        System.out.println(ResultadoHexadecimal + "\n");

        String ImpresiónPantalla = ResultadoBinario;
        ImpresiónPantalla += "\n" + ResultadoOctal;
        ImpresiónPantalla += "\n" + ResultadoHexadecimal;

        System.out.println(ImpresiónPantalla);
    }
}
