package JPA_Hibernate;

import JPA_Hibernate.Entity.Cliente;
import JPA_Hibernate.Util.JPAUtil;
import jakarta.persistence.EntityManager;
import jakarta.persistence.criteria.*;

import java.util.Arrays;
import java.util.List;

public class HibernateCriteria {
    public static void main(String[] args) {
            //Obtener la conexión
        EntityManager em = JPAUtil.getEntityManager();
            //Operar en la base de datos
                //Se va a operar con bloques de construcción usando la clase CriteriaBuilder
        CriteriaBuilder criteria = em.getCriteriaBuilder();
        CriteriaQuery<Cliente> query = criteria.createQuery(Cliente.class); //Así, lo que se consulte va a devolver un tipo Cliente
        Root<Cliente> from = query.from(Cliente.class); //Va a consultar de la clase entity Cliente

            //Cada que se hace una consulta hay que reinstanciar las variables, recuérdalo

                //Listar los clientes
        System.out.println("---------- Listando ando ----------");
        query.select(from); //Análogo de select c from Cliente c
        List<Cliente> clientes = em.createQuery(query).getResultList(); //El resultado como objeto Java
        clientes.forEach(System.out::println);
                //Buscar algún cliente
        System.out.println("---------- Buscando ando where * equals ----------");
        query = criteria.createQuery(Cliente.class);    //De nuevo, lo que va a arrojar la consulta es un tipo Cliente
        from = query.from(Cliente.class);   //Otra vez, va a consultar en la clase Entity Cliente
            /*ParameterExpression<String> nombreParam = criteria.parameter(String.class, "nombre");*/ //Para consultar asignando parámetros
        query.select(from).where(criteria.equal(from.get("nombre"), "Quesozuelos"));    //Análogo de select c from Cliente c where c.nombre = :<nombre>
            /*query.select(from).where(criteria.equal(from.get("nombre"), nombreParam));*/    //Análogo de select c from Cliente c where c.nombre = :<nombre>
        clientes = em.createQuery(query).getResultList();   //El resultado como objeto Java
            /*clientes = em.createQuery(query)
                    .setParameter("nombre", "Quesozuelos")
                    .getResultList();*/   //El resultado como objeto Java
        clientes.forEach(System.out::println);

        System.out.println("---------- Buscando ando where * like ----------");
        query = criteria.createQuery(Cliente.class);    //De nuevo, lo que va a arrojar la consulta es un tipo Cliente
        from = query.from(Cliente.class);   //Otra vez, va a consultar en la clase Entity Cliente
            ParameterExpression<String> nombreParamLike = criteria.parameter(String.class, "nombreParam"); //Para consultar asignando parámetros
        /*query.select(from).where(criteria.like(criteria.upper(from.get("nombre")), "%LITAS%"));*/
            query.select(from).where(criteria.like(criteria.upper(from.get("nombre")), criteria.upper(nombreParamLike)));
        /*clientes = em.createQuery(query).getResultList();*/   //El resultado como objeto Java
            clientes = em.createQuery(query)
                    .setParameter("nombreParam", "%litas%")
                    .getResultList();   //El resultado como objeto Java
        clientes.forEach(System.out::println);

        System.out.println("---------- Buscando ando where * between para rangos ----------");
        query = criteria.createQuery(Cliente.class);    //De nuevo, lo que va a arrojar la consulta es un tipo Cliente
        from = query.from(Cliente.class);   //Otra vez, va a consultar en la clase Entity Cliente
        query.select(from).where(criteria.between(from.get("id"), 2L, 6L)); //Ambas cotas se incluyen
        clientes = em.createQuery(query).getResultList();   //El resultado como objeto Java
        clientes.forEach(System.out::println);

        System.out.println("---------- Buscando ando where * in para arreglos ----------");
        query = criteria.createQuery(Cliente.class);    //De nuevo, lo que va a arrojar la consulta es un tipo Cliente
        from = query.from(Cliente.class);   //Otra vez, va a consultar en la clase Entity Cliente
            ParameterExpression<List> ListParam = criteria.parameter(List.class, "nombres");
        /*query.select(from).where(from.get("nombre").in("Santiaguito", "Manuelitas"));*/ //Ambas cotas se incluyen
            /*query.select(from).where(from.get("nombre").in(Arrays.asList("Santiaguito", "Manuelitas")));*/
            query.select(from).where(from.get("nombre").in(ListParam));
        /*clientes = em.createQuery(query).getResultList();*/   //El resultado como objeto Java
        clientes = em.createQuery(query)
                .setParameter("nombres", Arrays.asList("Santiaguito", "Manuelitas") )
                .getResultList();   //El resultado como objeto Java
        clientes.forEach(System.out::println);

        System.out.println("---------- Filtrando ando usando predicates con relaciones de orden ----------");
        query = criteria.createQuery(Cliente.class);    //De nuevo, lo que va a arrojar la consulta es un tipo Cliente
        from = query.from(Cliente.class);   //Otra vez, va a consultar en la clase Entity Cliente
        query.select(from).where(criteria.ge(from.get("id"), 3L ));
            /*query.select(from).where(criteria.lt(from.get("id"), 3L ));*/
        clientes = em.createQuery(query).getResultList();   //El resultado como objeto Java
        clientes.forEach(System.out::println);
            query = criteria.createQuery(Cliente.class);    //De nuevo, lo que va a arrojar la consulta es un tipo Cliente
            from = query.from(Cliente.class);   //Otra vez, va a consultar en la clase Entity Cliente
            query.select(from).where(criteria.gt(criteria.length(from.get("nombre")), 6L));
                /*query.select(from).where(criteria.le(criteria.length(from.get("nombre")), 6L));*/
            clientes = em.createQuery(query).getResultList();   //El resultado como objeto Java
            clientes.forEach(System.out::println);

        System.out.println("---------- Filtrando ando usando predicates de conjunción y disyunción ----------");
        query = criteria.createQuery(Cliente.class);    //De nuevo, lo que va a arrojar la consulta es un tipo Cliente
        from = query.from(Cliente.class);   //Otra vez, va a consultar en la clase Entity Cliente
        Predicate porNombre = criteria.equal(from.get("nombre"), "Santiaguito");
        Predicate porFormaPago = criteria.equal(from.get("formaPago"), "Ronroneos");
        Predicate preID = criteria.ge(from.get("id"), 4L);
        /*query.select(from).where(criteria.and(porNombre, porFormaPago));*/
            query.select(from).where(criteria.and(preID, criteria.or(porNombre, porFormaPago)));
                /*query.select(from).where(criteria.or(porNombre, porFormaPago));*/
        clientes = em.createQuery(query).getResultList();   //El resultado como objeto Java
        clientes.forEach(System.out::println);

        System.out.println("---------- Filtrando ando con ordenación de resultados ----------");
        query = criteria.createQuery(Cliente.class);    //De nuevo, lo que va a arrojar la consulta es un tipo Cliente
        from = query.from(Cliente.class);   //Otra vez, va a consultar en la clase Entity Cliente
        query.select(from).orderBy(criteria.asc(from.get("nombre")), criteria.desc(from.get("apellido")));
        clientes = em.createQuery(query).getResultList();   //El resultado como objeto Java
        clientes.forEach(System.out::println);
            query = criteria.createQuery(Cliente.class);    //De nuevo, lo que va a arrojar la consulta es un tipo Cliente
            from = query.from(Cliente.class);   //Otra vez, va a consultar en la clase Entity Cliente
            ParameterExpression<Long> idParam = criteria.parameter(Long.class, "id");
            query.select(from).where(criteria.equal(from.get("id"), idParam));
            Cliente cliente = em.createQuery(query)
                    .setParameter("id", 5L)
                    .getSingleResult();   //El resultado como objeto Java
            System.out.println(cliente);

        System.out.println("---------- Consultando ando sólo el nombre de los clientes ----------");
        CriteriaQuery<String> queryString = criteria.createQuery(String.class); //Porque vamos a obtener los nombres, nada más, que son Strings
        from = queryString.from(Cliente.class);   //Otra vez, va a consultar en la clase Entity Cliente
        queryString.select(from.get("nombre"));
        List<String> nombresClientes = em.createQuery(queryString).getResultList();
        nombresClientes.forEach(System.out::println);

        System.out.println("---------- Consultando ando sólo el nombre de los clientes, con única aparición ----------");
        queryString = criteria.createQuery(String.class); //Porque vamos a obtener los nombres, nada más, que son Strings
        from = queryString.from(Cliente.class);   //Otra vez, va a consultar en la clase Entity Cliente
        queryString.select(from.get("nombre")).distinct(true);
        nombresClientes = em.createQuery(queryString).getResultList();
        nombresClientes.forEach(System.out::println);

        System.out.println("---------- Consultando ando el nombre completo de los clientes, concatenando ----------");
        queryString = criteria.createQuery(String.class); //Porque vamos a obtener los nombres completos, nada más, que son Strings
        from = queryString.from(Cliente.class);   //Otra vez, va a consultar en la clase Entity Cliente
        queryString.select(criteria.concat(criteria.concat(from.get("nombre"), " "), from.get("apellido")));    //El método .concat() sólo funciona con dos eslabones
        nombresClientes = em.createQuery(queryString).getResultList();
        nombresClientes.forEach(System.out::println);
            queryString = criteria.createQuery(String.class); //Porque vamos a obtener los nombres completos, nada más, que son Strings
            from = queryString.from(Cliente.class);   //Otra vez, va a consultar en la clase Entity Cliente
            queryString.select(criteria.upper(criteria.concat(criteria.concat(from.get("nombre"), " "), from.get("apellido"))));    //El método .concat() sólo funciona con dos eslabones
            nombresClientes = em.createQuery(queryString).getResultList();
            nombresClientes.forEach(System.out::println);

        System.out.println("---------- Consultando ando por campos personalizados ----------");
        CriteriaQuery<Object[]> queryObject = criteria.createQuery(Object[].class); //Porque vamos a obtener campos personalizados, que es un arreglo de Object
        from = queryObject.from(Cliente.class);   //Otra vez, va a consultar en la clase Entity Cliente
        queryObject.multiselect(from.get("id"), from.get("nombre"), from.get("apellido"));
        List<Object[]> registros = em.createQuery(queryObject).getResultList();
        registros.forEach(reg -> {
            Long id = (Long) reg[0];
            String nombre = (String) reg[1];
            String apellido = (String) reg[2];
            System.out.println("id: " + id + ". Nombre completo: " + nombre + " " + apellido);
        });
            queryObject = criteria.createQuery(Object[].class); //Porque vamos a obtener campos personalizados, que es un arreglo de Object
            from = queryObject.from(Cliente.class);   //Otra vez, va a consultar en la clase Entity Cliente
            queryObject.multiselect(from.get("id"), from.get("nombre"), from.get("apellido")).where(criteria.like(from.get("nombre"), "%an%"));
            registros = em.createQuery(queryObject).getResultList();
            registros.forEach(reg -> {
                Long id = (Long) reg[0];
                String nombre = (String) reg[1];
                String apellido = (String) reg[2];
                System.out.println("id: " + id + ". Nombre completo: " + nombre + " " + apellido);
            });
                queryObject = criteria.createQuery(Object[].class); //Porque vamos a obtener campos personalizados, que es un arreglo de Object
                from = queryObject.from(Cliente.class);   //Otra vez, va a consultar en la clase Entity Cliente
                queryObject.multiselect(from.get("id"), from.get("nombre"), from.get("apellido")).where(criteria.equal(from.get("id"), 4L));
                Object[] registro = em.createQuery(queryObject).getSingleResult();
                    Long id = (Long) registro[0];
                    String nombre = (String) registro[1];
                    String apellido = (String) registro[2];
                System.out.println("id: " + id + ". Nombre completo: " + nombre + " " + apellido);

        System.out.println("---------- Consultando ando la cantidad de registros con count ----------");
        CriteriaQuery<Long> queryLong = criteria.createQuery(Long.class);
        from = queryLong.from(Cliente.class);   //Otra vez, va a consultar en la clase Entity Cliente
        queryLong.select(criteria.count(from.get("id")));
        Long count = em.createQuery(queryLong).getSingleResult();
        System.out.println("En la base de datos hay " + count + " registros");

        System.out.println("---------- Sumando ando datos de algún campo de la tabla ----------");
        queryLong = criteria.createQuery(Long.class);
        from = queryLong.from(Cliente.class);   //Otra vez, va a consultar en la clase Entity Cliente
        queryLong.select(criteria.sum(from.get("id")));
        Long sum = em.createQuery(queryLong).getSingleResult();
        System.out.println("La suma de los id presentes es " + count);

        System.out.println("---------- Consultando ando máximos y mínimos de algún campo de la tabla ----------");
        queryLong = criteria.createQuery(Long.class);
        from = queryLong.from(Cliente.class);   //Otra vez, va a consultar en la clase Entity Cliente
        queryLong.select(criteria.max(from.get("id")));
        Long max = em.createQuery(queryLong).getSingleResult();
        System.out.println("El máximo id guardado es " + max);
            queryLong.select(criteria.min(from.get("id")));
            Long min = em.createQuery(queryLong).getSingleResult();
            System.out.println("El mínimo id guardado es " + min);

        System.out.println("---------- Consultando ando varios resultados de funciones de agregación en una sola consulta ----------");
        queryObject = criteria.createQuery(Object[].class);
        from = queryObject.from(Cliente.class);   //Otra vez, va a consultar en la clase Entity Cliente
        queryObject.multiselect(criteria.count(from.get("id")),
                                criteria.sum(from.get("id")),
                                criteria.min(from.get("id")),
                                criteria.max(from.get("id")));
        registro = em.createQuery(queryObject).getSingleResult();
            Long registrous = (Long)registro[0];
            Long suma = (Long)registro[1];
            Long minimum = (Long)registro[2];
            Long maximum = (Long)registro[3];
        System.out.println("Conteo de registros: " + registrous + ".\nSuma de ids registrados: " + suma + ".\nMínimo id registrado: " + minimum + ".\nMáximo id registrado: " + maximum);

            //Cerrar la conexión
        em.close();
    }
}
