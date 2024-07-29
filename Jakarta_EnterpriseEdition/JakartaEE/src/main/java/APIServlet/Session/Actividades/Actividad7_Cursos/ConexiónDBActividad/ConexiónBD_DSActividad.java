package APIServlet.Session.Actividades.Actividad7_Cursos.ConexiónDBActividad;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexiónBD_DSActividad {
    //Atributos de ConexiónBDActividad
    //Constructores de ConexiónBDActividad
    //Asignadores de atributos de ConexiónBDActividad (setter)
    //Lectores de atributos de ConexiónBDActividad (getter)
        //Métodos de ConexiónBDActividad
    public static Connection getConnectionDB() throws SQLException, NamingException { //Esto es para un pool de conexiones
        Context initContext = null;
        initContext = new InitialContext();
        Context envContext = (Context) initContext.lookup("java:/comp/env");
        DataSource ds = (DataSource) envContext.lookup("jdbc/MySQLDB");
        /*Connection conn = ds.getConnection();*/       //Para ahorrar espacio en la memoria
        return ds.getConnection();
    }
}
