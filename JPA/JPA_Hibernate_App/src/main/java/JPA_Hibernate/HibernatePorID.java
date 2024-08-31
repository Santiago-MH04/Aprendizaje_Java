package JPA_Hibernate;

import JPA_Hibernate.Entity.Cliente;
import JPA_Hibernate.Util.JPAUtil;
import jakarta.persistence.EntityManager;

import java.util.Scanner;

public class HibernatePorID {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
            //Obtener el EntityManager
        EntityManager em = JPAUtil.getEntityManager();
            //Hacer la operación SQL
        /*Query query = em.createQuery("select c from Cliente c where c.id = ? 1", Cliente.class);*/ //Es una clase de sentencia preparada
        System.out.println("Por favor, ingrese un id cuyo cliente desea conocer: ");
        Long ID = sc.nextLong();    //Se puede hacer un manejo de excepciones para controlar esto
        Cliente clienteQuery = em.find(Cliente.class, ID); //Es una clase de sentencia preparada, a la JPA
        /*query.setParameter(1, ID);*/
        System.out.println(clienteQuery);

            //Una vez se usa el método find, se guarda la referencia del objeto encontrado, por lo que no es necesario hacer de nuevo la consulta
        Cliente clienteQuery2 = em.find(Cliente.class, ID); //Que ya consultó arriba. Pero, al ejecutar, podremos ver en los logs que sólo consultó una vez
    System.out.println(clienteQuery2);



        /*Cliente cliente = (Cliente) query.getSingleResult();*/    //Así devuelve un único resultado
        /*System.out.println(cliente);*/
        /*List<Cliente> clientes = query.getResultList();*/    //Así devuelve una lista de resultados
        /*clientes.forEach(System.out::println);*/

            //Cerrar el EntityManager
        em.close(); //Un EntityManager no puede autocerrarse con un try con recursos
    }
}
