package ValorVSReferencia;

public class PasarPorValor {
    public static void main(String[] args) {

        Integer i = 10;

            //Prueba con el método Main
        System.out.println("Inicio del método main para la variable i = " + i);
        probando(i);
        System.out.println("Finalización del método main para la variable i = " + i);
    }

    public static void probando (Integer i) {
            //Prueba con el método Probando
        System.out.println("Inicio del método probando para la variable i = " + i);
        i = 25;
        System.out.println("Finalización del método probando para la variable i = " + i);
    }
}
