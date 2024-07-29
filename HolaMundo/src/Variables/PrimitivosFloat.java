package Variables;

public class PrimitivosFloat {
    public static void main(String[] args) {

            // Los números de variable flotante poseen la coma decimal. Entonces, si se crea una variable con un entero, lo va a mostrar x,0; o si se lo asigna como flotante, también, es decir xF
        float realFloat = 1F;
        System.out.println("realFloat = " + realFloat);

        System.out.println("realFloat = " + realFloat);
        System.out.println("Tipo float corresponde en bytes a " + Float.BYTES);
        System.out.println("Tipo float corresponde en bits a " + Float.SIZE);
        System.out.println("El valor máximo de una variable tipo float es igual a " + Float.MAX_VALUE);
        System.out.println("El valor mínimo de una variable tipo float es igual a " + Float.MIN_VALUE);

        double  realDouble = 3.4028235E39;
        System.out.println("realDouble = " + realDouble);

        System.out.println("realDouble = " + realDouble);
        System.out.println("Tipo double corresponde en bytes a " + Double.BYTES);
        System.out.println("Tipo double corresponde en bits a " + Double.SIZE);
        System.out.println("El valor máximo de una variable tipo double es igual a " + Double.MAX_VALUE);
        System.out.println("El valor mínimo de una variable tipo double es igual a " + Double.MIN_VALUE);

        var varPi = Math.PI;
        System.out.println("varPi = " + varPi);
    }
}
