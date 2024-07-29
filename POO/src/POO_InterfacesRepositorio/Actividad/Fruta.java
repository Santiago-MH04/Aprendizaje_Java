package POO_InterfacesRepositorio.Actividad;

public class Fruta extends Producto{
        //Atributos de Fruta
    private String Color;
    private double Peso;

        //Constructores de Fruta
    public Fruta(String nombre, Double precio, String color, double peso) {
        super(nombre, precio);
        this.Color = color;
        this.Peso = peso;
    }

    //Asignadores de atributos de Fruta (setter)
        //Lectores de atributos de Fruta (getter)
    public String getColor() {
        return this.Color;
    }
        public double getPeso() {
            return this.Peso;
        }

        //Métodos de Fruta
    @Override
    public String DetalleProducto() {
        return super.DetalleProducto() +
                "\nPeso: " + this.getPeso() + " kg." +
                "\nColor: " + this.getColor().toLowerCase();
    }
}
