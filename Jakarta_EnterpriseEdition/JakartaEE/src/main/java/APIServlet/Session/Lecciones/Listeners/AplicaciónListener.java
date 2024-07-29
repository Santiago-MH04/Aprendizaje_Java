package APIServlet.Session.Lecciones.Listeners;

import APIServlet.Session.Lecciones.Models.*;
import jakarta.servlet.*;
import jakarta.servlet.annotation.WebListener;
import jakarta.servlet.http.HttpSession;
import jakarta.servlet.http.HttpSessionEvent;
import jakarta.servlet.http.HttpSessionListener;

@WebListener    //No es obligatorio que lleve una anotación, pero se puede, por buena práctica
public class AplicaciónListener implements ServletContextListener ,
        ServletRequestListener , HttpSessionListener {
        //Atributos de AplicaciónListener
    private ServletContext servletContext;
    //Constructores de AplicaciónListener
    //Asignadores de atributos de AplicaciónListener (setter)
    //Lectores de atributos de AplicaciónListener (getter)
        //Métodos de AplicaciónListener
            //Métodos de ServletContextListener
            //Tienen el alcance de todo el contexto (aplicación), no sólo del request, o la sesión
    @Override
    public void contextInitialized(ServletContextEvent sce) {
        sce.getServletContext().log("Iniciando la aplicación");
        this.servletContext = sce.getServletContext();
        this.servletContext.setAttribute("mensaje", "Algún mensaje global de la aplicación");
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        this.servletContext.log("Destruyendo la aplicación");
    }

        //Métodos de ServletRequestListener
            //Sólo tienen el alcance del request, no son globales
    @Override
    public void requestInitialized(ServletRequestEvent sre) {
        this.servletContext.log("Iniciando el request");
        sre.getServletRequest().setAttribute("mensaje", "Guardando valor del request");
        sre.getServletRequest().setAttribute("titulum", "Catálogo Servlet");

            //Para la actividad 5
        sre.getServletRequest().setAttribute("nombre-completo", "Quesocolo, dúo dinámico");
    }

    @Override
    public void requestDestroyed(ServletRequestEvent sre) {
        this.servletContext.log("Destruyendo el request");
    }

        //Métodos de HttpSessionListener
    @Override
    public void sessionCreated(HttpSessionEvent se) {
        this.servletContext.log("Iniciando la sesión HTTP");
            //Se puede hacer algo aquí en cuanto se inicia sesión, como crear el carrito

        /*Carrito Carro = new Carrito();*/      //Creando el carrito
        /*HttpSession Sesión = se.getSession();*/ //Obteniendo la sesión                //En CDI, se puede manejar todo esto de forma programática
        /*Sesión.setAttribute("carrito", Carro);*/  //Asignar un atributo carrito a la sesión


        //La existencia del atributo carrito en la sesión se garantiza siempre, al inyectarse su contexto con la
        // anotación @SessionScoped
    }

    @Override
    public void sessionDestroyed(HttpSessionEvent se) {
        this.servletContext.log("Destruyendo la sesión HTTP");
            //Se puede hacer algo aquí en cuanto se cierra sesión
    }
}
