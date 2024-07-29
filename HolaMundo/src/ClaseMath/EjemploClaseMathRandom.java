package ClaseMath;

import java.lang.reflect.Method;
import java.util.Random;

public class EjemploClaseMathRandom {
    public static void main(String[] args) {

        String[] losColores = {"amarillo", "azul", "rojo", "verde", "violeta", "naranja", "blanco", "negro"};
        double  random = Math.random();
        System.out.println("random = " + random);

        random *= losColores.length;
        System.out.println("random = " + random);

        random = Math.floor(random);
        System.out.println("random = " + random);
        System.out.println("El color de esta ocasión es = " + losColores[(int)random] + "\n");


            //Clase Random para crear números aleatorios de cualquier tipo, pues el método random sólo crea primitivos tipo double en el intervalo [0,1]
        Random objRan = new Random();
        int ranInt = 15 + objRan.nextInt(10+1); //El argumento es el intervalo, contando desde 0 hasta n-1
        System.out.println("ranInt = " + ranInt);

        ranInt = objRan.nextInt(losColores.length);
        System.out.println("ranInt = " + ranInt);
        System.out.println("Ahora, el color es = " + losColores[ranInt] + "\n");

            //Obtener los métodos de la clase Math
        Class ClaseMath = Math.class;

        for (Method unMéthode : ClaseMath.getMethods()){
            System.out.println("Método " + unMéthode + " = " + unMéthode.getName());
        }
    }
}
