package Clase_Optional.Repositorio;

import Clase_Optional.Modelo.Ordenador;

import java.util.Optional;

public interface Repositorio<T> {
    Optional<Ordenador> Filtrar(String nombre);
}
