package Close.BaseDatos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexiónBaseDatos {
        //Atributos de ConexiónBaseDatos
    /*private static String URL = "jdbc:mysql://<hostname>:<port>/<database>?serverTimezone=America/Bogota";*/  //Los elementos en <> se deben cambiar, incluyendo al operador diamante
    private static String URL = "jdbc:mysql://localhost:3306/curso_java?serverTimezone=America/Bogota";
    private static String USERNAME = "root";
    private static String PASSWORD = "sasa";
    private static Connection Connection;


    //Constructores de ConexiónBaseDatos
    //Asignadores de atributos de ConexiónBaseDatos (setter)
    //Lectores de atributos de ConexiónBaseDatos (getter)
        //Métodos de ConexiónBaseDatos
    public static Connection getInstance() throws SQLException {
        return DriverManager.getConnection(URL, USERNAME, PASSWORD);
    };

}
