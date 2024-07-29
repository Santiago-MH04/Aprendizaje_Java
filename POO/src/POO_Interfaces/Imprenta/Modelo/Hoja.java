package POO_Interfaces.Imprenta.Modelo;

public abstract class Hoja implements Imprimible{
        //Atributos de Hoja
    protected String Contenido;

        //Constructores de Hoja
    public Hoja(String contenido) {
        this.Contenido = contenido;
    }

    //Asignadores de atributos de Hoja (setter)
    //Lectores de atributos de Hoja (getter)
        //Métodos de Hoja
    public abstract String Imprimir();
}
