package ConexiónSingleton.Repositorio;

import java.util.List;

public interface Repositorio <T>{
    //Atributos de ConexiónSingleton.Repositorio
    //Constructores de ConexiónSingleton.Repositorio
    //Asignadores de atributos de ConexiónSingleton.Repositorio (setter)
    //Lectores de atributos de ConexiónSingleton.Repositorio (getter)
        //Métodos de ConexiónSingleton.Repositorio
    List<T> Listar();
    T PorID(Long id);
    void Guardar(T t);
    void Eliminar(Long id);
}
