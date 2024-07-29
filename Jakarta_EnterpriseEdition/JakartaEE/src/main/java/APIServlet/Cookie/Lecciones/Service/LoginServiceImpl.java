package APIServlet.Cookie.Lecciones.Service;

import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;

import java.util.Arrays;
import java.util.Optional;

public class LoginServiceImpl implements LoginService {
    //Atributos de LoginService
    //Constructores de LoginService
    //Asignadores de atributos de LoginService (setter)
    //Lectores de atributos de LoginService (getter)
        //Métodos de LoginService
    @Override
    public Optional<String> getUsername(HttpServletRequest req) {
        Cookie[] Cookies = req.getCookies() != null ? req.getCookies() : new Cookie[0];
        return Arrays.stream(Cookies)
                .filter(c -> "username".equals(c.getName()))
                .map(Cookie::getValue)
                .findAny();
    }
}
