package ConexiónSingleton;

import ConexiónSingleton.BaseDatos.ConexiónBaseDatos;
import ConexiónSingleton.Models.*;
import ConexiónSingleton.Repositorio.*;

import java.sql.*;
import java.time.LocalDate;
import java.time.Month;

public class EjemploJDBC {
    public static void main(String[] args) {
            //Obtener la conexión
        try (Connection Conn = ConexiónBaseDatos.getInstance()) {
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
                Cat.setID(5L);

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
                Cat.setID(5L);

                Produit.setCategoría(Cat);

            RepoProducto.Guardar(Produit);
            System.out.println("Producto actualizado con éxito");
            RepoProducto.Listar().forEach(System.out::println); //Para reflejar los cambios

            /*System.out.println(" ---- Eliminar producto ---- ");
            RepoProducto.Eliminar(7L);
            System.out.println("Producto eliminado con éxito");
            RepoProducto.Listar().forEach(System.out::println); //Para reflejar los cambios*/

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
