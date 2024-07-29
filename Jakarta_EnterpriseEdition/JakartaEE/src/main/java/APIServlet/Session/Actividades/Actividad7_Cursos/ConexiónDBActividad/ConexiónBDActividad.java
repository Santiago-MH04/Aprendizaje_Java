package APIServlet.Session.Actividades.Actividad7_Cursos.ConexiónDBActividad;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexiónBDActividad {
        //Atributos de ConexiónBDActividad
    private static String URL = "jdbc:mysql://localhost:3306/curso_java?serverTimezone=America/Bogota";
    private static String USERNAME = "root";
    private static String PASSWORD = "sasa";

    //Constructores de ConexiónBDActividad
    //Asignadores de atributos de ConexiónBDActividad (setter)
    //Lectores de atributos de ConexiónBDActividad (getter)
            //Métodos de ConexiónBDActividad
    public static Connection getConnectionBD() throws SQLException {
        return DriverManager.getConnection(URL, USERNAME, PASSWORD);
    }
}
