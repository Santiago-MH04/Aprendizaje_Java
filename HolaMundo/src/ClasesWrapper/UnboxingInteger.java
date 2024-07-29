package ClasesWrapper;

public class UnboxingInteger {
    public static void main(String[] args) {
        Integer [] misEnteros = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15};
        int sumaPares = 0;
        int sumaImpares = 0;

            //Unboxing explícito
        for (Integer i : misEnteros){
            if (i.intValue() % 2 == 0){
                sumaImpares += i.intValue();
            }
        }
        System.out.println("La suma de los elementos pares del arreglo es: " + sumaPares);

            //Unboxing implícito
        for (Integer i : misEnteros){
            if (i % 2 != 0){
                sumaImpares += i;
            }
        }
        System.out.println("La suma de los elementos impares del arreglo es: " + sumaImpares);
        System.out.println("Autoboxing es convertir primitivos a sus valores de referencia, y unboxing el procedimiento contrario");
    }
}
