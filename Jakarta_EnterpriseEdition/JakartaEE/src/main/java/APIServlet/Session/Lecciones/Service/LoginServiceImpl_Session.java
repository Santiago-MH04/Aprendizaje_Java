package APIServlet.Session.Lecciones.Service;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

import java.util.Optional;

@ApplicationScoped
public class LoginServiceImpl_Session implements LoginService {
    //Atributos de LoginServiceSessionImpl
    //Constructores de LoginServiceSessionImpl
    //Asignadores de atributos de LoginServiceSessionImpl (setters)
    //Lectores de atributos de LoginServiceSessionImpl (getters)
        //Métodos de LoginServiceSessionImpl
    @Override
    public Optional<String> getUsername(HttpServletRequest req) {
        HttpSession session = req.getSession();
        String NombreUsuario = (String)session.getAttribute("username");
        if(NombreUsuario != null){
            return Optional.of(NombreUsuario);
        }
        return Optional.empty();
    }
}
