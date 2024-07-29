package Operadores;

public class OperadoresRelacionales {
    public static void main(String[] args) {

        int i = 1;
        byte j = 2;
        float k = 2.345e-4f;
        double l = 3.4567e5;
        boolean m = false;

        boolean b1 = i == j;
            //No compara instancias, sino el valor del objeto
        System.out.println("b1 = " + b1);

        boolean b2 = !b1;
        System.out.println("b2 = " + b2);

        boolean b3 = i != j;
        System.out.println("b3 = " + b3);

        boolean b4 = m == true;
        System.out.println("b4 = " + b4);

        boolean b5 = m != true;
        System.out.println("b5 = " + b5);
    }
}
