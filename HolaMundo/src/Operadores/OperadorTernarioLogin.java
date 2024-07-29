package Operadores;

import java.util.Scanner;

public class OperadorTernarioLogin {
    public static void main(String[] args) {

        //Un operador ternario sólo retorna algo de la manera tipoObjeto operación = (Criterio)? RetornoSí : RetornoNo;
        //Donde operación, RetornoSí y RetornoNo deben ser objetos de la misma clase e instancia

        Scanner scanner = new Scanner(System.in);
        String[] nombreUsuario = {"Santiago", "Manuelas"};
        String[] suContraseña = {"QuesoyColo240*", "QuesoColo2915*"};
            //Un vector de n elementos, sin declarar que se va a crear desde cero se puede poblar entre llaves, separando cada elemento por una coma
        boolean seValida = false;

        do {
            System.out.println("Por favor, ingrese su nombre de usuario");
            String n = scanner.next();
            System.out.println("Ahora, ingrese su contraseña");
            String c = scanner.next();


            for (int i = 0; i < nombreUsuario.length; i++){
                seValida = (nombreUsuario[i].equals(n) && suContraseña[i].equals(c)) ? true : seValida;
              /*if (nombreUsuario[i].equals(n) && suContraseña[i].equals(c)){
                  seValida = true;
                  break;
              }*/
            }
            String esPermitido = "¡Bienvenido a nuestro portal, " + n + "!";
            String esDenegado = "Usuario o contraseña inválidos. Intente nuevamente";
            String miResultado = "";

            miResultado = (seValida == true)? esPermitido:esDenegado;
            System.out.println(miResultado);
              /*if (seValida){
              System.out.println("¡Bienvenido a nuestro portal, " + n + "!");
          }else{
              System.out.println("Usuario o contraseña inválidos. Intente nuevamente");
              }*/
        } while (!seValida);
    }
}
