package APIServlet.Cookie.Lecciones.Controllers;

import APIServlet.Cookie.Lecciones.Service.LoginService;
import APIServlet.Cookie.Lecciones.Service.LoginServiceImpl;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.Optional;

@WebServlet({"/logout-cookie", "/logout-cookie.html"})
public class LogoutServlet extends HttpServlet {
    //Atributos de LogoutServlet
    //Constructores de LogoutServlet
    //Asignadores de atributos de LogoutServlet (setter)
    //Lectores de atributos de LogoutServlet (getter)
        //Métodos de LogoutServlet
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        LoginService SeAutoriza = new LoginServiceImpl();
        Optional<String> NombreUsuario = SeAutoriza.getUsername(req);

        if (NombreUsuario.isPresent()){
            Cookie UsernameCookie = new Cookie("username", "");
            UsernameCookie.setMaxAge(0);    //Así se elimina una cookie, asignándole una vida máxima de 0s
            resp.addCookie(UsernameCookie);
        }
        resp.sendRedirect(req.getContextPath() + "/login-cookie.html");
    }
}
