package APIServlet.Session.Lecciones.Filters;


import APIServlet.Session.Lecciones.Service.LoginService;
import APIServlet.Session.Lecciones.Service.LoginServiceImpl_Session;
import jakarta.servlet.*;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.Optional;

@WebFilter({"/carrito/*", "/productos/*", "/usuarios/*"})
public class LoginFiltro implements Filter {    //Los filtros actúan únicamente en el contexto del request
    //Atributos de LoginFiltro
    //Constructores de LoginFiltro
    //Asignadores de atributos de LoginFiltro (setters)
    //Lectores de atributos de LoginFiltro (getters)
        //Métodos de LoginFiltro
    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        LoginService SeAutoriza = new LoginServiceImpl_Session();
        Optional<String> NombreUsuario = SeAutoriza.getUsername((HttpServletRequest)request);

            //Filtrar si encuentra el nombre de usuario
        if (NombreUsuario.isPresent()){
            chain.doFilter(request, response);
        } else {    //Enviar error de autorización si no lo encuentra
            ((HttpServletResponse)response).sendError(HttpServletResponse.SC_UNAUTHORIZED,       //Por tratarse de objetos más genéricos, se debe realizar el cast
                    "Lo sentimos, no tienes autorización para entrar en la página. Primero debes iniciar sesión");
        }
    }
}
