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
import java.io.PrintWriter;
import java.util.Optional;

@WebServlet({"/login-cookie", "/login-cookie.html"})
public class LoginServlet extends HttpServlet {
        //Atributos de LoginServlet
    final static String USERNAME = "Quesocolo";
    final static String PASSWORD = "Churus1529*";

    //Constructores de LoginServlet
    //Asignadores de atributos de LoginServlet (setter)
    //Lectores de atributos de LoginServlet (getter)
        //Métodos de LoginServlet
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        LoginService SeAutoriza = new LoginServiceImpl();
        Optional<String> CookieOptional = SeAutoriza.getUsername(req);

        if (CookieOptional.isPresent()){
            resp.setContentType("text/html;charset=UTF-8");
            try (PrintWriter out = resp.getWriter()) {    //Con el try-catch, el recurso se cierra automáticamente
                out.println("<!DOCTYPE html>");
                out.println("<html>");            //Siempre que se abre, se cierra
                out.println("    <head>");
                out.println("         <meta charset = \"UTF-8\">");
                out.println("         <title>Hola " + CookieOptional.get() + "</title>");
                out.println("    </head>");
                out.println("    <body>");
                out.println("       <h1>Hola " + CookieOptional.get() + ". Has iniciado sesión exitosamente</h1>");
                out.println("<p><a href=" + req.getContextPath() + "/index.html>Volver</a></p>");
                out.println("<p><a href=" + req.getContextPath() + "/logout-cookie.html>Cerrar sesión</a></p>");
                out.println("    </body>");
                out.println("</html>");           //Se cierra porque se abrió

                //out.close();    //No es tan necesario cerrar el recurso, sólo por buenas prácticas
            }
        } else {
            getServletContext().getRequestDispatcher("/loginCookie.jsp").forward(req, resp);    //Tener varias direcciones parece ser la solución
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String NombreUsuario = req.getParameter("username");
        String Contraseña = req.getParameter("password");

        if(USERNAME.equals(NombreUsuario) && PASSWORD.equals(Contraseña)){
            Cookie UsernameCookie = new Cookie("username", NombreUsuario);
            resp.addCookie(UsernameCookie);
                //Para ahorrar código y no confundir al usuario
            resp.sendRedirect(req.getContextPath() + "/login-cookie.html");
        } else {
            resp.sendError(HttpServletResponse.SC_UNAUTHORIZED, "Lo sentimos, no está autorizado a ingresar con las credenciales usadas");
        }
    }
}
