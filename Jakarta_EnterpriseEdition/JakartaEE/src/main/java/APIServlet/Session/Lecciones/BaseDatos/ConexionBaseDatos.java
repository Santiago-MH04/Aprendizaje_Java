package APIServlet.Session.Lecciones.BaseDatos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexionBaseDatos {
        //Atributos de ConexionBaseDatos
    /*private static String URL = "jdbc:mysql://<hostname>:<port>/<database>?serverTimezone=America/Bogota";*/  //Los elementos en <> se deben cambiar, incluyendo al operador diamante
    private static String URL = "jdbc:mysql://localhost:3306/curso_java?serverTimezone=America/Bogota";
    private static String USERNAME = "root";
    private static String PASSWORD = "sasa";

    //Constructores de ConexionBaseDatos
    //Asignadores de atributos de ConexionBaseDatos (setters)
    //Lectores de atributos de ConexionBaseDatos (getters)
        //Métodos de ConexionBaseDatos
    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL, USERNAME, PASSWORD);    //Esto no es una conexión Singleton
    }
}
