package APIServlet.Session.Lecciones.Repositorios;

import APIServlet.Session.Lecciones.Configs.Calificadores.MySQLConn;
import APIServlet.Session.Lecciones.Configs.Estereotipos.Repository;
import APIServlet.Session.Lecciones.Models.Usuario;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.inject.Named;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/*@ApplicationScoped*/  //Lo que es único por cada request es una conexión
@Repository
public class UsuarioRepositorioJDBCImpl implements UsuarioRepositorio {
        //Atributos de UsuarioRepositorioJDBCImpl
    @Inject
    @MySQLConn/*@Named("conn")*/   //Uso de calificadores
    private Connection Conn;    //Esta conexión implementa el pool de conexiones
                                //No es necesario manejar el constructor con una conexión, pues el contenedor gestiona la instancia
                                // de la conexión

        //Constructores de UsuarioRepositorioJDBCImpl
    public UsuarioRepositorioJDBCImpl() {   //El constructor vacío se deja por si las moscas
                                            // en caso de que la inyección de dependencias se dé
                                            // por un método diferente a atributos
    }
    /*public UsuarioRepositorioJDBCImpl(Connection conn) {
        this.Conn = conn;
    }  */     //Como el contenedor contiene la instancia de la conexión, este método
            // se vuelve redundante, y puede generar conflictos

        //Asignadores de atributos de UsuarioRepositorioJDBCImpl (setters)
    public void setConn(Connection conn) {
        this.Conn = conn;
    }

        //Lectores de atributos de UsuarioRepositorioJDBCImpl (getters)
    public Connection getConn() {
        return this.Conn;
    }

        //Métodos de UsuarioRepositorioJDBCImpl
    private static Usuario crearUsuario(ResultSet rs) throws SQLException {
        Usuario usuario = new Usuario();
            usuario.setID(rs.getLong("id"));
            usuario.setNombreUsuario(rs.getString("username"));
            usuario.setContraseña(rs.getString("password"));
            usuario.setCorreo(rs.getString("email"));
        return usuario;
    }
        //De la interfaz Repositorio (su implementación queda de tarea)
    @Override
    public List<Usuario> Listar() throws SQLException {
        List<Usuario> Usuarios = new ArrayList<>();
            //Obtener la conexión a la base de datos
        try (Statement Stmt = this.Conn.createStatement();
             ResultSet RS = Stmt.executeQuery("SELECT u.* FROM usuarios as u")){
                //Recorrer el cursor
            while (RS.next()){
                Usuario Usuarini = crearUsuario(RS);
                Usuarios.add(Usuarini);
            }
        }
        return Usuarios;
    }
    @Override
    public Usuario PorID(Long id) throws SQLException {
        Usuario Usuariou = null;
            //Obtener la conexión a la base de datos
        try (PreparedStatement PS = this.Conn.prepareStatement("SELECT * FROM usuarios WHERE id = ?")){
                //Asignar el parámetro a la sentencia
            PS.setLong(1, id);
                //Ejecutar la sentencia
            try (ResultSet RS = PS.executeQuery()){
                    //Recorrer el cursor
                if (RS.next()){
                        //Poblar el objeto de tipo usuario
                    Usuariou = crearUsuario(RS);
                }
            }
        }
        return Usuariou;
    }
    @Override
    public void Guardar(Usuario usuario) throws SQLException {
        String SQL;
            //Ver si vamos a guardar o a actualizar algún usuario
        if (usuario.getID() != null && usuario.getID() > 0){
            SQL = "UPDATE usuarios set username = ?, password = ?, email = ? WHERE id = ?";
        } else {
            SQL = "INSERT INTO usuarios (username, password, email) VALUES (?, ?, ?)";
        }
            //Obtener la conexión a la base de datos
        try (PreparedStatement PS = this.Conn.prepareStatement(SQL)){
                //Asignar los parámetros
            PS.setString(1, usuario.getNombreUsuario());
            PS.setString(2, usuario.getContraseña());
            PS.setString(3, usuario.getCorreo());
                //Verificar el ID de usuario para insertar en la tabla
            if (usuario.getID() != null && usuario.getID() > 0){
                PS.setLong(4, usuario.getID());
            }
                //Ejecutar la sentencia
            PS.executeUpdate();
        }
    }
    @Override
    public void Eliminar(Long ID) throws SQLException {
            //Obtener la conexión a la base de datos
        try (PreparedStatement PS = this.Conn.prepareStatement("DELETE u.* FROM usuarios as u WHERE u.id = ?")){
                //Asignar los parámetros
            PS.setLong(1, ID);
                //Ejecutar la sentencia
            PS.executeUpdate();
        }
    }

        //De la interfaz Usuario Repositorio
    @Override
    public Usuario PorUsername(String nombreUsuario) throws SQLException {
        Usuario Usuarito = null;
            //Obtener la conexión a la base de datos
        try (PreparedStatement PS = this.Conn.prepareStatement("SELECT u.* FROM usuarios as u WHERE u.username = ?")){
                //Asignar el parámetro a la sentencia
            PS.setString(1, nombreUsuario);
                //Ejecutar la sentencia
            try (ResultSet RS = PS.executeQuery()){
                    //Recorrer el cursor para poblar el objeto de tipo usuario
                if (RS.next()){
                    Usuarito = crearUsuario(RS);
                }
            }
        }
        return Usuarito;
    }
}
