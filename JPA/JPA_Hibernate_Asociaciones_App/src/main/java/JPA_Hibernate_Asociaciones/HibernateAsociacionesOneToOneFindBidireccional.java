package JPA_Hibernate_Asociaciones;

import JPA_Hibernate_Asociaciones.Entity.Cliente;
import JPA_Hibernate_Asociaciones.Entity.ClienteDetalle;
import JPA_Hibernate_Asociaciones.Util.JPAUtil;
import jakarta.persistence.EntityManager;

public class HibernateAsociacionesOneToOneFindBidireccional {
    public static void main(String[] args) {
            //Obtener la conexión
        EntityManager em = JPAUtil.getEntityManager();
            //Jugar con la transaccionalidad
        try{
            em.getTransaction().begin();
                //Buscar un cliente
            Cliente cliente = em.find(Cliente.class, 7L);
                //Crear un detalle
            ClienteDetalle detalle = new ClienteDetalle(true, 2550L);
                cliente.addClienteDetalle(detalle);
            em.merge(cliente);  //Aunque, por tratarse de clases Entity del contexto de una misma búsqueda, no es necesario, el commit() basta
            em.getTransaction().commit();
            System.out.println(cliente);

        } catch (Exception e){
            em.getTransaction().rollback();
            e.printStackTrace();
        } finally {
                //Cerrrar la conexión
            em.close();
        }
    }
}
