package ExpresionesLambda.Lecciones.Aritmética;

import java.util.function.BiFunction;

public class Calculadora {
    //Atributos de Calculadora
    //Constructores de Calculadora
    //Asignadores de atributos de Calculadora (setter)
    //Lectores de atributos de Calculadora (getter)
        //Métodos de Calculadora
    public double Calcular (double a, double b, Aritmética lambda){
        return lambda.Operando(a, b);
    }
    public double CalculandoBiFunction (double a, double b, BiFunction<Double, Double, Double> lambda){
        return lambda.apply(a, b);
    }
}
