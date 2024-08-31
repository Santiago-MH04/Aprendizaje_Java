package JPA_Hibernate;

import JPA_Hibernate.Entity.Cliente;
import JPA_Hibernate.Util.JPAUtil;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;

import java.util.List;
import java.util.Scanner;

public class HibernateResultListWhere {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
            //Obtener el EntityManager
        EntityManager em = JPAUtil.getEntityManager();
            //Hacer la operación SQL
        Query query = em.createQuery("select c from Cliente c where c.formaPago=?1", Cliente.class); //Es una clase de sentencia preparada
        System.out.println("Por favor, ingrese un método de pago válido: ");
        String Pago = sc.next();
            query.setParameter(1, Pago);
        List<Cliente> clientes = query.getResultList();    //Así devuelve una lista de resultados, adecuado para cuando el valor de la columna con que estamos buscando se repita en varias filas
        clientes.forEach(System.out::println);
            //Cerrar el EntityManager
        em.close(); //Un EntityManager no puede autocerrarse con un try con recursos
    }
}
