package Transacciones.Pool.Repositorio;

import Transacciones.Pool.Models.Categoría;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CategoríaRepositorioImpl implements Repositorio<Categoría> {
        //Atributos de CategoríaRepositorioImpl
    private Connection Conn;

        //Constructores de CategoríaRepositorioImpl
    public CategoríaRepositorioImpl() {
    }
    public CategoríaRepositorioImpl(Connection conn) {
        this.Conn = conn;
    }

        //Asignadores de atributos de CategoríaRepositorioImpl (setter)
    @Override
    public void setConnection(Connection connection) {
        this.Conn = connection;
    }

    //Lectores de atributos de CategoríaRepositorioImpl (getter)
        //Métodos de CategoríaRepositorioImpl
    private static Categoría CrearCategoría(ResultSet rs) throws SQLException {
            //Poblar el objeto de tipo categoría
        Categoría C = new Categoría();
            C.setID(rs.getLong("id"));
            C.setNombre(rs.getString("nombre"));
        return C;
    }

    @Override
    public List<Categoría> Listar() throws SQLException {
        List<Categoría> Categorías = new ArrayList<>();
            //Obtener la conexión
        try (Statement Stmt = this.Conn.createStatement();
             ResultSet RS = Stmt.executeQuery("SELECT * FROM categorias")) {
                //Recorrer el cursor
            while (RS.next()) {
                Categoría Cat = CrearCategoría(RS);
                    //Agregar a la lista
                Categorías.add(Cat);
            }
        }
        return Categorías;
    }

    @Override
    public Categoría PorID(Long id) throws SQLException {
            //Definir la categoría
        Categoría C = null;
            //Obtener la conexión
        try (PreparedStatement PS = this.Conn.prepareStatement("SELECT * FROM categorias as c WHERE c.id = ?")) {
                //Asignar los parámetros de la sentencia
            PS.setLong(1, id);
            try (ResultSet RS = PS.executeQuery();){
                    //Recorrer el cursor
                if (RS.next()){
                    C = CrearCategoría(RS);
                }
            }
        }
        return C;
    }

    @Override
    public Categoría Guardar(Categoría categoría) throws SQLException {
            //Preparar parámetros
        String SQL = null;
        if (categoría.getID() != null && categoría.getID() > 0){
            SQL = "UPDATE categorias SET nombre = ? WHERE id = ?";
        } else {
            SQL = "INSERT INTO categorias (nombre) VALUES (?)";
        }
            //Obtener la conexión
        try (PreparedStatement PS = this.Conn.prepareStatement(SQL, Statement.RETURN_GENERATED_KEYS)){
                //Asignar parámetros
            PS.setString(1, categoría.getNombre());
            if (categoría.getID() != null && categoría.getID() > 0){
                PS.setLong(2, categoría.getID());
            }
                //Actualizar la tabla en base de datos
            PS.executeUpdate();
                //Asignar el último ID disponible en caso de haber guardado una nueva categoría
            if (categoría.getID() == null){
                try (ResultSet RS = PS.getGeneratedKeys()) {
                    if (RS.next()){
                            //Recorrer el cursor
                        categoría.setID(RS.getLong(1)); //Es 1 y no ID porque no consulta la tabla como tal, sino los registros que creó
                    }
                }
            }
            return categoría;    //Aquí, para que quede dentro del contexto de una probable excepción
        }
    }

    @Override
    public void Eliminar(Long ID) throws SQLException {
        try(PreparedStatement PS = this.Conn.prepareStatement("DELETE FROM categorias WHERE id = ?")){
                //Asignar parámetros
            PS.setLong(1, ID);
                //Actualizar la tabla
            PS.executeUpdate();
        }

    }
}
