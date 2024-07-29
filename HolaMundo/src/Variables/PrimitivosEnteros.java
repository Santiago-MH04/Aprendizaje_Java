package Variables;

public class PrimitivosEnteros {
    public static void main(String[] args) {

        byte numberByte = 127;

        System.out.println("numberByte = " + numberByte);
        System.out.println("Tipo byte corresponde en bytes a " + Byte.BYTES);
        System.out.println("Tipo byte corresponde en bits a " + Byte.SIZE);
        System.out.println("El valor máximo de una variable tipo byte es igual a " + Byte.MAX_VALUE);
        System.out.println("El valor mínimo de una variable tipo byte es igual a " + Byte.MIN_VALUE);

        short numberShort = 999;

        System.out.println("numberShort = " + numberShort);
        System.out.println("Tipo short corresponde en bytes a " + Short.BYTES);
        System.out.println("Tipo short corresponde en bits a " + Short.SIZE);
        System.out.println("El valor máximo de una variable tipo short es igual a " + Short.MAX_VALUE);
        System.out.println("El valor mínimo de una variable tipo short es igual a " + Short.MIN_VALUE);

        int numberInt = 3276700;

        System.out.println("numberInt = " + numberInt);
        System.out.println("Tipo int corresponde en bytes a " + Integer.BYTES);
        System.out.println("Tipo int corresponde en bits a " + Integer.SIZE);
        System.out.println("El valor máximo de una variable tipo int es igual a " + Integer.MAX_VALUE);
        System.out.println("El valor mínimo de una variable tipo short es igual a " + Integer.MIN_VALUE);

        long numberLong = 2147483647L;
        //Dado que el número literal siempre se toma como entero por defecto, es recomendable dejar la letra L al final del número para asignarle la clase long

        System.out.println("numberLong = " + numberLong);
        System.out.println("Tipo long corresponde en bytes a " + Long.BYTES);
        System.out.println("Tipo long corresponde en bits a " + Long.SIZE);
        System.out.println("El valor máximo de una variable tipo long es igual a " + Long.MAX_VALUE);
        System.out.println("El valor mínimo de una variable tipo long es igual a " + Long.MIN_VALUE);

        // También existe la clase var, que adopta la clase integer por defecto, y, cuando es superada, hay que indiicar si es un long o flotante de precisión sencilla o doble
    }
}

