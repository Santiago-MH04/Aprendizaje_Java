package POO_InterfacesRepositorio.Lecciones.Interfaces;

import POO_InterfacesRepositorio.Lecciones.Interfaces.Modelo.*;
import POO_InterfacesRepositorio.Lecciones.Interfaces.Repositorio.*;
import POO_InterfacesRepositorio.Lecciones.Interfaces.Repositorio.Excepciones.*;
import POO_InterfacesRepositorio.Lecciones.Interfaces.Repositorio.Lista.ClienteListRepositorio;

import java.util.List;

public class EjemploRepositorio {
    public static void main(String[] args) {
        try {
            CrudRepositorio<Cliente> repo = new ClienteListRepositorio();
            //RepositorioPleno repo = new ClienteListRepositorio();     //De esta manera, nos ahorramos todo el cast que hay que hacer
            //por la herencia múltiple de interfaces
                repo.Crear(new Cliente("Pepito", "Pérez"));
                repo.Crear(new Cliente("Pepa", "Pombo"));
                repo.Crear(new Cliente("Manuelitas", "Torombolitas"));
                repo.Crear(new Cliente("Elías", "Floriciento"));

            System.out.println("Clientes");
            List<Cliente> Clientes = repo.Listar();
                Clientes.forEach(System.out::println); //Expresión Lambda listada como un método de referencia
            System.out.println("\nPaginable");
            List<Cliente> Paginable = ((PaginableRepositorio) repo).Listar(1, 3); //Se fuerza a usar PaginableRepositorio, dado que
            // en primera instancia, sólo puede usar los métodos de
            // la interfaz CrudRepositorio
            //List<Cliente> Paginable = repo.Listar(1,3);
                Paginable.forEach(System.out::println); //Expresión Lambda listada como un método de referencia

            System.out.println("\nOrdenable");
            System.out.println("Ordenando por nombre, en dirección ascendente");
            List<Cliente> OrdenableASC = ((OrdenableRepositorio) repo).Listar("nombre", Dirección.ASC); //Se fuerza a usar OrdenableRepositorio, dado que
            // en primera instancia, sólo puede usar los métodos de
            // la interfaz CrudRepositorio
                OrdenableASC.forEach(System.out::println); //Expresión Lambda listada como un método de referencia
            System.out.println("Ordenando por apellido, en dirección descendente");
            List<Cliente> OrdenableDESC = ((OrdenableRepositorio) repo).Listar("APELLIDO", Dirección.DESC); //Se fuerza a usar OrdenableRepositorio, dado que
            // en primera instancia, sólo puede usar los métodos de
            // la interfaz CrudRepositorio
                OrdenableDESC.forEach(System.out::println);

            System.out.println("\nEditable");
            System.out.println("Antes del cambio");
            ((OrdenableRepositorio) repo).Listar("id", Dirección.ASC).forEach(System.out::println); //Expresión Lambda listada como un método de referencia
            Cliente PepaActualizar = new Cliente("Juanito", "Alimaña");
                PepaActualizar.setID(2);
                repo.Editar(PepaActualizar);
            Cliente Pepa = repo.porID(2);
            System.out.println("Después del cambio");
                ((OrdenableRepositorio) repo).Listar("id", Dirección.ASC).forEach(System.out::println); //Expresión Lambda listada como un método de referencia

            System.out.println("\nEliminar");
                repo.Eliminar(1);
                repo.Listar().forEach(System.out::println); //Expresión Lambda listada como un método de referencia

            System.out.println("\nTotal registros: " + ((ContableRepositorio) repo).Total());
        } catch(RegistroDuplicadoAccesoDatoException rd){
            System.err.println("Error de ingreso: " + rd.getMessage());
            rd.printStackTrace();
        } catch (LecturaAccesoDatoException le){
            System.err.println("Error de lectura: " + le.getMessage());
            le.printStackTrace();
        } catch (EscrituraAccesoDatoException ee){
            System.err.println("Error de escritura: " + ee.getMessage());
            ee.printStackTrace();
        } catch (AccesoDatoException ae){
            System.err.println("Error genérico: " + ae.getMessage());
            ae.printStackTrace();
        }
    }
}
