package Variables;

public class PrimitivosCaracteres {
    public static void main(String[] args) {

        char unicode = '\u0040';
        char decimal = 64;
        char arroba = '@';

        System.out.println("unicode = " + unicode);
        System.out.println("decimal = " + decimal);
        System.out.println("arroba = " + arroba);

        System.out.println( (unicode == decimal) + " unicode = decimal = " + unicode);

        System.out.println("Tipo character corresponde en bytes a = " + Character.BYTES);
        System.out.println("Tipo character corresponde en bits a = " + Character.SIZE);
        System.out.println("El valor máximo de una variable tipo character es igual a " + Character.MAX_VALUE);
        System.out.println("El valor mínimo de una variable tipo character es igual a " + Character.MIN_VALUE);

            // Los siguientes caracteres especiales pueden a su vez, ser usados dentro de las cadenas como instrucciones
        char espacio = '\u0020';
        char retroceso = '\b';
        char tabulador = '\t';

        char NuevaLínea = '\n';
        char RetornoCarro = '\r';
        //Como, de acuerdo con el sistema operativo, \n y  \r pueden ejecutar acciones diferentes, se recomienda usar System.getProperty("line.separator")

        System.out.println("Tipo character corresponde en bytes a = " + System.getProperty("line.separator") + Character.BYTES);
    }
}
