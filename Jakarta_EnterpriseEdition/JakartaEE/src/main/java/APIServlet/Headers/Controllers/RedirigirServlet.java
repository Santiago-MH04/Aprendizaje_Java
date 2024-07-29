package APIServlet.Headers.Controllers;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/redirigir")
public class RedirigirServlet extends HttpServlet {
    //Atributos de RedirigirServlet
    //Constructores de RedirigirServlet
    //Asignadores de atributos de RedirigirServlet (setter)
    //Lectores de atributos de RedirigirServlet (getter)
        //Métodos de RedirigirServlet
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //resp.setHeader("Location", (req.getContextPath() + "/productos.html")); //Redirige la respuesta al enlace /productos.html
        //resp.setStatus(HttpServletResponse.SC_FOUND);
        resp.sendRedirect(req.getContextPath() + "/productos.html");        //Redirige la respuesta con una sola instrucción
    }
}
