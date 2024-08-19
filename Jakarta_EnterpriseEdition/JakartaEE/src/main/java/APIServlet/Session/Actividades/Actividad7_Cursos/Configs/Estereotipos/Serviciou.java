package APIServlet.Session.Actividades.Actividad7_Cursos.Configs.Estereotipos;

import APIServlet.Session.Actividades.Actividad7_Cursos.Interceptores.LoggingAct;
import APIServlet.Session.Actividades.Actividad7_Cursos.Interceptores.TransaccionalAct;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.enterprise.inject.Stereotype;
import jakarta.inject.Named;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
@TransaccionalAct
@LoggingAct
@ApplicationScoped
@Stereotype
@Named  //Se deja sólo por buena práctica
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
public @interface Serviciou {
    //Atributos de Serviciou
    //Constructores de Serviciou
    //Asignadores de atributos de Serviciou (setter)
    //Lectores de atributos de Serviciou (getter)
    //Métodos de Serviciou
}
