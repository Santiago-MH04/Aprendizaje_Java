package ExpresionesLambda.Actividad.AnalizarFrases;

import javax.swing.*;
import java.util.Collections;
import java.util.Map;
import java.util.function.Supplier;

public class ActividadAnalizarFrases {
    public static void main(String[] args) {
            //Recibir la frase (JVM me tiene que proporcionar una fuente de trabajo). Ejemplo: "Hola mundo, ¿cómo estás? Soy Santiago, y estoy aprendiendo a programar en Java."
        ContadorPalabras RatónBiblioteca = Oración -> {
            //Despojar a la oración de todo signo de puntuación y dejarla en minúsculas
            Oración = Oración.replace(".", "").replace(",", "")
                    .replace(":", "").replace(";", "")
                    .replace("¡", "").replace("!", "")
                    .replace("¿","").replace("?", "")
                    .toLowerCase();

            //Crear un arreglo que almacene cada palabra, para poder contarlas
            String[] Palabras = Oración.split(" ");

            //Contar la frecuencia de palabras en la oración, y obtener la palabra que más se repite, junto con su frecuencia
            String Palabra = null;
            Integer Cantidad = 0;
            for (int i = 0; i < Palabras.length; i++){
                int Frecuencia = 0;
                for (int j = 0; j < Palabras.length; j++){
                    Frecuencia = (Palabras[i].equals(Palabras[j]))? ++Frecuencia : Frecuencia;
                }
                if(Frecuencia > Cantidad){
                    Palabra = Palabras[i];
                    Cantidad = Frecuencia;
                }
            }

            //Devolver un Map con los resultados encontrados de la frase
            return Collections.singletonMap(Palabra, Cantidad);
        };

        String Frase = "Yo ni te conozco, ni te he visto, ni sé tu nombre, ni te hablaré, ni me interesas.";
        RatónBiblioteca.CuentaPalabras(Frase).forEach((palabra, cantidad) -> System.out.println("La palabra más repetida en la frase: «" + Frase
                + "» es '" + palabra + "' con "
                + cantidad + " apariciones."));
        System.out.println();
    }
}

