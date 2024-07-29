package POO_ClasesAbstractas.Lecciones.Elementos.Select;

public class Opción {
        //Atributos de Opción
    private String Valor;
    private String Nombre;
    private boolean Selected;

        //Constructores de Opción
    public Opción() {
    }
        public Opción(String valor, String nombre) {
            this.Valor = valor;
            this.Nombre = nombre;
        }

        //Asignadores de atributos de Opción (setter)
    public void setValor(String valor) {
        this.Valor = valor;
    }
        public void setNombre(String nombre) {
            this.Nombre = nombre;
        }
            public void setSelected(boolean selected) {
                this.Selected = selected;
            }
                public Opción setSelected() {
                    this.Selected = true;
                    return this;
                }

        //Lectores de atributos de Opción (getter)
    public String getValor() {
        return this.Valor;
    }
        public String getNombre() {
            return this.Nombre;
        }

        //Métodos de Opción
    public boolean isSelected() {
        return this.Selected;
    }
}
