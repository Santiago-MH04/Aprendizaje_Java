package ExpresionesLambda.Actividad.ComprimirStrings;

import javax.swing.*;
import java.util.function.*;

public class ActividadComprimirStrings {
    public static void main(String[] args) {
            //Recibir la frase (JVM me tiene que proporcionar una fuente de trabajo). Ejemplo: "Hola mundo, ¿cómo estás? Soy Santiago, y estoy aprendiendo a programar en Java."
        Supplier<String> ModificarFrase = () -> {
            String Mensaje = JOptionPane.showInputDialog("Inserte su frase a continuación");
            return Mensaje.replace(".", "").replace(",", "")
                    .replace("¡", "").replace("!", "")
                    .replace("¿","").replace("?", "")
                    .replace(" ", "")
                    .toUpperCase();
        };
        System.out.println(ModificarFrase.get());
    }
}
