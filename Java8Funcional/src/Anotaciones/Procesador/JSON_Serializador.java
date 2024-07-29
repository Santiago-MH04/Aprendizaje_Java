package Anotaciones.Procesador;

import Anotaciones.Init;
import Anotaciones.JSON_Atributo;
import Anotaciones.Procesador.Exception.*;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.Objects;
import java.util.stream.Collectors;

public class JSON_Serializador {
    //Atributos de JSON_Serializador
    //Constructores de JSON_Serializador
    //Asignadores de atributos de JSON_Serializador (setter)
    //Lectores de atributos de JSON_Serializador (getter)

        //Métodos de JSON_Serializador.
    public static void IniciarObjeto(Object objeto){
        //Gestionar posibles errores
        if(Objects.isNull(objeto)){
            throw new JSON_SerializadorException("El objeto a serializar no puede ser nulo en atributos ni métodos");
        }
            //Obtener los métodos del objeto y ejecutarlos
        Method[] Métodos = objeto.getClass().getDeclaredMethods();
        Arrays.stream(Métodos)
                .filter(m -> m.isAnnotationPresent(Init.class))
                .forEach(m -> {
                    m.setAccessible(true);                                                  //Para evitar la aparición de errores de acceso
                    try {
                        m.invoke(objeto);
                    } catch (IllegalAccessException | InvocationTargetException e) {
                        throw new JSON_SerializadorException("Error al serializar, no se puede iniciar el objeto " + e.getMessage());
                    }
                });
    }
    public static String ConvertirJSON(Object objeto){
            //Gestionar posibles errores
        if(Objects.isNull(objeto)){
            throw new JSON_SerializadorException("El objeto a serializar no puede ser nulo");
        }
            //Iniciar y obtener los atributos del objeto
        IniciarObjeto(objeto);
        Field[] Atributos = objeto.getClass().getDeclaredFields();

            //Transformar los atributos del JSON. Obtenerlos y funcionar en un Stream
        return Arrays.stream(Atributos)                                            //Obtener los atributos decorados
                .filter(a -> a.isAnnotationPresent(JSON_Atributo.class))
                .map(a -> {
                    try {
                        a.setAccessible(true);                                              //Para evitar la aparición de errores de acceso
                        Object Valor = a.get(objeto);
                        if(a.getAnnotation(JSON_Atributo.class).Capitalizar()
                                && Valor instanceof String){
                            String NuevoValor = (String) Valor;
                            NuevoValor = Arrays.stream(NuevoValor.split(" "))
                                    .map(palabra -> palabra.substring(0,1).toUpperCase() + //Otra forma sería String.valueOf(palabra.charAt(0)).toUpperCase()
                                            palabra.substring(1).toLowerCase())
                                    .collect(Collectors.joining(" "));
                            a.set(objeto, NuevoValor);
                        }
                        String Nombre = a.getAnnotation(JSON_Atributo.class).Nombre().equals("")
                                ? a.getName() : a.getAnnotation(JSON_Atributo.class).Nombre();
                        return "\"" + Nombre + "\":\"" + a.get(objeto) + "\"";                        //Este método get() exige usar try/catch
                    } catch (IllegalAccessException e) {
                        throw new JSON_SerializadorException("Error al serializar el JSON: " + e.getMessage());
                    }
                })
                .reduce("{", (a, b) -> {
                    //Para dar la estructura de JSON
                    if ("{".equals(a)){
                        return a + b;
                    } return a + ", " + b;
                }).concat("}");
    }
}
