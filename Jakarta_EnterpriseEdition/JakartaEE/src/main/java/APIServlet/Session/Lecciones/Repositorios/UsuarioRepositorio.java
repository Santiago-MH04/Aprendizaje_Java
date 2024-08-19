package APIServlet.Session.Lecciones.Repositorios;

import APIServlet.Session.Lecciones.Models.Usuario;

import java.sql.SQLException;

public interface UsuarioRepositorio extends Repositorio<Usuario>{
    //Atributos de UsuarioRepositorio
    //Constructores de UsuarioRepositorio
    //Asignadores de atributos de UsuarioRepositorio (setters)
    //Lectores de atributos de UsuarioRepositorio (getters)
        //Métodos de UsuarioRepositorio
    Usuario PorUsername(String nombreUsuario) throws SQLException;
}
