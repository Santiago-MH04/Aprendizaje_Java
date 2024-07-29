package POO_Interfaces.Imprenta.Modelo;

public class Página extends Hoja {
    //Atributos de Página
        //Constructores de Página
    public Página(String contenido) {
        super(contenido);
    }
    //Asignadores de atributos de Página (setter)
    //Lectores de atributos de Página (getter)

        //Métodos de Página
    @Override
    public String Imprimir() {
        return this.Contenido;
    }
}
