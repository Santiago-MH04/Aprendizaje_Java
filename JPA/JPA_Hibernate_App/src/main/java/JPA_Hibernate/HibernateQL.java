package JPA_Hibernate;

import JPA_Hibernate.Dominio.ClienteDTO;
import JPA_Hibernate.Entity.Cliente;
import JPA_Hibernate.Util.JPAUtil;
import jakarta.persistence.EntityManager;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.atomic.AtomicReference;

public class HibernateQL {
    public static void main(String[] args) {
            //Obtener la conexión
        EntityManager em = JPAUtil.getEntityManager();
        em.getTransaction().begin();
            //Operar en la base de datos
        System.out.println("----------  Listando ando  ----------");
        /*List<Cliente> clientes = em.createQuery("select c from Cliente c", Cliente.class).getResultList();*/
        List<Cliente> clientes = em.createQuery("from Cliente", Cliente.class).getResultList();
        clientes.forEach(System.out::println);

        System.out.println("----------  Consultando por id ando  ----------");
        /*Cliente cliente = em.createQuery("select c from Cliente c where id =?1", Cliente.class).getSingleResult();*/
        Cliente cliente = em.createQuery("select c from Cliente c where c.id = :id", Cliente.class)
                            .setParameter("id", 1L)
                            .getSingleResult();
        System.out.println(cliente);
        System.out.println("----------  Consultando el nombre por id ando  ----------");
        String nombreCliente = em.createQuery("select c.nombre from Cliente c where c.id = :id", String.class)
                                 .setParameter("id", 2L)
                                 .getSingleResult();
        System.out.println(nombreCliente);

        System.out.println("----------  Consultando campos personalizados por id ando  ----------");
        Object[] objetoCliente = em.createQuery("select c.id, c.nombre, c.apellido from Cliente c where c.id = :id", Object[].class)
                                 .setParameter("id", 3L)
                                 .getSingleResult();
        AtomicReference<Long> objetoClienteID = new AtomicReference<>((Long) objetoCliente[0]);
        AtomicReference<String> objetoClienteNombre = new AtomicReference<>((String) objetoCliente[1]);
        AtomicReference<String> objetoClienteApellido = new AtomicReference<>((String) objetoCliente[2]);
        System.out.println("ID: " + objetoClienteID +
                ". Nombre: " + objetoClienteNombre +
                ". Apellido: " + objetoClienteApellido);

        System.out.println("----------  Consultando campos personalizados List  ----------");
        List<Object[]> registros = em.createQuery("select c.id, c.nombre, c.apellido from Cliente c ", Object[].class)
                                     .getResultList();
            //A la for Each
        System.out.println("Imprmiendo a la for-each");
        for(Object[] registro : registros) {
            objetoClienteID.set((Long) registro[0]);
            objetoClienteNombre.set((String) registro[1]);
            objetoClienteApellido.set((String) registro[2]);
            System.out.println("ID: " + objetoClienteID +
                    ". Nombre: " + objetoClienteNombre +
                    ". Apellido: " + objetoClienteApellido);
        }
                //A la .forEach
        System.out.println("\nImprmiendo a la .forEach");
            registros.forEach(r -> {
                    //Si no queremos volver atómicas a las variables, se las renombra, y problemo resolvido
                objetoClienteID.set((Long) r[0]);
                objetoClienteNombre.set((String) r[1]);
                objetoClienteApellido.set((String) r[2]);
                System.out.println("ID: " + objetoClienteID +
                        ". Nombre: " + objetoClienteNombre +
                        ". Apellido: " + objetoClienteApellido);
            });

        System.out.println("----------  Consultando por Cliente y forma de pago  ----------");
        registros = em.createQuery("select c, c.formaPago from Cliente c", Object[].class).getResultList();
            registros.forEach(reg -> {
                Cliente c = (Cliente) reg[0];
                String formaPago = (String) reg[1];
                System.out.println("Forma de pago: " + formaPago + "\n" + c);
            });

        System.out.println("----------  Consultando y poblando objeto Entity de clases personalizadas  ----------");
        clientes = em.createQuery("select new Cliente(c.nombre, c.apellido) from Cliente c", Cliente.class)
                     .getResultList();
        clientes.forEach(System.out::println);

        System.out.println("----------  Consultando y poblando objeto OTRO de clases personalizadas  ----------");
        List<ClienteDTO> clientesDTO = em.createQuery("select new JPA_Hibernate.Dominio.ClienteDTO(c.nombre, c.apellido) from Cliente c", ClienteDTO.class)
                                         .getResultList();
        clientesDTO.forEach(System.out::println);

        System.out.println("----------  Consultando por nombre de Cliente  ----------");
        List<String> nombres = em.createQuery("select c.nombre from Cliente c", String.class)
                                 .getResultList();
        nombres.forEach(System.out::println);

        System.out.println("----------  Consultando por nombre único de Cliente  ----------");
        nombres = em.createQuery("select distinct(c.nombre) from Cliente c", String.class)
                    .getResultList();
        nombres.forEach(System.out::println);

        System.out.println("----------  Consultando por formas de pago únicas de Cliente  ----------");
        List<String> formasPago = em.createQuery("select distinct(c.formaPago) from Cliente c", String.class)
                                    .getResultList();
        formasPago.forEach(System.out::println);

        System.out.println("----------  Consultando cuántas formas de pago únicas de Cliente  ----------");
        Long totalFormasPago = em.createQuery("select count(distinct(c.formaPago)) from Cliente c", Long.class)
                                 .getSingleResult();
        System.out.println("Hay " + totalFormasPago + " formas de pago");

        System.out.println("----------  Consultando y concatenando nombre y apellido de Cliente  ----------");
        /*nombres = em.createQuery("select concat(c.nombre, ' ', c.apellido) as nombreCompleto from Cliente c", String.class)
                    .getResultList(); //Cuidadongos, los Strings no predeterminados tienen que ser especificados con apóstrofos
        nombres.forEach(System.out::println);*/
            nombres = em.createQuery("select c.nombre || ' ' || c.apellido as nombreCompleto from Cliente c", String.class)
                        .getResultList(); //Esto es únicamente otra forma de concatenar varios atributos como único resultado por fila de la tabla
            nombres.forEach(System.out::println);

        System.out.println("----------  Consultando y concatenando nombre y apellido de Cliente en mayúsculas ----------");
        nombres = em.createQuery("select upper(concat(c.nombre, ' ', c.apellido)) as nombreCompleto from Cliente c", String.class)
                    .getResultList();
        nombres.forEach(System.out::println);

        System.out.println("----------  Consultando por coincidencias en nombres de Cliente  ----------");
        String param = "Manuelitas";
        clientes = em.createQuery("select c from Cliente c where c.nombre like :parametrico", Cliente.class)
                .setParameter("parametrico", "%" + param + "%")
                .getResultList();
        clientes.forEach(System.out::println);

        System.out.println("----------  Consultando por rangos de cualidades de Cliente  ----------");
        clientes = /*em.createQuery("select c from Cliente c where c.id between 2 and 5", Cliente.class)*/
                   em.createQuery("select c from Cliente c where c.nombre between 'J' and 'R'", Cliente.class)
                     .getResultList();
        clientes.forEach(System.out::println);

        System.out.println("----------  Consultando por ocurrencia de cualidades en Cliente  ----------");
        clientes = em.createQuery("select c from Cliente c where c.id in :ids", Cliente.class)    //Únicamente devuelve los elementos que pertencen al conjunto especificado
                     .setParameter("ids", Arrays.asList(1L, 2L, 10L, 40L))  //Como el id 40 no existe, sencillamente lo omite de la búsqueda
                     .getResultList();
        clientes.forEach(System.out::println);

        System.out.println("----------  Consultando con ordenamiento de cualidades de Cliente  ----------");
        clientes = /*em.createQuery("select c from Cliente c order by c.nombre asc", Cliente.class)*/
                   em.createQuery("select c from Cliente c order by c.nombre, c.apellido desc", Cliente.class)  //Si tienen el mismo nombre, luego compara por apellidos -> Función súper útil
                     .getResultList();
        clientes.forEach(System.out::println);

        System.out.println("----------  Consultando con total de registros de Cliente  ----------");
        Long CantidadRegistros = em.createQuery("select count (c) as cantidadRegistros from Cliente c", Long.class)
                                   .getSingleResult();
        System.out.println("Hay " + CantidadRegistros + " de registros en la base de datos");

        System.out.println("----------  Consultando con valor mínimo de id de Cliente  ----------");
        Long minID = em.createQuery("select min (c.id) as minID from Cliente c", Long.class)
                                   .getSingleResult();
        System.out.println("El menor id registrado en nuestra base de datos es: " + minID);

        System.out.println("----------  Consultando con valor máximo de id de Cliente  ----------");
        Long maxID = em.createQuery("select max (c.id) as maxID from Cliente c", Long.class)
                                   .getSingleResult();
        System.out.println("El menor id registrado en nuestra base de datos es: " + maxID);

        System.out.println("----------  Consultando con nombre completo y su longitud en Cliente  ----------");
        registros = em.createQuery("select c.nombre, length(c.nombre) from Cliente c", Object[].class)
                .getResultList();
        registros.forEach(reg -> {
            System.out.println("Nombre: " + reg[0] + ". Longitud: " + reg[1] + " caracteres");
        });

        System.out.println("----------  Consultando con el nombre más corto Cliente  ----------");
        Integer NombreMinCaracteres = em.createQuery("select min(length(c.nombre)) from Cliente c", Integer.class)
                                        .getSingleResult();
        System.out.println("El nombre más corto de la base de datos tiene " + NombreMinCaracteres + " caracteres");

        System.out.println("----------  Consultando con el nombre más largo Cliente  ----------");
        Integer NombreMaxCaracteres = em.createQuery("select max (length(c.nombre)) from Cliente c", Integer.class)
                                        .getSingleResult();
        System.out.println("El nombre más largo de la base de datos tiene " + NombreMaxCaracteres + " caracteres");

        System.out.println("----------  Consultando resumen funciones agregación (min, max, count, avg) en Cliente  ----------");
        Object[] Estadísticas = em.createQuery("select min (c.id), max (c.id), sum (c.id), count (c), avg(length(c.nombre)) from Cliente c", Object[].class)
                                  .getSingleResult();
        Long min = (Long) Estadísticas[0];
        Long max = (Long) Estadísticas[1];
        Long sum = (Long) Estadísticas[2];
        Long count = (Long) Estadísticas[3];
        Double avg = (Double) Estadísticas[4];
        System.out.println("El menor id es " + min +
                           "\nEl mayor id es " + max +
                           "\nLa suma de los id registrados es " + sum +
                           "\nEl conteo de registros es " + count +
                           "\nLa longitud promedio de los nombres es " + avg + " caracteres");

        System.out.println("----------  Consultando con nombre más corto y su longitud en Cliente  ----------");
        registros = em.createQuery("select c.nombre, length(c.nombre) from Cliente c where " +
                                  "length(c.nombre) = (select min(length(c.nombre)) from Cliente c)", Object[].class)
                .getResultList();   //Con esta subconsulta sí podría hacer lo que pensaba del nombre completo, y para el máximo, es sino cambiar min por max
        registros.forEach(reg -> {
            System.out.println("Nombre: " + reg[0] + ". Longitud: " + reg[1] + " caracteres");
        });

        System.out.println("----------  Consultando para ver el último registro en Cliente  ----------");
        Cliente ultimoRegistro = em.createQuery("select c from Cliente c where " +
                "                               c.id = (select max (c.id) from Cliente c)", Cliente.class)
                                   .getSingleResult();
        System.out.println(ultimoRegistro);

            //Cerrar la conexión
        em.close();
    }
}
