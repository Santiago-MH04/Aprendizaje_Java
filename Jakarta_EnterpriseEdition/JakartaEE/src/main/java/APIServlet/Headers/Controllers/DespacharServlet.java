package APIServlet.Headers.Controllers;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/despachar")
public class DespacharServlet extends HttpServlet {
    //Atributos de DespacharServlet
    //Constructores de DespacharServlet
    //Asignadores de atributos de DespacharServlet (setters)
    //Lectores de atributos de DespacharServlet (getters)
        //Métodos de DespacharServlet
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        getServletContext().getRequestDispatcher("/productos.html").forward(req, resp);
            //Así, no se modifica el enlace cuando se despacha
    }
}
