package Clase_Optional;

import Clase_Optional.Modelo.Ordenador;
import Clase_Optional.Repositorio.*;

import java.util.Optional;

public class EjemploRepositorio {
    public static void main(String[] args) {
        Repositorio<Ordenador> Repositorio = new OrdenadorRepositorio();

        Optional<Ordenador> PC = Repositorio.Filtrar("Dell Inspiron");           // "HP Envy" (existe) "Dell Inspiron" (no existe)
        System.out.println(PC.isPresent()? PC.get().toString() : "No se ha encontrado");

            //Sin hacer uso de los Optional
        /*if(PC != null){
            System.out.println(PC.toString());                          // Aunque el .toString() es redundante, se deja
        } else{
            System.out.println("No se ha encontrado un ordenador " + PC + " en el repositorio");
        }*/

            //Haciendo uso de los Optional (ya se ha corregido la clase y el método)
        Repositorio.Filtrar("HP").ifPresentOrElse(System.out::println,
                () -> System.out.println("No se ha encontrado"));
    }
}
