package APIServlet.Session.Lecciones.Configs.Estereotipos;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.enterprise.inject.Stereotype;
import jakarta.inject.Named;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.RetentionPolicy.RUNTIME;

@ApplicationScoped
@Named
@Stereotype //Agrupa varias anotaciones (mostradas arriba) bajo esta etiqueta
@Retention(RUNTIME) //Va a aplicar durante tiempo de ejecución
@Target(ElementType.TYPE)   //Se aplica sobre las clases
public @interface Repository {
    //Atributos de Repository
    //Constructores de Repository
    //Asignadores de atributos de Repository (setters)
    //Lectores de atributos de Repository (getters)
    //Métodos de Repository
}
