package POO_InterfacesRepositorio.Actividad;

public class Lácteo extends Producto{
        //Atributos de Lácteo
    private int Cantidad;
    private int Proteínas;

        //Constructores de Lácteo
    public Lácteo(String nombre, Double precio, int cantidad, int proteínas) {
        super(nombre, precio);
        this.Cantidad = cantidad;
        this.Proteínas = proteínas;
    }

    //Asignadores de atributos de Lácteo (setter)
        //Lectores de atributos de Lácteo (getter)
    public int getCantidad() {
        return this.Cantidad;
    }
        public int getProteínas() {
            return this.Proteínas;
        }

        //Métodos de Lácteo
    @Override
    public String DetalleProducto() {
        return super.DetalleProducto() +
                "\nCantidad: " + this.getCantidad() + " unidades." +
                "\nContenido proteico: " + this.getProteínas() + " mg/(0.1 kg)";
    }
}
