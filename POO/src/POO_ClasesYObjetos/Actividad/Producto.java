package POO_ClasesYObjetos.Actividad;

public class Producto {
        //Atributos de la clase Producto
    private String fabricante;
    private String nombre;
    private int precio;

        //Constructores de la clase Producto
    public Producto(String fabricante, String nombre, int precio) {
        this.fabricante = fabricante;
        this.nombre = nombre;
        this.precio = precio;
    }

        //Setters de la clase Producto
        //Lectores de atributos de la clase Producto
    public String getFabricante() {
        return fabricante;
    }
        public String getNombre() {
            return nombre;
        }
            public int getPrecio() {
                return precio;
            }

        //Métodos de la clase Producto
}
