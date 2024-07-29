package POO_InterfacesRepositorio.Lecciones.Interfaces.Repositorio;

import POO_InterfacesRepositorio.Lecciones.Interfaces.Repositorio.Excepciones.AccesoDatoException;

import java.util.List;

public interface CrudRepositorio<T> {
    //Atributos de CrudRepositorio
    //Constructores de CrudRepositorio

        //Métodos de CrudRepositorio
    List<T> Listar();
    T porID(Integer id) throws AccesoDatoException;
    void Crear(T elemento) throws AccesoDatoException;;
    void Editar(T elemento) throws AccesoDatoException;
    void Eliminar(Integer id) throws AccesoDatoException;
}
