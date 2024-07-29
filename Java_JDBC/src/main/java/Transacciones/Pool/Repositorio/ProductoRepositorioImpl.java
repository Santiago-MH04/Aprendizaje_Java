package Transacciones.Pool.Repositorio;

import Transacciones.Pool.Models.*;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ProductoRepositorioImpl implements Repositorio<Producto> {
        //Atributos de ProductoRepositorioImpl
    private Connection Conn;    //Para que haya una única conexión asociada, se debe pasar mediante un constructor, o un setter

        //Constructores de ProductoRepositorioImpl
    public ProductoRepositorioImpl() {
    }
    public ProductoRepositorioImpl(Connection conn) {
        this.Conn = conn;
    }

        //Asignadores de atributos de ProductoRepositorioImpl (setter)
    @Override
    public void setConnection(Connection connection) {
        this.Conn = connection;
    }

    //Lectores de atributos de ProductoRepositorioImpl (getter)
        //Métodos de ProductoRepositorioImpl
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

            P.setSKU(rs.getString("sku"));
            P.setCategoría(C);
        return P;
    }

    @Override
    public List<Producto> Listar() throws SQLException {
        List<Producto> Productos = new ArrayList<>();
            //Obtener la conexión
        try (Statement Stmt = this.Conn.createStatement();
             ResultSet RS = Stmt.executeQuery("SELECT p.*, c.nombre as categoria FROM productos as p " +
                     "inner join categorias as c ON (p.categoria_id = c.id)")){
                //Recorrer el cursor
            while(RS.next()){
                Producto P = CrearProducto(RS);
                    //Poblar la lista
                Productos.add(P);
            }
        }
        return Productos;
    }

    @Override
    public Producto PorID(Long ID) throws SQLException {
            //Definir el producto
        Producto Produit = null;
            //Obtener la conexión
        try (PreparedStatement PS = this.Conn.prepareStatement("SELECT p.*, c.nombre as Categoria FROM productos as p " +
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
        }
        return Produit;
    }

    @Override
    public Producto Guardar(Producto producto) throws SQLException {
            //Preparar parámetros
        String SQL;
        if (producto.getID() != null && producto.getID() > 0) {
            SQL = "UPDATE productos SET nombre = ?, precio = ?, categoria_id = ?, sku = ?  WHERE id = ?";
        } else {
            SQL = "INSERT INTO productos (nombre, precio, categoria_id, sku, fecha_registro) VALUES (?, ?, ?, ?, ?)";
        }
            //Obtener la conexión
        try (PreparedStatement PS= this.Conn.prepareStatement(SQL, Statement.RETURN_GENERATED_KEYS)){
                //Asignar parámetros
            PS.setString(1, producto.getNombre());
            PS.setLong(2, producto.getPrecio());
            PS.setLong(3, producto.getCategoría().getID());
            PS.setString(4, producto.getSKU());
            if (producto.getID() != null && producto.getID() > 0){
                PS.setLong(5, producto.getID());    //Actualizar la tabla
            } else {
                PS.setDate(5, Date.valueOf(producto.getFecha_Registro()));  //Crear un nuevo registro
            }

                //Actualizar la tabla en base de datos
            PS.executeUpdate();
                //Asignar el último ID disponible en caso de haber guardado un nuevo producto
            if (producto.getID() == null){
                try (ResultSet RS = PS.getGeneratedKeys()){
                        //Recorrer el cursor
                    if (RS.next()) {
                        producto.setID(RS.getLong(1));  //Es 1 y no ID porque no consulta la tabla como tal, sino los registros que creó
                    }
                }
            }
            return producto;    //Aquí, para que quede dentro del contexto de una probable excepción
        }
    }

    @Override
    public void Eliminar(Long ID) throws SQLException {
        try (PreparedStatement PS = this.Conn.prepareStatement("DELETE FROM productos WHERE id = ?")){
                //Asignar parámetros
            PS.setLong(1, ID);
                //Actualizar la tabla
            PS.executeUpdate();
        }
    }
}
