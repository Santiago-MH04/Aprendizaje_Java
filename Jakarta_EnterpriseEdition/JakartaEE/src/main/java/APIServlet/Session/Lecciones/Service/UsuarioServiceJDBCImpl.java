package APIServlet.Session.Lecciones.Service;

import APIServlet.Session.Lecciones.Configs.Calificadores.*;
import APIServlet.Session.Lecciones.Configs.Estereotipos.*;
import APIServlet.Session.Lecciones.Models.*;

import APIServlet.Session.Lecciones.Repositorios.*;

import jakarta.inject.Inject;

import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

/*@ApplicationScoped*/  //Lo que es único por cada request es una conexión
@Servicio   //Ya va a ser transaccional
public class UsuarioServiceJDBCImpl implements UsuarioService{
        //Atributos de UsuarioServiceImpl
    private UsuarioRepositorio RepoUsuario;

        //Constructores de UsuarioServiceImpl
    /*public UsuarioServiceJDBCImpl(Connection connection) {
        this.RepoUsuario = new UsuarioRepositorioJDBCImpl(connection);
    }*/
    @Inject     //No hay que aclarar el nombre porque UsuarioRepositorioJDBCImpl es la única clase que implementa UsuarioRepositorio
    public UsuarioServiceJDBCImpl(UsuarioRepositorio usuarioRepositorio) {
        this.RepoUsuario = usuarioRepositorio;
    }

    //Asignadores de atributos de UsuarioServiceImpl (setter)
    //Lectores de atributos de UsuarioServiceImpl (getter)

        //Métodos de UsuarioServiceImpl
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
