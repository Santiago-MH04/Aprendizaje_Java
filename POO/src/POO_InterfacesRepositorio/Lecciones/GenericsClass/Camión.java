package POO_InterfacesRepositorio.Lecciones.GenericsClass;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Camión<T> implements Iterable<T>{
        //Atributos de Camión
    private List<T> Objetos;
    private int Max_objetos;

        //Constructores de Camión
    public Camión(int max_objetos) {
        this.Max_objetos = max_objetos;
        this.Objetos = new ArrayList<>();
    }

    //Asignadores de atributos de Camión (setter)
    //Lectores de atributos de Camión (getter)
        //Métodos de Camión
    public void add(T objeto){
        if(this.Objetos.size() <= Max_objetos) {
            this.Objetos.add(objeto);
        } else {
            throw new RuntimeException("Ya no queda más espacio en el camión");
        }
    }

    @Override
    public Iterator<T> iterator() {
        return this.Objetos.iterator();
    }
}
