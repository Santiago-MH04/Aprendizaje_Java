package APIServlet.Session.Lecciones.Service;

import APIServlet.Session.Lecciones.Models.Usuario;

import java.util.List;
import java.util.Optional;

public interface UsuarioService {
    //Atributos de UsuarioService
    //Constructores de UsuarioService
    //Asignadores de atributos de UsuarioService (setter)
    //Lectores de atributos de UsuarioService (getter)
    //Métodos de UsuarioService
        //Métodos de Repositorio
    List<Usuario> ListarUsuarios();
    Optional<Usuario> PorID(Long ID);
    void Guardar (Usuario usuario);
    void Eliminar (Long ID);
        //Métodos de UsuarioRepositorio
    Optional<Usuario> Login (String nombreUsuario, String clave);
}
