package APIServlet.Session.Lecciones.BaseDatos;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

public class ConexionBaseDatosDS {
    //Atributos de ConexionBaseDatosDS
    //Constructores de ConexionBaseDatosDS
    //Asignadores de atributos de ConexionBaseDatosDS (setters)
    //Lectores de atributos de ConexionBaseDatosDS (getters)
        //Métodos de ConexionBaseDatosDS
    public static Connection getConnection() throws SQLException, NamingException {
        Context initContext = new InitialContext();
        Context envContext  = (Context)initContext.lookup("java:/comp/env");
        DataSource ds = (DataSource)envContext.lookup("jdbc/MySQLDB");
        /*Connection conn = ds.getConnection();*/   //Para ahorrar espacio en la memoria
        return ds.getConnection();
    };
}
