package POO_Excepciones;

public class Calculadora {
    //Atributos de Calculadora
    //Constructores de Calculadora
    //Asignadores de atributos de Calculadora (setter)
    //Lectores de atributos de Calculadora (getter)
        //Métodos de Calculadora
    public double dividir(int numerador, int denominador) throws DivisiónPorCeroException {
        if (denominador == 0){
            throw new DivisiónPorCeroException("La división por cero está indeterminada");
        }
        return numerador/(double)denominador;
    }
    public double dividir(String numerador, String denominador)
            throws DivisiónPorCeroException, FormatoNúmeroException {
        try{
            int num = Integer.parseInt(numerador);
            int den = Integer.parseInt(denominador);
            return this.dividir(num, den);
        } catch (NumberFormatException e){
            throw new FormatoNúmeroException("El numerador y el denominador deben ser números enteros");
        }
    }
}
