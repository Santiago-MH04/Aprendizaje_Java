package Strings;

public class LecciónStrings {
    public static void main(String[] args) {

            //En los Strings, como otros tipos de objetos, dependiendo de su instancia se pueden diferenciar, a pesar de tener el mismo contenido

        String string1 = "Santiago";
        String string2 = new String("Santiago");
        String string3 = "santiago";
        String Con = "programa en Java";
        String cat = "para poder volverse más pro";

            //Aquí, sin embargo, también puede crearse una instancia boolean para hacer más corta la línea de soutv, con la instrucción que se pide comparar
            //Comparar los objetos y su procedencia (debe ser false)
        boolean comparación = string1==string2;
        System.out.println("¿Son el mismo objeto?: " + (string1==string2));
        System.out.println("¿Son el mismo objeto?: " + comparación + "\n");

            //Comparar los valores de cada objeto (debe ser true)
        comparación = string1.equals(string2);
        System.out.println("¿Tienen el mismo valor?: " + string1.equals(string2));
        System.out.println("¿Tienen el mismo valor?: " + comparación + "\n");

            //Comparar por los caracteres
        comparación = string1.equalsIgnoreCase(string3);
        System.out.println("¿Son la misma palabra?:  " + string1.equalsIgnoreCase(string3));
        System.out.println("¿Son la misma palabra?:  " + comparación);

            //Concatenar de varias maneras
        String Concatenar =string1 +" " + Con + " " + cat;
        System.out.println("Concatenar = " + Concatenar);

        Concatenar = string1.concat(" " + Con + " " + cat);
        System.out.println("Concatenar con concat todo dentro del mismo argumento= " + Concatenar);

        Concatenar = string1.concat(" ").concat(Con).concat(" ").concat(cat);
        System.out.println("Concatenar con concat en argumentos uno tras otro = " + Concatenar);

            //Función Lambda
        String conLambda = string1.transform(l -> {
            return l + " " + Con + " " + cat;
        });
        System.out.println("Concatenar con Lambda = " + conLambda);
            //Cambiar caracteres
        conLambda = conLambda.replace("a","A");
        System.out.println(conLambda);
    }
}