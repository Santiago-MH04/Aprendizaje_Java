package POO_Herencia.Actividad.EjemploAlmacénVerdulería.Bambalinas;

public class NoPerecedero extends Producto{
        //Atributos de NoPerecedero
    private int Contenido;
    private int Calorías;

        //Constructores de NoPerecedero
    public NoPerecedero() {
    }
        public NoPerecedero(String nombre, double precio, int contenido) {
            super(nombre, precio);
            this.Contenido = contenido;
        }
            public NoPerecedero(String nombre, double precio, int contenido, int calorías) {
                this(nombre, precio, contenido);
                this.Calorías = calorías;
            }

        //Asignadores de atributos de NoPerecedero (setter)
    public void setContenido(int contenido) {
        this.Contenido = contenido;
    }
        public void setCalorías(int calorías) {
            this.Calorías = calorías;
        }

        //Lectores de atributos de NoPerecedero (getter)
    public int getContenido() {
        return this.Contenido;
    }
        public int getCalorías() {
            return this.Calorías;
        }

        //Otros métodos de NoPerecedero
    @Override
    public String toString() {
        return super.toString() +
                "Contenido: " + Contenido + " [kg]" +
                "\nCalorías: " + Calorías + " [kCal]";
    }
}
