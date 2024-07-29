package POO_Herencia.Actividad.EjemploAlmacénVerdulería.Bambalinas;

public class Producto {
        //Atributos de Producto
    private String Nombre;
    private double Precio;

        //Constructores de Producto
    public Producto() {
    }
        public Producto(String nombre) {
            Nombre = nombre;
        }
            public Producto(String nombre, double precio) {
                Nombre = nombre;
                Precio = precio;
            }

        //Asignadores de atributos de Producto (setter)
    public void setNombre(String nombre) {
        Nombre = nombre;
    }
        public void setPrecio(double precio) {
            Precio = precio;
        }

        //Lectores de atributos de Producto (getter)
    public String getNombre() {
        return Nombre;
    }
        public double getPrecio() {
            return Precio;
        }

        //Otros métodos de Producto
    @Override
    public String toString() {
        return "Detalle de la legumbrería:" +
                "\nNombre producto: " + this.Nombre +
                "\nPrecio producto: $" + this.Precio;
    }
}
