package JPA_Hibernate;

import JPA_Hibernate.Entity.Cliente;
import JPA_Hibernate.Util.JPAUtil;
import jakarta.persistence.EntityManager;

import java.util.List;

public class HibernateListar {
    public static void main(String[] args) {
            //Obtener el EntityManager
        EntityManager em = JPAUtil.getEntityManager();
            //Hacer la operación SQL
        List<Cliente> Clientes = em.createQuery("select c from Cliente c", Cliente.class).getResultList();
        Clientes.forEach(System.out::println);
            //Cerrar la conexión
        em.close(); //Un EntityManager no puede autocerrarse con un try con recursos
    }
}
