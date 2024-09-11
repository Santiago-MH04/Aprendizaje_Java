package JPA_Hibernate_Asociaciones;

import JPA_Hibernate_Asociaciones.Entity.Cliente;
import JPA_Hibernate_Asociaciones.Entity.Factura;
import JPA_Hibernate_Asociaciones.Util.JPAUtil;
import jakarta.persistence.EntityManager;

public class HibernateAsociacionesOneToManyFindBidireccional {
    public static void main(String[] args) {
            //Obtener la conexión
        EntityManager em = JPAUtil.getEntityManager();
            //Aplicar transaccionalidad -- Hay que agregar en ambos sentidos
        try{
            em.getTransaction().begin();
                //Crear las facturas
            Factura factura1 = new Factura("Compras del D1", 150000L);
            Factura factura2 = new Factura("Maricaditas varias", 58000L);
                //Buscar al cliente
            Cliente cliente = em.find(Cliente.class, 3L);
                cliente.addFactura(factura1)
                       .addFactura(factura2);

                //Actualizar al Cliente
            em.merge(cliente);  //Aunque es opcional. El mero commit() actualiza solito
            em.getTransaction().commit();
            System.out.println(cliente);

                //Eliminar una factura
            em.getTransaction().begin();
                //Obtener una Factura
            Factura factura3 = em.find(Factura.class, 1L);
            /*Factura factura3 = new Factura("Compras del D1", 150000L);    //Esta manera implica la implementación del método equals() para borrar la factura del cliente
                factura3.setId(1L);*/
                //Reobtener al mismo cliente
            cliente = em.find(Cliente.class, cliente.getId());
                    //Eliminar la factura por ambos lados de la relación (con optimización de método)
                cliente.removeFactura(factura3);
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
