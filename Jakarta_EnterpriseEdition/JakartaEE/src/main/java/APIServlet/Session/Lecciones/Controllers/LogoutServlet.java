package APIServlet.Session.Lecciones.Controllers;

import APIServlet.Session.Lecciones.Service.*;
import jakarta.inject.Inject;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

import java.io.IOException;
import java.util.Optional;

@WebServlet({"/logout-session", "/logout-session.html"})
public class LogoutServlet extends HttpServlet {
    //Atributos de LogoutServlet
    @Inject
    private LoginService SeAutoriza;

    //Constructores de LogoutServlet
    //Asignadores de atributos de LogoutServlet (setter)
    //Lectores de atributos de LogoutServlet (getter)
        //Métodos de LogoutServlet
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        /*LoginService SeAutoriza = new LoginServiceImpl_Session();*/
        Optional<String> NombreUsuario = this.SeAutoriza.getUsername(req);

        if (NombreUsuario.isPresent()){
            HttpSession MiSesión = req.getSession();
            /*MiSesión.removeAttribute("username");*/   //Así, no se elimina la información del carrito de compras hasta no cerrar el navegador
            MiSesión.invalidate();      //Esto elimina los datos guardados de la sesión, para iniciar nuevamente
        }
        resp.sendRedirect(req.getContextPath() + "/loginSession.jsp");
    }
}
