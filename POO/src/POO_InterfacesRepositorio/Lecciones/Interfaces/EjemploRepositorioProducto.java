package POO_InterfacesRepositorio.Lecciones.Interfaces;

import POO_InterfacesRepositorio.Lecciones.Interfaces.Modelo.Producto;
import POO_InterfacesRepositorio.Lecciones.Interfaces.Repositorio.*;
import POO_InterfacesRepositorio.Lecciones.Interfaces.Repositorio.Excepciones.AccesoDatoException;
import POO_InterfacesRepositorio.Lecciones.Interfaces.Repositorio.Excepciones.EscrituraAccesoDatoException;
import POO_InterfacesRepositorio.Lecciones.Interfaces.Repositorio.Excepciones.LecturaAccesoDatoException;
import POO_InterfacesRepositorio.Lecciones.Interfaces.Repositorio.Lista.ProductoListRepositorio;

import java.util.List;

public class EjemploRepositorioProducto {
    public static void main(String[] args) {

        try {
            //CrudRepositorio<Producto> repo = new ProductoListRepositorio();
            RepositorioPleno repo = new ProductoListRepositorio();     //De esta manera, nos ahorramos todo el cast que hay que hacer
                                                                       //por la herencia múltiple de interfaces
                repo.Crear(new Producto("Mesa", 50.25));
                repo.Crear(new Producto("Silla", 22d));
                repo.Crear(new Producto("Lámpara", 18.62));
                repo.Crear(new Producto("Ordenador", 450.75));

            System.out.println("Productos");
            List<Producto> Productos = repo.Listar();
            Productos.forEach(System.out::println); //Expresión Lambda listada como un método de referencia
            System.out.println("\nPaginable");
            //List<Producto> Paginable = ((PaginableRepositorio)repo).Listar(1,3);          //Se fuerza a usar PaginableRepositorio, dado que
            // en primera instancia, sólo puede usar los métodos de
            // la interfaz CrudRepositorio
            List<Producto> Paginable = repo.Listar(1, 3);
            Paginable.forEach(System.out::println); //Expresión Lambda listada como un método de referencia

            System.out.println("\nOrdenable");
            System.out.println("Ordenando por descripción, en dirección ascendente");
            List<Producto> OrdenableASC = repo.Listar("descripción", Dirección.ASC);
                OrdenableASC.forEach(System.out::println); //Expresión Lambda listada como un método de referencia
                System.out.println("Ordenando por precio, en dirección descendente");
            List<Producto> OrdenableDESC = repo.Listar("PRECIO", Dirección.DESC);
                OrdenableDESC.forEach(System.out::println);

            System.out.println("\nEditable");
            System.out.println("Antes del cambio");
                repo.Listar("id", Dirección.ASC).forEach(System.out::println); //Expresión Lambda listada como un método de referencia
            Producto LámparaActualizar = new Producto("Lámpara de escritorio", 23d);
                LámparaActualizar.setID(3);
            repo.Editar(LámparaActualizar);
            Producto Lámpara = (Producto) repo.porID(3);
                System.out.println("Después del cambio");
            repo.Listar("id", Dirección.ASC).forEach(System.out::println); //Expresión Lambda listada como un método de referencia

            System.out.println("\nEliminar");
                repo.Eliminar(1);
                repo.Listar().forEach(System.out::println); //Expresión Lambda listada como un método de referencia
            System.out.println("\nTotal registros: " + ((ContableRepositorio) repo).Total());
        } catch (LecturaAccesoDatoException le){
            System.err.println(le.getMessage());
            le.printStackTrace();
        } catch (EscrituraAccesoDatoException ee){
            System.err.println("Error de escritura: " + ee.getMessage());
            ee.printStackTrace();
        } catch (AccesoDatoException ae){
            System.err.println(ae.getMessage());
            ae.printStackTrace();
        }
    }
}
