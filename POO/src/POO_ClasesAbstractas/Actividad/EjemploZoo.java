package POO_ClasesAbstractas.Actividad;

import POO_ClasesAbstractas.Actividad.Clase.Familia.Especie.*;
import POO_ClasesAbstractas.Actividad.Clase.Mamífero;

public class EjemploZoo {
    public static void main(String[] args) {

        Mamífero leopardo = new Leopardo("Panthera pardus", "Bosques tropicales, desiertos y sabanas de África y Asia", 0.7f, 1.6f, 31,
                10, 58);
        Mamífero león = new León("Panthera leo", "Sabana africana", 1.2f, 2.1f, 190,
                3.8f, 80,
                27, 114);
        Mamífero tigre = new Tigre("Panthera tigris", "Bosques asiáticos", 1.1f, 3.9f, 310,
                7.5f, 65, "tigris");
        Mamífero lobo = new Lobo("Canis lupus", "Generalista", 0.85f, 1.6f, 80,
                "Gris", 7.11f, 20, "dingo (dingo australiano)");
        Mamífero perro = new Perro("Lycaon pictus", "Llanuras abiertas y sabana", 60f, 92f, 22,
                "Gris, Negro, Blanco, Marrón, Bronceado, Oro, Rojo", 6f, 556);

        Mamífero[] Animales = {leopardo, león, tigre, lobo, perro};

        for (Mamífero Depredador : Animales) {
            System.out.println(Depredador.resumen());
            System.out.println();
        }
    }
}
