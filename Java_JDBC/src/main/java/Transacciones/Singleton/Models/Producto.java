package Transacciones.Singleton.Models;

import java.time.LocalDate;

public class Producto {
        //Atributos de Producto
    private Long ID;
    private String Nombre;
    private Integer Precio;
    private LocalDate Fecha_Registro;
    private Categoría Categoría;
    private String SKU;

        //Constructores de Producto
    public Producto() {
    }
    public Producto(Long ID, String nombre, Integer precio, LocalDate fecha_Registro) {
        this.ID = ID;
        this.Nombre = nombre;
        this.Precio = precio;
        this.Fecha_Registro = fecha_Registro;
    }

        //Asignadores de atributos de Producto (setter)
    public void setID(Long ID) {
        this.ID = ID;
    }
        public void setNombre(String nombre) {
            this.Nombre = nombre;
        }
            public void setPrecio(Integer precio) {
                this.Precio = precio;
            }
                public void setFecha_Registro(LocalDate fecha_Registro) {
                    this.Fecha_Registro = fecha_Registro;
                }
                    public void setCategoría(Categoría categoría) {
                        this.Categoría = categoría;
                    }
                        public void setSKU(String SKU) {
                            this.SKU = SKU;
                        }

        //Lectores de atributos de Producto (getter)
    public Long getID() {
        return this.ID;
    }
        public String getNombre() {
            return this.Nombre;
        }
            public Integer getPrecio() {
                return this.Precio;
            }
                public LocalDate getFecha_Registro() {
                    return this.Fecha_Registro;
                }
                    public Categoría getCategoría() {
                        return this.Categoría;
                    }
                        public String getSKU() {
                            return this.SKU;
                        }

        //Métodos de Producto
    @Override
    public String toString() {
        return this.ID + " | " +
                this.Nombre + " | " +
                this.Precio + " | " +
                this.Fecha_Registro/*.format(DateTimeFormatter.ofPattern("yyyy-mm-dd"))*/ + " | " +
                this.Categoría.getNombre() + " | " +
                this.SKU;
    }
}
