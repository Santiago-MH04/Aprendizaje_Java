package Transacciones.Pool.Service;

import Pool.BaseDatos.ConexiónBaseDatos;
import Transacciones.Pool.Models.Categoría;
import Transacciones.Pool.Models.Producto;
import Transacciones.Pool.Repositorio.CategoríaRepositorioImpl;
import Transacciones.Pool.Repositorio.ProductoRepositorioImpl;
import Transacciones.Pool.Repositorio.Repositorio;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public class CatálogoServiceImpl implements Service{
        //Atributos de CatálogoServiceImpl
    private Repositorio<Producto> RepoProducto;
    private Repositorio<Categoría> RepoCategoría;

        //Constructores de CatálogoServiceImpl
    public CatálogoServiceImpl() {
        this.RepoProducto = new ProductoRepositorioImpl();
        this.RepoCategoría = new CategoríaRepositorioImpl();
    }

    //Asignadores de atributos de CatálogoServiceImpl (setter)
    //Lectores de atributos de CatálogoServiceImpl (getter)

        //Métodos de CatálogoServiceImpl (los métodos de consulta no requieren manejo de transacciones)
    @Override
    public List<Producto> Listar() throws SQLException {
        try (Connection Conn = ConexiónBaseDatos.getConnection()){
            this.RepoProducto.setConnection(Conn);
            return this.RepoProducto.Listar();
        }
    }
    @Override
    public List<Categoría> ListarCategorías() throws SQLException {
        try (Connection Conn = ConexiónBaseDatos.getConnection()){
            this.RepoCategoría.setConnection(Conn);
            return RepoCategoría.Listar();
        }
    }

    @Override
    public Producto PorID(Long id) throws SQLException {
        try (Connection Conn = ConexiónBaseDatos.getConnection()){
            this.RepoProducto.setConnection(Conn);
            return this.RepoProducto.PorID(id);
        }
    }
    @Override
    public Categoría CategoríaPorID(Long id) throws SQLException {
        try (Connection Conn = ConexiónBaseDatos.getConnection()){
            this.RepoCategoría.setConnection(Conn);
            return this.RepoCategoría.PorID(id);
        }
    }

    @Override
    public Producto Guardar(Producto producto) throws SQLException {
        try (Connection Conn = ConexiónBaseDatos.getConnection()){
            this.RepoProducto.setConnection(Conn);

            if(Conn.getAutoCommit()){
                Conn.setAutoCommit(false);
            }
            Producto NuevoProducto = null;
            try {
                NuevoProducto = this.RepoProducto.Guardar(producto);
                Conn.commit();
            } catch (SQLException e){
                Conn.rollback();
                e.printStackTrace();
            }
            return NuevoProducto;
        }
    }
    @Override
    public Categoría GuardarCategoría(Categoría categoría) throws SQLException {
        try (Connection Conn = ConexiónBaseDatos.getConnection()){
            this.RepoCategoría.setConnection(Conn);

            if(Conn.getAutoCommit()){
                Conn.setAutoCommit(false);
            }
            Categoría NuevaCategoría = null;
            try {
                NuevaCategoría = this.RepoCategoría.Guardar(categoría);
                Conn.commit();
            } catch (SQLException e){
                Conn.rollback();
                e.printStackTrace();
            }
            return NuevaCategoría;
        }
    }

    @Override
    public void Eliminar(Long id) throws SQLException {
        try (Connection Conn = ConexiónBaseDatos.getConnection()){
            this.RepoProducto.setConnection(Conn);

            if(Conn.getAutoCommit()){
                Conn.setAutoCommit(false);
            }
            try {
                this.RepoProducto.Eliminar(id);
                Conn.commit();
            } catch (SQLException e){
                Conn.rollback();
                e.printStackTrace();
            }
        }
    }
    @Override
    public void EliminarCategoría(Long id) throws SQLException {
        try (Connection Conn = ConexiónBaseDatos.getConnection()){
            this.RepoCategoría.setConnection(Conn);

            if(Conn.getAutoCommit()){
                Conn.setAutoCommit(false);
            }
            try {
                this.RepoCategoría.Eliminar(id);
                Conn.commit();
            } catch (SQLException e){
                Conn.rollback();
                e.printStackTrace();
            }
        }
    }

    @Override
    public void GuardarProductoConCategoria(Producto producto, Categoría categoría) throws SQLException {
        try (Connection Conn = ConexiónBaseDatos.getConnection()){
            this.RepoProducto.setConnection(Conn);
            this.RepoCategoría.setConnection(Conn);

            if(Conn.getAutoCommit()){
                Conn.setAutoCommit(false);
            }
            try {
                Categoría NuevaCategoría = this.RepoCategoría.Guardar(categoría);
                producto.setCategoría(NuevaCategoría);
                this.RepoProducto.Guardar(producto);
                Conn.commit();
            } catch (SQLException e){
                Conn.rollback();
                e.printStackTrace();
            }
        }
    }
}
