package POO_Colecciones.Lecciones.Set;

import POO_Colecciones.Lecciones.Modelo.Alumno;

import java.util.*;

public class EjemploHashSetUnicidad {
    public static void main(String[] args) {

        Set<Alumno> SA = new HashSet<>();
        //Set<Alumno> SA = new TreeSet<>();
        //List<Alumno> SA = new ArrayList<>();
        //List<Alumno> SA = new LinkedList<>();

            SA.add(new Alumno("Pepo Pombo", 3));
            SA.add(new Alumno("Manuelitas Torombolitas", 4));
            SA.add(new Alumno("Santiaguito", 5));
            SA.add(new Alumno("Elías Floriciento", 2));
            SA.add(new Alumno("Quesozuelos", 4));
            SA.add(new Alumno("Colín Colín", 3));

        System.out.println(SA);

        System.out.println("Iterar el Set usando un for-each");
        for (Alumno a: SA){
            System.out.println(a);
        }

        System.out.println("\nIterar el Set usando un while y un iterator");
        Iterator<Alumno> it = SA.iterator();
        while(it.hasNext()){
            Alumno a = it.next();
            System.out.println(a);
        }

        System.out.println("\nIterar el Set usando expresiones lambda");
        SA.forEach(System.out::println);

        /*System.out.println("Iterar el Set usando un for clásico (único de listas)");
        for (int i = 0; i < SA.size(); i++){
            System.out.println(SA.get(i));
        }*/
    }
}
