package POO_Interfaces.Imprenta.Modelo;

public interface Imprimible {
        //Atributos de Imprimible
    static final String TEXTO_DEFECTO = "Imprimiendo una implementación por defecto";

        //Métodos de Imprimible
    default String Imprimir(){
        return TEXTO_DEFECTO;
    }
    static void Imprimir(Imprimible imprimible){
        if (imprimible instanceof Object) {
            System.out.println(imprimible.getClass().getSimpleName());
        }
        System.out.println(imprimible.Imprimir());
    }

}
