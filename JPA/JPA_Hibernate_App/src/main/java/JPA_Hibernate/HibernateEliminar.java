package JPA_Hibernate;

import JPA_Hibernate.Entity.Cliente;
import JPA_Hibernate.Util.JPAUtil;
import jakarta.persistence.EntityManager;

import javax.swing.*;
import java.util.Scanner;

public class HibernateEliminar {
    public static void main(String[] args) {
            //Estamos modificando la base de datos, usemos transacciones, ¿te parece?
                //Obtener la conexión
        EntityManager em = JPAUtil.getEntityManager();  //Al parecer, el autocommit se desactiva automáticamente, porque hasta en los logs aparece desactivado
        try{
                //Pedir información al cliente, para modificar el registro
            Scanner sc = new Scanner(System.in);
            System.out.println("Ingrese el ID del cliente a eliminar: ");
            Long id = sc.nextLong();
            Cliente c = em.find(Cliente.class, id);

            em.getTransaction().begin();    //Este comienza la transacción
                //Eliminar el objeto de la base de datos
            em.remove(c);
            em.getTransaction().commit();    //Este es el commit -> Sí actualiza la base de datos

        } catch (Exception e){
            em.getTransaction().rollback(); //Este es el rollback
            e.printStackTrace();
        } finally {
                //Cerramos la conexión
            em.close();
        }
    }
}
