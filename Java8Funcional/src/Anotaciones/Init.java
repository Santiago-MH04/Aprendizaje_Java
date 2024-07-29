package Anotaciones;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface Init {
    //Atributos de Init
    //Constructores de Init
    //Asignadores de atributos de Init (setter)
    //Lectores de atributos de Init (getter)
    //Métodos de Init
}
