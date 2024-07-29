package LíneaComando;

public class ArgumentosLíneaComando {
    public static void main(String[] args) {

        if(args.length == 0){
            System.err.println("Debe ingresar, como mínimo, algún argumento.");
            System.exit(-1);
        }

        for(int i = 0; i < args.length; i++){
            System.out.println("Argumento n° " + i + ": " + args[i]);
        }
    }
}