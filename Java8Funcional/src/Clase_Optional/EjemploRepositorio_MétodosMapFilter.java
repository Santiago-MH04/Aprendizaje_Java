package Clase_Optional;

import Clase_Optional.Modelo.*;
import Clase_Optional.Repositorio.*;

import java.util.Optional;

public class EjemploRepositorio_MétodosMapFilter {
    public static void main(String[] args) {
        Repositorio<Ordenador> Repositorio = new OrdenadorRepositorio();

        String Constructor_PC = Repositorio.Filtrar("Asus")     // Sólo se le asignó su procesador al HP
                .flatMap(Ordenador::getProcesador)              //Si el método en cuestión retorna un opcional en lugar de una instancia fija,
                                                                // Flatmap es la mejor opción
                .flatMap(Procesador::getFabricante)
                .filter(fab -> fab.getNombre().equalsIgnoreCase("intel"))
                .map(Fabricante::getNombre)
                .orElse("Fabricante desconocido");

        System.out.println(Constructor_PC);
    }
}
