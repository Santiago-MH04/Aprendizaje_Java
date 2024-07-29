package Transacciones.Pool.Repositorio;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public interface Repositorio <T>{
    //Atributos de Repositorio
    //Constructores de Repositorio
        //Asignadores de atributos de Repositorio (setter)
    void setConnection(Connection connection);

    //Lectores de atributos de Repositorio (getter)
        //Métodos de Repositorio
    List<T> Listar() throws SQLException;
    T PorID(Long id) throws SQLException;
    T Guardar(T t) throws SQLException;
    void Eliminar(Long id) throws SQLException;
}
