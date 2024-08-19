package APIServlet.Session.Lecciones.Controllers;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/carrito/ver")
public class VerCarritoServlet extends HttpServlet {
    //Atributos de VerCarritoServlet
    //Constructores de VerCarritoServlet
    //Asignadores de atributos de VerCarritoServlet (setters)
    //Lectores de atributos de VerCarritoServlet (getters)
        //Métodos de VerCarritoServlet
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("titulum", req.getAttribute("titulum") + ": carrito de compras");
        getServletContext().getRequestDispatcher("/carrito.jsp").forward(req, resp);
    }
}
