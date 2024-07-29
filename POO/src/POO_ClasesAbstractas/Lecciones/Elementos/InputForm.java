package POO_ClasesAbstractas.Lecciones.Elementos;

public class InputForm extends ElementoForm{
        //Atributos de InputForm
    private String Tipo = "text";

        //Constructores de InputForm
    public InputForm(String nombre) {
        super(nombre);
    }
    public InputForm(String nombre, String tipo) {
        super(nombre);
        this.Tipo = tipo;
    }

        //Asignadores de atributos de InputForm (setter)
    public void setTipo(String tipo) {
        this.Tipo = tipo;
    }

        //Lectores de atributos de InputForm (getter)
    public String getTipo() {
        return this.Tipo;
    }

        //Métodos de InputForm
    @Override
    public String dibujarHTML() {
        return "<input type = \"" + this.Tipo + "\"" +
                " name = \"" + this.Nombre + "\"" +
                " value = \"" + this.Valor + "\">";
    }
}
