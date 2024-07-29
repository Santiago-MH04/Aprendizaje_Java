package API_Stream.Actividad;

import java.util.Arrays;
import java.util.Random;
import java.util.function.Function;

public class ActividadNúmeroMayor {
    public static void main(String[] args) {
            //Crear function tal que devuelva el número mayor
        Function<Integer[], Integer> Medidor = vector -> Arrays.stream(vector)   //Se crea el Stream, para no operar con
                // flujos de control
                .peek(System.out::println)
                .reduce(0, (a, b) -> (a > b)? a : b);                     //Se reduce a un único elemento

            //Aplicar la función Medidor
        System.out.println("El número mayor de este arreglo de enteros es: " + Medidor.apply(CreandoAndo.CrearArreglo()));
    }

    public static class CreandoAndo{
            //Atributos de CreandoAndo
        private static Integer[] Arreglo;

        //Constructores de CreandoAndo
        //Asignadores de atributos de CreandoAndo (setter)
        //Lectores de atributos de CreandoAndo (getter)
            //Métodos de CreandoAndo
        public static Integer[] CrearArreglo(){
                //Crear un arreglo arbitrario de números enteros
            Random Tamaño = new Random();
            int DimArreglo = Math.abs(Tamaño.nextInt(100 + 1));
            Arreglo = new Integer[DimArreglo];

                //Poblar el arreglo
            for(int i = 0; i < Arreglo.length; i++){
                Arreglo[i] = Tamaño.nextInt(100 + 1);
            }
            return Arreglo;
        }
    }






}
