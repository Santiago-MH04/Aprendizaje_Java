package Operadores;

public class OperadoresIncrementales {
    public static void main(String[] args) {

            //Preincremento
        int i = 1;
        int j = ++i; // i = i + 1 ---> j = i
                //Aquí, primero se reescribe la variable anterior, y luego se le asigna valor a la nueva variable
        System.out.println("i preincremento = " + i);
        System.out.println("j preincremento = " + j);

            //Postincremento
        i = 2;
        j = i++; // j = i ---> i = i + 1
        //Aquí, primero se le asigna el valor a la nueva variable, y luego se reescribe la variable anterior
        System.out.println("i postincremento = " + i);
        System.out.println("j postincremento = " + j);

            //Predecremento
        i = 3;
        j = --i; // i = i - 1 ---> j = i
        System.out.println("i predecremento = " + i);
        System.out.println("j predecremento = " + j);

            //Postdecremento
        i = 4;
        j = i--; // j = i ---> i = i - 1
        System.out.println("i postdecremento = " + i);
        System.out.println("j postdecremento = " + j);
    }
}
