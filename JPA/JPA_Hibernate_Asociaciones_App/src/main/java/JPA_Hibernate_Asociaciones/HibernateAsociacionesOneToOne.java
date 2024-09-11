package JPA_Hibernate_Asociaciones;

import JPA_Hibernate_Asociaciones.Entity.Cliente;
import JPA_Hibernate_Asociaciones.Entity.ClienteDetalle;
import JPA_Hibernate_Asociaciones.Util.JPAUtil;
import jakarta.persistence.EntityManager;

public class HibernateAsociacionesOneToOne {
    public static void main(String[] args) {
            //Obtener la conexión
        EntityManager em = JPAUtil.getEntityManager();
            //Jugar con la transaccionalidad
        try{
            em.getTransaction().begin();
                //Crear un Cliente
            Cliente cliente = new Cliente("Condorito", "Andes", "Crédito");
            em.persist(cliente);
                //Asignar un Detalle
            ClienteDetalle detalle = new ClienteDetalle(true, 55L);
                /*detalle.setCliente(cliente);*/
                cliente.setClienteDetalle(detalle);
                em.persist(detalle);
            em.getTransaction().commit();
            System.out.println(cliente);

        } catch(Exception e){
            em.getTransaction().rollback();
            e.printStackTrace();
        } finally {
                //Cerrar la conexión
            em.close();
        }
    }
}
