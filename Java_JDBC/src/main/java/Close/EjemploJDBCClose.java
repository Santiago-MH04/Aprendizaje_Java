package Close;

import Close.BaseDatos.ConexiónBaseDatos;
import Close.Models.*;
import Close.Repositorio.*;

import java.sql.Connection;
import java.sql.SQLException;

public class EjemploJDBCClose {
    public static void main(String[] args) {
            //Consultar los elementos de la base de datos
        Repositorio<Producto> RepoProducto = new ProductoRepositorioImpl();
            //Desplegar los productos obtenidos
                //Método Listar
        System.out.println(" ---- Listar ---- ");
        RepoProducto.Listar().forEach(System.out::println);
                //Método PorID
        System.out.println(" ---- Por ID ---- ");
        System.out.println(RepoProducto.PorID(2L));
                /*//Crear producto
            System.out.println(" ---- Crear producto ---- ");
            Producto P = new Producto();
                P.setNombre("Teclado Red Dragon");
                P.setPrecio(1000);
                P.setFecha_Registro(LocalDate.of(2021, Month.MAY, 17));

            Categoría Cat = new Categoría();
                Cat.setID(2L);

                P.setCategoría(Cat);
            RepoProducto.Guardar(P);
            System.out.println("Producto guardado con éxito");
            RepoProducto.Listar().forEach(System.out::println); //Para reflejar los cambios*/

                //Actualizar producto
        System.out.println(" ---- Actualizar producto ---- ");
        Producto Produit = new Producto();
            Produit.setID(6L);
            Produit.setNombre("Teclado mecánico Razer");
            Produit.setPrecio(1200);

        Categoría Cat = new Categoría();
            Cat.setID(2L);

            Produit.setCategoría(Cat);

        RepoProducto.Guardar(Produit);
        System.out.println("Producto actualizado con éxito");
        RepoProducto.Listar().forEach(System.out::println); //Para reflejar los cambios

            /*System.out.println(" ---- Eliminar producto ---- ");
            RepoProducto.Eliminar(7L);
            System.out.println("Producto eliminado con éxito");
            RepoProducto.Listar().forEach(System.out::println); //Para reflejar los cambios*/
    }
}
