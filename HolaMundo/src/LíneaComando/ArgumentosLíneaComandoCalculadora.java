package LíneaComando;

import javax.swing.plaf.synth.SynthScrollBarUI;

public class ArgumentosLíneaComandoCalculadora {
    public static void main(String[] args) {

        if (args.length != 3){
            System.out.println("Por favor ingresar el nombre de una de las operaciones básicas y dos números");
            System.exit(-1);
        }

        String operación = args[0];
        double a = 0;
        double b = 0;
        double resultado = 0;

        try{
            a = Double.parseDouble(args[1]);
            b = Double.parseDouble(args[2]);
        } catch (NumberFormatException e){
            System.err.println("¡Cuidado! a y b deben ser números. Intentar nuevamente");
            System.exit(-1);
        }

        switch (operación){
            case "suma":
                resultado = a + b;
                break;
            case "resta":
                resultado = a - b;
                break;
            case "multiplicación":
                resultado = a*b;
                break;
            case "división":
                while (b != 0){
                    resultado = a/b;
                }
                if (b == 0){
                    System.err.println("La división por cero es indeterminada");
                    System.exit(-1);
                }
                break;
            default:
                resultado = a + b;
                break;
        }
        System.out.println("El resultado de la operación " + operación + " es: " + resultado);
    }
}

