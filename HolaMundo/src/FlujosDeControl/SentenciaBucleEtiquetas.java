package FlujosDeControl;

public class SentenciaBucleEtiquetas {
    public static void main(String[] args) {

        String miFrase = "tres tristes tigres tragan trigo en un trigal";
        String miPalabra = "trigo";

        int maxPalabra = miPalabra.length();
        int maxFrase = miFrase.length() - maxPalabra;

        int miCantidad = 0;

        buscar:
        for (int i = 0; i <= maxFrase;/*i++*/){
            int k = i;
            for (int j = 0; j < maxPalabra; j++){
                if (miFrase.charAt(k++) != miPalabra.charAt(j)){
                    i++;
                    continue buscar;
                }
            }
            miCantidad++;
            i = i + maxPalabra;
        }
        String elCardinal = (miCantidad == 1)? "vez": "veces";
        System.out.println("La palabra " + miPalabra + " se ha encontrado " + miCantidad + " " + elCardinal + " en la frase.");
    }
}
