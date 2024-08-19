package APIServlet.Session.Lecciones.Service;

import APIServlet.Session.Lecciones.Configs.Estereotipos.Servicio;
import APIServlet.Session.Lecciones.Models.Usuario;
import APIServlet.Session.Lecciones.Repositorios.UsuarioRepositorio;
import APIServlet.Session.Lecciones.Repositorios.UsuarioRepositorioJDBCImpl;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

/*@ApplicationScoped*/  //Lo que es único por cada request es una conexión
@Servicio
public class UsuarioServiceJDBCImpl implements UsuarioService {
        //Atributos de UsuarioServiceJDBCImpl
    @Inject
    private UsuarioRepositorio RepoUsuario;

        //Constructores de UsuarioServiceJDBCImpl
    /*public UsuarioServiceJDBCImpl(Connection connection) {
        this.RepoUsuario = new UsuarioRepositorioJDBCImpl(connection);
    }*/
    @Inject //No hay que aclarar el nombre porque UsuarioRepositorioJDBCImpl es la única clase que implementa UsuarioRepositorio
    public UsuarioServiceJDBCImpl(UsuarioRepositorio usuarioRepositorio) {
        this.RepoUsuario = usuarioRepositorio;
    }

    //Asignadores de atributos de UsuarioServiceJDBCImpl (setters)
    //Lectores de atributos de UsuarioServiceJDBCImpl (getters)
        //Métodos de UsuarioServiceJDBCImpl
            //Métodos de Repositorio
    @Override
    public List<Usuario> ListarUsuarios() {
        try {
            return this.RepoUsuario.Listar();
        } catch (SQLException e) {
            throw new ServiceJDBCException(e.getMessage(), e.getCause());
        }
    }
    @Override
    public Optional<Usuario> PorID(Long ID) {
        try {
            return Optional.ofNullable(this.RepoUsuario.PorID(ID));
        } catch (SQLException e) {
            throw new ServiceJDBCException(e.getMessage(), e.getCause());
        }
    }
    @Override
    public void Guardar(Usuario usuario) {
        try {
            this.RepoUsuario.Guardar(usuario);
        } catch (SQLException e) {
            throw new ServiceJDBCException(e.getMessage(), e.getCause());
        }
    }
    @Override
    public void Eliminar(Long ID) {
        try {
            this.RepoUsuario.Eliminar(ID);
        } catch (SQLException e) {
            throw new ServiceJDBCException(e.getMessage(), e.getCause());
        }
    }

        //Métodos de UsuarioRepositorio
    @Override
    public Optional<Usuario> Login(String nombreUsuario, String clave) {
        try {
            return Optional.ofNullable(this.RepoUsuario.PorUsername(nombreUsuario))
                    .filter(u -> u.getContraseña().equals(clave));
        } catch (SQLException e) {
            throw new ServiceJDBCException(e.getMessage(), e.getCause());
        }
    }
}
