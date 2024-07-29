package POO_Colecciones.Lecciones.Set;

import POO_Colecciones.Lecciones.Modelo.Alumno;

import java.util.Comparator;
import static java.util.Comparator.comparing;

import java.util.Set;
import java.util.TreeSet;

public class EjemploTreeSetComparable {
    public static void main(String[] args) {

        //Set<Alumno> SA = new TreeSet<>((a, b) -> b.getNota().compareTo(a.getNota())); //Implementando la expresión lambda
        Set<Alumno> SA = new TreeSet<>(Comparator.comparing(Alumno::getNota).reversed()); //Implementando la expresión lambda simplificada
        //Set<Alumno> SA = new TreeSet<>(comparing(Alumno::getNota).reversed()); //Implementando la expresión lambda simplificada, con el método estático comparing importado

        SA.add(new Alumno("Pepo Pombo", 3));
        SA.add(new Alumno("Manuelitas Torombolitas", 4));
        SA.add(new Alumno("Santiaguito", 5));
        SA.add(new Alumno("Elías Floriciento", 2));
        SA.add(new Alumno("Quesozuelos", 4));
        SA.add(new Alumno("Colín Colín", 3));

        System.out.println(SA);
    }
}
