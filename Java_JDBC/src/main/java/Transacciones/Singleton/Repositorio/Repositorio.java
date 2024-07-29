package Transacciones.Singleton.Repositorio;

import java.sql.SQLException;
import java.util.List;

public interface Repositorio <T>{
    //Atributos de ConexiónSingleton.Repositorio
    //Constructores de ConexiónSingleton.Repositorio
    //Asignadores de atributos de ConexiónSingleton.Repositorio (setter)
    //Lectores de atributos de ConexiónSingleton.Repositorio (getter)
        //Métodos de ConexiónSingleton.Repositorio
    List<T> Listar() throws SQLException;
    T PorID(Long id) throws SQLException;
    void Guardar(T t) throws SQLException;
    void Eliminar(Long id) throws SQLException;
}
