package APIServlet.Session.Actividades.Actividad7_Cursos.Configs.Estereotipos;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.enterprise.inject.Stereotype;
import jakarta.inject.Named;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@ApplicationScoped
@Named  //Se deja sólo por buena práctica
@Stereotype
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
public @interface Repositoriou {
    //Atributos de Repositoriou
    //Constructores de Repositoriou
    //Asignadores de atributos de Repositoriou (setter)
    //Lectores de atributos de Repositoriou (getter)
    //Métodos de Repositoriou
}
