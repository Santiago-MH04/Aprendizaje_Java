package POO_InterfacesRepositorio.Actividad;

import java.util.ArrayList;
import java.util.List;
import java.util.Iterator;


public class BolsaSupermercado <T extends Producto> implements Iterable<T>{
        //Atributos de BolsaSupermercado
    private List<T> Objetos;
    private final int Max_Objetos = 5;

        //Constructores de BolsaSupermercado
    public BolsaSupermercado() {
        this.Objetos = new ArrayList<>();
    }

    //Asignadores de atributos de BolsaSupermercado (setter)
        //Lectores de atributos de BolsaSupermercado (getter)
    public List<T> getObjetos() {
        return this.Objetos;
    }

        //Métodos de BolsaSupermercado
    @Override
    public Iterator<T> iterator() {
        return this.Objetos.iterator();
    }
    public void add(T t){
        if (this.Objetos.size() <= this.Max_Objetos){
            this.Objetos.add(t);
        } else{
            throw new RuntimeException("Se ha sobrepasado la capacidad de la bolsa");
        }
    }

}
