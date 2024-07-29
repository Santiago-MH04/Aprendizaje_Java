package POO_Colecciones.Lecciones.Set;

import java.util.HashSet;
import java.util.Set;

public class EjemploHashSetBuscarDuplicado {
    public static void main(String[] args) {

        String[] Peces = {"Bocachico", "Bagre", "Mojarra", "Róbalo", "Atún", "Bagre"};
        Set<String> Únicos = new HashSet<>();

        for(String Pez : Peces) {
            if(!Únicos.add(Pez)){
                System.out.println("Elemento duplicado: " + Pez);
            }
        }
        System.out.println("Tamaño del arreglo: " + Únicos.size() +
                "\nArreglo de peces no duplicados: " + Únicos);
    }
}
