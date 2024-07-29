package Operadores;

import java.util.Scanner;

public class OperadoresLógicosLogin {
    public static void main(String[] args) {

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
                if (nombreUsuario[i].equals(n) && suContraseña[i].equals(c)){
                    seValida = true;
                    break;
                }
            }
            if (seValida){
                System.out.println("¡Bienvenido a nuestro portal, " + n + "!");
            }else{
                System.out.println("Usuario o contraseña inválidos. Intente nuevamente");
            }
        } while (!seValida);
    }
}
