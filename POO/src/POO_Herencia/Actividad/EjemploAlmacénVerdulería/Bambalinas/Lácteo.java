package POO_Herencia.Actividad.EjemploAlmacénVerdulería.Bambalinas;

public class Lácteo extends Producto{
        //Atributos de Lácteo
    private int Cantidad;
    private int Proteínas;

        //Constructores de Lácteo
    public Lácteo() {
    }
        public Lácteo(String nombre, double precio, int cantidad) {
            super(nombre, precio);
            this.Cantidad = cantidad;
        }
            public Lácteo(String nombre, double precio, int cantidad, int proteínas) {
                this(nombre, precio, cantidad);
                this.Proteínas = proteínas;
            }

        //Asignadores de atributos de Lácteo (setter)
    public void setCantidad(int cantidad) {
        this.Cantidad = cantidad;
    }
        public void setProteínas(int proteínas) {
            this.Proteínas = proteínas;
        }

        //Lectores de atributos de Lácteo (getter)
    public int getCantidad() {
        return this.Cantidad;
    }
        public int getProteínas() {
            return this.Proteínas;
        }

        //Otros métodos de Lácteo
    @Override
    public String toString() {
        return super.toString() +
                "\nLácteo servido en " + Cantidad + " [l]" +
                "\nContenido de proteínas: " + Proteínas + " [mg/kg]";
    }
}
