package APIServlet.Session.Lecciones.Repositorios;

import java.sql.SQLException;
import java.util.List;

public interface Repositorio<T> {
    //Atributos de Repositorio
    //Constructores de Repositorio
    //Asignadores de atributos de Repositorio (setter)
    //Lectores de atributos de Repositorio (getter)
        //Métodos de Repositorio
    List<T> Listar() throws SQLException;
    T PorID(Long ID) throws SQLException;
    void Guardar(T t) throws SQLException;
    void Eliminar(Long ID) throws SQLException;
}
