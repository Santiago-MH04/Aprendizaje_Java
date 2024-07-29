package POO_ClasesAbstractas.Lecciones.Validador;

public class EmailValidador extends Validador{
        //Atributos de EmailValidador
    protected String Mensaje = "El campo %s tiene un formato de correo inválido";
    private static final String EMAIL_REGEX = "^(.+)@(.+)$";

        //Constructores de EmailValidador
        //Asignadores de atributos de EmailValidador (setter)
    @Override
    public void setMensaje(String mensaje) {
        this.Mensaje = mensaje;
    }

        //Lectores de atributos de EmailValidador (getter)
    @Override
    public String getMensaje() {
        return this.Mensaje;
    }

        //Métodos de EmailValidador
    @Override
    public boolean esVálido(String valor) {
        return valor.matches(EMAIL_REGEX);
    }
}
