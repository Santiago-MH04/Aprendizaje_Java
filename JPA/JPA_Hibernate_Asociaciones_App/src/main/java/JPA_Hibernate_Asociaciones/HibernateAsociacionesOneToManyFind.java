package JPA_Hibernate_Asociaciones;

import JPA_Hibernate_Asociaciones.Entity.Cliente;
import JPA_Hibernate_Asociaciones.Entity.Direccion;
import JPA_Hibernate_Asociaciones.Util.JPAUtil;
import jakarta.persistence.EntityManager;

public class HibernateAsociacionesOneToManyFind {
    public static void main(String[] args) {
                //Obtener la conexión
        EntityManager em = JPAUtil.getEntityManager();
            //Operar en la base de datos
        try{
                //Aplicar transaccionalidad
            em.getTransaction().begin();
                Cliente cliente = em.find(Cliente.class, 4L);   //Buscando un cliente que no existe
            Direccion dir1 = new Direccion("Grimauld Place", 12);
            Direccion dir2 = new Direccion("Private Drive", 4);
                cliente.getDirecciones().add(dir1);
                cliente.getDirecciones().add(dir2);

            em.merge(cliente);  //Es merge, porque no crea un nuevo registro, sino que actualiza
            em.getTransaction().commit();
            System.out.println(cliente);

                //Remover una dirección, y ver que no se borra de la base de datos, porque no está asociada al contexto de JPA
            em.getTransaction().begin();
                //Obtengamos el cliente de la misma consulta
            dir2 = em.find(Direccion.class, 2); //Si hago la consulta JPQL, ahí sí elimina la dirección de la base de datos
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
