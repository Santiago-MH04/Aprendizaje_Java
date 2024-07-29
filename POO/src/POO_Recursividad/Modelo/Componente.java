package POO_Recursividad.Modelo;

import java.util.ArrayList;
import java.util.List;

public class Componente {
        //Atributos de Componente
    private String Nombre;
    private List<Componente> Hijos;
    private int Nivel;

        //Constructores de Componente
    public Componente(String nombre) {
        this.Nombre = nombre;
        this.Hijos = new ArrayList<>();
    }

        //Asignadores de atributos de Componente (setter)
    public void setNombre(String nombre) {
        this.Nombre = nombre;
    }
        public void setHijos(List<Componente> hijos) {
            this.Hijos = hijos;
        }
            public void setNivel(int nivel) {
                this.Nivel = nivel;
            }

        //Lectores de atributos de Componente (getter)
    public String getNombre() {
        return this.Nombre;
    }
        public List<Componente> getHijos() {
            return this.Hijos;
        }
            public int getNivel() {
                return this.Nivel;
            }

        //Métodos de Componente
    public Componente addComponente (Componente C){
        this.Hijos.add(C);                          //Para que se pueda encadenar
        return this;
    }
    public boolean TieneHijos(){
        return !(this.Hijos.isEmpty());
    }
}
