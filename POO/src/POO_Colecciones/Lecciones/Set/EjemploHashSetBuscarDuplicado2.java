package POO_Colecciones.Lecciones.Set;

import java.util.HashSet;
import java.util.Set;

public class EjemploHashSetBuscarDuplicado2 {
    public static void main(String[] args) {

        String[] Peces = {"Bocachico", "Bagre", "Mojarra", "Róbalo", "Atún", "Bagre"};
        Set<String> Únicos = new HashSet<>();
        Set<String> Duplicados = new HashSet<>();

        for(String Pez : Peces) {
            if(!Únicos.add(Pez)){
                Duplicados.add(Pez);
            }
        }

        Únicos.removeAll(Duplicados);

        System.out.println("Tamaño del arreglo (set): " + Únicos.size() +
                "\nArreglo de peces no duplicados (set): " + Únicos);
        System.out.println("Tamaño del arreglo (set): " + Duplicados.size() +
                "\nArreglo de peces duplicados (set): " + Duplicados);
    }
}
