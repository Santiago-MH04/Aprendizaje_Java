package JPA_Hibernate.Repositories;

import JPA_Hibernate.Entity.Cliente;
import jakarta.persistence.EntityManager;

import java.util.List;

public class ClienteRepository implements CRUDRepository<Cliente> {
        //Atributos de ClienteRepository
    private EntityManager em;

        //Constructores de ClienteRepository
    public ClienteRepository() {}
    public ClienteRepository(EntityManager entityManager) {
        this.em = entityManager;
    }

    //Asignadores de atributos de ClienteRepository (setters)
    //Lectores de atributos de ClienteRepository (getters)
        //Métodos de ClienteRepository
    @Override
    public List<Cliente> Listar() {
        return this.em.createQuery("select c from Cliente  c", Cliente.class).getResultList();
    }
    @Override
    public Cliente PorID(Long id) {
        return this.em.find(Cliente.class, id);
    }
    @Override
    public void Guardar(Cliente cliente) {
        if(cliente.getId() != null && cliente.getId() > 0){
            this.em.merge(cliente);
        } else {
            this.em.persist(cliente);
        }
    }
    @Override
    public void Eliminar(Long id) {
        Cliente cliente = this.PorID(id);
        this.em.remove(cliente);
    }
}
