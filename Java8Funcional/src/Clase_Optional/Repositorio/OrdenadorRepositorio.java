package Clase_Optional.Repositorio;

import Clase_Optional.Modelo.Fabricante;
import Clase_Optional.Modelo.Ordenador;
import Clase_Optional.Modelo.Procesador;

import java.util.List;
import java.util.ArrayList;
import java.util.Optional;

public class OrdenadorRepositorio implements Repositorio<Ordenador>{
        //Atributos de OrdenadorRepositorio
    private List<Ordenador> DataSource;

        //Constructores de OrdenadorRepositorio
    public OrdenadorRepositorio() {
        this.DataSource = new ArrayList<>();
        Procesador ProPC = new Procesador("Core i9880H", new Fabricante("Intel"));
        Procesador ProcPC = new Procesador("Ryzen 9", new Fabricante("AMD"));


        Ordenador HP = new Ordenador("HP Envy", "15-dr1xxx");
            HP.setProcesador(ProPC);
        Ordenador Asus = new Ordenador("ASUS ROG", "Strix G512");
            Asus.setProcesador(ProcPC);

            DataSource.add(HP);
            DataSource.add(Asus);
            DataSource.add(new Ordenador("MacBook Pro", "MVV k2-CI"));
    }

    //Asignadores de atributos de OrdenadorRepositorio (setter)
    //Lectores de atributos de OrdenadorRepositorio (getter)
        //Métodos de OrdenadorRepositorio
    @Override
    public Optional<Ordenador> Filtrar(String nombre) {
        return DataSource.stream()
                .filter(O -> O.getNombre().toLowerCase().contains(nombre.toLowerCase()))
                .findFirst();   //.findAny() también sirve

        /*for (Ordenador O : DataSource){
            if(O.getNombre().equalsIgnoreCase(nombre)){
                return Optional.of(O);
            }
        }
        return Optional.empty();
            //return Optional.of(new Ordenador(nombre,null));   // Esta idea no funciona*/
    }
}
