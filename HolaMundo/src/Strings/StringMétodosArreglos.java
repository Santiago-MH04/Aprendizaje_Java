package Strings;

public class StringMétodosArreglos {
    public static void main(String[] args) {

        String Parangaricutirimícuaro = "Parangaricutirimícuaro";
        System.out.println("La cadena \"parangaricutirimícuaro\" tiene " + Parangaricutirimícuaro.length() + " caracteres");
        System.out.println("Parangaricutirimícuaro.toCharArray() = " + Parangaricutirimícuaro.toCharArray());

        char[] arreglo = Parangaricutirimícuaro.toCharArray();
            //Creando el objeto char[] es como crear un vector con los distintos elementos de cada cadena de caracteres
        int longitud = Parangaricutirimícuaro.length();
        System.out.println("longitud = " + longitud);

        for (int i = 0; i < longitud; i++){
            System.out.println("Posición_"+ (i + 1) + " de arreglo: " + arreglo[i]);
        }
        System.out.println();
        System.out.println("Parangaricutirimícuaro = " + Parangaricutirimícuaro.split("a"));

        String[] otroArreglo = Parangaricutirimícuaro.split("a");
            //Aquí crea un vector donde, cada elemento es la sección de la cadena de caracteres que se encuentra separado por el caracter definido, en este caso, la letra A
        longitud = otroArreglo.length;
        for (int i = 0; i < longitud; i++){
            System.out.println("otroArreglo_" + (i+1) + ": " + otroArreglo[i]);
        }
    }
}
