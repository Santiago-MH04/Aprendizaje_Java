package Clase_Optional.Modelo;

public class Fabricante {
        //Atributos de Fabricante
    private String Nombre;

        //Constructores de Fabricante
    public Fabricante(String nombre) {
        this.Nombre = nombre;
    }

        //Asignadores de atributos de Fabricante (setter)
    public void setNombre(String nombre) {
        this.Nombre = nombre;
    }
        //Lectores de atributos de Fabricante (getter)
    public String getNombre() {
        return this.Nombre;
    }

    //Métodos de Fabricante
}
