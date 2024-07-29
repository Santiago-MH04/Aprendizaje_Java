package ClasesWrapper;

public class WrapperOperadoresRelacionales {
    public static void main(String[] args) {
        Integer num1 = 127;
        Integer num2 = num1;

        System.out.println("num1 = " + num1);
        System.out.println("num2 = " + num2);
        System.out.println("¿Son el mismo objeto (El operador == compara las instancias)?: " + (num1 == num2));

        //Si el valor del objeto o la referencia es menor que 127, no compara instancias, sino su valor. Particularidad de Java
        num2 = 127;

        System.out.println("num1 = " + num1);
        System.out.println("num2 = " + num2);
        System.out.println("¿Son el mismo objeto (El operador == compara las instancias en tipos numéricos)?: " + (num1 == num2));

            //Comparar los valores o referencias
        System.out.println("¿Estos objetos tienen el mismo valor?: " + (num1.equals(num2)));
        System.out.println("¿Estos objetos tienen el mismo valor?: " + (num1.intValue() == num2.intValue()));

            //Los otros operadores relacionales comparan valor, no referencia
        boolean Condición = num1 > num2;
        System.out.println("Condición = " + Condición);
    }
}
