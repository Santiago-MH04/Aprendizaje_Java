package Anotaciones;

import Anotaciones.Modelo.Producto;
import Anotaciones.Procesador.JSON_Serializador;

import java.time.LocalDate;
public class EjemploAnotación {
    public static void main(String[] args) {

            //Crear el producto, susceptible de ser decorado
        Producto P = new Producto();
            P.setFecha(LocalDate.now());
            P.setNombre("mesita de centro");
            P.setPrecio(1500L);

        System.out.println("JSON: " + JSON_Serializador.ConvertirJSON(P));
    }
}
