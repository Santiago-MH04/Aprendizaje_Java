package Anotaciones.Modelo;

import Anotaciones.Init;
import Anotaciones.JSON_Atributo;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.stream.Collectors;

public class Producto {
        //Atributos de Producto (señalar los atributos susceptibles de ser exportados)
    @JSON_Atributo/*(Nombre = "Descripción", Capitalizar = true)*/
    private String Nombre;
    @JSON_Atributo(Nombre = "Costo")
    private Long Precio;
    private LocalDate Fecha;

    //Constructores de Producto
        //Asignadores de atributos de Producto (setter)
    public void setNombre(String nombre) {
        this.Nombre = nombre;
    }
        public void setPrecio(Long precio) {
            this.Precio = precio;
        }
            public void setFecha(LocalDate fecha) {
                this.Fecha = fecha;
            }

        //Lectores de atributos de Producto (getter)
    public String getNombre() {
        return this.Nombre;
    }
        public Long getPrecio() {
            return this.Precio;
        }
            public LocalDate getFecha() {
                return this.Fecha;
            }

        //Métodos de Producto
    @Init       //Para decorar capitalizaciones, pero sobre un método
    private void Init(){
        this.Nombre = Arrays.stream(this.Nombre.split(" "))
                .map(palabra -> palabra.substring(0,1).toUpperCase() + //Otra forma sería String.valueOf(palabra.charAt(0)).toUpperCase()
                        palabra.substring(1).toLowerCase())
                .collect(Collectors.joining(" "));
    }
}
