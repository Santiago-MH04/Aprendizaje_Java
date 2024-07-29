package ClaseMath;

public class EjemploClaseMath {
    public static void main(String[] args) {
            //Valor absoluto
        double absoluto = Math.abs(-25.32);
        System.out.println("absoluto = " + absoluto);

            //Potenciación
        double pot_ = 10^3;         // El operador ^ (XOR) = (a & !B) || (!a & B)
        double _pot_ = Math.pow(10,3);
        System.out.println("pot_ = " + pot_);
        System.out.println("_pot_ = " + _pot_);

            //Funciones trigonométricas
        double senpi2 = Math.sin((Math.PI)/2);
        System.out.println("sen(\u03c0/2) = " + senpi2);
    }
}

