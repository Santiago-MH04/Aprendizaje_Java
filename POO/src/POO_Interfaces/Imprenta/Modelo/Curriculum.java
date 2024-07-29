package POO_Interfaces.Imprenta.Modelo;

import java.util.ArrayList;
import java.util.List;

public class Curriculum extends Hoja{
        //Atributos de Curriculum
    private Persona Persona;
    private String Carrera;
    private List<String> Experiencias;

        //Constructores de Curriculum
    public Curriculum(Persona persona, String carrera, String contenido) {
        super(contenido);
        this.Persona = persona;
        this.Carrera = carrera;
        this.Experiencias = new ArrayList<>();
    }

    //Asignadores de atributos de Curriculum (setter)
    //Lectores de atributos de Curriculum (getter)
        //Métodos de Curriculum
    public Curriculum addExperiencia(String experiencia){
        this.Experiencias.add(experiencia);
        return this;
    }
    @Override
    public String Imprimir() {
        StringBuilder sb = new StringBuilder("Nombre: ").append(this.Persona)
                .append("\nResumen: ").append(this.Contenido)
                .append("\nProfesión: ").append(this.Carrera)
                .append("\nExperiencias:\n");
        for(String experiencia : this.Experiencias){
            sb.append("- ").append(experiencia).append("\n");
        }
        return sb.toString();
    }
}
