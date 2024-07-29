package POO_Interfaces.Imprenta.Modelo;

import java.util.ArrayList;
import java.util.List;

public class Libro implements Imprimible{
        //Atributos de Libro
    private List<Imprimible> Páginas;
    private Persona Autor;
    private String Título;
    private Género ElGénero;

        //Constructores de Libro
    public Libro(Persona autor, String título, Género elGénero) {
        this.Autor = autor;
        this.Título = título;
        this.ElGénero = elGénero;
        this.Páginas = new ArrayList<>();
    }

    //Asignadores de atributos de Libro (setter)
    //Lectores de atributos de Libro (getter)
        //Métodos de Libro
    public Libro addPágina(Imprimible página){
        this.Páginas.add(página);
        return this;
    }
    @Override
    public String Imprimir(){
        StringBuilder sb = new StringBuilder("Título: ").append(this.Título)
                .append("\nAutor: ").append(this.Autor)
                .append("\nGénero: "). append(this.ElGénero.getNomGénero()).append("\n");
        for (Imprimible página : this.Páginas){
            sb.append(página.Imprimir()).append("\n");
        }
        return sb.toString();
    }
}
