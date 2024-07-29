package APIServlet.Session.Lecciones.Filters;

import APIServlet.Session.Lecciones.Service.*;
import jakarta.inject.Inject;
import jakarta.servlet.*;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.Optional;

@WebFilter({"/carrito/*", "/productos/*", "/usuarios/*"})    //Este sí debe incluir las rutas donde se ejecuta (con las expresiones regulares)
public class LoginFiltro implements Filter {  //Todas las rutas que implementan  Filter se vuelven «privadas», y en cada request vuelve y se implementan los filter y listeners
        //Atributos de LoginFiltro
    @Inject
    private LoginService SeAutoriza;    //Qué forma tan chévere de aplicar un guardián

    //Constructores de LoginFiltro
    //Asignadores de atributos de LoginFiltro (setter)
    //Lectores de atributos de LoginFiltro (getter)
        //Métodos de LoginFiltro (el método doFilter se ejecuta una vez por cada request)
            //Se ejecuta antes y después que los métodos del Servlet. Siempre orientado a una petición
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        /*LoginService SeAutoriza = new LoginServiceImpl_Session();*/
        Optional<String> NombreUsuario = this.SeAutoriza.getUsername((HttpServletRequest)servletRequest);

            //Filtrar si encuentra el nombre de usuario
        if (NombreUsuario.isPresent()){
            filterChain.doFilter(servletRequest, servletResponse);
        } else {    //Enviar error de autorización si no lo encuentra
            ((HttpServletResponse)servletResponse).sendError(HttpServletResponse.SC_UNAUTHORIZED,       //Por tratarse de objetos más genéricos, se debe realizar el cast
                    "Lo sentimos, no tienes autorización para entrar en la página. Primero debes iniciar sesión");
        }
    }
}
