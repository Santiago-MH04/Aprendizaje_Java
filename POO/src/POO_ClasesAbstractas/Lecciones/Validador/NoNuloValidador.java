package POO_ClasesAbstractas.Lecciones.Validador;

public class NoNuloValidador extends Validador{
        //Atributos de NoNuloValidador;
    protected String Mensaje = "El campo %s no puede ser nulo";

        //Constructores de NoNuloValidador;
        //Asignadores de atributos de NoNuloValidador (setter);
    @Override
    public void setMensaje(String mensaje) {
        this.Mensaje = mensaje;
    }

        //Lectores de atributos de NoNuloValidador (getter);
    @Override
    public String getMensaje() {
        return this.Mensaje;
    }

        //Métodos de NoNuloValidador;
    @Override
    public boolean esVálido(String valor) {
        return (valor != null);
    }
}
