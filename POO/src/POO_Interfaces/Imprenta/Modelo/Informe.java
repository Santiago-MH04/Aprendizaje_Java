package POO_Interfaces.Imprenta.Modelo;

public class Informe extends Hoja {
        //Atributos de Informe
    private Persona Autor;
    private Persona Revisor;

        //Constructores de Informe
    public Informe(String contenido, Persona autor, Persona revisor) {
        super(contenido);
        this.Autor = autor;
        this.Revisor = revisor;
    }

    //Asignadores de atributos de Informe (setter)
    //Lectores de atributos de Informe (getter)
        //Métodos de Informe
    @Override
    public String Imprimir() {
        return "Informe escrito por: " + this.Autor +
                ". Revisado por: " + this.Revisor +
                "\n" + this.Contenido + "\n";
    }
}
