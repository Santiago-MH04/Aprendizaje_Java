package APIServlet.Session.Actividades.Actividad7_Cursos.ServiceActividad;

import APIServlet.Session.Actividades.Actividad7_Cursos.ModelosActividad.Curso;

import java.util.List;
import java.util.Optional;

public interface CursoServiceActividad {
    //Atributos de CursoServiceActividad
    //Constructores de CursoServiceActividad
    //Asignadores de atributos de CursoServiceActividad (setter)
    //Lectores de atributos de CursoServiceActividad (getter)

        //Métodos de CursoServiceActividad
    List<Curso> Listar();
    List<Curso> PorNombre(String Nombre);
    Optional<Curso> PorID(Long id);
    void Guardar(Curso curso);
    void Eliminar(Long id);
}
