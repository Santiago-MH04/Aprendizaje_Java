package POO_ClasesAbstractas.Lecciones.Validador;

public class RequeridoValidador extends Validador{
        //Atributos de RequeridoValidador
    protected String Mensaje = "El campo %s es requerido";

        //Constructores de RequeridoValidador
        //Asignadores de atributos de RequeridoValidador (setter)
    @Override
    public void setMensaje(String mensaje) {
        this.Mensaje = mensaje;
    }

        //Lectores de atributos de RequeridoValidador (getter)
    @Override
    public String getMensaje() {
        return this.Mensaje;
    }

        //Métodos de RequeridoValidador
    @Override
    public boolean esVálido(String valor) {
        return (valor != null && valor.length() > 0);
    }
}
