package Clase_Optional.Modelo;

import java.util.Optional;

public class Procesador {
        //Atributos de Procesador
    private String Nombre;
    private Fabricante fabricante;

        //Constructores de Procesador
    public Procesador(String nombre, Fabricante fabricante) {
        this.Nombre = nombre;
        this.fabricante = fabricante;
    }

        //Asignadores de atributos de Procesador (setter)
    public void setNombre(String nombre) {
        this.Nombre = nombre;
    }

        //Lectores de atributos de Procesador (getter)
    public String getNombre() {
        return this.Nombre;
    }
    public Optional<Fabricante> getFabricante() {
        return Optional.ofNullable(this.fabricante);
    }

    //Métodos de Procesador
}
