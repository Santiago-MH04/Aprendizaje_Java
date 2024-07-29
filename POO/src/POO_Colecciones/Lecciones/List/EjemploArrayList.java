package POO_Colecciones.Lecciones.List;

import POO_Colecciones.Lecciones.Modelo.Alumno;

import java.util.List;
import java.util.ArrayList;

public class EjemploArrayList {
    public static void main(String[] args) {

        //Set<Alumno> SA = new HashSet<>();
        //Set<Alumno> SA = new TreeSet<>();
        List<Alumno> ALA = new ArrayList<>();
        //List<Alumno> SA = new LinkedList<>();

        System.out.println(ALA + ". Tamaño antes: " + ALA.size());
        System.out.println("¿Está vacía antes?: " + ALA.isEmpty());
        ALA.add(new Alumno("Pepo Pombo", 3));
        ALA.add(new Alumno("Manuelitas Torombolitas", 4));
        ALA.add(new Alumno("Santiaguito", 5));
        ALA.add(new Alumno("Elías Floriciento", 2));
        ALA.add(2, new Alumno("Quesozuelos", 4)); //Se desea guardar en el índice 2
        ALA.set(3, new Alumno("Colín Colín", 3)); //Se modifica el dato en la posición indicada. Modifica el tamaño del arreglo
        System.out.println(ALA + ". Tamaño después: " + ALA.size());
        System.out.println("¿Está vacía después? " + ALA.isEmpty());

        //ALA.remove(new Alumno("Manuelitas Torombolitas", 4)); //Elimina objeto por referencia
        ALA.remove(1); //Elimina objeto por índice
        System.out.println(ALA + ". Tamaño después de eliminar el elemento: " + ALA.size());


        boolean b = ALA.contains(new Alumno("Manuelitas Torombolitas", 4) /*new Alumno("Quesozuelos", 4)*/);
        String d = (b)? "sí": "no";
        System.out.println("¿La lista contiene a Manuelitas Torombolitas?: " + d);

        Object[] A = ALA.toArray();
        for(int i = 0; i < A.length; i++){
            System.out.println("Desde el arreglo: " + A[i]);
        }
    }
}
