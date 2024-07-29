package POO_Colecciones.Lecciones.Set;

import java.util.Comparator;
import java.util.Set;
import java.util.TreeSet;

public class EjemploTreeSet {
    public static void main(String[] args) {

        Set<String> TS = new TreeSet<>((a, b) -> b.compareTo(a)); //Todos los elementos que se agreguen a un TreeSet tienen que implementar la interfaz comparable

        TS.add("Uno");
        TS.add("Dos");
        TS.add("Tres");
        TS.add("Cuatro");
        TS.add("Cuatro");
        TS.add("Cinco");

        Set<Integer> TSn = new TreeSet<>(Comparator.reverseOrder()); //Todos los elementos que se agreguen a un TreeSet tienen que implementar la interfaz comparable
        TSn.add(1);
        TSn.add(2);
        TSn.add(3);
        TSn.add(4);
        TSn.add(4);
        TSn.add(5);

        System.out.println("TS (se muestran en orden natural, es decir, de la tabla Unicode, pero inverso): " + TS);
        System.out.println("TSn (en orden descendente): " + TSn);
    }
}
