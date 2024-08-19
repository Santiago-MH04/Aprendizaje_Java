package APIServlet.Session.Actividades.Actividad7_Cursos.ServiceActividad;

import APIServlet.Session.Actividades.Actividad7_Cursos.Configs.Estereotipos.Serviciou;
import APIServlet.Session.Actividades.Actividad7_Cursos.ModelosActividad.Curso;
import APIServlet.Session.Actividades.Actividad7_Cursos.RepositorioActividad.RepoActividadCursoJDBCImpl;
import APIServlet.Session.Actividades.Actividad7_Cursos.RepositorioActividad.RepositorioActividad;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

/*@ApplicationScoped*/
@Serviciou
public class CursoServiceActividadImpl implements CursoServiceActividad{
        //Atributos de CursoServiceActividadImpl
    @Inject
    private RepositorioActividad<Curso> RepoCurso;

        //Constructores de CursoServiceActividadImpl

    /*public CursoServiceActividadImpl(Connection conexión) {
        this.RepoCurso = new RepoActividadCursoJDBCImpl(conexión);
    }*/

    //Asignadores de atributos de CursoServiceActividadImpl (setter)
    //Lectores de atributos de CursoServiceActividadImpl (getter)

        //Métodos de CursoServiceActividadImpl
    @Override
    public List<Curso> Listar() {
        try {
            return this.RepoCurso.Listar();
        } catch (SQLException e) {
            throw new ServiceJDBCActividadException(e.getMessage(), e.getCause());
        }
    }

    @Override
    public List<Curso> PorNombre(String Nombre) {
        try {
            return this.RepoCurso.PorNombre(Nombre);
        } catch (SQLException e){
            throw new ServiceJDBCActividadException(e.getMessage(), e.getCause());
        }
    }

    @Override
    public Optional<Curso> PorID(Long id) {
        try {
            return Optional.ofNullable(this.RepoCurso.PorID(id));
        } catch (SQLException e) {
            throw new ServiceJDBCActividadException(e.getMessage(), e.getCause());
        }
    }

    @Override
    public void Guardar(Curso curso) {
        try {
            this.RepoCurso.Guardar(curso);
        } catch (SQLException e) {
            throw new ServiceJDBCActividadException(e.getMessage(), e.getCause());
        }
    }

    @Override
    public void Eliminar(Long id) {
        try {
            this.RepoCurso.Eliminar(id);
        } catch (SQLException e) {
            throw new ServiceJDBCActividadException(e.getMessage(), e.getCause());
        }
    }
}
