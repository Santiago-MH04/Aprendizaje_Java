package POO_ClasesAbstractas.Lecciones.Validador;

public class NúmeroValidador extends Validador{
        //Atributos de NúmeroValidador
    protected String Mensaje = "El campo %s debe ser un número";

        //Constructores de NúmeroValidador
        //Asignadores de atributos de NúmeroValidador (setter)
    @Override
    public void setMensaje(String mensaje) {
        this.Mensaje = mensaje;
    }

        //Lectores de atributos de NúmeroValidador (getter)
    @Override
    public String getMensaje() {
        return null;
    }

        //Métodos de NúmeroValidador
    @Override
    public boolean esVálido(String valor) {
        try{
            Integer.parseInt(valor);
            return true;
        } catch (NumberFormatException e){
            return false;
        }
    }
}
