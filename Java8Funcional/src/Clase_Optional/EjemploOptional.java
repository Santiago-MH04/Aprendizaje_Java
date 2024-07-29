package Clase_Optional;

import java.util.Optional;

public class EjemploOptional {
    public static void main(String[] args) {
            //Optional es un contenedor de un único elemento que permite salvar excepciones,
            // para seguir ejecutando el código
        String Nombre = "Santiago";
        Optional<String> Opt = Optional.of(Nombre);
        System.out.println("Opt: " + Opt);
        System.out.println("¿La opción " + Nombre + " se encuentra?: " + (Opt.isPresent()? "Sí" : "No"));

        if (Opt.isPresent()){
            System.out.println("Hola " + Opt.get() + ", ¿qué tal?");
        }

        System.out.println("¿La opción " + Nombre + " no se encuentra?: " + (Opt.isEmpty()? "Sí, no se encuentra" : "No, sí se encuentra"));

        Opt.ifPresent(valor -> {
            System.out.println("Hola " + valor);
        });

            //Veamos ahora redefiniendo las variables
        Nombre = null;  //"Juanito Alimaña"
            //Opt = Optional.of(Nombre);      //Para evitar arrojar la excepción, usar la interfaz Nullable
        Opt = Optional.ofNullable(Nombre);
        System.out.println("Opt: " + Opt);
        System.out.println("Opt.isEmpty(): " + (Opt.isEmpty()? "vacío" : "no vacío"));
        System.out.println("Opt.isPresent(): " + (Opt.isPresent()? "No está vacío" : "Está vacío"));

        Opt.ifPresent(valor -> System.out.println("Hola " + valor));    //En este caso, no se debería ejecutar

            //Maneras de representar una dualidad con el método ifPresent()
                //Java 9
        Opt.ifPresentOrElse(valor -> System.out.println("Hola " + valor),
                () -> System.out.println("El valor deseado no se encuentra presente"));
                //Otra manera
        if (Opt.isPresent()){
            System.out.println("Hola " + Opt.get() + ", ¿qué tal?");
        } else {
            System.out.println("El valor deseado no se encuentra presente");
        }

            //Creando opcionales vacíos
        Optional<String> OptEmpty = Optional.empty();
        // Optional<String> OptEmpty = Optional.of(null);
        System.out.println("OptEmpty = " + OptEmpty);
        System.out.println(OptEmpty.isPresent());
    }
}
