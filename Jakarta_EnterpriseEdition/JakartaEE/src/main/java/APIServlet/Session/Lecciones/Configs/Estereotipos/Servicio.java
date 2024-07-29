package APIServlet.Session.Lecciones.Configs.Estereotipos;

import APIServlet.Session.Lecciones.Interceptores.Logging;
import APIServlet.Session.Lecciones.Interceptores.TransaccionalJDBC;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.enterprise.inject.Stereotype;
import jakarta.inject.Named;

import static java.lang.annotation.ElementType.*;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@TransaccionalJDBC
@Logging
@ApplicationScoped
@Named
@Stereotype //Sirve para agrupar a las anotaciones encima de la indicación de estereotipo
@Retention(RetentionPolicy.RUNTIME)
@Target(TYPE) //Así, podremos ingresar al log de Tomcat en cada clase cuándo se ejecute cada método que lleva esta anotación
public @interface Servicio {
    //Atributos de Servicio
    //Constructores de Servicio
    //Asignadores de atributos de Servicio (setter)
    //Lectores de atributos de Servicio (getter)
    //Métodos de Servicio
}
