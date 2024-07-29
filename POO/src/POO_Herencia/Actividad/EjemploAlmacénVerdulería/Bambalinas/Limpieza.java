package POO_Herencia.Actividad.EjemploAlmacénVerdulería.Bambalinas;

public class Limpieza extends Producto{
        //Atributos de Limpieza
    private String Componentes;
    private double Volumen;

        //Constructores de Limpieza
    public Limpieza() {
    }
        public Limpieza(String nombre, double precio, String componentes) {
            super(nombre, precio);
            this.Componentes = componentes;
        }
            public Limpieza(String nombre, double precio, String componentes, double volumen) {
                this(nombre, precio, componentes);
                this.Volumen = volumen;
            }

        //Asignadores de atributos de Limpieza (setter)
    public void setComponentes(String componentes) {
        this.Componentes = componentes;
    }
        public void setVolumen(double volumen) {
            this.Volumen = volumen;
        }

        //Lectores de atributos de Limpieza (getter)
    public String getComponentes() {
        return this.Componentes;
    }
        public double getVolumen() {
            return this.Volumen;
        }

        //Otros métodos de Limpieza
    @Override
    public String toString() {
        return super.toString() +
                "\nComponentes: " + Componentes +
                "\nVolumen: " + Volumen + " [l]";
    }
}
