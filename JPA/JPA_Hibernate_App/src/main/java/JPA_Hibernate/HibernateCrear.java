package JPA_Hibernate;

import JPA_Hibernate.Entity.Cliente;
import JPA_Hibernate.Util.JPAUtil;
import jakarta.persistence.EntityManager;

import javax.swing.*;

public class HibernateCrear {
    public static void main(String[] args) {
            //Estamos modificando la base de datos, usemos transacciones, ¿te parece?
                //Obtener la conexión
        EntityManager em = JPAUtil.getEntityManager();  //Al parecer, el autocommit se desactiva automáticamente, porque hasta en los logs aparece desactivado
        try{
            String Nombre = JOptionPane.showInputDialog("Ingrese el nombre del cliente a registrar: ");
            String Apellido = JOptionPane.showInputDialog("Ahora, ingrese el apellido: ");
            String FormaPago = JOptionPane.showInputDialog("Esta vez, el método de pago: ");

            em.getTransaction().begin();    //Este comienza la transacción

            Cliente c = new Cliente(Nombre, Apellido, FormaPago);
                /*c.setNombre(Nombre);
                c.setApellido(Apellido);    //Recuerda que creates un constructor con parámetros
                c.setFormaPago(FormaPago);*/

                //Guardar el objeto en la base de datos
            em.persist(c);
            em.getTransaction().commit();    //Este es el commit
            System.out.println("El cliente " + c.getNombre() + " " + c.getApellido() + " ha sido registrado con id " + c.getId());

                //Devolver el cliente sin repetir la consulta
            c = em.find(Cliente.class, c.getId());
            System.out.println(c);
        } catch (Exception e){
            em.getTransaction().rollback(); //Este es el rollback
            e.printStackTrace();
        } finally {
                //Cerramos la conexión
            em.close();
        }
    }
}
