package Variables;

public class PrimitivosBoolean {
    public static void main(String[] args) {

        boolean DatoLógico = true;
        System.out.println("DatoLógico = " + DatoLógico);

        double d = 98765.43e-3; // 98.76543
        System.out.println("d = " + d);
        float f = 1.2345e2F; // 123.45
        System.out.println("f = " + f);

        DatoLógico = d > f;
        System.out.println("DatoLógico = " + DatoLógico);
    }
}
