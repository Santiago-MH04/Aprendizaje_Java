package APIServlet.Session.Lecciones.Service;

import APIServlet.Session.Lecciones.Models.Usuario;

import java.util.List;
import java.util.Optional;

public interface UsuarioService {
    //Atributos de UsuarioService
    //Constructores de UsuarioService
    //Asignadores de atributos de UsuarioService (setters)
    //Lectores de atributos de UsuarioService (getters)
        //Métodos de UsuarioService
            //Métodos de Repositorio
    List<Usuario> ListarUsuarios();
    Optional<Usuario> PorID(Long id);
    void Guardar (Usuario usuario);
    void Eliminar (Long id);
            //Métodos de UsuarioRepositorio
    Optional<Usuario> Login (String nombreUsuario, String clave);
}
