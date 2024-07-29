package APIServlet.Session.Lecciones.BaseDatos;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

public class ConexionBaseDatosDS {
    //Atributos de ConexiónBaseDatos
    //Constructores de ConexiónBaseDatos
    //Asignadores de atributos de ConexiónBaseDatos (setter)
    //Lectores de atributos de ConexiónBaseDatos (getter)
        //Métodos de ConexiónBaseDatos
    public static Connection getConnection() throws SQLException, NamingException { //Esto es para un pool de conexiones
        Context initContext = null;
        initContext = new InitialContext();
        Context envContext = (Context) initContext.lookup("java:/comp/env");
        DataSource ds = (DataSource) envContext.lookup("jdbc/MySQLDB");
        /*Connection conn = ds.getConnection();*/       //Para ahorrar espacio en la memoria
        return ds.getConnection();
    }

}
