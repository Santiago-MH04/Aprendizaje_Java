package JPA_Hibernate_Asociaciones;

import JPA_Hibernate_Asociaciones.Entity.Cliente;
import JPA_Hibernate_Asociaciones.Entity.Factura;
import JPA_Hibernate_Asociaciones.Util.JPAUtil;
import jakarta.persistence.EntityManager;

public class HibernateAsociacionesManyToOneFind {
    public static void main(String[] args) {
            //Obtener la conexión
        EntityManager em = JPAUtil.getEntityManager();

            //Operar en la base de datos con transaccionalidad
        try{
            em.getTransaction().begin();
                //Buscando ando un cliente
            Cliente cliente = em.find(Cliente.class, 9L);
                //Crear ahora una factura
            Factura factura = new Factura("Cocorolló", 85500L);
                factura.setCliente(cliente);    //Para persistir la factura, el Cliente debe existir ya en la base de datos
                em.persist(factura);
            System.out.println(factura);

            em.getTransaction().commit();
        } catch (Exception e){
            em.getTransaction().rollback();
            e.printStackTrace();
        } finally {
                //Cerrar la conexión
            em.close();
        }

    }
}
