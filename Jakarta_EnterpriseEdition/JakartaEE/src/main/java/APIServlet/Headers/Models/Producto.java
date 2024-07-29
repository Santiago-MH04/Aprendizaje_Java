package APIServlet.Headers.Models;

public class Producto {
        //Atributos de Producto
    private Long ID;
    private String Nombre;
    private String Tipo;
    private int Precio;

        //Constructores de Producto
    public Producto() {
    }
    public Producto(Long ID, String nombre, String tipo, int precio) {
        this.ID = ID;
        this.Nombre = nombre;
        this.Tipo = tipo;
        this.Precio = precio;
    }

        //Asignadores de atributos de Producto (setter)
    public void setID(Long ID) {
        this.ID = ID;
    }
        public void setNombre(String nombre) {
            this.Nombre = nombre;
        }
            public void setTipo(String tipo) {
                this.Tipo = tipo;
            }
                public void setPrecio(int precio) {
                    this.Precio = precio;
                }

        //Lectores de atributos de Producto (getter)
    public Long getID() {
        return this.ID;
    }
        public String getNombre() {
            return this.Nombre;
        }
            public String getTipo() {
                return this.Tipo;
            }
                public int getPrecio() {
                    return this.Precio;
                }

    //Métodos de Producto
}
