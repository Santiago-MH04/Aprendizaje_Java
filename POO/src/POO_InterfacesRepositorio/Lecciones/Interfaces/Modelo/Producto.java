package POO_InterfacesRepositorio.Lecciones.Interfaces.Modelo;

public class Producto extends BaseEntity{
        //Atributos de Producto
    private String Descripción;
    private Double Precio;

        //Constructores de Producto
    public Producto(String descripción, Double precio) {
        super();
        this.Descripción = descripción;
        this.Precio = precio;
    }

        //Asignadores de atributos de Producto (setter)
    public void setDescripción(String descripción) {
        this.Descripción = descripción;
    }
    public void setPrecio(Double precio) {
        this.Precio = precio;
    }

        //Lectores de atributos de Producto (getter)
    public String getDescripción() {
        return Descripción;
    }
    public Double getPrecio() {
        return this.Precio;
    }

        //Métodos de Producto
    @Override
    public String toString() {
        return  "ID: '" + this.ID +
                "' Descripción: '" + this.Descripción +
                "' Precio: $" + this.Precio;
    }
}
