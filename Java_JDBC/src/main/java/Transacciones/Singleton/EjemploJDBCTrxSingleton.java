package Transacciones.Singleton;

import Transacciones.Singleton.BaseDatos.ConexiónBaseDatos;
import Transacciones.Singleton.Models.*;
import Transacciones.Singleton.Repositorio.*;


import java.sql.Connection;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.Month;

public class EjemploJDBCTrxSingleton {
    public static void main(String[] args) throws SQLException {

        try (Connection Conn = ConexiónBaseDatos.getInstance()){
                //Aliviar el autocommit
            if (Conn.getAutoCommit()) {
                Conn.setAutoCommit(false);
            }
            try {
                    //Consultar los elementos de la base de datos
                Repositorio<Producto> RepoProducto = new ProductoRepositorioImpl();
                    //Desplegar los productos obtenidos
                        //Método Listar
                System.out.println(" ---- Listar ---- ");
                RepoProducto.Listar().forEach(System.out::println);
                        //Método PorID
                System.out.println(" ---- Por ID ---- ");
                System.out.println(RepoProducto.PorID(2L));

                        //Actualizar producto
                /*System.out.println(" ---- Actualizar producto ---- ");
                Producto Produit = new Producto();
                    Produit.setID(7L);
                    Produit.setNombre("Teclado IBM mecánico");
                    Produit.setPrecio(1400);

                Categoría Cate = new Categoría();
                    Cate.setID(2L);

                    Produit.setCategoría(Cate);
                    Produit.setSKU("QuesoColo1");   //QuesoColo1 //abc1234

                RepoProducto.Guardar(Produit);
                System.out.println("Producto actualizado con éxito");*/

                        //Crear producto
                /*System.out.println(" ---- Crear producto ---- ");
                Producto P = new Producto();
                    P.setNombre("Samsung Galaxy S23 Ultra");
                    P.setPrecio(5700);
                    P.setFecha_Registro(LocalDate.of(2023, Month.APRIL, 30));

                Categoría Cat = new Categoría();
                    Cat.setID(3L);

                    P.setCategoría(Cat);
                    P.setSKU("1234Pepito");
                RepoProducto.Guardar(P);
                System.out.println("Producto guardado con éxito");
                RepoProducto.Listar().forEach(System.out::println);*/ //Para reflejar los cambios

                /*System.out.println(" ---- Eliminar producto ---- ");
                RepoProducto.Eliminar(7L);
                System.out.println("Producto eliminado con éxito");
                RepoProducto.Listar().forEach(System.out::println); //Para reflejar los cambios*/

                    //Realizar el commit
                Conn.commit();
            } catch (SQLException e) {
                Conn.rollback();    //La doble anidación es para poder tener la conexión en un contexto donde se pueda usar, en caso de ser necesario
                e.printStackTrace();
                //throw new RuntimeException(ex);
            }
        }
    }
}
