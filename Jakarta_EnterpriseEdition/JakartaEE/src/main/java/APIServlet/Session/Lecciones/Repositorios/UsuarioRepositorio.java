package APIServlet.Session.Lecciones.Repositorios;

import APIServlet.Session.Lecciones.Models.*;

import java.sql.SQLException;

public interface UsuarioRepositorio extends Repositorio<Usuario>{
    //Atributos de UsuarioRepositorio
    //Constructores de UsuarioRepositorio
    //Asignadores de atributos de UsuarioRepositorio (setter)
    //Lectores de atributos de UsuarioRepositorio (getter)
        //Métodos de UsuarioRepositorio
    Usuario PorUsername(String nombreUsuario) throws SQLException;
}
