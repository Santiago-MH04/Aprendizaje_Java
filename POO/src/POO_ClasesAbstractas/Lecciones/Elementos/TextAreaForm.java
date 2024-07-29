package POO_ClasesAbstractas.Lecciones.Elementos;

public class TextAreaForm extends ElementoForm{
        //Atributos de TextAreaForm
    private int Filas;
    private int Columnas;

        //Constructores de TextAreaForm
    public TextAreaForm(String nombre) {
        super(nombre);
    }
    public TextAreaForm(String nombre, int filas, int columnas) {
        super(nombre);
        this.Filas = filas;
        this.Columnas = columnas;
    }

        //Asignadores de atributos de TextAreaForm (setter)
    public void setFilas(int filas) {
        this.Filas = filas;
    }
    public void setColumnas(int columnas) {
        this.Columnas = columnas;
    }

        //Lectores de atributos de TextAreaForm (getter)
    public int getFilas() {
        return this.Filas;
    }
    public int getColumnas() {
        return this.Columnas;
    }

        //Métodos de TextAreaForm
    @Override
    public String dibujarHTML() {
        return "<textarea name = '" + this.Nombre + "'" +
                " cols = '" + this.Columnas + "'" +
                " rows = '" + this.Filas + "'>" +
                this.Valor + "</textarea>";
    }
}