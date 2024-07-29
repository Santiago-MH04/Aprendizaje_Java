package ExpresionesLambda.Actividad.AnalizarFrases;

import java.util.Map;

@FunctionalInterface
public interface ContadorPalabras {
    Map<String, Integer> CuentaPalabras(String Frase);
}
