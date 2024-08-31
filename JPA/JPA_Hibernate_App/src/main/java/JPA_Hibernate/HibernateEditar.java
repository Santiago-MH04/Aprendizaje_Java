package JPA_Hibernate;

import JPA_Hibernate.Entity.Cliente;
import JPA_Hibernate.Util.JPAUtil;
import jakarta.persistence.EntityManager;

import javax.swing.*;

public class HibernateEditar {
    public static void main(String[] args) {
            //Estamos modificando la base de datos, usemos transacciones, ¿te parece?
                //Obtener la conexión
        EntityManager em = JPAUtil.getEntityManager();  //Al parecer, el autocommit se desactiva automáticamente, porque hasta en los logs aparece desactivado
        try{
            Long id = Long.valueOf(JOptionPane.showInputDialog("Ingrese el ID del cliente a modificar: "));
            Cliente c = em.find(Cliente.class, id);
                //Pedir información al cliente, para modificar el registro
            String Nombre = JOptionPane.showInputDialog("Ingrese el nombre del cliente: ", c.getNombre());    //Lo trae, para ver si lo cambiamos o no
            String Apellido = JOptionPane.showInputDialog("Ingrese el apellido del cliente: ", c.getApellido());    //Lo trae, para ver si lo cambiamos o no
            String FormaPago = JOptionPane.showInputDialog("Esta vez, el método de pago: ", c.getFormaPago());    //Lo trae, para ver si lo cambiamos o no

            em.getTransaction().begin();    //Este comienza la transacción
                c.setNombre(Nombre);
                c.setApellido(Apellido);
                c.setFormaPago(FormaPago);
                //Guardar el objeto en la base de datos
            em.merge(c);    //Sólo cambia el objeto guardado en el contexto de la persistencia
            em.getTransaction().commit();    //Este es el commit -> Sí actualiza la base de datos
                //Devolver el cliente modificado
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
