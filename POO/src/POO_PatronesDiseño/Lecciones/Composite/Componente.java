package POO_PatronesDiseño.Lecciones.Composite;

import java.util.Objects;

public abstract class Componente {
        //Atributos de Componente
    protected String Nombre;

        //Constructores de Componente
    public Componente(String nombre) {
        this.Nombre = nombre;
    }

    //Asignadores de atributos de Componente (setter)
        //Lectores de atributos de Componente (getter)
    public String getNombre() {
        return this.Nombre;
    }

        //Métodos de Componente
    @Override                           //Para poder recorrer los valores de manera recursiva
    public boolean equals(Object o) {
        if (this == o) {return true;}
        if (o == null || getClass() != o.getClass()) {return false;}
        Componente that = (Componente) o;
        return Objects.equals(Nombre, that.getNombre());
    }
    @Override
    public int hashCode() {
        return Objects.hash(Nombre);
    }
    public abstract String Mostrar(int Nivel);
    public abstract boolean Buscar(String Nombre);
}
