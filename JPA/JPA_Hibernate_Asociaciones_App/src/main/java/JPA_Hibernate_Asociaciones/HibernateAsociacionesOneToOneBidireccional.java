package JPA_Hibernate_Asociaciones;

import JPA_Hibernate_Asociaciones.Entity.Cliente;
import JPA_Hibernate_Asociaciones.Entity.ClienteDetalle;
import JPA_Hibernate_Asociaciones.Util.JPAUtil;
import jakarta.persistence.EntityManager;

public class HibernateAsociacionesOneToOneBidireccional {
    public static void main(String[] args) {
            //Obtener la conexión
        EntityManager em = JPAUtil.getEntityManager();
            //Jugar con la transaccionalidad
        try{
            em.getTransaction().begin();
                //Crear un cliente
            Cliente cliente = new Cliente("Juan Carlos", "Bodoque", "Cheques falsos");
                //Crear un detalle
            ClienteDetalle detalle = new ClienteDetalle(true, 150L);
                /*cliente.setClienteDetalle(detalle);
                detalle.setCliente(cliente);*/
                cliente.addClienteDetalle(detalle);
            em.persist(cliente);
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
