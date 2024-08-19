package APIServlet.Session.Lecciones.Repositorios;

import java.sql.SQLException;
import java.util.List;

public interface Repositorio<T> {
    //Atributos de Repositorio
    //Constructores de Repositorio
    //Asignadores de atributos de Repositorio (setters)
    //Lectores de atributos de Repositorio (getters)
        //Métodos de Repositorio
    List<T> Listar() throws SQLException;
    T PorID(Long id) throws SQLException;
    void Guardar(T t) throws SQLException;
    void Eliminar(Long id) throws SQLException;
}
