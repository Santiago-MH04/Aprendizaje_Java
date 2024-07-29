package MockitoApp.Models;

import java.util.ArrayList;
import java.util.List;

public class Examen {
        //Atributos de Examen
    private Long ID;
    private String Nombre;
    private List<String> Preguntas;

        //Constructores de Examen
    public Examen(Long ID, String nombre) {
        this.ID = ID;
        this.Nombre = nombre;
        this.Preguntas = new ArrayList<>();
    }

        //Asignadores de atributos de Examen (setter)
    public void setID(Long ID) {
        this.ID = ID;
    }
        public void setNombre(String nombre) {
            Nombre = nombre;
        }
            public void setPreguntas(List<String> preguntas) {
                Preguntas = preguntas;
            }

        //Lectores de atributos de Examen (getter)
    public Long getID() {
        return ID;
    }
        public String getNombre() {
            return this.Nombre;
        }
            public List<String> getPreguntas() {
                return this.Preguntas;
            }

    //Métodos de Examen
}
