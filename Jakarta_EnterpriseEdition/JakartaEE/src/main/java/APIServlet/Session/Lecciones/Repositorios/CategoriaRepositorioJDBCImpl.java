package APIServlet.Session.Lecciones.Repositorios;

import APIServlet.Session.Lecciones.Configs.Calificadores.MySQLConn;
import APIServlet.Session.Lecciones.Configs.Estereotipos.Repository;
import APIServlet.Session.Lecciones.Models.Categoria;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.inject.Named;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/*@ApplicationScoped*/ //Lo que es único por cada request es una conexión
@Repository
public class CategoriaRepositorioJDBCImpl implements Repositorio<Categoria>{
        //Atributos de CategoriaRepositorioJDBCImpl
    private Connection Conn;    //Esta conexión implementa el pool de conexiones
                                //No es necesario manejar el constructor con una conexión, pues el contenedor gestiona la instancia
                                // de la conexión

        //Constructores de CategoriaRepositorioJDBCImpl
    public CategoriaRepositorioJDBCImpl() { //Lo dejo nada más por si las moscas
    }
    @Inject
    public CategoriaRepositorioJDBCImpl(@MySQLConn Connection conn) {  /*(@Named("conn") Connection conn)*/ // Uso de calificadores
        this.Conn = conn;
    }

    //Asignadores de atributos de CategoriaRepositorioJDBCImpl (setters)
    //Lectores de atributos de CategoriaRepositorioJDBCImpl (getters)
        //Métodos de CategoriaRepositorioJDBCImpl
    private static Categoria crearCategoria(ResultSet rs) throws SQLException {
            //Poblar el objeto de tipo categoría
        Categoria c = new Categoria();
            c.setID(rs.getLong("id"));
            c.setNombre(rs.getString("nombre"));
        return c;
    }

    @Override
    public List<Categoria> Listar() throws SQLException {
        List<Categoria> Categorias = new ArrayList<>();
            //Obtener la Conexión
        try (Statement Stmt = Conn.createStatement();
             ResultSet RS = Stmt.executeQuery("SELECT * FROM categorias")) {
                //Recorrer el cursor
            while(RS.next()) {
                Categoria Cat = crearCategoria(RS);
                    //Agregar la categoría a la lista
                Categorias.add(Cat);
            }
        }
        return Categorias;
    }

    @Override
    public Categoria PorID(Long id) throws SQLException {
        Categoria C = null;
            //Obtener la conexión
        try (PreparedStatement PS = Conn.prepareStatement("SELECT * FROM categorias as c WHERE c.id = ?")) {
            PS.setLong(1, id);
                //Realizar la consulta
            try (ResultSet RS = PS.executeQuery()) {
                if (RS.next()) {
                        //Recorrer el cursor
                    C = crearCategoria(RS);
                }
            }
        }
        return C;
    }

    @Override
    public void Guardar(Categoria categoria) throws SQLException {
            //Pre-preparar la sentencia
        String SQL;
            //Ver si hay que actualizar o crear una categoría en lista
        if (categoria.getID() != null && categoria.getID() > 0){  //Se actualiza una categoria
            SQL = "UPDATE categorias SET nombre = ?  WHERE id = ?";
        } else{
            SQL = "INSERT INTO categorias (nombre) VALUES (?)";
        }
            //Realizar la instrucción
        try(PreparedStatement PS = Conn.prepareStatement(SQL)){
            PS.setString(1, categoria.getNombre());
            if (categoria.getID() != null && categoria.getID() > 0){
                PS.setLong(2, categoria.getID());
            }
            PS.executeUpdate();
        }
    }

    @Override
    public void Eliminar(Long id) throws SQLException {

    }
}
