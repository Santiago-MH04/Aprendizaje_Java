package APIServlet.Session.Actividades.Actividad7_Cursos.RepositorioActividad;

import java.sql.SQLException;
import java.util.List;

public interface RepositorioActividad<T> {
    //Atributos de RepositorioActividad
    //Constructores de RepositorioActividad
    //Asignadores de atributos de RepositorioActividad (setter)
    //Lectores de atributos de RepositorioActividad (getter)

        //Métodos de RepositorioActividad
    List<T> Listar() throws SQLException;
    List<T> PorNombre(String Nombre) throws SQLException;
    T PorID(Long id) throws SQLException;
    void Guardar(T t) throws SQLException;
    void Eliminar(Long id) throws SQLException;
}
