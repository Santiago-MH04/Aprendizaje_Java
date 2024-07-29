package Clase_Optional;

import Clase_Optional.Modelo.Ordenador;
import Clase_Optional.Repositorio.*;

import java.util.Optional;

public class EjemploRepositorio_MétodosOrElse {
    public static void main(String[] args) {
        Repositorio<Ordenador> Repositorio = new OrdenadorRepositorio();

        Optional<Ordenador> PC = Repositorio.Filtrar("Dell Inspiron");      // "HP Envy" (existe) "Dell Inspiron" (no existe)
            //Sin hacer uso de los Optional
        System.out.println("Sin uso de los Optional:");
        System.out.println(PC.isPresent()? PC.get().toString() : "No se ha encontrado");

            //Haciendo uso de los Optional (ya se ha corregido la clase y el método)
        /*Ordenador PCDefecto = new Ordenador("PC", "Gato");*/
        Ordenador MiOrdenador = Repositorio.Filtrar("HP").orElse(ValorDefecto());   //Otra manera de escribir el método get().
                                                                                    // Si no se crea la instancia in situ, consume recursos
                                                                                    // del valor por defecto definido
        System.out.println("Con uso de los Optional:");
        System.out.println("\tCon el método orElse() (menos eficiente) -> " + MiOrdenador);
        Ordenador MiEquipo = Repositorio.Filtrar("Macbook pro2").orElseGet(EjemploRepositorio_MétodosOrElse::ValorDefecto); //Otra manera de escribir el método get().
                                                                                                                            // Si no se crea la instancia in situ, no consume recursos
                                                                                                                            // del valor por defecto definido
        //Ordenador MiEquipo = Repositorio.Filtrar("Macbook pro2").orElseGet( () -> new Ordenador("PC", "Gato"));
        System.out.println("\tCon el método orElseGet() (más eficiente) -> " + MiEquipo);
    }

    public static Ordenador ValorDefecto(){
        System.out.println("Obteniendo el valor por defecto");
        return new Ordenador("PC", "Gato");
    }
}
