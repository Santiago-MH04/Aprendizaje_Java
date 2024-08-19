package APIServlet.Session.Lecciones.Controllers;

import APIServlet.Session.Lecciones.Models.Usuario;
import APIServlet.Session.Lecciones.Service.LoginService;
import APIServlet.Session.Lecciones.Service.LoginServiceImpl_Session;
import APIServlet.Session.Lecciones.Service.UsuarioService;
import jakarta.inject.Inject;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

@WebServlet("/usuarios-session")
public class UsuarioServlet extends HttpServlet {
        //Atributos de UsuarioServlet
    @Inject
    private UsuarioService Service;
    //Constructores de UsuarioServlet
    //Asignadores de atributos de UsuarioServlet (setters)
    //Lectores de atributos de UsuarioServlet (getters)
        //Métodos de UsuarioServlet

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
            //Obtener la conexión
        /*Connection Conn = (Connection)req.getAttribute("conn");*/
        /*UsuarioService Service = new UsuarioServiceJDBCImpl(Conn);*/
            //Obtener la lista de usuarios
        List<Usuario> ListaUsuarios = this.Service.ListarUsuarios();

        LoginService SeAutoriza = new LoginServiceImpl_Session();
        Optional<String> UsuarioSessionOptional = SeAutoriza.getUsername(req);

            //Configurar los atributos que se dirijan a la vista
        req.setAttribute("usuarios", ListaUsuarios);
        req.setAttribute("username", UsuarioSessionOptional);
        req.setAttribute("titulum", req.getAttribute("titulum") + ": listado de usuarios");

            //Redirigir a la vista de los usuarios actualizada
        getServletContext().getRequestDispatcher("/listar_usuarios.jsp").forward(req, resp);
    }
}
