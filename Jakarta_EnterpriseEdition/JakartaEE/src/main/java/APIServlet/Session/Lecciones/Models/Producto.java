package APIServlet.Session.Lecciones.Models;

import java.time.LocalDate;

public class Producto {
        //Atributos de Producto
    private Long ID;
    private String Nombre;
    private Categoria Categoría;
    private int Precio;
    private String SKU;
    private LocalDate FechaRegistro;

        //Constructores de Producto
    public Producto() {
    }
    public Producto(Long ID, String nombre, String tipo, int precio) {
        this.ID = ID;
        this.Nombre = nombre;
        Categoria C = new Categoria();
            C.setNombre(tipo);
        this.Categoría = C;
        this.Precio = precio;
    }

        //Asignadores de atributos de Producto (setter)
    public void setID(Long ID) {
        this.ID = ID;
    }
        public void setNombre(String nombre) {
            this.Nombre = nombre;
        }
            public void setCategoria(Categoria categoria) {
                this.Categoría = categoria;
            }
                public void setPrecio(int precio) {
                    this.Precio = precio;
                }
                    public void setSKU(String SKU) {this.SKU = SKU;}
                        public void setFechaRegistro(LocalDate fechaRegistro) {
                            this.FechaRegistro = fechaRegistro;
                        }


        //Lectores de atributos de Producto (getter)
    public Long getID() {
        return this.ID;
    }
        public String getNombre() {
            return this.Nombre;
        }
            public Categoria getCategoria() {
                return this.Categoría;
            }
                public int getPrecio() {
                    return this.Precio;
                }
                    public String getSKU() {
                    return this.SKU;
                }
                        public LocalDate getFechaRegistro() {
                            return this.FechaRegistro;
                        }

    //Métodos de Producto
}
