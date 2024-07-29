package POO_InterfacesRepositorio.Actividad;

public class Limpieza extends Producto{
        //Atributos de Limpieza
    private String Componentes;
    private double Volumen;

        //Constructores de Limpieza
    public Limpieza(String nombre, Double precio, String componentes, double volumen) {
        super(nombre, precio);
        this.Componentes = componentes;
        this.Volumen = volumen;
    }

    //Asignadores de atributos de Limpieza (setter)
        //Lectores de atributos de Limpieza (getter)
    public String getComponentes() {
        return this.Componentes;
    }
        public double getVolumen() {
            return this.Volumen;
        }

        //Métodos de Limpieza
    @Override
    public String DetalleProducto() {
        return super.DetalleProducto() +
                "\nComponentes: " + this.getComponentes().toLowerCase() +
                "\nVolumen unitario: " + this.getVolumen() + " l.";
    }
}
