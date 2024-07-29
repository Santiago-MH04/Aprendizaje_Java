package Pool.Repositorio;

import Pool.BaseDatos.*;
import Pool.Models.*;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ProductoRepositorioImpl implements Repositorio<Producto> {
    //Atributos de ProductoRepositorioImpl
    //Constructores de ProductoRepositorioImpl
    //Asignadores de atributos de ProductoRepositorioImpl (setter)
    //Lectores de atributos de ProductoRepositorioImpl (getter)
        //Métodos de ProductoRepositorioImpl
    private Connection getConnection() throws SQLException {
        return ConexiónBaseDatos.getConnection();
    }

    private static Producto CrearProducto(ResultSet rs) throws SQLException {
            //Crear el objeto de tipo Producto
        Producto P = new Producto();
            P.setID(rs.getLong("id"));
            P.setNombre(rs.getString("nombre"));
            P.setPrecio(rs.getInt("precio"));
            P.setFecha_Registro(rs.getDate("fecha_registro").toLocalDate());
        Categoría C = new Categoría();
            C.setID(rs.getLong("categoria_id"));
            C.setNombre(rs.getString("categoria"));

        P.setCategoría(C);
        return P;
    }

    @Override
    public List<Producto> Listar(){
        List<Producto> Productos = new ArrayList<>();
            //Obtener la conexión
        try (Connection Conn = getConnection();
             Statement Stmt = Conn.createStatement();
             ResultSet RS = Stmt.executeQuery("SELECT p.*, c.nombre as categoria FROM productos as p " +
                     "inner join categorias as c ON (p.categoria_id = c.id)")){
                //Recorrer el cursor
            while(RS.next()){
                Producto P = CrearProducto(RS);
                    //Poblar la lista
                Productos.add(P);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return Productos;
    }

    @Override
    public Producto PorID(Long ID){
        Producto Produit = null;
            //Obtener la conexión
        try (Connection Conn = getConnection();
             PreparedStatement PS = Conn.prepareStatement("SELECT p.*, c.nombre as categoria FROM productos as p " +
                     "inner join categorias as c ON (p.categoria_id = c.id) WHERE p.id = ?")){
            PS.setLong(1, ID);
                //Ejecutar la consulta
            try (ResultSet RS = PS.executeQuery()) {
                    //Recorrer el cursor
                if (RS.next()) {
                        //Crear objeto de tipo Producto
                    Produit = CrearProducto(RS);
                }
            }
        }  catch (SQLException e) {
            e.printStackTrace();
        }
        return Produit;
    }

    @Override
    public void Guardar(Producto producto){
            //Preparar parámetros
        String SQL;
        if (producto.getID() != null && producto.getID() > 0) {
            SQL = "UPDATE productos SET nombre = ?, precio = ?, categoria_id = ? WHERE id = ?";
        } else {
            SQL = "INSERT INTO productos (nombre, precio, categoria_id, fecha_registro) VALUES (?, ?, ?, ?)";
        }
            //Obtener la conexión
        try (Connection Conn = getConnection();
             PreparedStatement PS= Conn.prepareStatement(SQL)){
                //Asignar parámetros
            PS.setString(1, producto.getNombre());
            PS.setLong(2, producto.getPrecio());
            PS.setLong(3, producto.getCategoría().getID());
            if (producto.getID() != null && producto.getID() > 0){
                PS.setLong(4, producto.getID());    //Actualizar la tabla
            } else {
                PS.setDate(4, Date.valueOf(producto.getFecha_Registro()));  //Crear un nuevo registro
            }
                //Actualizar la base de datos
            PS.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    @Override
    public void Eliminar(Long ID){
        try (Connection Conn = getConnection();
             PreparedStatement PS = Conn.prepareStatement("DELETE FROM productos WHERE id = ?")){
            PS.setLong(1, ID);
            PS.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
