package POO_InterfacesRepositorio.Actividad;

public class NoPerecedero extends Producto{
        //Atributos de NoPerecedero
    private int Contenido;
    private int Calorías;

        //Constructores de NoPerecedero
    public NoPerecedero(String nombre, Double precio, int contenido, int calorías) {
        super(nombre, precio);
        this.Contenido = contenido;
        this.Calorías = calorías;
    }

    //Asignadores de atributos de NoPerecedero (setter)
        //Lectores de atributos de NoPerecedero (getter)
    public int getContenido() {
        return this.Contenido;
    }
        public int getCalorías() {
            return this.Calorías;
        }

        //Métodos de NoPerecedero
    @Override
    public String DetalleProducto() {
        return super.DetalleProducto() +
                "\nContenido neto: " + this.getContenido() + " kg." +
                "\nCalorías: " + this.getCalorías() + " kCal por porción.";
    }
}
