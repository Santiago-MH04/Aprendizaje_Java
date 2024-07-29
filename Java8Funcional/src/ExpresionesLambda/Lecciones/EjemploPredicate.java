package ExpresionesLambda.Lecciones;

import ExpresionesLambda.Lecciones.Modelo.*;

import java.util.function.BiPredicate;
import java.util.function.Predicate;

public class EjemploPredicate {
    public static void main(String[] args) {

        Predicate<Integer> Prueba = Número -> Número > 10;  //Predicate siempre devuelve un boolean
        boolean Pe = Prueba.test(12);
        System.out.println((Pe)? "Sí" : "No");

        Predicate<String> Prueba2 = role -> role.equals("ROLE_ADMIN");
        boolean Pe2 = Prueba2.test("ROLE_USER");
        System.out.println("Pe2 = " + Pe2);

        BiPredicate<String, String> Prueba3 = (a, b) -> a.equals(b);
        boolean Pe3 = Prueba3.test("Colínsaurio", "Colínsaurio");
        System.out.println("Pe3 = " + Pe3);

        BiPredicate<Integer, Integer> Prueba4 = (i, j) -> j > i;
        boolean Pe4 = Prueba4.test(4, 2);
        System.out.println("Pe4 = " + Pe4);

        Usuario A = new Usuario("Quesozuelos");
        Usuario B = new Usuario("Colínsaurio");
        BiPredicate<Usuario, Usuario> Prueba5 = (Usuario a, Usuario b) -> a.getNombre().equals(b.getNombre());
        boolean Pe5 = Prueba5.test(A, B);
        System.out.println("Pe5 = " + Pe5);
    }
}