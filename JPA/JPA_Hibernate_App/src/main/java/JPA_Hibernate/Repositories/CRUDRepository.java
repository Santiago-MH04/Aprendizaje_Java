package JPA_Hibernate.Repositories;

import java.util.List;

public interface CRUDRepository<T> {
    //Atributos de CRUDRepository
    //Constructores de CRUDRepository
    //Asignadores de atributos de CRUDRepository (setters)
    //Lectores de atributos de CRUDRepository (getters)
        //Métodos de CRUDRepository
    List<T> Listar();
    T PorID(Long id);
    void Guardar(T t);
    void Eliminar(Long id);
}
