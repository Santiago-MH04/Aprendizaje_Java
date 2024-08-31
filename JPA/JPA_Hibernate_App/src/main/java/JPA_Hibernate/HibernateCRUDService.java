package JPA_Hibernate;

import JPA_Hibernate.Entity.Cliente;
import JPA_Hibernate.Services.ClienteService;
import JPA_Hibernate.Services.ClienteServiceImpl;
import JPA_Hibernate.Util.JPAUtil;
import jakarta.persistence.EntityManager;

import java.util.List;
import java.util.Optional;

public class HibernateCRUDService {
    public static void main(String[] args) {
            //Conectémonos, mes amis !
        EntityManager em = JPAUtil.getEntityManager();
            //Instanciemos el servicio
        ClienteService Service = new ClienteServiceImpl(em);
            //Operemos de lo lindo
        System.out.println("---------- Listando ando ----------");
        List<Cliente> Clientes = Service.Listar();
        Clientes.forEach(System.out::println);

        System.out.println("---------- Buscando ando por ID ----------");
        Optional<Cliente> ClienteOpt = Service.PorID(4L);
        ClienteOpt.ifPresent(System.out::println);

        System.out.println("---------- Guardando ando ----------");
            //Insertar un nuevo cliente
        Cliente cliente = new Cliente();
            cliente.setNombre("María");
            cliente.setApellido("Palitos");
            cliente.setFormaPago("Nequi");
        Service.Guardar(cliente);
        System.out.println("Cliente " + cliente.getNombre() + " " + cliente.getApellido() + " guardado exitosamente");
        Service.Listar().forEach(System.out::println);
            //Modificar un cliente ya existente
        Long id = cliente.getId();
        ClienteOpt = Service.PorID(id);
        ClienteOpt.ifPresent(c -> {
            c.setFormaPago("Débito");
            Service.Guardar(c);
            System.out.println("Cliente " + cliente.getNombre() + " " + cliente.getApellido() + " modificado exitosamente");
            Service.Listar().forEach(System.out::println);
        });

        System.out.println("---------- Eliminando ando ----------");
        Long idClienteEliminar = cliente.getId();
        ClienteOpt = Service.PorID(idClienteEliminar);
        ClienteOpt.ifPresent(c -> {
            Service.Eliminar(c.getId());
            System.out.println("Cliente " + cliente.getNombre() + " " + cliente.getApellido() + " eliminado exitosamente");
            Service.Listar().forEach(System.out::println);
        });

            //Fermons-on la connection !
        em.close();
    }
}
