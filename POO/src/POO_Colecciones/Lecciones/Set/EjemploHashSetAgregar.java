package POO_Colecciones.Lecciones.Set;

import java.util.*;

public class EjemploHashSetAgregar {
    public static void main(String[] args) {

        Set<String> HS = new HashSet<>();
            HS.add("Uno");
            HS.add("Dos");
            HS.add("Tres");
            HS.add("Cuatro");
            HS.add("Cinco");

        /*List<String> Lista = new ArrayList<>(HS);
        Collections.sort(Lista);
        System.out.println("Elementos ordenados en una lista: " + Lista);*/

        System.out.println("Elementos del set: " + HS);
        boolean b = HS.add("Cuatro");
        System.out.println("¿El set permite agregar elementos duplicados?: " + b);
    }
}
