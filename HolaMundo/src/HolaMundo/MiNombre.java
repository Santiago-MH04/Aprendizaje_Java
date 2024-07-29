package HolaMundo;

public class MiNombre {

    // Esta línea se comenta con las dos barras diagonales. Así se comentan líneas
    /* Esta línea se comenta con la barra y el asterisco para abrir, asterisco y barra para cerrar. Así se comentan bloques */

    public static void main(String[] args) {
        String nombre = "Santiago";
        String saludo = "Mi nombre es ";
        System.out.println(saludo + nombre);
        System.out.println((saludo + nombre).toUpperCase());

        int number = 10;
        int numberA = 0;

        boolean value = false;

        if(value){
            numberA = 1;
            System.out.println("Número = " + number);
        }
        System.out.println("numberA = " + numberA);
    }
}
