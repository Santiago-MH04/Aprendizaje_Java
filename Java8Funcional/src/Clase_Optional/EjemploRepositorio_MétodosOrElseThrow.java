package Clase_Optional;

import Clase_Optional.Modelo.Ordenador;
import Clase_Optional.Repositorio.*;

import java.util.Optional;

public class EjemploRepositorio_MétodosOrElseThrow {
    public static void main(String[] args) {
            Repositorio<Ordenador> Repositorio = new OrdenadorRepositorio();

            //Haciendo uso de los Optional (ya se ha corregido la clase y el método)
        /*Ordenador PCDefecto = new Ordenador("PC", "Gato");*/
        Ordenador MiOrdenador = Repositorio.Filtrar("HP").orElseThrow(IllegalStateException::new);
        System.out.println(MiOrdenador);

        String Archivo = "documento.pdf";
        String Extensión = Optional.ofNullable(Archivo)     //Un Optional puede tratarse como un Stream, también
                .filter(a -> a.contains("."))
                .map(a -> a.substring(Archivo.lastIndexOf(".") +1 ))
                .orElseThrow();
        System.out.println(Extensión);
    }
}
