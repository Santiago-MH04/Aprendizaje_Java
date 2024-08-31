package JPA_Hibernate.Services;

import JPA_Hibernate.Entity.Cliente;
import JPA_Hibernate.Repositories.CRUDRepository;
import JPA_Hibernate.Repositories.ClienteRepository;
import jakarta.persistence.EntityManager;

import java.util.List;
import java.util.Optional;

public class ClienteServiceImpl implements ClienteService {
        //Atributos de ClienteServiceImpl
    private EntityManager em;
    CRUDRepository<Cliente> ClienteRepo;

        //Constructores de ClienteServiceImpl
    public ClienteServiceImpl(EntityManager entityManager) {
        this.em = entityManager;
        this.ClienteRepo = new ClienteRepository(em);
    }

    //Asignadores de atributos de ClienteServiceImpl (setters)
    //Lectores de atributos de ClienteServiceImpl (getters)
        //Métodos de ClienteServiceImpl
    @Override
    public List<Cliente> Listar() {
        return this.ClienteRepo.Listar();
    }
    @Override
    public Optional<Cliente> PorID(Long id) {
        return Optional.ofNullable(this.ClienteRepo.PorID(id));
    }
    @Override
    public void Guardar(Cliente cliente) {
        try{
                //Comenzar la transacción
            this.em.getTransaction().begin();
                //Operar el método
            this.ClienteRepo.Guardar(cliente);
                //Realizar el commit
            this.em.getTransaction().commit();
        } catch (Exception e){
            this.em.getTransaction().rollback();
        }
    }
    @Override
    public void Eliminar(Long id) {
        try{
                //Comenzar la transacción
            this.em.getTransaction().begin();
                //Operar el método
            this.ClienteRepo.Eliminar(id);
                //Realizar el commit
            this.em.getTransaction().commit();
        } catch (Exception e){
            this.em.getTransaction().rollback();
        }
    }
}
