package POO_PatronesDiseño.Lecciones.Composite;

import java.util.ArrayList;
import java.util.List;

public class Directorio extends Componente{
        //Atributos de Directorio
    private List<Componente> Hijos;

        //Constructores de Directorio
    public Directorio(String nombre) {
        super(nombre);
        this.Hijos = new ArrayList<>();
    }

    //Asignadores de atributos de Directorio (setter)
    //Lectores de atributos de Directorio (getter)
        //Métodos de Directorio
    public Directorio addComponente(Componente C){     //Para agregar componentes al directorio de forma encadenada
        this.Hijos.add(C);
        return this;
    }
    private void removeComponente(Componente C){    //Para eliminar componentes, no es necesario encadenar, pero sí comparar
        // elementos, por lo que se hace necesario implementar el método equals en la
        // clase padre
        this.Hijos.remove(C);
    }

    @Override
    public String Mostrar(int Nivel) {
        StringBuilder sb = new StringBuilder("\t".repeat(Nivel));
        sb.append(Nombre).append("/")
                .append("\n");
        for (Componente Hijo : this.Hijos){
            sb.append(Hijo.Mostrar((Nivel + 1)));
            if(Hijo instanceof Archivo) {
                sb.append("\n");
            }
        }
        return sb.toString();
    }
    @Override
    public boolean Buscar(String Nombre) {
            //Por si lo encuentra de una
        if(this.Nombre.equalsIgnoreCase(Nombre)){
            return true;
        }
            //De manera recursiva para buscar uno por uno (se puede con un for each o un Stream)
                //Con el for each
        /*for(Componente Hijo : this.Hijos){
            if(Hijo.Buscar(Nombre)){
                return true;
            }
        }
        return false;*/
                //Con el Stream (más potente, más bonito)
        return Hijos.stream().anyMatch(H -> H.Buscar(Nombre));
    }
}
