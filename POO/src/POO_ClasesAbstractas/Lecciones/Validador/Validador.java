package POO_ClasesAbstractas.Lecciones.Validador;

public abstract class Validador {
        //Atributos de Validador
    protected String Mensaje;

        //Constructores de Validador
        //Asignadores de atributos (setter)
    public abstract void setMensaje(String mensaje);

        //Lectores de atributos (getter)
    public abstract String getMensaje();

        //Métodos de Validador
    public abstract boolean esVálido(String valor);
}
