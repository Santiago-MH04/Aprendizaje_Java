package Anotaciones;

import java.lang.annotation.*;

//Una anotación es una configuración, o metadata, o decoraciones
@Documented                             //Por si se quiere agregar a la API Doc
@Target(ElementType.FIELD)              //Objetivo: el «objetivo» de esta anotación es el conjunto de los atributos
@Retention(RetentionPolicy.RUNTIME)     //Contexto: significa que va a actuar sobre el «objetivo» en tiempo de ejecución
public @interface JSON_Atributo {
    //Las anotaciones también cuentan con «atributos»
    //Atributos de JSON_Atributo (se inician como clases)
    String Nombre() default "";
    boolean Capitalizar() default false;

    //Constructores de JSON_Atributo
    //Asignadores de atributos de JSON_Atributo (setter)
    //Lectores de atributos de JSON_Atributo (getter)
    //Métodos de JSON_Atributo
}
