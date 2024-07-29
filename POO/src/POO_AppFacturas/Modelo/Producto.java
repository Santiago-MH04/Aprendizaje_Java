package POO_AppFacturas.Modelo;

public class Producto {
        //Atributos de la clase Producto
    private int Código;
    private static int ÚltimoCódigo;
    private String Nombre;
    private float Precio;

        //Constructores de Producto
    public Producto() {
        this.Código = ++ÚltimoCódigo;
    }

        //Asignadores de atributos (setter)
    public void setNombre(String nombre) {
        this.Nombre = nombre;
    }
    public void setPrecio(float precio) {
        this.Precio = precio;
    }
        //Lectores de atributos (getter)
    public int getCódigo() {
        return this.Código;
    }
    public String getNombre() {
        return this.Nombre;
    }
    public float getPrecio() {
        return this.Precio;
    }

        //Métodos de Producto
    @Override
    public String toString() {
        return this.Código +
                "\t" + this.Nombre +
                "\t" + this.Precio;
    }
}
