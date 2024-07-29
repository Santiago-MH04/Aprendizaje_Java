package Transacciones.Pool.BaseDatos;

import org.apache.commons.dbcp2.BasicDataSource;

import java.sql.Connection;
import java.sql.SQLException;

public class ConexiónBaseDatos {
        //Atributos de ConexiónBaseDatos
    /*private static String URL = "jdbc:mysql://<hostname>:<port>/<database>?serverTimezone=America/Bogota";*/  //Los elementos en <> se deben cambiar, incluyendo al operador diamante
    private static String URL = "jdbc:mysql://localhost:3306/curso_java?serverTimezone=America/Bogota";
    private static String USERNAME = "root";
    private static String PASSWORD = "sasa";
    private static BasicDataSource Pool;


    //Constructores de ConexiónBaseDatos
    //Asignadores de atributos de ConexiónBaseDatos (setter)
    //Lectores de atributos de ConexiónBaseDatos (getter)
        //Métodos de ConexiónBaseDatos
    public static BasicDataSource getInstance() throws SQLException {
        if (Pool == null) {
            Pool = new BasicDataSource();
            Pool.setUrl(URL);
            Pool.setUsername(USERNAME);
            Pool.setPassword(PASSWORD);

            Pool.setInitialSize(3);
            Pool.setMinIdle(3);
            Pool.setMaxIdle(8);
            Pool.setMaxTotal(8);
        }
        return Pool;
    }

    public static Connection getConnection() throws SQLException{
        return getInstance().getConnection();
    }
}
