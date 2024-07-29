package APIServlet.Session.Actividades.Actividad7_Cursos.ModelosActividad;

import APIServlet.Session.Actividades.Actividad7_Cursos.Configs.Calificadores.LogsAct;
import APIServlet.Session.Actividades.Actividad7_Cursos.Interceptores.LoggingAct;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.enterprise.context.SessionScoped;
import jakarta.inject.Inject;

import java.io.Serializable;
import java.util.logging.Logger;

@ApplicationScoped
public class Curso {
        //Atributos de Curso.
    private Long ID;
    private String Nombre;
    private String Descripción;
    private String Instructor;
    private Double Longevidad;
    @Inject
    @LogsAct
    private Logger LogAct;

        //Constructores de Curso
    public Curso() {
    }

        //Asignadores de atributos de Curso (setter)
    public void setID(Long ID) {
        this.ID = ID;
    }
        public void setNombre(String nombre) {
            this.Nombre = nombre;
        }
            public void setDescripción(String descripción) {
                this.Descripción = descripción;
            }
                public void setInstructor(String instructor) {
                    this.Instructor = instructor;
                }
                    public void setLongevidad(Double Longevidad) {
                        this.Longevidad = Longevidad;
                    }

        //Lectores de atributos de Curso (getter)
    public Long getID() {
        return this.ID;
    }
        public String getNombre() {
            return this.Nombre;
        }
            public String getDescripción() {
                return this.Descripción;
            }
                public String getInstructor() {
                    return this.Instructor;
                }
                    public Double getLongevidad() {
                        return this.Longevidad;
                    }

    //Métodos de Curso
}
