package APIServlet.Session.Lecciones.Service;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

import java.util.Arrays;
import java.util.Optional;
@ApplicationScoped
public class LoginServiceImpl_Session implements LoginService {
    //Atributos de LoginServiceImpl_Session
    //Constructores de LoginServiceImpl_Session
    //Asignadores de atributos de LoginServiceImpl_Session (setter)
    //Lectores de atributos de LoginServiceImpl_Session (getter)
        //Métodos de LoginService
    @Override
    public Optional<String> getUsername(HttpServletRequest req) {
        HttpSession Sesión = req.getSession();
        String NombreUsuario = (String)Sesión.getAttribute("username");
        if (NombreUsuario != null){
            return Optional.of(NombreUsuario);
        }
        return Optional.empty();
    }
}
