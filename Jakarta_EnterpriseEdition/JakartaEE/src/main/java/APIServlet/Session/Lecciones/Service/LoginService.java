package APIServlet.Session.Lecciones.Service;

import jakarta.servlet.http.HttpServletRequest;

import java.util.Optional;

public interface LoginService {
    //Atributos de LoginService
    //Constructores de LoginService
    //Asignadores de atributos de LoginService (setter)
    //Lectores de atributos de LoginService (getter)
        //Métodos de LoginService
    Optional<String> getUsername(HttpServletRequest req);
}
