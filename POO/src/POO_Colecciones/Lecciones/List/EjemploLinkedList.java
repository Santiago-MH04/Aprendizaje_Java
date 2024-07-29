package POO_Colecciones.Lecciones.List;

import POO_Colecciones.Lecciones.Modelo.Alumno;

import java.util.LinkedList;
import java.util.ListIterator;

public class EjemploLinkedList {
    public static void main(String[] args) {

        //Set<Alumno> LL = new HashSet<>();
        //Set<Alumno> LL = new TreeSet<>();
        //List<Alumno> LL = new ArrayList<>();
        //List<Alumno> LL = new LinkedList<>();
        LinkedList<Alumno> LL = new LinkedList<>();


        System.out.println(LL + ". Tamaño antes: " + LL.size());
        System.out.println("¿Está vacía antes?: " + LL.isEmpty());
        LL.add(new Alumno("Pepo Pombo", 3));
        LL.add(new Alumno("Manuelitas Torombolitas", 4));
        LL.add(new Alumno("Santiaguito", 5));
        LL.add(new Alumno("Elías Floriciento", 2));
        LL.add(new Alumno("Quesozuelos", 4));
        LL.add(new Alumno("Colín Colín", 3));
        System.out.println(LL + ". Tamaño después: " + LL.size());
        System.out.println("¿Está vacía después?: " + LL.isEmpty());

        LL.addFirst(new Alumno("Pepito Pérez", 4));
        LL.addLast(new Alumno("Nosequién Cito", 3));
        System.out.println(LL + ". Tamaño aún después: " + LL.size());
        System.out.println("Primer elemento: " + LL.getFirst() + ". \nÚltimo elemento: " + LL.peekLast()); //La diferencia entre
        // Get y Peek es que
        // Get lanza excepción si la lista es vacía,
        // y Peek devuelve un elemento nulo
        System.out.println("Obteniendo por índice 2 " + LL.get(2));
        Alumno Pepito = LL.removeFirst();
        //Alumno PepitoPérez = LL.pop(); //Pop y removeFirst son equivalentes,
        // es decir, lanzan excepción si el
        // elemento es nulo
        LL.pollLast();  //La diferencia entre
        // Remove y Poll es que
        // Remove lanza excepción si la lista es vacía,
        // y Poll devuelve un elemento nulo
        System.out.println(LL + ". Tamaño aún más después ya: " + LL.size());

        LL.remove(new Alumno("Elías Floriciento", 2));
        System.out.println(LL + ". Tamaño aún más después: " + LL.size());

        Alumno A = new Alumno("Lord Baldomero", 5);
        LL.addLast(A);
        System.out.println("Índice de Lord Baldomero: " + LL.indexOf(A));

        LL.remove(1);
        System.out.println(LL + ". Tamaño aún más después peor: " + LL.size());
        System.out.println("Índice de Lord Baldomero aún más después peor: " + LL.indexOf(A));

        LL.set(3, new Alumno("Diomedes Díaz", 1));
        System.out.println(LL + ". Tamaño aún más después peor con cambio de casilla: " + LL.size());

        ListIterator<Alumno> LILL = LL.listIterator();
        //Recorriendo en sentido ascendente
        System.out.println("\nRecorriendo en sentido ascendente");
        while(LILL.hasNext()){
            System.out.println(LILL.next());
        }
        //Recorriendo en sentido descendente
        System.out.println("\nRecorriendo en sentido descendente");
        while(LILL.hasPrevious()){
            System.out.println(LILL.previous());
        }

    }
}
