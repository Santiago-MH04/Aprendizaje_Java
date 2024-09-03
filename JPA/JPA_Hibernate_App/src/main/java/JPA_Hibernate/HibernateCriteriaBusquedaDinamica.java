package JPA_Hibernate;

import JPA_Hibernate.Entity.Cliente;
import JPA_Hibernate.Util.JPAUtil;
import jakarta.persistence.EntityManager;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class HibernateCriteriaBusquedaDinamica {
    public static void main(String[] args) {
            //Para interactuar un tris con el usuario
        Scanner sc = new Scanner(System.in);

        System.out.println("Filtro para nombre: ");
        String nombre = sc.nextLine();
        System.out.println("Filtro para apellido: ");
        String apellido = sc.nextLine();
        System.out.println("Filtro para la forma de pago: ");
        String formaPago = sc.nextLine();

            //Obtener la conexión
        EntityManager em = JPAUtil.getEntityManager();
            //Obtener el criteriaBuilder
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Cliente> query = cb.createQuery(Cliente.class);   //La consulta va a devolver objetos de tipo Cliente
        Root<Cliente> from = query.from(Cliente.class);//La fuente de consulta es la clase Entity Cliente

        List<Predicate> condiciones = new ArrayList<>();

            //Comenzar a poblar la lista
        if (!nombre.isBlank()){ /*nombre != null && !nombre.isEmpty()*/
            condiciones.add(cb.equal(from.get("nombre"), nombre));
        }
        if (!apellido.isBlank()){ /*apellido != null && !apellido.isEmpty()*/
            condiciones.add(cb.equal(from.get("apellido"), apellido));
        }
        if (!formaPago.isBlank()){ /*formaPago != null && !formaPago.isEmpty()*/
            condiciones.add(cb.equal(from.get("formaPago"), formaPago));
        }

        query.select(from).where(cb.and(condiciones.toArray(new Predicate[condiciones.size()])));
        List<Cliente> clientes = em.createQuery(query).getResultList();
        clientes.forEach(System.out::println);


        //Cerrar la conexión
        em.close();
    }
}
