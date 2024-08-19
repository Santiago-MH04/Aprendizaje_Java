package APIServlet.Session.Lecciones.Configs.Calificadores;

import jakarta.inject.Qualifier;

import static java.lang.annotation.ElementType.*;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Qualifier  //Aquí se decide cuál es la implementación por defecto, ahorrándonos el trabajo de anotar con @Alternative en los casos que no
@Retention(RetentionPolicy.RUNTIME)
@Target({TYPE, FIELD, CONSTRUCTOR, METHOD, PARAMETER})   //Puede inyectarse sobre cualquier elemento dentro de las llaves
public @interface ProductoServicePrincipal {
    //Atributos de ProductoServicePrincipal
    //Constructores de ProductoServicePrincipal
    //Asignadores de atributos de ProductoServicePrincipal (setters)
    //Lectores de atributos de ProductoServicePrincipal (getters)
    //Métodos de ProductoServicePrincipal
}
