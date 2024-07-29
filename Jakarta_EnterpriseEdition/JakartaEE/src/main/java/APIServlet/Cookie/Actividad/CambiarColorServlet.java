package APIServlet.Cookie.Actividad;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/cambiar-color")
public class CambiarColorServlet extends HttpServlet {
    //Atributos de CambiarColorServlet
    //Constructores de CambiarColorServlet
    //Asignadores de atributos de CambiarColorServlet (setter)
    //Lectores de atributos de CambiarColorServlet (getter)
        //Métodos de CambiarColorServlet
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String ColorTexto = req.getParameter("color");

        Cookie ColorCookie = new Cookie("color", ColorTexto);
        resp.addCookie(ColorCookie);
        resp.sendRedirect(req.getContextPath() + "/index.jsp");  //Para que el color cambie de una
    }
}
