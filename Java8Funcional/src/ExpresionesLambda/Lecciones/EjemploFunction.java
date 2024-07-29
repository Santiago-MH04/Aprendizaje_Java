package ExpresionesLambda.Lecciones;

import java.util.function.BiFunction;
import java.util.function.Function;

public class EjemploFunction {
    public static void main(String[] args) {

        Function<String, String> F1 = (String parámetro) -> {   //Function<Argumento, Resultado> Recordar que siempre se puede simplificar
            return "Hola, ¿qué tal?" + parámetro;
        };
        String Resultado = F1.apply(" Trenzas por el octavo mundial");     //En los Consumer: accept, en los Supplier: get y en los Function: apply
        System.out.println(Resultado);

        Function<String, String> F2 = argumento -> argumento.toUpperCase(); //Versión extendida
        System.out.println(F2.apply("Estudiando expresiones lambda"));

        Function<String, String> F3 = String::toUpperCase;  //Versión resumida
        System.out.println(F3.apply("En volandas a aprender"));

        BiFunction<String, String, String> F4 = (a, b) -> a.toUpperCase().concat(b.toUpperCase());
        System.out.println(F4.apply("hola, " , "¿cómo estás?"));

        BiFunction<String, String, Integer> F5 = (a, b) -> a.compareTo(b);
        System.out.println(F5.apply("Concha de ", "la lora"));
    }
}
