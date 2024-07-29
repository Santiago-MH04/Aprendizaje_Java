package ValorVSReferencia;

public class PasarPorReferencia {
    public static void main(String[] args) {

        int[] edad = {10, 11, 12};

            //Antes de probando();
        System.out.println("Antes de llamar al método probando");
        for (int i = 0; i < edad.length; i++){
            System.out.println("edad_" + i +": "+ edad[i]);
        }

            //Después de probando();
        System.out.println("Después de llamar al método probando \n");
        probando(edad);
        for (int i = 0; i < edad.length; i++){
            System.out.println("edad_" + i +": "+ edad[i]);
        }

        System.out.println("Finaliza el método probando, y modifica los valores del arreglo");
    }

    public static void probando (int[] edadArreglo) {
            //Prueba con el método Probando
        System.out.println("Inicio del método probando");
        for (int i = 0; i < edadArreglo.length; i++) {
            edadArreglo[i] = edadArreglo[i] + 20;
        }
        System.out.println("Finalización del método probando");
    }
}
