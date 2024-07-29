package Clase_Optional.Modelo;

import java.util.Optional;

public class Ordenador {
        //Atributos de Ordenador
    private String Nombre;
    private String Modelo;
    private Procesador ElProcesador;

        //Constructores de Ordenador
    public Ordenador() {
    }
    public Ordenador(String nombre, String modelo) {
        this.Nombre = nombre;
        this.Modelo = modelo;
    }

        //Asignadores de atributos de Ordenador (setter)
    public void setNombre(String nombre) {
        this.Nombre = nombre;
    }
        public void setModelo(String modelo) {
            this.Modelo = modelo;
        }
            public void setProcesador(Procesador procesador) {
                this.ElProcesador = procesador;
            }

        //Lectores de atributos de Ordenador (getter)
    public String getNombre() {
        return this.Nombre;
    }
        public String getModelo() {
            return this.Modelo;
        }
            public Optional<Procesador> getProcesador() {
                return Optional.ofNullable(this.ElProcesador);
            }

        //Métodos de Ordenador
    @Override
    public String toString() {
        return "Ordenador: " + Nombre + " " + Modelo;
    }
}
