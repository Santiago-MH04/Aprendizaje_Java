package APIServlet.Session.Actividades;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

@WebServlet("/guardar-session")
public class GuardarNombreSesiónServlet extends HttpServlet {
    //Atributos de GuardarNombreSesiónServlet
    //Constructores de GuardarNombreSesiónServlet
    //Asignadores de atributos de GuardarNombreSesiónServlet (setter)
    //Lectores de atributos de GuardarNombreSesiónServlet (getter)
        //Métodos de GuardarNombreSesiónServlet
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String NombreUsuario = req.getParameter("nombre");

        HttpSession Sesión = req.getSession();
        Sesión.setAttribute("nombre", NombreUsuario);
            //Redirigir de la manera más elegante
        resp.sendRedirect(req.getContextPath() + "/perfil-usuario");
    }
}
