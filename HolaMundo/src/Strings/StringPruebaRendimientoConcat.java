package Strings;

public class StringPruebaRendimientoConcat {
    public static void main(String[] args) {

        String a = "a";
        String b = "b";
        String c = a;
        String d = a;
        StringBuilder e = new StringBuilder(a);

        long inicio = System.currentTimeMillis();
        for (int i = 0; i < 5; i++){
            c = c.concat(a).concat(b).concat("\n"); // 500 iteraciones: 2ms --> 1000 iteraciones: 4ms
            d += a + b + "\n";                          // 500 iteraciones: 19ms --> 1000 iteraciones: 21ms
            e = e.append(a).append(b).append("\n");     // 500 iteraciones: 0ms --> 1000 iteraciones: 0ms
        }
        long fin = System.currentTimeMillis();

        System.out.println("(fin-inicio) = " + (fin - inicio));
        System.out.println("Para ver el rendimiento de cada método, añadir un número más apreciable de iteraciones y comentar las líneas de otros métodos, una vez sepamos manejar mejor el programa, se puede hacer todo sin necesidad de comentar");
        System.out.println("c: " + c);
        System.out.println("d usando el método Concat es: " + d);
        System.out.println("e usando la instancia StringBuilder es: " + e.toString());
    }
}
