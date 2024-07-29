package Operadores;

public class OperadoresLógicos {
    public static void main(String[] args) {

        int i = 1;
        byte j = 2;
        float k = 2.345e-4f;
        double l = 3.4567e5;
        boolean m = false;

        boolean b1 = i == j && k > l;
            //No compara instancias, sino el valor del objeto. Como tiene doble operación, ambas partes deben ser verdaderas, para arrojar un resultado verdadero
        System.out.println("b1 = " + b1);

        boolean b2 = i == j || k < l;
        System.out.println("b2 = " + b2);

        boolean b3 = i == j && k < l || m == false;
        System.out.println("b3 = " + b3);

        boolean b4 = i == j || k < l && m == false;
            //Contrario a la lógica, uno pensaría que se resuelve todo de izquierda a derecha, pero el operador && tiene precedencia sobre el ||
        System.out.println("b4 = " + b4);

        boolean b5 = true || true && false;
        System.out.println("b5 = " + b5);

        boolean b6 = true || true && false || false;
        System.out.println("b6 = " + b6);
    }
}
