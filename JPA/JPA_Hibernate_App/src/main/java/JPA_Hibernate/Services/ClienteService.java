package JPA_Hibernate.Services;

import JPA_Hibernate.Entity.Cliente;

import java.util.List;
import java.util.Optional;

public interface ClienteService {
    //Atributos de ClienteService
    //Constructores de ClienteService
    //Asignadores de atributos de ClienteService (setters)
    //Lectores de atributos de ClienteService (getters)
        //Métodos de ClienteService
    List<Cliente> Listar();
    Optional<Cliente> PorID(Long id);   //Para evitar excepciones, cuidadongos
    void Guardar(Cliente cliente);
    void Eliminar(Long id);
}
