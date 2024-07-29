package Transacciones.Pool;

import Transacciones.Pool.BaseDatos.ConexiónBaseDatos;
import Transacciones.Pool.Models.*;
import Transacciones.Pool.Repositorio.*;
import Transacciones.Pool.Service.CatálogoServiceImpl;
import Transacciones.Pool.Service.Service;

import java.sql.Connection;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.Month;

public class EjemploJDBCTrxPool {
    public static void main(String[] args) throws SQLException {
            //Interactuar con la nueva clase de servicio
        Service Servicio = new CatálogoServiceImpl();

            //Insertando una categoría nueva
        Categoría Categorie = new Categoría();
        Categorie.setNombre("Iluminación");

            //Desplegar los productos obtenidos
                //Método Listar
        System.out.println(" ---- Listar ---- ");
        Servicio.Listar().forEach(System.out::println);
                //Método PorID
        System.out.println(" ---- Por ID ---- ");
        System.out.println(Servicio.PorID(2L));

                /*//Actualizar producto
        System.out.println(" ---- Actualizar producto ---- ");
        Producto Produit = new Producto();
            Produit.setID(6L);
            Produit.setNombre("Teclado IBM digital");
            Produit.setPrecio(2300);

        *//*Categoría Cate = new Categoría();
            Cate.setID(2L);

            Produit.setCategoría(Cate);*//*
            Produit.setSKU("QuesoColo1");   //QuesoColo1 //abc1234

        Servicio.Guardar(Produit);
        System.out.println("Producto actualizado con éxito");*/

                //Crear producto
        System.out.println(" ---- Crear producto ---- ");
        Producto P = new Producto();
            P.setNombre("Lámpara LED para escritorio");
            P.setPrecio(750);
            P.setFecha_Registro(LocalDate.of(2019, Month.JULY, 24));

            P.setSKU("ADB47ACA12");     //ADB47ACA12  //123ColQue*  //abc1234
            Servicio.GuardarProductoConCategoria(P, Categorie);

        System.out.println("Producto guardado con éxito con ID: " + P.getID());
        Servicio.Listar().forEach(System.out::println); //Para reflejar los cambios
    }
}
