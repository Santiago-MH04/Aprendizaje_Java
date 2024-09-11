package JPA_Hibernate_Asociaciones;

import JPA_Hibernate_Asociaciones.Entity.Cliente;
import JPA_Hibernate_Asociaciones.Entity.Direccion;
import JPA_Hibernate_Asociaciones.Util.JPAUtil;
import jakarta.persistence.EntityManager;

public class HibernateAsociacionesOneToMany {
    public static void main(String[] args) {
                //Obtener la conexión
        EntityManager em = JPAUtil.getEntityManager();
            //Operar en la base de datos
        try{
                //Aplicar transaccionalidad
            em.getTransaction().begin();
                Cliente cliente = new Cliente("Aladdín", "Abdullah", "Oro");
            Direccion dir1 = new Direccion("Alameda central", 1);
            Direccion dir2 = new Direccion("QuesoColo", 240);
                cliente.getDirecciones().add(dir1);
                cliente.getDirecciones().add(dir2);

            em.persist(cliente);
            em.getTransaction().commit();
            System.out.println(cliente);

                //Eliminar alguna de las direcciones, para ver cómo funciona
            em.getTransaction().begin();
                //Obtengamos el cliente de la misma consulta
            cliente = em.find(Cliente.class, cliente.getId());
                cliente.getDirecciones().remove(dir2);
                //Efectuar los cambios
            em.getTransaction().commit();
            System.out.println(cliente);
        } catch (Exception e){
            e.printStackTrace();
            em.getTransaction().rollback();
        } finally {
                //Desconectarse de la base de datos
            em.close();
        }
    }
}
