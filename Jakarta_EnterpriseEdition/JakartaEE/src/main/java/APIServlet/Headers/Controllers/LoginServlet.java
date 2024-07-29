package APIServlet.Headers.Controllers;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
    //Atributos de LoginServlet
    final static String USERNAME = "admin";
    final static String PASSWORD = "12345";

    //Constructores de LoginServlet
    //Asignadores de atributos de LoginServlet (setter)
    //Lectores de atributos de LoginServlet (getter)
        //Métodos de LoginServlet
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String NombreUsuario = req.getParameter("username");
        String Contraseña = req.getParameter("password");

        if(USERNAME.equals(NombreUsuario) && PASSWORD.equals(Contraseña)){
            resp.setContentType("text/html;charset=UTF-8");
            try (PrintWriter out = resp.getWriter()) {    //Con el try-catch, el recurso se cierra automáticamente
                out.println("<!DOCTYPE html>");
                out.println("<html>");            //Siempre que se abre, se cierra
                out.println("    <head>");
                out.println("         <meta charset = \"UTF-8\">");
                out.println("         <title>Ingreso correcto</title>");
                out.println("    </head>");
                out.println("    <body>");
                out.println("       <h1>Ingreso correcto</h1>");
                out.println("       <h3>Hola " + NombreUsuario + ". Has iniciado sesión con éxito</h3>");
                out.println("    </body>");
                out.println("</html>");           //Se cierra porque se abrió

                //out.close();    //No es tan necesario cerrar el recurso, sólo por buenas prácticas
            }
        } else {
            resp.sendError(HttpServletResponse.SC_UNAUTHORIZED, "Lo sentimos, no está autorizado a ingresar con las credenciales usadas");
        }
    }
}
