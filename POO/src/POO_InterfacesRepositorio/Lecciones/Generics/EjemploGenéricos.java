package POO_InterfacesRepositorio.Lecciones.Generics;

import POO_InterfacesRepositorio.Lecciones.Interfaces.Modelo.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class EjemploGenéricos {
    public static void main(String[] args) {

        List<Cliente> Clientes = new ArrayList<>();
        Clientes.add(new Cliente("Quesozuelos", "Torombozuelos"));

        Cliente Queso = Clientes.iterator().next();

        Cliente[] Clientela = {new Cliente("Quesozuelos", "Torombozuelos"),
                new Cliente("Colín", "Barrigoncín")};
        Integer[] Enteros = {1, 2, 3};

        List<Cliente> ClientelaList = fromArrayToList(Clientela);
        System.out.println("Lista de clientes");
        ClientelaList.forEach(System.out::println);
        List<ClientePremium> ClientelaPremiumList = fromArrayToList(new ClientePremium[]{
                (new ClientePremium("Vaca", "Lola")),
                (new ClientePremium("Mickey", "Mouse"))});
        List<Integer> EnterosList = fromArrayToList(Enteros);
        System.out.println("\nLista de enteros");
        EnterosList.forEach(System.out::println);
        System.out.println();
        List<String> Nombres = fromArrayToList(new String[]{"Flor", "Elías", "Manuelitas", "Santiago"}, Enteros);
        Nombres.forEach(System.out::println);

        imprimirClientes(Clientes);
        imprimirClientes(ClientelaList);
        imprimirClientes(ClientelaPremiumList);

        System.out.println("\n Máximo de 1, 9 y 4 es: " + Max(1, 4, 9));
        System.out.println("\n Máximo de 3.9, 11.6 y 7.78 es: " + Max(3.9, 11.6, 7.78));
        System.out.println("\n \"Máximo\" de zanahoria, arándanos y manzana es: " + Max("zanahoria", "arándanos", "manzana"));
    }

    public static <T> List<T> fromArrayToList(T[] c){
        return Arrays.asList(c);
    }
    public static <T extends Cliente> List<T> fromArrayToList(T[] x){
        return Arrays.asList(x);
    }
    public static <T extends Number> List<T> fromArrayToList(T[] y){
        return Arrays.asList(y);
    }
    public static <T, G> List<T> fromArrayToList(T[] t, G[] g){
        for(G elemento : g){
            System.out.println(elemento);
        }
        return Arrays.asList(t);
    }
    public static void imprimirClientes(List<? extends Cliente> Clientes){
        Clientes.forEach(System.out::println);
    }
    public static <T extends Comparable<T>> T Max(T a, T b, T c){
        T T_max = a;
        if(b.compareTo(T_max) > 0){
            T_max = b;
        }
        T_max = (c.compareTo(T_max) > 0)? c : T_max;
        return T_max;
    }
}
