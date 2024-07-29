package Variables;

public class SistemasNuméricos {
    public static void main(String[] args) {

        int RepresentaciónDecimal = 500;
        System.out.println("RepresentaciónDecimal = " + RepresentaciónDecimal);

        //Distintas representaciones
        System.out.println("Escritura de " + RepresentaciónDecimal + " en sistema binario es: " + Integer.toBinaryString(RepresentaciónDecimal));
        System.out.println("Escritura de " + RepresentaciónDecimal + " en sistema octal es: " + Integer.toOctalString(RepresentaciónDecimal));
        System.out.println("Escritura de " + RepresentaciónDecimal + " en sistema hexadecimal es: " + Integer.toHexString(RepresentaciónDecimal));

        int RepresentaciónBinaria = 0b111110100;
        //La escritura 0b antes del número, le indica a Java que lo lea como un binario, para que lo transforme a un decimal
        System.out.println("La representación decimal de " + Integer.toBinaryString(RepresentaciónDecimal) + " es "+ RepresentaciónBinaria);

        int RepresentaciónOctal = 0764;
        // La escritura 0 antes del número, le indica a Java que lo lea como un octal, para que lo transforme a un decimal
        System.out.println("La representación decimal de " + Integer.toOctalString(RepresentaciónDecimal) + " es " + RepresentaciónOctal);

        int RepresentaciónHex = 0x1f4;
        // La escritura 0x antes del número, le indica a Java que lo lea como un hexadecimal, para que lo transforme a un decimal
        System.out.println("La representación decimal de " + Integer.toHexString(RepresentaciónDecimal) + " es " + RepresentaciónHex);
    }
}
