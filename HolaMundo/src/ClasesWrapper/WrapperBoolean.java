package ClasesWrapper;

public class WrapperBoolean {
    public static void main(String[] args) {
        Integer num1, num2;
        num1 = 1;
        num2 = 2;

        boolean primiBoolean = num1 > num2;
        Boolean objetoBoolean = Boolean.valueOf(primiBoolean);
        Boolean objetoBoolean2 = Boolean.valueOf("false");
        Boolean objetoBoolean3 = false;

        System.out.println("primiBoolean = " + primiBoolean);
        System.out.println("objetoBoolean = " + objetoBoolean);
        System.out.println("objetoBoolean2 = " + objetoBoolean2);

        System.out.println("Comparando dos objetos Boolean: " + (objetoBoolean == objetoBoolean2));
        System.out.println("Comparando dos objetos Boolean: " + (objetoBoolean.equals(objetoBoolean2)));
        System.out.println("Comparando dos objetos Boolean: " + (objetoBoolean == objetoBoolean3));
        System.out.println("Comparando dos objetos Boolean: " + (objetoBoolean2 == objetoBoolean3));

        boolean primiBoolean2 = objetoBoolean.booleanValue();
        System.out.println("primiBoolean2 = " + primiBoolean2);
    }
}
