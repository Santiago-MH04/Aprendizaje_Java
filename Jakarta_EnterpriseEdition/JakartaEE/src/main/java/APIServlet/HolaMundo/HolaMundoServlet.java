package APIServlet.HolaMundo;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/Hola-mundo")
public class HolaMundoServlet extends HttpServlet {
    //Atributos de HolaMundoServlet
    //Constructores de HolaMundoServlet
    //Asignadores de atributos de HolaMundoServlet (setter)
    //Lectores de atributos de HolaMundoServlet (getter)
        //Métodos de HolaMundoServlet
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        response.setContentType("text/html"); //Método aplicado sobre el objeto de la respuesta
        PrintWriter out = response.getWriter();
            out.println("<!DOCTYPE html>");
            out.println("<html>");            //Siempre que se abre, se cierra
            out.println("    <head>");
            out.println("         <meta charset = \"UTF-8\">");
            out.println("         <title>Hola mundo Servlet</title>");
            out.println("    </head>");
            out.println("    <body>");
            out.println("    <h1>¡Hola mundo, Servlet!</h1>");
            out.println("    </body>");
            out.println("</html>");           //Se cierra porque se abrió
        out.close();    //No es tan necesario cerrar el recurso, sólo por buenas prácticas
    }
}
